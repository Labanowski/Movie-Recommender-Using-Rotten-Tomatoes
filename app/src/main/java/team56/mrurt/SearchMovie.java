package team56.mrurt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kuiski on 2/21/2016.
 */
public class SearchMovie extends AppCompatActivity {
    public static UserStorage mUserStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_movie);

        mUserStorage = new UserStorage();
    }
}
