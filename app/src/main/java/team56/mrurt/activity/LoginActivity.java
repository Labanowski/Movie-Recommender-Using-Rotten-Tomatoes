<<<<<<< HEAD:app/src/main/java/team56/mrurt/Login.java
package team56.mrurt;
=======
package team56.mrurt.activity;
>>>>>>> edbfb80134c0950782df951356b6e0da56ee5fe7:app/src/main/java/team56/mrurt/activity/LoginActivity.java

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
<<<<<<< HEAD:app/src/main/java/team56/mrurt/Login.java
        setContentView(R.layout.login);
=======
        setContentView(R.layout.login_activity);
>>>>>>> edbfb80134c0950782df951356b6e0da56ee5fe7:app/src/main/java/team56/mrurt/activity/LoginActivity.java

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



<<<<<<< HEAD:app/src/main/java/team56/mrurt/Login.java
        if(Welcome.mUserStorage.handleLoginRequest(username, password)){
            Intent intent = new Intent(this, Homepage.class);
=======
        if(WelcomeActivity.mUserStorage.handleLoginRequest(username, password)){
            Intent intent = new Intent(this, HomepageActivity.class);
>>>>>>> edbfb80134c0950782df951356b6e0da56ee5fe7:app/src/main/java/team56/mrurt/activity/LoginActivity.java
            startActivity(intent);
            finish();
        } else {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast t = Toast.makeText(context, "Login failure!", duration);
            t.show();
        }
        currentLoggedInUser = username;
    }
}
