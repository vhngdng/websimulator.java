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
        return 0;
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
