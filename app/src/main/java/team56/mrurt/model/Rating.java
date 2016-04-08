package team56.mrurt.model;


import android.support.annotation.NonNull;

/**
 * A rating for a movie and stores the username that rated a movie
 */
public class Rating implements Comparable<Rating> {
    private String major;
    private String user;
    private Movie movie;
    private double movieRating;

    public Rating(String major, String user, Movie movie, double movieRating) {
        this.major = major;
        this.user = user;
        this.movie = movie;
        this.movieRating = movieRating;
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
     * Get the rated movie object
     * @return the movie
     */
    public Movie getMovie() {
        return this.movie;
    }

    /**
     * Get the rating of the movie
     * @return the movie id
     */
    public Double getMovieRating() {
        return this.movieRating;
    }

    public boolean equals(Rating r) {
        if(r.getMovie().equals(this.getMovie())) {
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
        return movie.getTitle() + " " + movieRating + " " + user;
    }

    @Override
    public int compareTo(@NonNull Rating a) {
        return (a.getMovieRating().compareTo(this.getMovieRating()));
    }

}
