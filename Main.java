import Classi.DataInformation;
import Classi.Information;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import url.Download;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        String link = "https://webgate.ec.europa.eu/comp/redisstat/api/dissemination/sdmx/2.1/data/comp_ag_x$comp_ag_01?format=json&compressed=false";
        File out = new File("C:\\Users\\stefa\\Documents\\GitHub\\ProgettoBackendJava\\url\\Scaricato.json");
        new Thread(new Download(link, out)).start(); //da approfondire Thread() e .start();

        DataInformation.getDataInformation();

        //DataInformation.getDataInformation(json);
        //Information information = new Information();
        //System.out.println(information);


    }
}