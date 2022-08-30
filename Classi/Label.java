package Classi;

public class Label {
    private String label;

    public Label(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Label{" +
                "label='" + label + '\'' +
                '}';
    }
}
