package Classi;

import Convertitore.Converter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class GeneralInformation {
    private String version;
    private String classe;
    private String label;
    private String source;
    private String updated;
    private HashMap value;
    private ArrayList id;
    private ArrayList size;
    private Dimension dimension;
    private Extension extension;
    private JSONObject js;

    public GeneralInformation(JSONObject js) {
        Converter converter = new Converter();
        this.js = js;
        this.id = (ArrayList) converter.ConverterArray((JSONArray) js.get("id"));
        this.classe = (String) js.get("class");
        this.dimension = new Dimension(converter.ConverterObj((JSONObject) js.get("dimension")), id);
        this.extension = new Extension(converter.ConverterObj((JSONObject) js.get("extension")));
        this.size = (ArrayList) converter.ConverterArray((JSONArray) js.get("size"));
        this.label = (String) js.get("label");
        this.source = (String) js.get("source");
        this.updated = (String) js.get("updated");
        this.version = (String) js.get("version");
        this.value = converter.ConverterObj((JSONObject) js.get("value"));
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public HashMap getValue() {
        return value;
    }

    public void setValue(HashMap value) {
        this.value = value;
    }

    public ArrayList getId() {
        return id;
    }

    public void setId(ArrayList id) {
        this.id = id;
    }

    public ArrayList getSize() {
        return size;
    }

    public void setSize(ArrayList size) {
        this.size = size;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "GeneralInformation{" +
                "version='" + version + '\'' +
                ", classe='" + classe + '\'' +
                ", label='" + label + '\'' +
                ", source='" + source + '\'' +
                ", updated='" + updated + '\'' +
                ", value=" + value +
                ", id=" + id +
                ", size=" + size +
                ", dimension=" + dimension +
                ", extension=" + extension +
                '}';
    }
}
