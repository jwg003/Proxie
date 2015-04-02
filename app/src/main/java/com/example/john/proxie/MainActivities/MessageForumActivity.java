package com.example.john.proxie.MainActivities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.john.proxie.MapActivities.MapActivity;
import com.example.john.proxie.R;
import com.example.john.proxie.SettingsActivities.SettingsActivity;


public class MessageForumActivity extends Activity {

    private String messages[] = {"hello", "hello", "hello", "hello", "is", "there", "anybody",
            "in", "there", "just", "nod", "if", "you", "can", "hear", "me"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_forum);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, messages );
        ListView listView = (ListView) findViewById(R.id.mssgForumListView);
        listView.setAdapter(arrayAdapter);

        AdapterView.OnItemClickListener handler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                String message = ((TextView) v).getText().toString();
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        };

        listView.setOnItemClickListener(handler);

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_message_forum, menu);
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
            case R.id.mssgaction_bar_map_button:
                Intent intent2 = new Intent(this, MapActivity.class);
                this.startActivity(intent2);
                break;
            case R.id.mssgaction_bar_contacts_button:
                Intent intent3 = new Intent(this, ContactsActivity.class);
                this.startActivity(intent3);
                break;
            default:
                return super.onOptionsItemSelected(item);


        }
        return true;
    }

    public void launchComposeActivity(View view){

        Intent intent = new Intent(this, MessageComposeActivity.class);
        startActivity(intent);
    }
}
