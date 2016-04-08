package com.example.alexlabanowski.movierecommenderusingrottentomatoes;

import org.junit.Assert;
import org.junit.Test;
import team56.mrurt.model.Movie;

/**
 * Created by Wyckoff.
 */
public class testSortByMajor {
    @Test
    public void testSortByMajorTest() {
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

        Assert.assertTrue(a.equals(b));
        Assert.assertTrue(b.equals(g));
        Assert.assertTrue(g.equals(a));

        Assert.assertFalse(a.equals(c));

        Assert.assertFalse(c.equals(d));

        Assert.assertFalse(e.equals(f));

    }
}
