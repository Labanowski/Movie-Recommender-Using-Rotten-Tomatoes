package team56.mrurt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * HomePage
 */
public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
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
}
