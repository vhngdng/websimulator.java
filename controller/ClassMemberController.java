package controller;

import dto.MemberDto;
import dto.StudentDto;
import dto.TeacherDto;
import service.ClassMemberService;

public class ClassMemberController {
    
    private ClassMemberService classMemberService;

    public ClassMemberController() {
        this.classMemberService = new ClassMemberService();
    }

    /**
     * add moi student
     * @param studentDto
     * @return
     */
    public int addStudent(StudentDto studentDto) {

        return 0;

    }

    /**
     * add moi teacher
     * @param teachderDto
     * @return
     */
    public int addTeacher(TeacherDto teachderDto) {
        return 0;
    }

    /**
     * delete user by id
     * @param id
     * @return
     */
    public int deleteUser(int id) {
        return 0;
    }

    /**
     * search user by keyword
     * @param keyword
     * @return
     */
    public MemberDto[] search(String keyword) {
        return null;
    }


    public StudentDto getStudentInfo(int id) {
        return null;
    }

    public TeacherDto getTeacherInfo(int id) {
        return null;
    }

}
