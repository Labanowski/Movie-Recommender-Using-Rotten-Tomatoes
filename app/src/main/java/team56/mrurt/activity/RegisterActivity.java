package team56.mrurt.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import team56.mrurt.R;
import team56.mrurt.model.Database.DatabaseOperations;
import team56.mrurt.model.UserStorage;

/**
 * Created by Connor Wyckoff
 */
public class RegisterActivity extends AppCompatActivity {

    /**
     * edit texts used to register in the app
     */
    private EditText mEmailView, mUsernameView, mNameView, mMajorView, mPasswordView;

    /**
     * context c
     */
    private final Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        mEmailView = (EditText) findViewById(R.id.eEmailView);
        mUsernameView = (EditText) findViewById(R.id.eUsernameView);
        mNameView = (EditText) findViewById(R.id.eNameView);
        mMajorView = (EditText) findViewById(R.id.eMajorView);
        mPasswordView = (EditText) findViewById(R.id.ePasswordView);
    }

    /**
     * Returns the username in the editText
     *
     * @return username
     */
    private String getUsernameString() {
        return mUsernameView.getText().toString();
    }

    /**
     * Returns the password in the editText
     *
     * @return password
     */
    private String getPasswordString() {
        return mPasswordView.getText().toString();
    }

    /**
     * Returns the name in the editText
     *
     * @return name
     */
    private String getNameString() {
        return mNameView.getText().toString();
    }

    /**
     * Returns the major in the editText
     *
     * @return major
     */
    private String getMajorString() {
        return mMajorView.getText().toString();
    }

    /**
     * Returns the email in the editText
     *
     * @return email
     */
    private String getEmailString() {
        return mEmailView.getText().toString();
    }

    /**
     * Registers the new user into the map
     *
     * @param v The View
     */
    public void register(View v) {
        DatabaseOperations.getHelper(ctx).putUserInformation(DatabaseOperations.getHelper(ctx), getEmailString(), getUsernameString(), getNameString(), getMajorString(), getPasswordString());

        UserStorage.getInstance().addUser(getEmailString(), getUsernameString(), getNameString(), getMajorString(), getPasswordString());
        final Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}