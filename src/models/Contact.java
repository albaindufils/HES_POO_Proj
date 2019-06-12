package src.models;

import javax.swing.*;<<<<<<< HEAD
class Contact {

=======
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
    private JPanel pan=null;

    public Contact( String firstName, String lastName, String companyName, String phoneNumber,
                     String address, String city, /*String zipcode,*/ String dateOfBirth, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.city = city;

    }

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
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public JPanel getOneContactPanel(){ return pan; }
    public void setOneContactPanel(JPanel pan){ this.pan=pan; }
    @Override
    public int compareTo(Contact o) {
        return this.getLastName().compareTo(o.getLastName());
    }
    @Override
    public String toString() {
        return "[lastname=" + lastName + ",firstName="+firstName+"]";
    }
/*
    @Override
    public int compareTo(Contact comparestu) {
        int compareage=((Contact)comparestu).get();
        *//* For Ascending order*//*
        return this.studentage-compareage;

        *//* For Descending order do like this *//*
        //return compareage-this.studentage;
    }*/

>>>>>>> bd9f0b198943657311ff9686e5bca8342e5f4281
}
