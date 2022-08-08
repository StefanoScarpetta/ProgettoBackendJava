package Classi;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public static JSONObject GET_JSON(String url) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(url));
        StringBuilder result = new StringBuilder();
        String line;
        while((line= reader.readLine())!= null) {
            result.append(line);
        }
        reader.close();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result.toString());
        System.out.println(json);
        return json;
    }
}
