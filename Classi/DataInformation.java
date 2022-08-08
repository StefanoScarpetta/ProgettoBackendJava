package Classi;

import com.sun.tools.javac.Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataInformation {

    public static void getDataInformation(String link) throws IOException, ParseException {
        JSONObject response = Utils.GET_JSON(link);
        Information information = new Information();

        JSONObject value = (JSONObject) response.get("value");
        System.out.println("Value: " + value);
        System.out.println("Dato con nome 3 di Value: " + value.get("3"));

        Information.Dimension dimensionObj = information.new Dimension();
        JSONObject dimension = (JSONObject) response.get("dimension");
        JSONObject GEO = (JSONObject) dimension.get("GEO");
        JSONObject categoryGeo = (JSONObject) GEO.get("category");
        JSONObject indexGeo = (JSONObject) categoryGeo.get("index");
        JSONObject labelGeo = (JSONObject) categoryGeo.get("label");
        JSONObject TIMEPERIOD = (JSONObject) dimension.get("TIME_PERIOD");
        JSONObject categoryTime = (JSONObject) TIMEPERIOD.get("category");
        JSONObject indexTime = (JSONObject) categoryTime.get("index");
        JSONObject labelTime = (JSONObject) categoryTime.get("label");
        System.out.println("Dimension: " + dimension);
        System.out.println("Label: " + labelGeo);
        System.out.println("DE di label di GEO: " + labelGeo.get("DE"));
        System.out.println("2009 di label di TIMEPERIOD: " + labelTime.get("2009"));


    }

}
