package mrurt.team56.movierecommender;

import android.content.Context;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import javax.xml.datatype.Duration;

/**
 * Created by connorwyckoff
 */
public class Login extends AppCompatActivity {

    private EditText mUsernameView;
    private EditText mPasswordView;

    public static String currentLoggedInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameView = (EditText) findViewById(R.id.login_username);
        mPasswordView = (EditText) findViewById(R.id.password);
    }

    public EditText getUsernameView() {
        return mUsernameView;
    }

    public EditText getPassWordView() {
        return  mPasswordView;
    }

    public void login(View v){
        String username = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();



        if(HomePage.mUserStorage.handleLoginRequest(username, password)){
            Intent intent = new Intent(this, Profile.class);
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