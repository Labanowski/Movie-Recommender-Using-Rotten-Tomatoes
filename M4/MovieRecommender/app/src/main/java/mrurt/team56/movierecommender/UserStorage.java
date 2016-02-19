package mrurt.team56.movierecommender;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wyckoff on 2/13/2016.
 */
public class UserStorage {
    public static Map<String, User> users = new HashMap<>();

    public UserStorage() {

    }

    public User findUserByName(String username){
        return users.get(username);
    }

    public void addUser(String email, String username, String name, String major, String password) {
        User user = new User(email, username, name, major, password);
        users.put(username, user);
    }


    public boolean handleLoginRequest(String userName, String password) {
        User user = findUserByName(userName);
        if (user == null) {
            return false;
        } else {
            return user.checkPassword(password);
        }
    }
}
