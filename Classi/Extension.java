package Classi;

import org.json.simple.JSONArray;

import java.util.HashMap;

public class Extension {
    private String lang;
    private String id;
    private String agencyId;
    private String version;
    private JSONArray annotation;
    private HashMap datastructure;
    private HashMap extension;
    private HashMap annotationCollection;

    public Extension(HashMap extension) {
        this.extension = extension;
        this.agencyId = (String) extension.get("agencyId");
        this.annotation = (JSONArray) extension.get("annotation");
        this.id = (String) extension.get("id");
        this.datastructure = (HashMap) extension.get("datastructure");
        this.lang = (String) extension.get("lang");
        this.version = (String) extension.get("version");
        HashMap appoggio = new HashMap<>();
        for(int i=0; i<annotation.size(); i++) {
            appoggio.put(i, annotation.get(i));
        }
        this.annotationCollection = appoggio;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public JSONArray getAnnotation() {
        return annotation;
    }

    public void setAnnotation(JSONArray annotation) {
        this.annotation = annotation;
    }

    public HashMap getDatastructure() {
        return datastructure;
    }

    public void setDatastructure(HashMap datastructure) {
        this.datastructure = datastructure;
    }

    public HashMap getExtension() {
        return extension;
    }

    public void setExtension(HashMap extension) {
        this.extension = extension;
    }

    public HashMap getAnnotationCollection() {
        return annotationCollection;
    }

    public void setAnnotationCollection(HashMap annotationCollection) {
        this.annotationCollection = annotationCollection;
    }

    @Override
    public String toString() {
        return "Extension{" +
                "extension=" + extension +
                '}';
    }
}
