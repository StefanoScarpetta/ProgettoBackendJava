package Classi;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Dimension {
    private HashMap dimension;
    private Item item;
    private ArrayList id;
    private HashMap mappa;

    public Dimension(HashMap dimension, ArrayList id) {
        this.id = id;
        this.dimension = dimension;
        HashMap appoggio = new HashMap<>();
        for(int i = 0; i<id.size(); i++) {
            appoggio.put(id.get(i), dimension.get(id.get(i)));
        }
        this.mappa = appoggio;
    }

    public Item getItem(String nome) {
        return new Item(mappa, nome);
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public HashMap getDimension() {
        return dimension;
    }

    public void setDimension(HashMap dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "dimension=" + dimension +
                '}';
    }
}
