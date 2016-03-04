<<<<<<< HEAD:app/src/main/java/team56/mrurt/Profile.java
package team56.mrurt;
=======
package team56.mrurt.activity;
>>>>>>> edbfb80134c0950782df951356b6e0da56ee5fe7:app/src/main/java/team56/mrurt/activity/ProfileActivity.java

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import team56.mrurt.R;
import team56.mrurt.model.User;

/**
 * The user's profile page
 */
<<<<<<< HEAD:app/src/main/java/team56/mrurt/Profile.java
public class Profile extends MenuActivity {

    private EditText mEmailView, mUsernameView, mNameView, mMajorView, mPasswordView;

    String currentLoggedIn = Login.currentLoggedInUser;
    User user = Welcome.mUserStorage.findUserByName(currentLoggedIn);
=======
public class ProfileActivity extends AppCompatActivity {

    private EditText mEmailView, mUsernameView, mNameView, mMajorView, mPasswordView;

    String currentLoggedIn = LoginActivity.currentLoggedInUser;
    User user = WelcomeActivity.mUserStorage.findUserByName(currentLoggedIn);
>>>>>>> edbfb80134c0950782df951356b6e0da56ee5fe7:app/src/main/java/team56/mrurt/activity/ProfileActivity.java



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD:app/src/main/java/team56/mrurt/Profile.java
        setContentView(R.layout.profile);
=======
        setContentView(R.layout.profile_activity);
>>>>>>> edbfb80134c0950782df951356b6e0da56ee5fe7:app/src/main/java/team56/mrurt/activity/ProfileActivity.java

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
<<<<<<< HEAD:app/src/main/java/team56/mrurt/Profile.java
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_homepage, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.profile_id:
                viewProfile(item);
                return true;
            case R.id.logout_id:
                logout(item);
                return true;
            case R.id.newDVD_id:
                logout(item);
                return true;
            case R.id.newRelease_id:
                logout(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
=======
    public void onBackPressed() {
        //Go back to HomePage instead logging out
        Intent homeIntent = new Intent(ProfileActivity.this, HomepageActivity.class);
        startActivity(homeIntent);
        finish();
>>>>>>> edbfb80134c0950782df951356b6e0da56ee5fe7:app/src/main/java/team56/mrurt/activity/ProfileActivity.java
    }

    /**
     * Logs out the user, if any changes have been made to the profile, the old user
     * data is removed and the new data is added
     * @param item The View
     */
    public void logoutAndSave(MenuItem item){
        String e1 = mEmailView.getText().toString();
        String u1 = mUsernameView.getText().toString();
        String n1 = mNameView.getText().toString();
        String m1 = mMajorView.getText().toString();
        String p1 = mPasswordView.getText().toString();


<<<<<<< HEAD:app/src/main/java/team56/mrurt/Profile.java
        Welcome.mUserStorage.remove(currentLoggedIn);
        Welcome.mUserStorage.addUser(e1, u1, n1, m1, p1);
=======
        WelcomeActivity.mUserStorage.remove(currentLoggedIn);
        WelcomeActivity.mUserStorage.addUser(e1, u1, n1, m1, p1);
>>>>>>> edbfb80134c0950782df951356b6e0da56ee5fe7:app/src/main/java/team56/mrurt/activity/ProfileActivity.java

        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}