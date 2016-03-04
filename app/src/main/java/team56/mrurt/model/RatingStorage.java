package team56.mrurt.model;

import java.util.ArrayList;

/**
 * Created by Haruka on 2016/03/04.
 */
/**
 * A class that stores ratings and the users that rated them, stored locally
 */
public class RatingStorage {

    private ArrayList<Rating> ratings;
    private static RatingStorage rsInstance;

    private RatingStorage() {
        ratings = new ArrayList<>();
    }

    /**
     * Gets an instance of Rating Storage
     * @return returns the instance of RatingStorage
     */
    public static RatingStorage getInstance() {
        if (rsInstance == null) {
            rsInstance = new RatingStorage();
        }
        return rsInstance;

    }

    /**
     * gets the list of ratings stored
     * @return returns list of ratings
     */
    public ArrayList<Rating> getRatings() {
        return this.ratings;
    }

    /**
     * Adds rating to storage
     * @param rating rating to be added
     */
    public void addRating(Rating rating) {
        this.ratings.add(rating);
    }

    /**
     * Removes rating from this storage
     * @param m is rating to be removed.
     */
    public void removeRating(Rating m) {
        this.ratings.remove(m);
    }

    /**
     * Gets average Rating of Movie by a particular major group
     *
     * @param movie_id id of the movie when want the average rating of
     * @param major      the major of the user
     * @return the average rating for that major group
     */
    public double getAverageRatingByMajor(String movie_id, String major) {
        double movie_rating = 0;
        int counter = 0;
        for (Rating r : this.ratings) {
            if (r.getMovie_id().equals(movie_id) && r.getMajor().equals(major)) {
                counter++;
                movie_rating = ((r.getMovie_Rating()) + movie_rating) / counter;
            }
        }
        return movie_rating;
    }

    /**
     * Gets average rating for a movie
     *
     * @param movie_id id of the movie when want the average rating of
     * @return the average rating
     */
    public String getAverageRating(String movie_id) {
        double movie_rating = 0;
        int counter = 0;
        for (Rating r : this.ratings) {
            if (r.getMovie_id().equals(movie_id)) {
                counter++;
                movie_rating = ((r.getMovie_Rating()) + movie_rating) / counter;
            }
        }
        return "Average User Rating: " + movie_rating ;
    }


}
