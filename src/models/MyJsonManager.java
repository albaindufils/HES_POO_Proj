package src.models;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
}
