package mrurt.team56.movierecommender;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * HomePage
 */
public class HomePage extends AppCompatActivity {

    public static UserStorage mUserStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mUserStorage = new UserStorage();

    }

    /**
     * returns the user to the welcome screen after logging them out
     * @param view The view
     */
    public void logout(View view){
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
        finish();
    }


    /**
     * Returns the UserStorage
     * @return mUserStorage
     */
    public UserStorage getUserStorage() {
        return mUserStorage;
    }
}

