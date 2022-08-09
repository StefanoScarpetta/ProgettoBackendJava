package Classi;

import java.util.HashMap;

public class Dimension {
    private HashMap dimension;

    public Dimension(HashMap dimension) {
        this.dimension = dimension;
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
