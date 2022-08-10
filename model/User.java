package model;

import java.time.LocalDate;

import util.DateTimeUtil;
public class User {
    protected int id;
    protected String name;
    protected LocalDate birthday;
    protected Gender gender;
    protected String email;
    protected String phoneNumber;

    public User(int id, String name, LocalDate birthday, Gender gender, String email, String phoneNumber) {
        this.id = id;
        this.name =name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void printInfo() {
        System.out.println("id: " + this.id + ", name: " + this.name + ", birthday: " + DateTimeUtil.convertLocalDateToString(this.birthday)
        + ", gender: " + this.gender + ", email: " + this.email + ", phone number: " + this.phoneNumber);
    }
    
}
