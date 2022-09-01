package Classi;

import org.json.simple.JSONObject;

import java.util.HashMap;

public class Item {
    private Category category;
    private String label;
    private String shortName;

    public Item(HashMap map, String shortName) {
        this.shortName = shortName;
        this.category = new Category((JSONObject) map.get("category"));
        this.label = (String) map.get("label");
    }

    public Item(Category category, String label, String shortName) {
        this.category = category;
        this.label = label;
        this.shortName = shortName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "category=" + category +
                ", label='" + label + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
