package team56.mrurt.activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import team56.mrurt.R;
import team56.mrurt.model.Movie;


/**
 * This is the Search Movie Page
 * Here you can search by tile, new Releases and new on DVD
 */
public class SearchMovieActivity extends AppCompatActivity {
    /** this is our volley queue for holding our REST requests.  Volley will create the necessary threading to
     * handle the requests for us in the background.
     */
    private RequestQueue queue;

    private String response;

    private SearchView MovieSearchView;
    private Button MovieSearchButton;
    private Button newReleaseSearchButton;
    private Button recentDVDSearchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_movie_activity);
        queue = Volley.newRequestQueue(this);

        this.MovieSearchView = (SearchView) findViewById(R.id.movieSearchView);
        this.MovieSearchButton = (Button) findViewById(R.id.movieSearchButton);
        this.newReleaseSearchButton = (Button) findViewById(R.id.newReleaseSearch);
        this.recentDVDSearchButton = (Button) findViewById(R.id.recentDVDSearch);

        MovieSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearchRequested();
            }
        });
        newReleaseSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRecentReleases();
            }
        });
        recentDVDSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRecentDVDs();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //Go back to HomePage instead logging out
        Intent homeIntent = new Intent(SearchMovieActivity.this, HomepageActivity.class);
        startActivity(homeIntent);
        finish();
    }

    @Override
    public boolean onSearchRequested() {
        String url = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=yedukp76ffytfuy24zsqk7f5";
        String query = MovieSearchView.getQuery().toString().replace(" ", "+");

        url += ("&q=" + query + "&page_limit=40");
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject resp) {
                        //handle a valid response coming back.  Getting this string mainly for debug
                        response = resp.toString();

                        //Now we parse the information.  Looking at the format, everything encapsulated in RestResponse object
                        JSONArray array = null;
                        try {
                            array = resp.getJSONArray("movies");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        assert array != null;

                        ArrayList<Movie> movies = new ArrayList<>();
                        for(int i=0; i < array.length(); i++) {

                            try {
                                //for each array element, we have to create an object
                                JSONObject jsonObject = array.getJSONObject(i);
                                JSONObject ratingsJSON = jsonObject.getJSONObject("ratings");
                                Movie m = new Movie();
                                assert jsonObject != null;
                                m.setTitle(jsonObject.optString("title"));
                                m.setYear(jsonObject.optString("year"));
                                m.setSynopsis(jsonObject.optString("synopsis"));
                                m.setCriticsRating(ratingsJSON.optString("critics_score"));
                                movies.add(m);


                            } catch (JSONException e) {
                                Log.d("VolleyApp", "Failed to get JSON object");
                                e.printStackTrace();
                            }
                        }
                        //once we have all data, then go to list screen
                        changeView(movies);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        response = "JSon Request Failed!!";
                    }
                });
        //this actually queues up the async response with Volley
        queue.add(jsObjRequest);
        return true;
    }

    /**
     * Gets recent releases from RottenTomatoes API and displays them.
     */
    public void getRecentReleases() {
        String url = "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/opening.json?apikey=yedukp76ffytfuy24zsqk7f5";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject resp) {
                        //handle a valid response coming back.  Getting this string mainly for debug
                        response = resp.toString();;

                        //Now we parse the information.  Looking at the format, everything encapsulated in RestResponse object
                        JSONArray array = null;
                        try {
                            array = resp.getJSONArray("movies");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        assert array != null;

                        ArrayList<Movie> movies = new ArrayList<>();
                        for(int i=0; i < array.length(); i++) {

                            try {
                                //for each array element, we have to create an object
                                JSONObject jsonObject = array.getJSONObject(i);
                                JSONObject ratingsJSON = jsonObject.getJSONObject("ratings");
                                Movie m = new Movie();
                                assert jsonObject != null;
                                m.setTitle(jsonObject.optString("title"));
                                m.setYear(jsonObject.optString("year"));
                                m.setSynopsis(jsonObject.optString("synopsis"));
                                m.setCriticsRating(ratingsJSON.optString("critics_score"));
                                //save the object for later
                                movies.add(m);


                            } catch (JSONException e) {
                                Log.d("MovieApp", "Failed to get JSON object");
                                e.printStackTrace();
                            }
                        }
                        //once we have all data, then go to list screen
                        changeView(movies);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        response = "JSon Request Failed!!";
                    }
                });
        //this actually queues up the async response with Volley
        queue.add(jsObjRequest);
    }

    /**
     * Gets recent DVDs from RottenTomatoes API and displays.
     */
    public void getRecentDVDs() {
        String url = "http://api.rottentomatoes.com/api/public/v1.0/lists/dvds/new_releases.json?apikey=yedukp76ffytfuy24zsqk7f5";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject resp) {
                        //handle a valid response coming back.  Getting this string mainly for debug
                        response = resp.toString();

                        //Now we parse the information.  Looking at the format, everything encapsulated in RestResponse object
                        JSONArray array = null;
                        try {
                            array = resp.getJSONArray("movies");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        assert array != null;

                        ArrayList<Movie> movies = new ArrayList<>();
                        for(int i=0; i < array.length(); i++) {

                            try {
                                //for each array element, we have to create an object
                                JSONObject jsonObject = array.getJSONObject(i);
                                JSONObject ratingsJSON = jsonObject.getJSONObject("ratings");
                                Movie m = new Movie();
                                assert jsonObject != null;
                                m.setTitle(jsonObject.optString("title"));
                                m.setYear(jsonObject.optString("year"));
                                m.setSynopsis(jsonObject.optString("synopsis"));
                                m.setCriticsRating(ratingsJSON.optString("critics_score"));
                                //save the object for later
                                movies.add(m);


                            } catch (JSONException e) {
                                Log.d("MovieApp", "Failed to get JSON object");
                                e.printStackTrace();
                            }
                        }
                        //once we have all data, then go to list screen
                        changeView(movies);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        response = "JSon Request Failed!!";
                    }
                });
        //this actually queues up the async response with Volley
        queue.add(jsObjRequest);
    }

    /**
     * This method changes to our new list view of the movies, but we have to pass the
     * moviearray into the intent so the new screen gets the data.
     *
     * @param movies the list of movie objects we created from the JSon response
     */
    public void changeView(ArrayList<Movie> movies) {
        Intent viewResultsIntent = new Intent(this, MovieListActivity.class);
        viewResultsIntent.putExtra("movies", movies);
        startActivity(viewResultsIntent);
        finish();
    }

}
