package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bsisk
 */
public class JacksonDelegate {

    private static ObjectMapper mapper;

    public static void init() {
        if(mapper == null)
                mapper = new ObjectMapper();
    }

    public static String marshallMapToMultiArray(Map map) throws JacksonDelegateException {
        String jsonStr;
        try {
            Object[] twodArray = convertMapToMultiArray(map);
            jsonStr = mapper.writeValueAsString(twodArray);
        } catch (Exception x) {
            throw new JacksonDelegateException(x);
        }
        return jsonStr;
    }

    public static String objectToJson(Object o) throws JacksonDelegateException {
        try {
            return mapper.writeValueAsString(o);
        } catch (Exception x) {
            throw new JacksonDelegateException(x.getMessage(), x);
        }
    }

    public static Object jsonTextToObject(String json) throws JacksonDelegateException {
        try {
            JsonNode tree = mapper.readTree(json);
            return tree;
        } catch (IOException iox) {
            throw new JacksonDelegateException(iox);
        }
    }

    public static Map jsonTextToListWrapperMap(StringBuffer jsonText) throws JacksonDelegateException {
        StringBuffer wrappedJson = new StringBuffer();
        wrappedJson.append("{\"results\":" + jsonText + "}");
        return jsonTextToMap(wrappedJson);
    }

    public static Map<String, Object> jsonTextToMap(StringBuffer jsonText) throws JacksonDelegateException {
        Map<String, Object> responseJson = null;
        try {
            responseJson = mapper.readValue(jsonText.toString(), Map.class);
        } catch (IOException iox) {
            responseJson = null;
            throw new JacksonDelegateException(iox);
        }
        return responseJson;
    }

    public static List jsonTextToList(StringBuffer jsonText) throws JacksonDelegateException {
        List responseObj = null;
        try {
            responseObj = mapper.readValue(jsonText.toString(), List.class);
        } catch (IOException iox) {
            responseObj = null;
            throw new JacksonDelegateException(iox.getMessage(), iox);
        }
        return responseObj;
    }

    public static Object[] convertMapToMultiArray(Map m) {
        Iterator i = m.keySet().iterator();
        ArrayList ar = new ArrayList();
        if (m.size() == 0) {
            return new Object[0];
        }
        while (i.hasNext()) {
            Object[] currecord = new Object[2];
            String curkey = (String) i.next();
            if (curkey == null) {
                continue;
            }
            currecord[0] = curkey;
            currecord[1] = m.get(curkey);
            ar.add(currecord);
        }
        Object[] retval = (Object[]) ar.toArray(new Object[0]);
        System.out.println("created the multiarray...");
        System.out.println("its size is: " + retval.length);
        return retval;
    }
    
    

    public static String convertMapToObjectJson(Map m) throws JacksonDelegateException {
        try {
            return mapper.writeValueAsString(m);
        } catch (IOException iox) {
            throw new JacksonDelegateException(iox);
        }

    }

    public static String convertObjectListToJsonArray(List l) throws JacksonDelegateException {
        try {
            return mapper.writeValueAsString(l);
        } catch (IOException iox) {
            throw new JacksonDelegateException(iox);
        }
    }
}
