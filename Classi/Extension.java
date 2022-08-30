package Classi;

import java.util.HashMap;

public class Extension {
    private HashMap extension;

    public Extension(HashMap extension) {
        this.extension = extension;
    }

    public HashMap getExtension() {
        return extension;
    }

    public void setExtension(HashMap extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "Extension{" +
                "extension=" + extension +
                '}';
    }
}
