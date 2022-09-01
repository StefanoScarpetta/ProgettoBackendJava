package Classi;

public class CategoryItem {
    private Object label;
    private Object key;
    private Object index;

    public CategoryItem(Object key, Object label, Object index) {
        this.key = key;
        this.index = index;
        this.label = label;
    }

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getIndex() {
        return index;
    }

    public void setIndex(Object index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "CategoryItems{" +
                "label='" + label + '\'' +
                ", key='" + key + '\'' +
                ", index=" + index +
                '}';
    }
}
