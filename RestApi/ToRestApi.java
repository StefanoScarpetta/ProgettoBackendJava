package RestApi;

import Classi.*;
import Convertitore.Converter;
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

        GeneralInformation generalInformation = new GeneralInformation(js);

        Map<Integer, String> mappaInvertita = new HashMap<Integer, String>();
        Iterator iterator = (generalInformation.getDimension().getItem("GEO").getCategory().getIndex()).entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Long> appoggio = (Map.Entry<String, Long>) iterator.next();
            mappaInvertita.put(Math.toIntExact(appoggio.getValue()), appoggio.getKey());
        }

        JSONArray dati = new JSONArray();
        for(int i=0; i<(generalInformation.getDimension().getItem("GEO").getCategory().getIndex()).size(); i++) {
            JSONObject nazione = new JSONObject();
            nazione.put("id", i);
            nazione.put("nazione", (generalInformation.getDimension().getItem("GEO").getCategory().getLabel()).get(mappaInvertita.get(i)));
            nazione.put("sigla", mappaInvertita.get(i));
            for(int a=0; a<(generalInformation.getDimension().getItem("TIME_PERIOD").getCategory().getIndex()).size(); a++) {
                int b= i*36;
                if(a<10) {
                    nazione.put("200"+a, generalInformation.getValue().get(String.valueOf(b+a)));
                } else {
                    nazione.put("20"+a, generalInformation.getValue().get(String.valueOf(b+a)));
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
