package team56.mrurt.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import team56.mrurt.R;

/**
 * Created by Haruka on 2016/03/04.
 */
public class Recommender extends AppCompatActivity {
    private Button recommendGenre;
    private Button recommendMajor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend_movie_activity);

        this.recommendGenre= (Button) findViewById(R.id.recommend_genre);
        this.recommendMajor = (Button) findViewById(R.id.recommend_major);

        recommendGenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        recommendMajor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
