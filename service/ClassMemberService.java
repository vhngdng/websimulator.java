package service;

// import dto.MemberDto;
import model.Student;
import model.Teacher;
import model.User;
import repository.UserRepository;

public class ClassMemberService {

    private UserRepository userRepository;

    public ClassMemberService() {
        this.userRepository = new UserRepository();
    }

    /**
     * add new student
     * 
     * @param student
     * @return
     */
    public int addNewStudent(Student student) {
        System.out.println("Add new student: ");
        student.printInfo();
        userRepository.addNewUser(student);
        // gui mail thong bao
        // code logic gui mail o day ( vi du)
        return student.getId();
    }

    public User[] getMemberList() {
        User[] users = userRepository.getAllUser();
        return users;
    }

    /**
     * add new teacher
     * 
     * @param teacher
     * @return
     */
    public int addNewTeacher(Teacher teacher) {
        System.out.println("Add new teacher: ");
        teacher.printInfo();
        userRepository.addNewUser(teacher);
        // gui mail thong bao
        // code logic gui mail o day ( vi du)
        return teacher.getId();
    }

    /**
     * 
     * @param id
     * @return
     */
    public int deleteUser(int id) {
        System.out.println("Total User: " + userRepository.USER_COUNT);
        userRepository.deleteUser(id);
        int totalUser = userRepository.USER_COUNT;
        System.out.println("Remaining: " + totalUser);
        return totalUser;
    }

    /**
     * 
     * @param keyword
     * @return
     */
    public User[] hasKeyword(String keyword) {
       User[] user = userRepository.findUser(keyword);
        return user; 
    }

    public boolean findTeacherOrStudentByID (int id){
        User user = userRepository.getUserById(id);
        boolean result = (user.getRole().toLowerCase()).equals("giao vien");
        return result;
    }

    public User getTeacherWithID(int id) {
        User user = userRepository.getUserById(id);
            user = new Teacher(id, user.getName(), user.getBirthday(), user.getGender(), user.getEmail(), 
                                user.getPhoneNumber(), ((Teacher)user).getYearOfExperience(), ((Teacher)user).getSpeciality());


        return user;
    }
    
    public User getStudentWithID (int id) {
        User user = userRepository.getUserById(id);
        user = new Student(id, user.getName(), user.getBirthday(), user.getGender(), user.getEmail(), 
                                user.getPhoneNumber(), ((Student)user).getIsOnline(), ((Student)user).getBackground());
        
        return user;
    }
}
