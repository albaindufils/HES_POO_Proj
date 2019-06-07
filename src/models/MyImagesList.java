package src.models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import src.helper.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyImagesList {
    private ArrayList<MyImage> imgArr;
    private JSONParser jsonParser;

    public MyImagesList() {
        imgArr = new ArrayList<>();
        jsonParser = new JSONParser();
        init();
    }
    private void init() {
        try (FileReader reader = new FileReader(Constants.IMAGES_JSON_FILE))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray images_list = (JSONArray) obj;

            images_list.forEach((emp) -> {
                JSONObject emp_tmp = (JSONObject) emp;
                imgArr.add(new MyImage(
                        (String) emp_tmp.get("path"),
                        (String)emp_tmp.get("name"),
                        (String)emp_tmp.get("creation_date"),
                        (String)emp_tmp.get("modification_date")));
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<MyImage> getArrayList() {
        return imgArr;
    }
}
