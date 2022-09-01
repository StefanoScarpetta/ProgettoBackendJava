package Classi;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Category {
    private ArrayList<CategoryItem> lista;

    public Category(JSONObject category) {
        JSONObject index = (JSONObject) category.get("index");
        JSONObject label = (JSONObject) category.get("label");
        ArrayList<CategoryItem> temp = new ArrayList<>();
        Iterator iterKey = index.keySet().iterator();
        Iterator iterIndex = index.values().iterator();
        Iterator iterLabel = label.values().iterator();
        while(iterKey.hasNext()) {
            Object chiave = iterKey.next();
            Object ind = iterIndex.next();
            Object lab= iterLabel.next();
            temp.add(new CategoryItem(chiave, lab, ind));
        }
        this.lista = temp;
    }

    public ArrayList<CategoryItem> getLista() {
        return lista;
    }

    public void setLista(ArrayList<CategoryItem> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Category{" +
                "lista=" + lista +
                '}';
    }
}
