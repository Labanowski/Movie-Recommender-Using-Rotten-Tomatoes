package team56.mrurt.model;

/**
 * Created by Haruka on 2016/03/04.
 */

/**
 * A rating for a movie and stores the username that rated a movie
 */
public class Rating {
    private String major;
    private String user;
    private String movie_id;
    private double movie_Rating;

    public Rating(String major, String user, String movie_id, double movie_Rating) {
        this.major = major;
        this.user = user;
        this.movie_id = movie_id;
        this.movie_Rating = movie_Rating;
    }

    /**
     * Gets user Major
     * @return the major
     */
    public String getMajor() {
        return this.major;
    }

    /**
     * Gets username of User(toString())
     * @return the user
     * */
    public String getUser() {
        return this.user;
    }

    /**
     * Get the rated movie id string
     * @return the movie id
     */
    public String getMovie_id() {
        return this.movie_id;
    }

    /**
     * Get the rating of the movie
     * @return the movie id
     */
    public Double getMovie_Rating() {
        return this.movie_Rating;
    }

    @Override
    public boolean equals(Object o) {
        Rating r = (Rating) o;
        if(r.getUser().equals(this.user)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.user.hashCode();
    }

    /**
     * The movie_id and movie rating
     * @return the string representation of Rating
     */
    public String toString(){
        return movie_id + " " + movie_Rating + " " + user;
    }

}
