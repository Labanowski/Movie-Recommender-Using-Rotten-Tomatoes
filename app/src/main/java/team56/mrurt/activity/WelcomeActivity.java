package team56.mrurt.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import team56.mrurt.R;
import team56.mrurt.model.Database.DatabaseOperations;
import team56.mrurt.model.UserStorage;


public class WelcomeActivity extends AppCompatActivity {
    Context c = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        DatabaseOperations.getHelper(c).putUserInformation(DatabaseOperations.getHelper(c), "admin@admin.com", "admin", "admin", "administrator", "password1", 0, 1);
        DatabaseOperations.getHelper(c).putUserInformation(DatabaseOperations.getHelper(c), "ban@ban.com", "ban", "ban", "ban", "ban", 1, 0);
        UserStorage.getInstance().updateUserDatabase(DatabaseOperations.getHelper(this).getUsers());
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
}
