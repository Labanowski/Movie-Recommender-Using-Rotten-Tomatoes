package team56.mrurt;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Welcome extends AppCompatActivity {

    public static UserStorage mUserStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        mUserStorage = new UserStorage();
    }

    public void openLogin(View v) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void openRegister(View v) {
        Intent intent = new Intent(this, Register.class);
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