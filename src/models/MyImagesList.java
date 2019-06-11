package src.models;

import org.json.simple.JSONObject;
import src.helper.Constants;

import java.util.ArrayList;

public class MyImagesList {
    private ArrayList<MyImage> imgArr;
    private MyJsonManager jsonMan;
    private static MyImagesList INSTANCE = new MyImagesList();

    public MyImagesList() {
        init();
    }
    public static MyImagesList getInstance()
    {
        return INSTANCE;
    }
    private void init() {
        imgArr = new ArrayList<>();
        jsonMan = new MyJsonManager(Constants.IMAGES_JSON_FILE);
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
    public MyImage addImage(String path, String name, String creation_date, String modification_date) {
        JSONObject img_json = jsonMan.addJsonObject(path, name, creation_date,modification_date);
        MyImage img_tmp = new MyImage(path, name, creation_date,modification_date,img_json,jsonMan);
        imgArr.add(img_tmp);
        return img_tmp;
    }

}
