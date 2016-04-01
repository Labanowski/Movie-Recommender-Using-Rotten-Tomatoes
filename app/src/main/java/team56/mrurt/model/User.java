package team56.mrurt.model;


import java.util.ArrayList;

/**
 * Created by Wyckoff on 2/13/2016.
 */

/**
 * A class that represents a User
 */
public class User {
    private String email;
    private String username;
    private String name;
    private String major;
    private String password;
    private ArrayList<Rating> ratingList;
    private boolean banned;
    private boolean admin;

    /**
     * Creates a User Object
     * @param email user email
     * @param username username of user
     * @param name the name of the user
     * @param major the major
     * @param password the majors
     */
    public User(String email, String username, String name, String major, String password) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.major = major;
        this.password = password;
        this.ratingList = new ArrayList<>();
        this.banned = false;
        this.admin = false;
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

    /**
     * Set the user to be banned or not
     */
    public void setBanStatus(boolean status){
        this.banned = status;
    }

    /**
     * Set the user to be an Admin or not
     */
    public void setAdminStatus(boolean status){
        this.admin = status;
    }

    /**
     * Get the banned status
     * @return the int value
     */
    public int getBanStatus(){
        if(banned) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Get the admin status
     * @return the int value
     */
    public int getAdminStatus(){
        if(admin) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Set the user to be banned
     */
    public void banUser(){
        this.banned = true;
    }

    /**
     * Unban user
     */
    public void unbanUser(){
        this.banned = false;
    }

    /**
     * Get banned status
     * @return the status
     */
    public boolean isBanned(){
        return this.banned;
    }

    /**
     * Set the user to be an Admin
     */
    public void makeAdmin() { this.admin = true;}

    /**
     * Get admin status
     * @return the status
     */
    public boolean isAdmin(){
        return admin;
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

