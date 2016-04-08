package team56.mrurt.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import team56.mrurt.activity.LoginActivity;

/**
 * Created by Haruka.
 * Sorts the movies based on recommendation criteria
 */
public class Recommend {

    /**
     * Sorts the movie by year
     * @param year the year the user wants to see recommendation for
     * @return the list of the movie sorted from highest to lowest rating
     */
    public static List<Movie> sortByYear(String year) {
        List<Rating> ratedMovieList = RatingStorage.getInstance().getRatings();
        List<Rating> ratings = new ArrayList<>();
        for (Rating r : ratedMovieList) {
             if (r.getMovie().getYear().equals(year)) {
                 ratings.add(r);
             }
        }
        Collections.sort(ratings);
        List<Movie> moviesInYear = new ArrayList<>();
        for (Rating r: ratings) {
            moviesInYear.add(r.getMovie());
        }
        return moviesInYear;
    }

    /**
     * Sorts the movie by the user's major
     * @return the list of the movie sorted from highest to lowest rating
     */
    public static List<Movie> sortByMajor(){
        List<Rating> ratedMovieList = RatingStorage.getInstance().getRatings();
        List<Rating> ratings = new ArrayList<>();
        String currentLoggedIn = LoginActivity.currentLoggedInUser;
        User currentUser = UserStorage.getInstance().findUserByName(currentLoggedIn);
        for (Rating r : ratedMovieList) {
            if (r.getMajor().equals(currentUser.getMajor())) {
                ratings.add(r);
            }
        }
        Collections.sort(ratings);
        List<Movie> moviesForMajor = new ArrayList<>();
        for (Rating r: ratings) {
            moviesForMajor.add(r.getMovie());
        }
        return moviesForMajor;
    }

}
