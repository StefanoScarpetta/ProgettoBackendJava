package RestApi;

import Classi.*;
import Classi.Class;
import Classi.Proprietà.Descrizione.Categorie.Index;
import Classi.Proprietà.Descrizione.Categorie.Label;
import Classi.Proprietà.Descrizione.Category;
import Classi.Proprietà.Descrizione.Title;
import Convertitore.Converter;
import Convertitore.GeneralInformation;
import Convertitore.Reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ToRestApi {
    private final String directory;
    private String api;

    public ToRestApi(String directory, String api) throws IOException, ParseException {
        this.directory = directory;
        this.api = api;
    }

    public void run() throws IOException, ParseException {
        Reader reader = new Reader(directory);
        JSONObject js = reader.getJsonObject();
        Converter converter = new Converter();

        GeneralInformation generalInformation = new GeneralInformation(converter.ConverterObj(js), js);
        Value value = new Value(converter.ConverterObj((JSONObject) js.get("value")));
        Id id = new Id(converter.ConverterArray((JSONArray) js.get("id")));
        Dimension dimension = new Dimension(converter.ConverterObj((JSONObject) js.get("dimension")));
        Version version = new Version((String) js.get("version"));
        Class classe = new Class((String) js.get("class"));
        Classi.Label label = new Classi.Label((String) js.get("label"));
        Source source = new Source((String) js.get("source"));
        Updated updated = new Updated((String) js.get("updated"));
        Extension extension = new Extension(converter.ConverterObj((JSONObject) js.get("extension")));

        JSONObject FREQ = (JSONObject) ((JSONObject) js.get("dimension")).get(id.getId().get(0));
        JSONObject GEO = (JSONObject) ((JSONObject) js.get("dimension")).get(id.getId().get(1));
        JSONObject UNIT = (JSONObject) ((JSONObject) js.get("dimension")).get(id.getId().get(2));
        JSONObject OBJECTIV = (JSONObject) ((JSONObject) js.get("dimension")).get(id.getId().get(3));
        JSONObject TIME_PERIOD = (JSONObject) ((JSONObject) js.get("dimension")).get(id.getId().get(4));

        Title titleFREQ = new Title((String) FREQ.get("label"));
        Title titleGEO = new Title((String) GEO.get("label"));
        Title titleUNIT = new Title((String) UNIT.get("label"));
        Title titleOBJECTIV = new Title((String) OBJECTIV.get("label"));
        Title titleTIME_PERIOD = new Title((String) TIME_PERIOD.get("label"));

        Category categoryFREQ = new Category(converter.ConverterObj((JSONObject) FREQ.get("category")));
        Category categoryGEO = new Category(converter.ConverterObj((JSONObject) GEO.get("category")));
        Category categoryUNIT = new Category(converter.ConverterObj((JSONObject) UNIT.get("category")));
        Category categoryOBJECTIV = new Category(converter.ConverterObj((JSONObject) OBJECTIV.get("category")));
        Category categoryTIME_PERIOD = new Category(converter.ConverterObj((JSONObject) TIME_PERIOD.get("category")));

        JSONObject IndexELableFREQ = (JSONObject) FREQ.get("category");
        JSONObject IndexELableGEO = (JSONObject) GEO.get("category");
        JSONObject IndexELableUNIT = (JSONObject) UNIT.get("category");
        JSONObject IndexELableOBJECTIV = (JSONObject) OBJECTIV.get("category");
        JSONObject IndexELableTIME_PERIOD = (JSONObject) TIME_PERIOD.get("category");

        Label labelFREQ = new Label(converter.ConverterObj((JSONObject) IndexELableFREQ.get("label")));
        Index indexFREQ = new Index(converter.ConverterObj((JSONObject) IndexELableFREQ.get("index")));
        Label labelGEO = new Label(converter.ConverterObj((JSONObject) IndexELableGEO.get("label")));
        Index indexGEO = new Index(converter.ConverterObj((JSONObject) IndexELableGEO.get("index")));
        Label labelUNIT = new Label(converter.ConverterObj((JSONObject) IndexELableUNIT.get("label")));
        Index indexUNIT = new Index(converter.ConverterObj((JSONObject) IndexELableUNIT.get("index")));
        Label labelOBJECTIV = new Label(converter.ConverterObj((JSONObject) IndexELableOBJECTIV.get("label")));
        Index indexOBJECTIV = new Index(converter.ConverterObj((JSONObject) IndexELableOBJECTIV.get("index")));
        Label labelTIME_PERIOD = new Label(converter.ConverterObj((JSONObject) IndexELableTIME_PERIOD.get("label")));
        Index indexTIME_PERIOD = new Index(converter.ConverterObj((JSONObject) IndexELableTIME_PERIOD.get("index")));

        Map<Integer, String> mappaInvertita = new HashMap<Integer, String>();
        Iterator iterator = indexGEO.getIndex().entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Long> appoggio = (Map.Entry<String, Long>) iterator.next();
            mappaInvertita.put(Math.toIntExact(appoggio.getValue()), appoggio.getKey());
        }

        JSONArray dati = new JSONArray();
        for(int i=0; i<indexGEO.getIndex().size(); i++) {
            JSONObject nazione = new JSONObject();
            nazione.put("id", i);
            nazione.put("nazione", labelGEO.getLabel().get(mappaInvertita.get(i)));
            nazione.put("sigla", mappaInvertita.get(i));
            for(int a=0; a<indexTIME_PERIOD.getIndex().size(); a++) {
                int b= i*36;
                if(a<10) {
                    nazione.put("200"+a, value.getValue().get(String.valueOf(b+a)));
                } else {
                    nazione.put("20"+a, value.getValue().get(String.valueOf(b+a)));
                }
            }
            dati.add(nazione);
        }

        JSONObject main = new JSONObject();
        main.put("dati", dati);

        try(FileWriter file = new FileWriter(api)) {
            file.write(main.toString());
            file.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
