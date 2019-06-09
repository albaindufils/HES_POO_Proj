package src.models;

import java.util.ArrayList;

public class ListContact {
    private ArrayList<Contact> ContactArr;
    private MyJsonManager jsonMan;


    public ListContact() {
        ContactArr = new ArrayList<>();
        init();
    }



    public void init() {

    }
    public ArrayList<Contact> getArrayList() {
        return ContactArr;
    }
}
