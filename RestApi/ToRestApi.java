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

        GeneralInformation generalInformation = new GeneralInformation(js);

        JSONArray dati = new JSONArray();
        for(int i=0; i<generalInformation.getDimension().getItems().get(1).getCategory().getLista().size(); i++) {
            JSONObject nazione = new JSONObject();
            nazione.put("id", generalInformation.getDimension().getItems().get(1).getCategory().getLista().get(i).getIndex());
            nazione.put("nazione", generalInformation.getDimension().getItems().get(1).getCategory().getLista().get(i).getLabel());
            nazione.put("sigla", generalInformation.getDimension().getItems().get(1).getCategory().getLista().get(i).getKey());
            for(int a=0; a<(generalInformation.getDimension().getItems().get(4).getCategory().getLista()).size(); a++) {
                int b= (int) (((long) generalInformation.getDimension().getItems().get(1).getCategory().getLista().get(i).getIndex())*36);
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
