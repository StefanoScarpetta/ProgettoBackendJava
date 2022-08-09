package Classi.Proprietà.Descrizione.Categorie;

import java.util.HashMap;

public class Label {
    private HashMap label;

    public Label(HashMap label) {
        this.label = label;
    }

    public HashMap getLabel() {
        return label;
    }

    public void setLabel(HashMap label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Label{" +
                "label=" + label +
                '}';
    }
}
