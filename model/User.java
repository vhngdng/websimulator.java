package model;

import java.time.LocalDate;
public class User {
    protected int id;
    protected String name;
    protected LocalDate birthday;
    protected Gender gender;
    protected String email;
    protected String phoneNumber;

    public User(String name, String birthday, Gender gender, String email, String phoneNumber) {

    }

    public void setName(String name) {

    }

    public String getName() {
        return "";
    }

    public void setBirthDay(String birthday) {
    }

    public String getBirthday() {
        return "";
    }

    public void setGender(Gender gender) {

    }

    public Gender getGender() {
        return this.gender;
    }

    public void setEmail(String email) {
    
    }

    public void getEmail(String email) {

    }

    public void setPhoneNumber(String phoneNumber) {

    }

    public String getPhoneNumber() {
        return "";
    }
    
}
