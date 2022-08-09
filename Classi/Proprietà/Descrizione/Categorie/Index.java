package Classi.Proprietà.Descrizione.Categorie;

import java.util.HashMap;

public class Index {
    private HashMap index;

    public Index(HashMap index) {
        this.index = index;
    }

    public HashMap getIndex() {
        return index;
    }

    public void setIndex(HashMap index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Index{" +
                "index=" + index +
                '}';
    }
}
