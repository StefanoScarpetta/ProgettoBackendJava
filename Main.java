import Classi.DataInformation;
import Classi.Information;
import url.Download;

import java.io.*;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws Exception {

        String link = "https://webgate.ec.europa.eu/comp/redisstat/api/dissemination/sdmx/2.1/data/comp_ag_x$comp_ag_01?format=json&compressed=false";
        String directory = "C:\\Users\\stefa\\Documents\\GitHub\\ProgettoBackendJava\\url\\Scaricato.json";
        File out = new File(directory);
        new Thread(new Download(link, out)).start(); //da approfondire Thread() e .start();

        Information information = new Information();
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        try {
                            System.out.println(DataInformation.getDataInformation(directory).value._6);
                            System.out.println(information.value._6);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (org.json.simple.parser.ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, 2500
        );

    }
}