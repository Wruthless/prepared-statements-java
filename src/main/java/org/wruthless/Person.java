package org.wruthless;

public class Person {

    private int addressID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Person(){}

    public Person(int addressID, String firstName, String lastName, String email,
                  String phoneNumber) {

        setAddressID(addressID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);

    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAddressID() {
        return addressID;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


} // end Person{}
