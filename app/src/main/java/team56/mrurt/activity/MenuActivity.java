package team56.mrurt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * This hold the Menu methods
 */
public class MenuActivity extends AppCompatActivity {

    /**
     * Logout User
     * @param item the menu item clicked on
     */
    void logout(MenuItem item){
        finish();
    }

    /**
     * View/Edit Profile page
     * @param item the menu item clicked on
     */
<<<<<<< HEAD
    public void viewProfile(MenuItem item){
        final Intent intent = new Intent(this, ProfileActivity.class);
=======
    void viewProfile(MenuItem item){
        Intent intent = new Intent(this, ProfileActivity.class);
>>>>>>> origin/master
        startActivity(intent);
        finish();
    }

    /**
     * Takes user to Search Page
     * @param item the menu item clicked on
     */
<<<<<<< HEAD
    public void searchMovie(MenuItem item) {
        final Intent intent = new Intent(this, SearchMovieActivity.class);
=======
    void searchMovie(MenuItem item) {
        Intent intent = new Intent(this, SearchMovieActivity.class);
>>>>>>> origin/master
        startActivity(intent);
        finish();
    }

    /**
     * Takes user to Search Page
     * @param item the menu item clicked on
     */
<<<<<<< HEAD
    public void recommendMovie(MenuItem item) {
        final Intent intent = new Intent(this, RecommendMovieActivity.class);
=======
    void recommendMovie(MenuItem item) {
        Intent intent = new Intent(this, RecommendMovieActivity.class);
>>>>>>> origin/master
        startActivity(intent);
        finish();
    }

}
