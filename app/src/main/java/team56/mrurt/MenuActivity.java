package team56.mrurt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by Haruka on 2016/02/21.
 */
/**
 * This hold the Menu methods
 */
public class MenuActivity extends AppCompatActivity {

    /**
     * Logout User
     * @param item the menu item clicked on
     */
    public void logout(MenuItem item){
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
        finish();
    }

    /**
     * View/Edit Profile page
     * @param item the menu item clicked on
     */
    public void viewProfile(MenuItem item){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
        finish();
    }

    /**
     * Takes user to Search Page
     * @param item the menu item clicked on
     */
    public void searchMovie(MenuItem item) {
        Intent intent = new Intent(this, SearchMovieActivity.class);
        startActivity(intent);
        finish();
    }

}
