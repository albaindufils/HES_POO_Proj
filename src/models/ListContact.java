package src.models;

import org.json.simple.JSONObject;
import src.helper.Constants;

import java.util.ArrayList;

public class ListContact {
    private ArrayList<Contact> contactArr;
    private MyJsonManager jsonMan;


    public ListContact() {
        contactArr = new ArrayList<>();
        jsonMan = new MyJsonManager(Constants.CONTACT_JSON_FILE);
        init();
    }



    public void init() {
        jsonMan.getReadedJson().forEach(ctct -> {
            JSONObject img_tmp = (JSONObject) ctct;
            contactArr.add(new Contact((String) img_tmp.get("firstName"),
                    (String) img_tmp.get("lastName"),
                    (String) img_tmp.get("companyName"),
                    (String) img_tmp.get("phoneNumber"),
                    (String) img_tmp.get("address"),
                    (String) img_tmp.get("city"),
                    //(String) img_tmp.get("zipcode"),
                    (String) img_tmp.get("dateOfBirth"),
                    (String) img_tmp.get("emailAddress")));
        });
    }
    public ArrayList<Contact> getArrayList() {
        return contactArr;
    }
}
