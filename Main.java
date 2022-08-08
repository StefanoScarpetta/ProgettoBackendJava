import Classi.DataInformation;
import Classi.Information;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import url.Download;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        String link = "https://webgate.ec.europa.eu/comp/redisstat/api/dissemination/sdmx/2.1/data/comp_ag_x$comp_ag_01?format=json&compressed=false";
        String directory = "C:\\Users\\stefa\\Documents\\GitHub\\ProgettoBackendJava\\url\\Scaricato.json";
        File out = new File(directory);
        new Thread(new Download(link, out)).start(); //da approfondire Thread() e .start();

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        try {
                            DataInformation.getDataInformation(directory);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, 2500
        );
    }
}