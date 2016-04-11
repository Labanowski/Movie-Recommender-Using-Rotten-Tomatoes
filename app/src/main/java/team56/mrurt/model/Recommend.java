package team56.mrurt.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import team56.mrurt.activity.LoginActivity;

/**
 * Created by Haruka.
 * Sorts the movies based on recommendation criteria
 */
<<<<<<< HEAD
public final class Recommend {

    /**
     * constructor for Recommend
     */
    private Recommend() {

    }
=======
public class Recommend {
>>>>>>> origin/master

    /**
     * Sorts the movie by year
     * @param year the year the user wants to see recommendation for
     * @return the list of the movie sorted from highest to lowest rating
     */
    public static List<Movie> sortByYear(String year) {
        final  List<Rating> ratedMovieList = RatingStorage.getInstance().getRatings();
        final List<Rating> ratings = new ArrayList<>();
        for (final Rating r : ratedMovieList){
            if (r.getMovie().getYear().equals(year)){
                ratings.add(r);
            }
        }
        Collections.sort(ratings);
<<<<<<< HEAD
        final List<Movie> moviesInYear = new ArrayList<>();
        for (final Rating r: ratings) {
=======
        List<Movie> moviesInYear = new ArrayList<>();
        for (Rating r: ratings) {
>>>>>>> origin/master
            moviesInYear.add(r.getMovie());
        }
        return moviesInYear;
    }

    /**
     * Sorts the movie by the user's major
     * @return the list of the movie sorted from highest to lowest rating
     */
    public static List<Movie> sortByMajor(){
<<<<<<< HEAD
        final List<Rating> ratedMovieList = RatingStorage.getInstance().getRatings();
        final  List<Rating> ratings = new ArrayList<>();
        final String currentLoggedIn = LoginActivity.currentLoggedInUser;
        final  User currentUser = UserStorage.getInstance().findUserByName(currentLoggedIn);
        for (final Rating r : ratedMovieList) {
=======
        List<Rating> ratedMovieList = RatingStorage.getInstance().getRatings();
        List<Rating> ratings = new ArrayList<>();
        String currentLoggedIn = LoginActivity.currentLoggedInUser;
        User currentUser = UserStorage.getInstance().findUserByName(currentLoggedIn);
        for (Rating r : ratedMovieList) {
>>>>>>> origin/master
            if (r.getMajor().equals(currentUser.getMajor())) {
                ratings.add(r);
            }
        }
        Collections.sort(ratings);
<<<<<<< HEAD
        final List<Movie> moviesForMajor = new ArrayList<>();
        for (final Rating r: ratings) {
=======
        List<Movie> moviesForMajor = new ArrayList<>();
        for (Rating r: ratings) {
>>>>>>> origin/master
            moviesForMajor.add(r.getMovie());
        }
        return moviesForMajor;
    }

}
