package mrurt.team56.movierecommender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by connorwyckoff
 */
public class HomePage extends AppCompatActivity {

    public static UserStorage mUserStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mUserStorage = new UserStorage();

    }

    public void searchMovie(View view) {
        Intent intent = new Intent(this, SearchMovie.class);
        startActivity(intent);
        finish();
    }

    public void viewProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
        finish();
    }

    public void logout(View view){
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
        finish();
    }

    public UserStorage getUserStorage() {
        return mUserStorage;
    }
}
