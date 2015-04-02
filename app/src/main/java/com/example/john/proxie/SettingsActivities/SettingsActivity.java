package com.example.john.proxie.SettingsActivities;


import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.john.proxie.R;


public class SettingsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();

    }

    public static class SettingsFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //load the preferences from an XML resource

            addPreferencesFromResource(R.xml.preferences);

        }

    }

}
