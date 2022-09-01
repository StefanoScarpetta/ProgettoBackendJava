package Classi;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Item {
    private Category category;
    private String label;
    private HashMap item;
    private String nome;

    public Item(HashMap item, String nome) {
        this.nome = nome;
        this.item = item;
        JSONObject appoggio = (JSONObject) item.get(nome);
        this.category = new Category((JSONObject) appoggio.get("category"));
        this.label = (String) appoggio.get("label");
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
}
