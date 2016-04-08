package team56.mrurt.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

import team56.mrurt.R;
import team56.mrurt.model.Database.DatabaseOperations;
import team56.mrurt.model.User;
import team56.mrurt.model.UserStorage;

/**
 * Created by Alexander Labanowski
 */
public class AdminActivity extends AppCompatActivity implements OnItemSelectedListener{
    private static String[] users;
    private static String currentUser;
    public Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);
        Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        dropdown.setOnItemSelectedListener(this);
        UserStorage.getInstance().updateUserDatabase(DatabaseOperations.getHelper(this).getUsers());
        users = UserStorage.getInstance().toArray();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, users);
        dropdown.setAdapter(adapter);
    }


    /**
     * Handles what is selected from the dropdown spinner.
     * @param parent The AdapterView where the selection happened
     * @param view The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        currentUser = (String)parent.getItemAtPosition(position);
        User user = UserStorage.getInstance().findUserByName(currentUser);
        if(user.isAdmin()){
            ((TextView) findViewById(R.id.textView4)).setText(currentUser + " is an admin.");
        } else if(user.isBanned()) {
            ((TextView) findViewById(R.id.textView4)).setText(currentUser + " is banned.");
        } else {
            ((TextView) findViewById(R.id.textView4)).setText(currentUser + " is active.");
        }
    }

    /**
     * No current use.
     * @param arg0 The AdapterView that now contains no selected item.
     */
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    /**
     * Bans the selected user from the dropdown spinner and updates the text view.
     * @param view The view within the AdapterView that was clicked
     */
    public void banUser(View view){
        if(UserStorage.getInstance().findUserByName(currentUser).isAdmin()){
            ((TextView) findViewById(R.id.textView4)).setText(currentUser + " is an admin.");
        } else {
            UserStorage.getInstance().findUserByName(currentUser).banUser();
            DatabaseOperations.getHelper(c).updateUser(DatabaseOperations.getHelper(c), UserStorage.getInstance().findUserByName(currentUser));
            UserStorage.getInstance().updateUserDatabase(DatabaseOperations.getHelper(c).getUsers());
            ((TextView) findViewById(R.id.textView4)).setText(currentUser + " is now banned.");
        }
    }

    /**
     * Un-bans the selected user from the dropdown spinner and updates the text view.
     * @param view The view within the AdapterView that was clicked
     */
    public void unlockUser(View view){
        UserStorage.getInstance().findUserByName(currentUser).unlockUser();
        DatabaseOperations.getHelper(c).updateUser(DatabaseOperations.getHelper(c), UserStorage.getInstance().findUserByName(currentUser));
        UserStorage.getInstance().updateUserDatabase(DatabaseOperations.getHelper(c).getUsers());
        ((TextView) findViewById(R.id.textView4)).setText(currentUser + " is now unbanned.");
    }

    /**
     * Logs the admin out
     * @param view The view within the AdapterView that was clicked
     */
    public void logout(View view){
        finish();
    }
}
