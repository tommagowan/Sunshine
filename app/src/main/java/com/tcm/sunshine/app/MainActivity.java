package com.tcm.sunshine.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        }

        if (item.getItemId() == R.id.action_view_map) {
            launchMapIntent();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void launchMapIntent() {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:0,0").buildUpon()
                        .appendQueryParameter("q", getLocationPreference())
                        .build());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String getLocationPreference() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return preferences.getString(getString(R.string.pref_location_key), "london");
    }

    @Override
    protected void onPause() {
        Log.d(LOG_TAG, "onPause()");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d(LOG_TAG, "onResume()");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.d(LOG_TAG, "onStop()");
        super.onStop();
    }

    @Override
    protected void onStart() {
        Log.d(LOG_TAG, "onStart()");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.d(LOG_TAG, "onDestroy()");
        super.onDestroy();
    }
}
