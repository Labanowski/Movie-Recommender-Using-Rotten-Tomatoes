package com.example.alexlabanowski.movierecommenderusingrottentomatoes;

import junit.framework.TestCase;

import java.util.regex.Pattern;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import team56.mrurt.model.Rating;
import team56.mrurt.model.Movie;
import team56.mrurt.model.RatingStorage;
import team56.mrurt.model.Recommender;

import org.junit.Test;
import org.junit.Before;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

/**
 * Created by Wyckoff on 4/10/2016.
 */
public class testRatingStorage extends TestCase {
    @Test
    public void ratingStorageTest() throws Exception {
       /* System.out.println("Testing getInstance method in RatingStorage class");
        RatingStorage rs = new RatingStorage();

        User user =  new User("email.com", "u1", "n1", "e1", "p1",);
        Movie chickenLittle = new Movie();
        chickenLittle.setTitle("Chicken Little");

        Rating rating = new Rating(user.getMajor(), user.getUsername(), chickenLittle, 50.0);
        List<Rating> ratingList = new List<Rating>();
        ratingList.add(0, rating);

        */
        RatingStorage rs1 = null;

        assertTrue(rs1 == null);
        rs1.getInstance();

        assertFalse(rs1.equals(null));


        RatingStorage rs2 = new RatingStorage();
        assertFalse(rs2 == null);

        assertTrue(rs2.getInstance().equals(rs2);
    }
}
