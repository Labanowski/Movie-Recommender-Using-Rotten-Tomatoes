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
    }

    public void openLogin(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void openRegister(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * Returns the UserStorage
     * @return mUserStorage
     */
    public UserStorage getUserStorage() {
        return mUserStorage;
    }
}
