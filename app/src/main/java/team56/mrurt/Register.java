package team56.mrurt;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by connorwyckoff
 */
public class Register extends AppCompatActivity {


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
        setContentView(R.layout.register);
        //mUserStorage = new UserStorage();

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
    public String getUsernameString() {
        return mUsernameView.getText().toString();
    }

    /**
     * Returns the password in the editText
     *
     * @return password
     */
    public String getPasswordString() {
        return mPasswordView.getText().toString();
    }

    /**
     * Returns the name in the editText
     *
     * @return name
     */
    public String getNameString() {
        return mNameView.getText().toString();
    }

    /**
     * Returns the major in the editText
     *
     * @return major
     */
    public String getMajorString() {
        return mMajorView.getText().toString();
    }

    /**
     * Returns the email in the editText
     *
     * @return email
     */
    public String getEmailString() {
        return mEmailView.getText().toString();
    }

    /**
     * Registers the new user into the map
     *
     * @param v The View
     */
    public void register(View v) {
        Welcome.mUserStorage.addUser(getEmailString(), getUsernameString(), getNameString(), getMajorString(), getPasswordString());
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}