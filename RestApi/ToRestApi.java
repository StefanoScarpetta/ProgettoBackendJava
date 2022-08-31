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

        HashMap ANNOTATION = new HashMap<>();
        for(int i=0; i<annotationExt.getJsonarray().size(); i++) {
            ANNOTATION.put(i, annotationExt.getJsonarray().get(i));
        }

        HashMap DIMENSION = new HashMap<>();
        HashMap TITLE = new HashMap<>();
        HashMap CATEGORY = new HashMap<>();
        HashMap INDEX = new HashMap<>();
        HashMap LABEL = new HashMap<>();
        for(int i = 0; i<id.getJsonarray().size(); i++) {
            DIMENSION.put(id.getJsonarray().get(i), (JSONObject) ((JSONObject) js.get("dimension")).get(id.getJsonarray().get(i)));
            JSONObject title = (JSONObject) DIMENSION.get(id.getJsonarray().get(i));
            TITLE.put("title"+id.getJsonarray().get(i), title.get("label"));
            JSONObject category = (JSONObject) DIMENSION.get(id.getJsonarray().get(i));
            CATEGORY.put("category"+id.getJsonarray().get(i), category.get("category"));
            HashMap indexlabel = (JSONObject) CATEGORY.get("category"+id.getJsonarray().get(i));
            INDEX.put("index"+id.getJsonarray().get(i), indexlabel.get("index"));
            LABEL.put("label"+id.getJsonarray().get(i), indexlabel.get("label"));
        }

        Map<Integer, String> mappaInvertita = new HashMap<Integer, String>();
        Iterator iterator = ((HashMap) ((HashMap) INDEX.get("indexGEO"))).entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Long> appoggio = (Map.Entry<String, Long>) iterator.next();
            mappaInvertita.put(Math.toIntExact(appoggio.getValue()), appoggio.getKey());
        }

        JSONArray dati = new JSONArray();
        for(int i=0; i<((HashMap) ((HashMap) INDEX.get("indexGEO"))).size(); i++) {
            JSONObject nazione = new JSONObject();
            nazione.put("id", i);
            nazione.put("nazione", ((HashMap) ((HashMap) LABEL.get("labelGEO"))).get(mappaInvertita.get(i)));
            nazione.put("sigla", mappaInvertita.get(i));
            for(int a=0; a<((HashMap) ((HashMap) INDEX.get("indexTIME_PERIOD"))).size(); a++) {
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
