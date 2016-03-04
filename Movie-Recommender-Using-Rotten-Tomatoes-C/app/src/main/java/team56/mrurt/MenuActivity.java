package team56.mrurt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by Haruka on 2016/02/21.
 */
public class MenuActivity extends AppCompatActivity {

    public void logout(MenuItem item){
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
        finish();
    }

    public void viewProfile(MenuItem item){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
        finish();
    }

    public void searchMovie(MenuItem item) {
        Intent intent = new Intent(this, SearchMovie.class);
        startActivity(intent);
        finish();
    }

}
