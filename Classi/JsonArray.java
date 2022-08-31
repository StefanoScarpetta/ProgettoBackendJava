package Classi;

import org.json.simple.JSONArray;

public class JsonArray {
    private JSONArray jsonarray;

    public JsonArray(JSONArray jsonarray) {
        this.jsonarray = jsonarray;
    }

    public JSONArray getJsonarray() {
        return jsonarray;
    }

    public void setJsonarrayId(JSONArray jsonarray) {
        this.jsonarray = jsonarray;
    }

    @Override
    public String toString() {
        return "JsonArray{" +
                "jsonarray=" + jsonarray +
                '}';
    }
}
