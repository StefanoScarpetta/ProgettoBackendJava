package Classi;

import java.util.HashMap;

public class Hashmap {
    private HashMap hashmap;

    public Hashmap(HashMap hashmap) {
        this.hashmap = hashmap;
    }

    public HashMap getHashmap() {
        return hashmap;
    }

    public void setHashmap(HashMap hashmap) {
        this.hashmap = hashmap;
    }

    @Override
    public String toString() {
        return "Hashmap{" +
                "hashmap=" + hashmap +
                '}';
    }
}
