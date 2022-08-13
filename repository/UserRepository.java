package repository;

import model.Student;
import model.Teacher;
import model.User;
// import service.ClassMemberService;

public class UserRepository {
    public static int USER_COUNT = 0;

    User[] userList;

    public UserRepository() {
        this.userList = new User[100];
    }

    /**
     * add new user
     * 
     * @param person
     */
    public User addNewUser(User person) {

        int id = USER_COUNT + 1;
        person.setId(id);

        userList[USER_COUNT] = person;
        USER_COUNT++;
        return person;
    }

    /**
     * delete user by id
     * 
     * @param id
     * @return
     */
    public User deleteUser(int id) {
        User people = null;
        if (USER_COUNT >= 1) {

            for (int i = id - 1; i < USER_COUNT - 1; i++) {
                userList[i] = userList[i + 1];
            }
            
            
            userList[USER_COUNT - 1] = people;
            USER_COUNT = USER_COUNT - 1;
        } else {
            USER_COUNT = 0;
        }
        return people;
    }

    /**
     * get user by id
     * 
     * @param id
     * @return
     */
    public User getUserById(int id) {

        User users = new User(id, null, null, null, null, null);
        for (User usr : this.userList) {
            if (id == (usr.getId())) {
                users = usr;

                break;

            }

        }

        return users;
    }

    /**
     * lay toan bo danh sach users
     * 
     * @return
     */
    public User[] getAllUser() {
        int count = 0;
        for (User user : this.userList) {
            if (user != null) {
                count++;
            } else {
                break;
            }
        }
        int temp = 0;
        User[] users = new User[count];
        for (User user : this.userList) {
            if (user != null) {
                users[temp] = user;
                temp++;
            }
        }
        return users;
    }

    public User[] findUser(String keyword) {
        int temp = 0;

        User[] user = getAllUser();

        for (User usr : user) {
            if (usr.getName().toLowerCase().contains(keyword)
                    || usr.getBirthday().toString().contains(keyword)
                    || usr.getEmail().toLowerCase().contains(keyword)
                    || Integer.toString(usr.getId()).contains(keyword)
                    || usr.getPhoneNumber().contains(keyword)
                    || ((usr instanceof Teacher)
                            && ((Teacher) usr).getSpeciality().toLowerCase().contains(keyword))
                    || ((usr instanceof Student)
                            && ((Student) usr).getBackground().toLowerCase().contains(keyword))) {
                temp++;
            }
        }

        if (temp == 0) {
            User[] userHasKeyword = null;
            return userHasKeyword;
        }
        User[] userHasKeyword = new User[temp];
        if (temp != 0) {
            userHasKeyword = new User[temp];
            int i = 0;
            for (User usr : user) {
                if (usr.getName().toLowerCase().contains(keyword)
                        || usr.getBirthday().toString().contains(keyword)
                        || usr.getEmail().toLowerCase().contains(keyword)
                        || Integer.toString(usr.getId()).contains(keyword)
                        || usr.getPhoneNumber().contains(keyword)
                        || ((usr instanceof Teacher)
                                && ((Teacher) usr).getSpeciality().toLowerCase().contains(keyword))
                        || ((usr instanceof Student)
                                && ((Student) usr).getBackground().toLowerCase().contains(keyword))) {
                    userHasKeyword[i++] = usr;

                }
            }
        }
        return userHasKeyword;
    }
}
