package src.models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

/**
 *
 */
public class MyJsonManager {
    private JSONParser jsonParser;
    private JSONArray jsonArray;
    private String jsonPath;

    public MyJsonManager(String path) {
        jsonParser=new JSONParser();
        this.jsonPath=path;
    }
    public JSONArray getReadedJson() {
        try (FileReader reader = new FileReader(jsonPath))
        {
            Object obj = jsonParser.parse(reader);
            jsonArray = (JSONArray) obj;
            return jsonArray;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateJson() {
        try (FileWriter file = new FileWriter(jsonPath))
        {
            file.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void removeObject(JSONObject jsobj) {
        jsonArray.remove(jsobj);
        this.updateJson();

    }
    public JSONObject addJsonObjectImage(String path, String name, String creation_date, String modification_date) {
        JSONObject jsonobj = new JSONObject();
        jsonobj.put("path", path);
        jsonobj.put("name", name);
        jsonobj.put("creation_date", creation_date);
        jsonobj.put("modification_date", modification_date);
        jsonArray.add(jsonobj);
        updateJson();
        return jsonobj;
    }
    public JSONObject addJsonObjectContact() {
        return null;
    }
}
