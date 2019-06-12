package src.models;

import org.json.simple.JSONObject;

import javax.swing.*;

public class Contact implements Comparable< Contact > {
    private String firstName;
    private String lastName;
    private String companyName;
    private String phoneNumber;
    private String address;
    private String dateOfBirth;
    private String emailAddress;
    private String city;
    private MyJsonManager jsonMan;
    private JSONObject ctc_json;
    private JPanel pan=null;

    public Contact(String firstName, String lastName, String companyName, String phoneNumber,
                   String address, String city, /*String zipcode,*/ String dateOfBirth, String emailAddress, JSONObject ctc_json, MyJsonManager jsonMan) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.city = city;
        this.ctc_json = ctc_json;
        this.jsonMan=jsonMan;
    }
    public JSONObject getJsonObject() {return ctc_json;}
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getcity() { return city; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setValueToJson("firstName",firstName);
    }
    public void setCity(String city) {
        this.city = city;
        setValueToJson("city",city);

    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
        setValueToJson("city",city);

    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
        setValueToJson("companyName",companyName);

    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        setValueToJson("phoneNumber",phoneNumber);

    }
    public void setAddress(String address) {
        this.address = address;
        setValueToJson("address",address);

    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        setValueToJson("dateOfBirth",dateOfBirth);

    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        setValueToJson("emailAddress",emailAddress);

    }
    public JPanel getOneContactPanel(){ return pan; }
    public void setOneContactPanel(JPanel pan){ this.pan=pan; }



    private void setValueToJson(String key, String value) {
        this.ctc_json.put(key,value);
        jsonMan.updateJson();
        System.out.println(key + ":" + value);
    }
    @Override
    public int compareTo(Contact o) {
        return this.getLastName().compareTo(o.getLastName());
    }
    @Override
    public String toString() {
        return "[lastname=" + lastName + ",firstName="+firstName+"]";
    }

}
