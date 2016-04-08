package com.example.alexlabanowski.movierecommenderusingrottentomatoes;

import junit.framework.*;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import team56.mrurt.activity.LoginActivity;
import team56.mrurt.model.Rating;
import team56.mrurt.model.RatingStorage;
import team56.mrurt.model.Recommender;
import team56.mrurt.model.User;
import team56.mrurt.model.UserStorage;
import team56.mrurt.model.Movie;
import team56.mrurt.model.Movies;

import static org.junit.Assert.*;


/**
 * Created by Wyckoff on 4/8/2016.
 */
public class testSortByMajor extends TestCase {
    @Test
    public void testSortByMajor() {
        System.out.println("Testing Equals Method in Movie Class");
        Movie a = new Movie();
        a.setTitle("Chicken Little");
        a.setYear("1980");

        Movie b = new Movie();
        b.setTitle("Chicken Little");
        b.setYear("1980");

        Movie g = new Movie();
        g.setTitle("Chicken Little");
        g.setYear("1981");

        Movie c = new Movie();
        c.setTitle("King Kong");
        c.setYear("1954");

        Movie d = new Movie();
        d.setTitle("King Kong 2");
        d.setYear("2012");


        Movie e = new Movie();
        e.setTitle("The Matrix");
        e.setYear("1999");

        Movie f = new Movie();
        f.setTitle("TheMatrix");
        f.setYear("1999");

        assertTrue(a.equals(b)));
        assertTrue(b.equals(g));
        assertTrue(g.equals(a));

        assertFalse(a.equals(c));

        assertFalse(c.equals(d));

        assertFalse(e.equals(f));

    }
}
