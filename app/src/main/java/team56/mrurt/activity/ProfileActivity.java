package team56.mrurt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import team56.mrurt.R;
import team56.mrurt.model.User;

/**
 * The user's profile page
 */
public class ProfileActivity extends AppCompatActivity {

    private EditText mEmailView, mUsernameView, mNameView, mMajorView, mPasswordView;

    String currentLoggedIn = LoginActivity.currentLoggedInUser;
    User user = WelcomeActivity.mUserStorage.findUserByName(currentLoggedIn);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        mEmailView = (EditText) findViewById(R.id.userEmail);
        mUsernameView = (EditText) findViewById(R.id.userUsername);
        mNameView = (EditText) findViewById(R.id.userName);
        mMajorView = (EditText) findViewById(R.id.userMajor);
        mPasswordView = (EditText) findViewById(R.id.userPassword);

        mEmailView.setText(user.getEmail(), TextView.BufferType.EDITABLE);
        mUsernameView.setText(user.getUsername(), TextView.BufferType.EDITABLE);
        mNameView.setText(user.getName(), TextView.BufferType.EDITABLE);
        mMajorView.setText(user.getMajor(), TextView.BufferType.EDITABLE);
        mPasswordView.setText(user.getPassword(), TextView.BufferType.EDITABLE);
    }

    @Override
    public void onBackPressed() {
        //Go back to HomePage instead logging out
        Intent homeIntent = new Intent(ProfileActivity.this, HomepageActivity.class);
        startActivity(homeIntent);
        finish();
    }

    /**
     * Logs out the user, if any changes have been made to the profile, the old user
     * data is removed and the new data is added
     * @param view The View
     */
    public void logout(View view){
        String e1 = mEmailView.getText().toString();
        String u1 = mUsernameView.getText().toString();
        String n1 = mNameView.getText().toString();
        String m1 = mMajorView.getText().toString();
        String p1 = mPasswordView.getText().toString();


        WelcomeActivity.mUserStorage.remove(currentLoggedIn);
        WelcomeActivity.mUserStorage.addUser(e1, u1, n1, m1, p1);

        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}