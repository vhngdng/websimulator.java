package service;

import dto.MemberDto;
import dto.StudentDto;
import dto.TeacherDto;
import model.User;
import repository.UserRepository;

public class ClassMemberService {
    
    private UserRepository userRepository;

    public ClassMemberService() {
        this.userRepository = new UserRepository();
    }

    /**
     * add new student
     * @param studentDto
     * @return
     */
    public int addNewStudent(StudentDto studentDto) {
        return 0;
    }


    /**
     * add new teacher
     * @param teacherDto
     * @return
     */
    public int addNewTeacher(TeacherDto teacherDto) {
        return 0;
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
