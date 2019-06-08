package src.models;

import org.json.simple.JSONObject;
import src.helper.Constants;

import java.time.LocalDateTime;

public class MyImage {
    private String path;
    private String name;
    private String creation_date;
    private String modification_date;
    private JSONObject img_json;
    private MyJsonManager jsonMan;

    public MyImage(String path, String name, String creation_date, String modification_date, JSONObject img_json, MyJsonManager jsonMan) {
        this.path=path;
        this.name=name;
        this.creation_date=creation_date;
        this.modification_date=modification_date;
        this.img_json=img_json;
        this.jsonMan=jsonMan;
    }
    public String getName() { return this.name; }
    public String getPath() { return this.path; }
    public String getCreation_date() { return this.creation_date; }
    public String getModification_date() { return this.modification_date; }
    public void setName(String str) {
        this.name = str;
        setValueToJson("name", name);
    }

    public void setModificationDateNow() {
        modification_date = Constants.DATETIME_FILE_FORMATTER.format(LocalDateTime.now());
        setValueToJson("modification_date", modification_date);

    }
    private void setValueToJson(String key, String value) {
        this.img_json.put(key,value);
        jsonMan.updateJson();
        // System.out.println(key + ":" + value);
    }

}
