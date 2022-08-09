package Classi.Proprietà.Descrizione;

import java.util.HashMap;

public class Category {
    private HashMap category;

    public Category(HashMap category) {
        this.category = category;
    }

    public HashMap getCategory() {
        return category;
    }

    public void setCategory(HashMap category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category=" + category +
                '}';
    }
}
