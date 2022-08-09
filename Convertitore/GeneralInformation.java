package Convertitore;

import com.sun.tools.javac.Main;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GeneralInformation {
    private HashMap information;
    private JSONObject generalInformation;

    public GeneralInformation(HashMap information, JSONObject generalInformation) {
        this.information = information;
        this.generalInformation = generalInformation;
    }

    public JSONObject getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(JSONObject generalInformation) {
        this.generalInformation = generalInformation;
    }

    public HashMap getInformation() {
        return information;
    }

    public void setInformation(HashMap information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "GeneralInformation{" +
                "information=" + information +
                ", generalInformation=" + generalInformation +
                '}';
    }
}
