package com.example.john.proxie.LoginActivities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.john.proxie.MainActivities.MessageForumActivity;
import com.example.john.proxie.R;

/**
 * Created by John on 3/3/15.
 */
public class StartActivity extends Activity{

    private static boolean userLoggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String savedUsername = sharedPref.getString("usernameKey", "none");

        if(!savedUsername.equalsIgnoreCase("none"))
            userLoggedIn = true;

        if(userLoggedIn){
            Intent i = new Intent(this, MessageForumActivity.class);
            startActivity(i);
            finish();
        }
        else{
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        }
    }


}
