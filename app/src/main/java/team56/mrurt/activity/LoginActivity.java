package team56.mrurt.activity;

import android.content.Context;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import team56.mrurt.R;
import team56.mrurt.activity.HomepageActivity;
import team56.mrurt.activity.WelcomeActivity;

/**
 * Created by alexlabanowski on 2/10/16.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText mUsernameView;
    private EditText mPasswordView;
    public static String currentLoggedInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mUsernameView = (EditText) findViewById(R.id.login_username);
        mPasswordView = (EditText) findViewById(R.id.password);
    }

    public EditText getUsernameView() {
        return mUsernameView;
    }

    public EditText getPassWordView() {
        return  mPasswordView;
    }

    /**
     * Logins in the user if they input registered username and password
     * @param v The View
     */
    public void login(View v){
        String username = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();



        if(WelcomeActivity.mUserStorage.handleLoginRequest(username, password)){
            if(WelcomeActivity.mUserStorage.findUserByName(username).isBanned()){
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast t = Toast.makeText(context, "You are banned!", duration);
                t.show();
            } else if(WelcomeActivity.mUserStorage.findUserByName(username).isAdmin()){
                Intent intent = new Intent(this, AdminActivity.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(this, HomepageActivity.class);
                startActivity(intent);
                finish();
            }
        } else {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast t = Toast.makeText(context, "Login failure!", duration);
            t.show();
        }
        currentLoggedInUser = username;
    }
}
