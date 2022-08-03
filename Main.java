import url.Download;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        String link = "https://webgate.ec.europa.eu/comp/redisstat/api/dissemination/sdmx/2.1/data/comp_ag_x$comp_ag_01?format=json&compressed=false";
        File out = new File("C:\\Users\\stefa\\Documents\\GitHub\\ProgettoBackendJava\\url\\Scaricato.json");
        new Thread(new Download(link, out)).start(); //da approfondire Thread() e .start();

    }

}