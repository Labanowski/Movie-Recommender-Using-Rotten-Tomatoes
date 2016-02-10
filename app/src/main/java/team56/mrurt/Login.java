package team56.mrurt;

import android.content.Context;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import javax.xml.datatype.Duration;

/**
 * Created by alexlabanowski on 2/10/16.
 */
public class Login extends Activity {

    private EditText mUsernameView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mUsernameView = (EditText) findViewById(R.id.login_username);
        mPasswordView = (EditText) findViewById(R.id.password);
    }

    public void login(View v){
        String username = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();

        if(username.equals("user") && password.equals("pass")){
            Intent intent = new Intent(this, Homepage.class);
            startActivity(intent);
            finish();
        } else {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast t = Toast.makeText(context, "Login failure!", duration);
            t.show();
        }
    }
}
