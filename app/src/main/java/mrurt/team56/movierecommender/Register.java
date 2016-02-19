package mrurt.team56.movierecommender;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by connorwyckoff
 */
public class Register extends AppCompatActivity {

  //  private UserStorage mUserStorage;

    private EditText mEmailView;
    private EditText mUsernameView;
    private EditText mNameView;
    private EditText mMajorView;
    private EditText mPasswordView;

    private Button mRegisterButton;

    private boolean bool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //mUserStorage = new UserStorage();

        mEmailView = (EditText) findViewById(R.id.eEmailView);
        mUsernameView = (EditText) findViewById(R.id.eUsernameView);
        mNameView = (EditText) findViewById(R.id.eNameView);
        mMajorView = (EditText) findViewById(R.id.eMajorView);
        mPasswordView = (EditText) findViewById(R.id.ePasswordView);
    }

    public String getUsernameString() {
        return mUsernameView.getText().toString();
    }

    public String getPasswordString() {
        return  mPasswordView.getText().toString();
    }

    public String getNameString() {
        return mNameView.getText().toString();
    }

    public String getMajorString() {
        return mMajorView.getText().toString();
    }

    public String getEmailString() {
        return  mEmailView.getText().toString();
    }


    public void register(View v) {
        HomePage.mUserStorage.addUser(getEmailString(), getUsernameString(), getNameString(), getMajorString(), getPasswordString());
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}
