package team56.mrurt.activity;

/**
 * Created by Haruka on 2016/02/24.
 */
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.app.AlertDialog;

import team56.mrurt.R;
import team56.mrurt.model.Movie;
import team56.mrurt.model.Movies;
import team56.mrurt.model.Rating;
import team56.mrurt.model.RatingStorage;
import team56.mrurt.model.User;
import team56.mrurt.presenters.MovieDetailFragment;


/**
 * An activity representing a single Movie detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link MovieListActivity}.
 */
public class MovieDetailActivity extends AppCompatActivity {
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        String currentLoggedIn = LoginActivity.currentLoggedInUser;
        currentUser = WelcomeActivity.mUserStorage.findUserByName(currentLoggedIn);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(MovieDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(MovieDetailFragment.ARG_ITEM_ID));
            MovieDetailFragment fragment = new MovieDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.movie_detail_container, fragment)
                    .commit();
            //this.movie_id = MovieDetailFragment.ARG_ITEM_ID;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpTo(this, new Intent(this, MovieListActivity.class));
                return true;
            case R.id.rate_id:
                rateMovie(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /**
     * Opens an Alert Dialog allowing the user to rate a movie
     * @param item the menu option that was selected
     */
    public void rateMovie(MenuItem item) {
        AlertDialog.Builder movie_rate = new AlertDialog.Builder(MovieDetailActivity.this);
        final Movie ratedMovie = (Movie) getIntent().getSerializableExtra("Movie Object");
        final RatingBar ratingbar1 = new RatingBar(MovieDetailActivity.this);
        ratingbar1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        ratingbar1.setNumStars(5);
        ratingbar1.setRating(1.0f);
        ratingbar1.setStepSize(1);
        ratingbar1.setMax(5);


        String m = "Rate this movie 1 to 5 stars";
        movie_rate.setMessage(m)
                .setTitle("Rate this Movie")
                .setView(ratingbar1)
                .setPositiveButton("Rate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                               Rating newRating = new Rating(MovieDetailActivity.this.currentUser.getMajor(), MovieDetailActivity.this.currentUser.getUsername(), ratedMovie, ratingbar1.getRating());
                               if (!RatingStorage.getInstance().getRatings().contains(newRating)) {
                                   RatingStorage.getInstance().addRating(newRating);
                                   MovieDetailActivity.this.currentUser.addRating(newRating);
                                   //debuging purposes
                                   System.out.println(ratingbar1.getRating() + "rating-if " + MovieDetailActivity.this.currentUser.getMajor() + " ");
                               } else {
                                   RatingStorage.getInstance().removeRating(newRating);
                                   RatingStorage.getInstance().addRating(newRating);
                                   MovieDetailActivity.this.currentUser.removeRating(newRating);
                                   MovieDetailActivity.this.currentUser.addRating(newRating);
                                   //debuging purposes
                                   System.out.println(ratingbar1.getRating() + "rating-else " + MovieDetailActivity.this.currentUser.getMajor() + " ");
                               }
                        return;
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
        AlertDialog ratingDialog = movie_rate.create();
        ratingDialog.show();
        ratingbar1.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
    }
}
