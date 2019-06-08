package src.models;

import org.json.simple.JSONObject;
import src.helper.Constants;

import java.util.ArrayList;

public class MyImagesList {
    private ArrayList<MyImage> imgArr;
    private MyJsonManager jsonMan;
    public MyImagesList() {
        imgArr = new ArrayList<>();
        jsonMan = new MyJsonManager(Constants.IMAGES_JSON_FILE);
        init();
    }

    private void init() {
        jsonMan.getReadedJson().forEach((img) -> {
            JSONObject img_tmp = (JSONObject) img;
            imgArr.add(new MyImage(
                    (String) img_tmp.get("path"),
                    (String)img_tmp.get("name"),
                    (String)img_tmp.get("creation_date"),
                    (String)img_tmp.get("modification_date"), img_tmp, jsonMan));
        });

    }
    public ArrayList<MyImage> getArrayList() {
        return imgArr;
    }
}
