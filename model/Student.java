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

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public boolean getIsOnline() {
        return this.isOnline;
    }

    public void setBackground(String background){
        this.background = background;
    }

    public String getBackground() {
        return this.background;
    }
    
    @Override
    public void printInfo() {
        super.printInfo();
        if (isOnline){
            System.out.print(" background: " + background + ", đăng ký lớp Online" );
        }else{
            System.out.println(" background: " + background + ", đăng ký lớp Offline" );
        }
    }
}
