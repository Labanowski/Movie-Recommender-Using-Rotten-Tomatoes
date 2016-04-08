package com.example.alexlabanowski.movierecommenderusingrottentomatoes;

import org.junit.Test;

import java.util.ArrayList;

import team56.mrurt.model.User;
import team56.mrurt.model.UserStorage;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class testUserList {
    @Test
    public void testUserList() {
        System.out.println("Testing setting the UserList");
        ArrayList<User> test = new ArrayList<>();
        UserStorage.getInstance().updateUserDatabase(test);
    }
}