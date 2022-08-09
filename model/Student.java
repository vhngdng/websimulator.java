package model;

import java.time.LocalDate;

public class Student extends User {
    private boolean isOnline;
    private String background;

    public Student(int id, String name, LocalDate birthday, Gender gender, String email, String phoneNumber, boolean isOnline, String background) {
        super(id, name, birthday, gender, email, phoneNumber);
        this.isOnline = isOnline;
        this.background = background;
    }
    public boolean getIsOnline() {
        return this.isOnline;
    }
    public String getBackground() {
        return this.background;
    }
    
}
