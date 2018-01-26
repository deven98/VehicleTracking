package com.devapp.vehicletracking.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.devapp.vehicletracking.R;
import com.devapp.vehicletracking.utils.NetworkUtils;

import java.sql.SQLException;

public class SplashScreenActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if(getSupportActionBar() != null){

            getSupportActionBar().hide();

        }

        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    NetworkUtils.retrieveCarIDList();
                } catch (SQLException e) {
                    e.printStackTrace();
                    Toast.makeText(SplashScreenActivity.this, "Error in retrieving data!", Toast.LENGTH_SHORT).show();
                    Log.d("ERROR",e.getMessage());
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                Intent in = new Intent(getApplicationContext(),MainActivity.class);

                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK );

                startActivity(in);

                finish();

            }
        }.execute();

    }
}
