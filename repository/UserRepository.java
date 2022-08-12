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
        User people = new User(id, null, null, null, null, null);
        userList[id - 1] = people;
        if (USER_COUNT >= 1) {
        USER_COUNT = USER_COUNT -1;
        }else{
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
        User user = null;
        for (int i = 0; i < 100; i++) {
            if (id == userList[i].getId() ) {
              user = userList[i];  
            }else{
                System.out.println("Khong tim thay ID");
                break;
            }

        }
    return user;
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
        User user[] = getAllUser();
        for (User usr : user) {
            String speciality = ((Teacher) usr).getSpeciality();
            String background = ((Student) usr).getBackground();
            if (usr.getName().toLowerCase().contains(keyword)
                    || usr.getBirthday().toString().contains(keyword)
                    || usr.getEmail().toLowerCase().contains(keyword)
                    || Integer.toString(usr.getId()).contains(keyword)
                    || usr.getPhoneNumber().contains(keyword)
                    || (speciality.toLowerCase().equals(keyword) && usr instanceof Teacher)
                    || (background.toLowerCase().equals(keyword) && usr instanceof Student)) {
                temp++;
            }
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
                        || (((Teacher) usr).getSpeciality().toLowerCase().contains(keyword) && usr instanceof Teacher)
                        || (((Student) usr).getBackground().toLowerCase().contains(keyword)
                                && usr instanceof Student)) {
                    userHasKeyword[i++] = usr;

                }
            }
        }
        return userHasKeyword;
    }
}
