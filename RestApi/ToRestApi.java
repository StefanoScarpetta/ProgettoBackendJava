package RestApi;

import Classi.*;
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
        Hashmap value = new Hashmap(converter.ConverterObj((JSONObject) js.get("value")));
        JsonArray id = new JsonArray(converter.ConverterArray((JSONArray) js.get("id")));
        Hashmap dimension = new Hashmap(converter.ConverterObj((JSONObject) js.get("dimension")));
        Stringa version = new Stringa((String) js.get("version"));
        Stringa classe = new Stringa((String) js.get("class"));
        Stringa label = new Stringa((String) js.get("label"));
        Stringa source = new Stringa((String) js.get("source"));
        Stringa updated = new Stringa((String) js.get("updated"));
        Hashmap extension = new Hashmap(converter.ConverterObj((JSONObject) js.get("extension")));

        Stringa langExt = new Stringa((String) ((JSONObject) js.get("extension")).get("lang"));
        Stringa idExt = new Stringa((String) ((JSONObject) js.get("extension")).get("id"));
        Stringa agencyIdExt = new Stringa((String) ((JSONObject) js.get("extension")).get("agencyId"));
        Stringa versionExt = new Stringa((String) ((JSONObject) js.get("extension")).get("version"));
        Hashmap datastructureExt = new Hashmap(converter.ConverterObj((JSONObject) ((JSONObject) js.get("extension")).get("datastructure")));
        JsonArray annotationExt = new JsonArray(converter.ConverterArray((JSONArray) ((JSONObject) js.get("extension")).get("annotation")));

        JSONObject DATASTRUCTURE = (JSONObject) ((JSONObject) js.get("extension")).get("datastructure");
        Stringa idData = new Stringa((String) DATASTRUCTURE.get("id"));
        Stringa agencyIdData = new Stringa((String) DATASTRUCTURE.get("agencyId"));
        Stringa versionData = new Stringa((String) DATASTRUCTURE.get("version"));

        Hashmap ANNOTATION0 = new Hashmap((HashMap) annotationExt.getJsonarray().get(0));
        Hashmap ANNOTATION1 = new Hashmap((HashMap) annotationExt.getJsonarray().get(1));
        Hashmap ANNOTATION2 = new Hashmap((HashMap) annotationExt.getJsonarray().get(2));
        Hashmap ANNOTATION3 = new Hashmap((HashMap) annotationExt.getJsonarray().get(3));
        Hashmap ANNOTATION4 = new Hashmap((HashMap) annotationExt.getJsonarray().get(4));
        Hashmap ANNOTATION5 = new Hashmap((HashMap) annotationExt.getJsonarray().get(5));
        Hashmap ANNOTATION6 = new Hashmap((HashMap) annotationExt.getJsonarray().get(6));
        Hashmap ANNOTATION7 = new Hashmap((HashMap) annotationExt.getJsonarray().get(7));

        JSONObject FREQ = (JSONObject) ((JSONObject) js.get("dimension")).get(id.getJsonarray().get(0));
        JSONObject GEO = (JSONObject) ((JSONObject) js.get("dimension")).get(id.getJsonarray().get(1));
        JSONObject UNIT = (JSONObject) ((JSONObject) js.get("dimension")).get(id.getJsonarray().get(2));
        JSONObject OBJECTIV = (JSONObject) ((JSONObject) js.get("dimension")).get(id.getJsonarray().get(3));
        JSONObject TIME_PERIOD = (JSONObject) ((JSONObject) js.get("dimension")).get(id.getJsonarray().get(4));

        Stringa titleFREQ = new Stringa((String) FREQ.get("label"));
        Stringa titleGEO = new Stringa((String) GEO.get("label"));
        Stringa titleUNIT = new Stringa((String) UNIT.get("label"));
        Stringa titleOBJECTIV = new Stringa((String) OBJECTIV.get("label"));
        Stringa titleTIME_PERIOD = new Stringa((String) TIME_PERIOD.get("label"));

        Hashmap categoryFREQ = new Hashmap(converter.ConverterObj((JSONObject) FREQ.get("category")));
        Hashmap categoryGEO = new Hashmap(converter.ConverterObj((JSONObject) GEO.get("category")));
        Hashmap categoryUNIT = new Hashmap(converter.ConverterObj((JSONObject) UNIT.get("category")));
        Hashmap categoryOBJECTIV = new Hashmap(converter.ConverterObj((JSONObject) OBJECTIV.get("category")));
        Hashmap categoryTIME_PERIOD = new Hashmap(converter.ConverterObj((JSONObject) TIME_PERIOD.get("category")));

        JSONObject IndexELableFREQ = (JSONObject) FREQ.get("category");
        JSONObject IndexELableGEO = (JSONObject) GEO.get("category");
        JSONObject IndexELableUNIT = (JSONObject) UNIT.get("category");
        JSONObject IndexELableOBJECTIV = (JSONObject) OBJECTIV.get("category");
        JSONObject IndexELableTIME_PERIOD = (JSONObject) TIME_PERIOD.get("category");

        Hashmap labelFREQ = new Hashmap(converter.ConverterObj((JSONObject) IndexELableFREQ.get("label")));
        Hashmap indexFREQ = new Hashmap(converter.ConverterObj((JSONObject) IndexELableFREQ.get("index")));
        Hashmap labelGEO = new Hashmap(converter.ConverterObj((JSONObject) IndexELableGEO.get("label")));
        Hashmap indexGEO = new Hashmap(converter.ConverterObj((JSONObject) IndexELableGEO.get("index")));
        Hashmap labelUNIT = new Hashmap(converter.ConverterObj((JSONObject) IndexELableUNIT.get("label")));
        Hashmap indexUNIT = new Hashmap(converter.ConverterObj((JSONObject) IndexELableUNIT.get("index")));
        Hashmap labelOBJECTIV = new Hashmap(converter.ConverterObj((JSONObject) IndexELableOBJECTIV.get("label")));
        Hashmap indexOBJECTIV = new Hashmap(converter.ConverterObj((JSONObject) IndexELableOBJECTIV.get("index")));
        Hashmap labelTIME_PERIOD = new Hashmap(converter.ConverterObj((JSONObject) IndexELableTIME_PERIOD.get("label")));
        Hashmap indexTIME_PERIOD = new Hashmap(converter.ConverterObj((JSONObject) IndexELableTIME_PERIOD.get("index")));

        Map<Integer, String> mappaInvertita = new HashMap<Integer, String>();
        Iterator iterator = indexGEO.getHashmap().entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Long> appoggio = (Map.Entry<String, Long>) iterator.next();
            mappaInvertita.put(Math.toIntExact(appoggio.getValue()), appoggio.getKey());
        }

        JSONArray dati = new JSONArray();
        for(int i=0; i<indexGEO.getHashmap().size(); i++) {
            JSONObject nazione = new JSONObject();
            nazione.put("id", i);
            nazione.put("nazione", labelGEO.getHashmap().get(mappaInvertita.get(i)));
            nazione.put("sigla", mappaInvertita.get(i));
            for(int a=0; a<indexTIME_PERIOD.getHashmap().size(); a++) {
                int b= i*36;
                if(a<10) {
                    nazione.put("200"+a, value.getHashmap().get(String.valueOf(b+a)));
                } else {
                    nazione.put("20"+a, value.getHashmap().get(String.valueOf(b+a)));
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
