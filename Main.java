import Classi.Dimension;
import Classi.Id;
import Classi.Proprietà.Descrizione.Categorie.Index;
import Classi.Proprietà.Descrizione.Categorie.Label;
import Classi.Proprietà.Descrizione.Category;
import Classi.Proprietà.Descrizione.Title;
import Classi.Value;
import Convertitore.Converter;
import Convertitore.GeneralInformation;
import Convertitore.Reader;
import RestApi.ToRestApi;
import Risorse.Download;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        String link = "https://webgate.ec.europa.eu/comp/redisstat/api/dissemination/sdmx/2.1/data/comp_ag_x$comp_ag_01?format=json&compressed=false";
        String directory = "C:\\Users\\stefa\\Documents\\GitHub\\ProgettoBackendJava\\Risorse\\Scaricato.json";
        String api = "C:\\Users\\stefa\\Documents\\GitHub\\ProgettoBackendJava\\RestApi\\db.json";
        //File out = new File(directory);
        //Download download = new Download(link, out); //il file da scaricare dal link non esiste più, la parte di programma riguardante il download funziona
        //download.run();

        ToRestApi toRestApi = new ToRestApi(directory, api);
        toRestApi.run();

    }
}