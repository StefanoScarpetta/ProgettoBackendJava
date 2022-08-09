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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {

    public static void main(String[] args) throws Exception {

        //String link = "https://webgate.ec.europa.eu/comp/redisstat/api/dissemination/sdmx/2.1/data/comp_ag_x$comp_ag_01?format=json&compressed=false";
        //String directory = "C:\\Users\\stefa\\Documents\\GitHub\\ProgettoBackendJava\\Risorse\\Scaricato.json";
        //File out = new File(directory);
        //Download download = new Download(link, out);
        //download.run();

        Reader reader = new Reader("C:\\Users\\stefa\\Documents\\GitHub\\ProgettoBackendJava\\Risorse\\Scaricato.json");
        JSONObject js = reader.getJsonObject();
        Converter converter = new Converter();

        GeneralInformation generalInformation = new GeneralInformation(converter.ConverterObj(js), js);
        System.out.println(generalInformation.getGeneralInformation());
        System.out.println(generalInformation.getInformation().get("dimension"));

        Value value = new Value(converter.ConverterObj((JSONObject) js.get("value")));
        System.out.println(value.getValue().get("6"));

        Id id = new Id(converter.ConverterArray((JSONArray) js.get("id")));
        System.out.println(id.getId().get(2));

        Dimension dimension = new Dimension(converter.ConverterObj((JSONObject) js.get("dimension")));
        System.out.println(dimension.getDimension().get("GEO"));

        int choose = 1;

        JSONObject appoggio = (JSONObject) ((JSONObject) js.get("dimension")).get(id.getId().get(choose));
        Title title = new Title((String) appoggio.get("label"));
        System.out.println(title.getTitle());
        Category category = new Category(converter.ConverterObj((JSONObject) appoggio.get("category")));
        System.out.println(category.getCategory().get("index"));

        JSONObject appoggio2 = (JSONObject) appoggio.get("category");
        Label label = new Label(converter.ConverterObj((JSONObject) appoggio2.get("label")));
        Index index = new Index(converter.ConverterObj((JSONObject) appoggio2.get("index")));
        System.out.println(label.getLabel().get("EU28"));
        System.out.println(index.getIndex().get("EU28"));

    }
}