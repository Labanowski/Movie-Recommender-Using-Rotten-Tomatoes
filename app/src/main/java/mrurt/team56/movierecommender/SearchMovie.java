package mrurt.team56.movierecommender;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kuisit
 */
public class SearchMovie extends AppCompatActivity {
    public static UserStorage mUserStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movie);
    }

}
