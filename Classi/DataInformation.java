package Classi;

import com.google.gson.Gson;
import com.sun.tools.javac.Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.runtime.ObjectMethods;
import java.util.List;

public class DataInformation {

    public static Information getDataInformation(String link) throws IOException, ParseException {
        JSONObject response = Utils.GET_JSON(link);
        Information information = new Information();
        Information.Value valueObj = information.new Value();

        JSONObject value = (JSONObject) response.get("value");
        valueObj._6 = (double) value.get("6");
        System.out.println("Dato con nome 3 di Value: " + value.get("3"));

        JSONObject dimension = (JSONObject) response.get("dimension");
        JSONObject GEO = (JSONObject) dimension.get("GEO");
        JSONObject categoryGeo = (JSONObject) GEO.get("category");
        JSONObject indexGeo = (JSONObject) categoryGeo.get("index");
        JSONObject labelGeo = (JSONObject) categoryGeo.get("label");
        JSONObject TIMEPERIOD = (JSONObject) dimension.get("TIME_PERIOD");
        JSONObject categoryTime = (JSONObject) TIMEPERIOD.get("category");
        JSONObject indexTime = (JSONObject) categoryTime.get("index");
        JSONObject labelTime = (JSONObject) categoryTime.get("label");
        System.out.println("2009 di label di TIMEPERIOD: " + labelTime.get("2009"));

        return information;
    }
}
