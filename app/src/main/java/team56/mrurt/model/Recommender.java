package team56.mrurt.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

import team56.mrurt.R;
import team56.mrurt.activity.LoginActivity;
import team56.mrurt.activity.MovieListActivity;
import team56.mrurt.activity.WelcomeActivity;
import team56.mrurt.model.RatingStorage;

/**
 * Created by Haruka on 2016/03/04.
 * Sorts the movies based on recommendation criteria
 */
public class Recommender {
    static List<Movie> moviesInYear, moviesForMajor;
    static User currentUser;

    /**
     * Sorts the movie by year
     * @param year the year the user wants to see recommendation for
     * @return the arraylist of the movie sorted from highest to lowest rating
     */
    public static ArrayList<Movie> sortByYear(String year) {
        List<Rating> ratedMovieList = RatingStorage.getInstance().getRatings();
        List<Rating> ratings = new ArrayList<Rating>();
        for (Rating r : ratedMovieList) {
             if (r.getMovie().getYear().equals(year)) {
                 ratings.add(r);
             }
        }
        Collections.sort(ratings);
        moviesInYear = new ArrayList<Movie>();
        for (Rating r: ratings) {
            moviesInYear.add(r.getMovie());
        }
        return (ArrayList<Movie>) moviesInYear;
    }

    /**
     * Sorts the movie by the user's major
     * @return the arraylist of the movie sorted from highest to lowest rating
     */
    public static ArrayList<Movie> sortByMajor(){
        List<Rating> ratedMovieList = RatingStorage.getInstance().getRatings();
        List<Rating> ratings = new ArrayList<Rating>();
        String currentLoggedIn = LoginActivity.currentLoggedInUser;
        currentUser = WelcomeActivity.mUserStorage.findUserByName(currentLoggedIn);
        for (Rating r : ratedMovieList) {
            if (r.getMajor().equals(currentUser.getMajor())) {
                ratings.add(r);
            }
        }
        Collections.sort(ratings);
        moviesForMajor = new ArrayList<Movie>();
        for (Rating r: ratings) {
            moviesForMajor.add(r.getMovie());
        }
        return (ArrayList<Movie>) moviesForMajor;
    }

}
