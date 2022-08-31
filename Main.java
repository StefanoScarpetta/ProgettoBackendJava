import RestApi.ToRestApi;

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