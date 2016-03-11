package team56.mrurt.model;


import java.util.ArrayList;

/**
 * Created by Wyckoff on 2/13/2016.
 */
public class User {
    private String email;
    private String username;
    private String name;
    private String major;
    private String password;
    private ArrayList<Rating> ratingList;

    public User(String email, String username, String name, String major, String password) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.major = major;
        this.password = password;
        this.ratingList = new ArrayList<>();
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

    /**
     * Add a rating to user's list of ratings made
     * @param newRating the new rating to be added
     */
    public void addRating(Rating newRating) {
        this.ratingList.add(newRating);
    }

    /**
     * Remove a rating to user's list of ratings made
     * @param oldRating the rating to be removed
     */
    public void removeRating(Rating oldRating) {
        this.ratingList.remove(oldRating);
    }

    /**
     * Return the user's ratings list
     * @return the user's rating list
     */
    public ArrayList<Rating> getRatingList() {
        return this.ratingList;
    }

    @Override
    public boolean equals(Object o) {
        User u = (User) o;
        if (u.getUsername().equals(this.getUsername())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getUsername().hashCode();
    }
}

