package com.example.john.proxie.LoginActivities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.john.proxie.R;
import com.example.john.proxie.SettingsActivities.SettingsActivity;


public class LoginActivity extends Activity {

    private boolean newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String savedUsername = sharedPref.getString("usernameKey", "none");

        if(savedUsername.equalsIgnoreCase("none")){
            Toast.makeText(getApplicationContext(), "New user", Toast.LENGTH_LONG).show();
            newUser = true;
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.mssgaction_bar_settings_button:
                Intent intent = new Intent(this, SettingsActivity.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    public void exitActivity(View view) {

        EditText usernameView = (EditText)findViewById(R.id.userNameloginfieldid);
        usernameView.requestFocus();

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPref.edit().putString("usernameKey", usernameView.getText().toString()).apply();

        
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();


    }
}
