package model;

import java.time.LocalDate;

public class Teacher extends User {
    private int yearOfExperience;
    private String speciality;

    public Teacher(int id, String name, LocalDate birthday, Gender gender, String email, String phoneNumber, int yearOfExperience, String speciality) {
        super(id, name, birthday, gender, email, phoneNumber);
        this.yearOfExperience = yearOfExperience;
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public int getYearOfExperience() {
        return this.yearOfExperience;
    }
}