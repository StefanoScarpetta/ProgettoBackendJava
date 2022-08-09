package Classi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Id {
    private JSONArray id;

    public Id(JSONArray id) {
        this.id = id;
    }

    public JSONArray getId() {
        return id;
    }

    public void setId(JSONArray id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id{" +
                "id=" + id +
                '}';
    }
}
