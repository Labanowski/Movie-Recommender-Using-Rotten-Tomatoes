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

    public void setEmail(String email) {
        email = this.email;
    }

    public String getEmail(){
        return email;
    }

    public void setUsername(String username) {
        username = this.username;
    }

    public String getUsername(){
        return username;
    }

    public void setName(String name) {
        name = this.name;
    }

    public String getName(){
        return name;
    }

    public void setMajor(String major) {
        major = this.major;
    }

    public String getMajor(){
        return major;
    }

    public void setPassword(String password) {
        password = this.password;
    }

    public String getPassword(){
        return password;
    }

    public boolean checkPassword(String pass) {
        return password.equals(pass);
    }
}
