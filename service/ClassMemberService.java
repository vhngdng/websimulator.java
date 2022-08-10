package service;

import dto.MemberDto;
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
     * get user by Id
     * @param id
     * @return
     */
    public User getUser(int id) {
        return null;
    }

    /**
     * 
     * @param id
     * @return
     */
    public int deleteUser(int id) {
        return 0;
    }

    /**
     * 
     * @param keyword
     * @return
     */
    public MemberDto[] searchByKeyword(String keyword) {
        return null;
    }

}
