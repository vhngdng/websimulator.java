package dto;

enum UserType {
    STUDENT, 
    TEACHER
}
public class MemberDto {
    String name;
    String gender;
    String birthday;
    String email;
    String phoneNumber;
    UserType userType;
}
