package mrurt.team56.movierecommender;

/**
 * Created by Wyckoff on 2/13/2016.
 */
public class User {
    private String email;
    private String username;
    private String name;
    private String major;
    private String password;

    public User(String email, String username, String name, String major, String password) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.major = major;
        this.password = password;
    }

    /**
     * Returns the user's email
     * @return email
     */
    public String getEmail(){
        return email;
    }

    /**
     * Returns the user's username
     * @return username
     */
    public String getUsername(){
        return username;
    }

    /**
     * Return the user's name
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * return the user's Major
     * @return major
     */
    public String getMajor(){
        return major;
    }

    /**
     * Return the user's password
     * @return password
     */
    public String getPassword(){
        return password;
    }

    /**
     * Determines if the inputed password matches the user's password
     * @param pass password being checked
     * @return True if the passwords match
     */
    public boolean checkPassword(String pass) {
        return password.equals(pass);
    }
}
