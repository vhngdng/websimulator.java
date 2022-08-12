package controller;

import java.time.LocalDate;

import org.json.JSONObject;

import dto.MemberDto;
import model.Gender;
import model.Student;
import model.Teacher;
import model.User;
import repository.UserRepository;
import service.ClassMemberService;
import util.Constants;
import util.DateTimeUtil;

public class ClassMemberController {

    private ClassMemberService classMemberService;

    public ClassMemberController() {
        this.classMemberService = new ClassMemberService();
    }

    /**
     * add moi student
     * 
     * @param studentDto
     * @return
     */
    public JSONObject addStudent(JSONObject studentInfo) {
        // convert json object to teacher Dto
        String name = studentInfo.get("name").toString();
        LocalDate birthday = DateTimeUtil.convertStringToLocalDate(studentInfo.get("birthday").toString());
        Gender gender = studentInfo.get("gender").toString().toLowerCase().equals("nam") ? Gender.MALE : Gender.FEMALE;
        String email = studentInfo.get("email").toString();
        String phoneNumber = studentInfo.get("phoneNumber").toString();
        boolean isOnline = studentInfo.get("isOnline").toString().toLowerCase().equals("y") ? true : false;
        String background = studentInfo.get("background").toString();
        Student student = new Student(0, name, birthday, gender, email, phoneNumber, isOnline, background);
        // call service
        int id = classMemberService.addNewStudent(student);
        System.out.println(", new user id: " + id);
        // create result
        JSONObject result = new JSONObject();
        result.put("status_code", Constants.OK);
        if (id > 0) {
            result.put("success", true);
            result.put("message", "Add student thanh cong");
        } else {
            result.put("success", false);
            result.put("message", "Add students that bai");
        }
        return result;

    }

    /**
     * add moi teacher
     * 
     * @param teachderDto
     * @return
     */
    public JSONObject addTeacher(JSONObject teacherInfo) {
        // convert json object to teacher Dto
        String name = teacherInfo.get("name").toString();
        LocalDate birthday = DateTimeUtil.convertStringToLocalDate(teacherInfo.get("birthday").toString());
        Gender gender = teacherInfo.get("gender").toString().toLowerCase().equals("nam") ? Gender.MALE : Gender.FEMALE;
        String email = teacherInfo.get("email").toString();
        String phoneNumber = teacherInfo.get("phoneNumber").toString();
        int yearOfExperience = Integer.parseInt(teacherInfo.get("yearOfExperience").toString());
        String speciality = teacherInfo.get("speciality").toString();

        Teacher teacher = new Teacher(0, name, birthday, gender, email, phoneNumber, yearOfExperience, speciality);
        // call service
        int id = classMemberService.addNewTeacher(teacher);
        System.out.println(", new user id: " + id);
        // create result
        JSONObject result = new JSONObject();
        result.put("status_code", Constants.OK);
        if (id > 0) {
            result.put("success", true);
            result.put("message", "Add teacher thanh cong");
        } else {
            result.put("success", false);
            result.put("message", "Add teacher that bai");
        }
        return result;
    }

    public JSONObject getMemberList() {
        User[] users = classMemberService.getMemberList();
        JSONObject userListJson = new JSONObject();
        JSONObject[] temp = new JSONObject[users.length];
        int count = 0;
        for (User user : users) {
            String name = user.getName();
            String role = "";
            String yearOfExperience = "";
            String speciality = "";
            String isOnline = "";
            String background = "";
            String birthday = user.getBirthday().toString();
            int id = user.getId();
            if (user instanceof Teacher) {
                role += "Giao vien";
                yearOfExperience = Integer.toString(((Teacher) user).getYearOfExperience());
                speciality = ((Teacher) user).getSpeciality();
            } else if (user instanceof Student) {
                role += "Sinh vien";
                background = ((Student) user).getBackground();
                if (((Student) user).getIsOnline() == true) {
                    isOnline = "hoc Online";
                } else {
                    isOnline = "hoc Offline";
                }

            }

            String gender = (user.getGender() == Gender.MALE) ? "nam" : "nu";
            String email = user.getEmail();
            String phoneNumber = user.getPhoneNumber();

            JSONObject userJson = new JSONObject();
            userJson.put("name", name);
            userJson.put("role", role);
            userJson.put("gender", gender);
            userJson.put("email", email);
            userJson.put("phoneNumber", phoneNumber);
            userJson.put("birthday", birthday);
            userJson.put("id", String.valueOf(id));
            
            if ((role.toLowerCase()).equals("giao vien")) {
                userJson.put("yearOfExperience", yearOfExperience);
                userJson.put("speciality", speciality);
            } else {
                userJson.put("isOnline", isOnline);
                userJson.put("background", background);
            }
            temp[count++] = userJson;
        }
        userListJson.put("data", temp );

        System.out.println(userListJson.toString());

        return userListJson;
    }

    /**
     * delete user by id
     * 
     * @param id
     * @return
     */
    public int deleteUser(int id) {
        
        int totalUser = classMemberService.deleteUser(id);
        return totalUser;
    }

    /**
     * search user by keyword
     * 
     * @param keyword
     * @return
     */
    public JSONObject hasKeyword(String keyword) {
        User[] users = classMemberService.hasKeyword(keyword);
        JSONObject userJson = new JSONObject();
        JSONObject userListJson = new JSONObject();
        JSONObject[] temp = new JSONObject[users.length];
        int count = 0;
        for (User user : users) {
            String name = user.getName();
            String role = "";
            String yearOfExperience = "";
            String speciality = "";
            String isOnline = "";
            String background = "";
            String birthday = user.getBirthday().toString();
            int id = user.getId();
            if (user instanceof Teacher) {
                role = "Giao vien";
                yearOfExperience = Integer.toString(((Teacher) user).getYearOfExperience());
                speciality = ((Teacher) user).getSpeciality();
            } else if (user instanceof Student) {
                role = "Sinh vien";
                background = ((Student) user).getBackground();
                if (((Student) user).getIsOnline() == true) {
                    isOnline = "hoc Online";
                } else {
                    isOnline = "hoc Offline";
                }

            }

            String gender = (user.getGender() == Gender.MALE) ? "nam" : "nu";
            String email = user.getEmail();
            String phoneNumber = user.getPhoneNumber();

            userJson.put("name", name);
            userJson.put("role", role);
            userJson.put("gender", gender);
            userJson.put("email", email);
            userJson.put("phoneNumber", phoneNumber);
            userJson.put("birthday", birthday);
            userJson.put("id",id);
            if (user instanceof Teacher) {
                userJson.put("yearOfExperience", yearOfExperience);
                userJson.put("speciality", speciality);
            } else {
                userJson.put("isOnline", isOnline);
                userJson.put("background", background);
            }

            temp[count++] = userJson;
            userListJson.put("data", temp);
        }

        // System.out.println(userListJson.toString());
        return userListJson;
    }

    //Find Student or Teacher
    public boolean findTeacherOrStudentByID (int id) {
        boolean result = classMemberService.findTeacherOrStudentByID(id);
        return result;
    }

    //Find member with ID
    public JSONObject findMemberWithID(int id) {  
        JSONObject userJson = new JSONObject();
        if (classMemberService.findTeacherOrStudentByID(id)) {
            userJson = getTeacherInfo(id);
        }else{             
            userJson = getStudentInfo(id);
        }
        return userJson;
    }
   
    // find Teacher with ID
    public JSONObject getTeacherInfo(int id) {
        User user = classMemberService.getTeacherWithID(id);
        JSONObject userJson = new JSONObject();

            String birthday = user.getBirthday().toString();
            String gender = (user.getGender() == Gender.MALE) ? "nam" : "nu";
            String email = user.getEmail();
            String phoneNumber = user.getPhoneNumber();
            String name = user.getName();
            String role = "Giao vien";
            int yearOfExperience = ((Teacher) user).getYearOfExperience();
            String speciality = ((Teacher) user).getSpeciality();

            userJson.put("name", name);
            userJson.put("role", role);
            userJson.put("gender", gender);
            userJson.put("email", email);
            userJson.put("phoneNumber", phoneNumber);
            userJson.put("birthday", birthday);
            userJson.put("id",id);
            userJson.put("yearOfExperience", yearOfExperience);
            userJson.put("speciality", speciality);

        return userJson;
    }

  

    // Find Student with ID
    public JSONObject getStudentInfo(int id) {
        User user = classMemberService.getStudentWithID(id);
        JSONObject userJson = new JSONObject();

            String birthday = user.getBirthday().toString();
            String gender = (user.getGender() == Gender.MALE) ? "nam" : "nu";
            String email = user.getEmail();
            String phoneNumber = user.getPhoneNumber();
            String name = user.getName();
            String role = "Sinh vien";
            String isOnline = ((Student)user).getIsOnline()? "Hoc Online" : "Hoc Offline";
            String background = ((Student)user).getBackground();

            userJson.put("name", name);
            userJson.put("role", role);
            userJson.put("gender", gender);
            userJson.put("email", email);
            userJson.put("phoneNumber", phoneNumber);
            userJson.put("birthday", birthday);
            userJson.put("id",id);
            userJson.put("isOnline", isOnline);
            userJson.put("background", background);

        return userJson;
    }

}
