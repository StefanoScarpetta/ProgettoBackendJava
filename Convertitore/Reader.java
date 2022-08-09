package Convertitore;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reader {
    private String fileName;
    private JSONObject jsonObject;

    public Reader(String fileName) throws IOException, ParseException {
        this.fileName = fileName;
        this.loadData();
    }

    private void loadData() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(this.fileName));
        this.jsonObject = (JSONObject) obj;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "fileName='" + fileName + '\'' +
                ", jsonObject=" + jsonObject +
                '}';
    }
}
