package com.devapp.vehicletracking.activities;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.devapp.vehicletracking.R;
import com.devapp.vehicletracking.activities.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if(getSupportActionBar() != null){

            getSupportActionBar().hide();

        }

        new CountDownTimer(1000,500){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }

        }.start();

    }
}
