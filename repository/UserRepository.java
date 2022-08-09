package repository;

import model.User;

public class UserRepository {
    public static int USER_COUNT = 0;

    User[] userList;

    public UserRepository() {
        this.userList = new User[100];
    }
    
    /**
     * add new user
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
     * @param id
     * @return
     */
    public User deleteUser(int id) {
        return null;
    }

    /**
     * get user by id
     * @param id
     * @return
     */
    public User getUserById(int id) {
        return null;
    }

    /**
     * lay toan bo danh sach users
     * @return
     */
    public User[] getAllUser() {
        return null;
    }
    
}
