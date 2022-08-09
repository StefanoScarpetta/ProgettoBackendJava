package Convertitore;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Converter {

    public HashMap ConverterObj(JSONObject jsonObjectInfo) {
        HashMap inform = new HashMap();
        Iterator iterkey = jsonObjectInfo.keySet().iterator();
        Iterator itervalue = jsonObjectInfo.values().iterator();
        while(iterkey.hasNext()) {
            Object infokey = (Object) iterkey.next();
            Object infovalue = (Object) itervalue.next();
            inform.put(infokey, infovalue);
        }
        return inform;
     }

    public JSONArray ConverterArray(JSONArray id) {
        JSONArray ids = new JSONArray();
        Iterator iter = id.iterator();
        while(iter.hasNext()) {
            Object idObj = (Object) iter.next();
            ids.add(idObj);
        }
        return ids;
    }
}
