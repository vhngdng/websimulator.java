package model;

public class Teacher extends User {
    private int yearOfExperience;
    public String speciality;

    public Teacher(String name, String birthday, Gender gender, String email, String phoneNumber) {
        super(name, birthday, gender, email, phoneNumber);
        //TODO Auto-generated constructor stub
    }
}
