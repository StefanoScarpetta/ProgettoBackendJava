package Classi;

import java.util.HashMap;

public class Value {
    private HashMap value;

    public Value(HashMap value) {
        this.value = value;
    }

    public HashMap getValue() {
        return value;
    }

    public void setValue(HashMap value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                '}';
    }
}
