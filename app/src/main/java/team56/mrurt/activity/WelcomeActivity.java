package team56.mrurt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import team56.mrurt.R;
import team56.mrurt.model.UserStorage;


public class WelcomeActivity extends AppCompatActivity {

    public static UserStorage mUserStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        mUserStorage = new UserStorage();
        mUserStorage.addUser("admin@admin.com", "admin", "admin", "administrator", "password1");
        mUserStorage.findUserByName("admin").makeAdmin();
        mUserStorage.addUser("ban@ban.com", "ban", "ban", "ban", "ban");
        mUserStorage.findUserByName("ban").banUser();
    }

    public void openLogin(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        onPause();
    }

    public void openRegister(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        onPause();
    }

    /**
     * Returns the UserStorage
     * @return mUserStorage
     */
    public UserStorage getUserStorage() {
        return mUserStorage;
    }
}
