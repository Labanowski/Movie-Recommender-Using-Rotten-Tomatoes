package team56.mrurt.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

import team56.mrurt.R;
import team56.mrurt.model.User;

/**
 * Created by alexanderlabanowski on 3/16/16.
 */
public class AdminActivity extends AppCompatActivity implements OnItemSelectedListener{

    private Spinner dropdown;
    private static String[] users = WelcomeActivity.mUserStorage.toArray();
    private static String currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);
        dropdown = (Spinner)findViewById(R.id.spinner);
        dropdown.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, users);
        dropdown.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        currentUser = (String)parent.getItemAtPosition(position);
        User user = WelcomeActivity.mUserStorage.findUserByName(currentUser);
        if(user.isAdmin()){
            ((TextView) findViewById(R.id.textView4)).setText(currentUser + " is an admin.");
        } else if(user.isBanned()) {
            ((TextView) findViewById(R.id.textView4)).setText(currentUser + " is banned.");
        } else {
            ((TextView) findViewById(R.id.textView4)).setText(currentUser + " is active.");
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        //Todo
    }

    public void banUser(View view){
        WelcomeActivity.mUserStorage.findUserByName(currentUser).banUser();
        ((TextView) findViewById(R.id.textView4)).setText(currentUser + "is now banned.");
    }

    public void unlockUser(View view){
        WelcomeActivity.mUserStorage.findUserByName(currentUser).unbanUser();
        ((TextView) findViewById(R.id.textView4)).setText(currentUser + "is now unbanned.");
    }

    public void logout(View view){
        finish();
    }
}
