package Classi;

import java.util.ArrayList;
import java.util.HashMap;

public class Dimension {
    private ArrayList<Item> items;
    private ArrayList ids;

    public Dimension(HashMap dimension, ArrayList ids) {
        this.ids = ids;
        ArrayList<Item> temp = new ArrayList<>();
        for(int i=0; i<ids.size(); i++){
            temp.add(new Item((HashMap) dimension.get(ids.get(i)), (String) ids.get(i)));
        }
        this.items = temp;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "item=" + items +
                '}';
    }
}
