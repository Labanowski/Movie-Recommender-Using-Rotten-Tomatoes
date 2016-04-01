package team56.mrurt.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wyckoff on 2/13/2016.
 */
/**
 * A class thats holds the list of Users
 */
public class UserStorage {
    private static Map<String, User> users = new HashMap<>();
    private static UserStorage usInstance;
    /**
     * Gets an instance of User Storage
     * @return returns the instance of UserStorage
     */
    public static UserStorage getInstance() {
        if (usInstance == null) {
            usInstance = new UserStorage();
        }
        return usInstance;

    }

    /**
     * Gets the list of Users from the database and
     * puts them into UserStorage for local user
     * @param list1 the list of users from database
     */
    public void setUserList(ArrayList<User> list1) {
        ArrayList<User> list = list1;

        for(int a = 0; a < list.size(); a++) {
            users.put(list1.get(a).getUsername(), list1.get(a));
        }
    }

    /**
     * Updates userstorage when changes were made to database
     * @param list the list of users from database
     */
    public void updateUserDatabase(ArrayList<User> list) {
        users.clear();
        setUserList(list);
    }
    /**
     * Find the user in the map by their username
     * @param username the user's username
     * @return the User with the corresponding username
     */
    public User findUserByName(String username){
        return users.get(username);
    }

    /**
     * Adds a user to the map
     * @param email email of new user
     * @param username username of new user
     * @param name name of new user
     * @param major major of new user
     * @param password password of new user
     */
    public void addUser(String email, String username, String name, String major, String password) {
        User user = new User(email, username, name, major, password);
        users.put(username, user);
    }

    /**
     * removes the user with the corresponding username from the map
     * @param username the username of the user being removed
     */
    public void remove(String username) {
        users.remove(username);
    }

    /**
     * Determines if the user trying to log in is registered or not
     * @param userName Username that the user input
     * @param password password that the user input
     * @return If the user is registered, return true;
     */
    public boolean handleLoginRequest(String userName, String password) {
        User user = findUserByName(userName);
        if (user == null) {
            return false;
        } else {
            return user.checkPassword(password);
        }
    }

    /**
     * Gets the list of Users in array form
     * @return the array of users
     */
    public String[] toArray(){
        return Arrays.copyOf(this.users.keySet().toArray(), this.users.keySet().toArray().length, String[].class);
    }

}