package src.models;

public class Contact {
    private int contactId;
    private String firstName;
    private String lastName;
    private String companyName;
    private String phoneNumber;
    private String address;
    private String dateOfBirth;
    private String emailAddress;

    private Contact(int contactId, String firstName, String lastName, String companyName, String phoneNumber, String address, String dateOfBirth, String emailAddress) {

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;

    }

    public int getContactId() {
        return contactId;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getCompanyName() {
        return companyName;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    String getAddress() {
        return address;
    }

    String getDateOfBirth() {
        return dateOfBirth;
    }

    String getEmailAddress() {
        return emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void setAddress(String address) {
        this.address = address;
    }

    void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}