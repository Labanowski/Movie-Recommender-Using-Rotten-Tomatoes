package team56.mrurt.model;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by Haruka
 */
/**
 * A class that stores ratings and the users that rated them, stored locally
 */
public class RatingStorage {

    private List<Rating> ratings;
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
    public List<Rating> getRatings() {
        return this.ratings;
    }

    /**
     * gets the list of ratings stored
     * @return returns list of ratings
     */
    public void setRatings(List<Rating> list) {
        this.ratings = list;
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
     * @param list is rating to be removed.
     */
    public void updateRatingDatabase(List<Rating> list) {
        ratings.removeAll(ratings);
        setRatings(list);
    }

}
