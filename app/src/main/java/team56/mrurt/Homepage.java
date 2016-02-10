package team56.mrurt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by alexlabanowski on 2/10/16.
 */
public class Homepage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
    }

    public void logout(View view){
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
        finish();
    }
}
