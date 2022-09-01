package Classi;

import org.json.simple.JSONObject;

import java.util.HashMap;

public class Category {
    private  HashMap index;
    private  HashMap label;
    private JSONObject category;

    public Category(JSONObject category) {
        this.category = category;
        this.index = (HashMap) category.get("index");
        this.label = (HashMap) category.get("label");
    }

    public HashMap getIndex() {
        return index;
    }

    public void setIndex(HashMap index) {
        this.index = index;
    }

    public HashMap getLabel() {
        return label;
    }

    public void setLabel(HashMap label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Category{" +
                "index=" + index +
                ", label=" + label +
                '}';
    }
}
