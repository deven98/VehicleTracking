package com.devapp.vehicletracking.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.devapp.vehicletracking.R;
import com.devapp.vehicletracking.fragments.StationTrackDialogFragment;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    Button scanBarcode;
    EditText barcodeEditText;
    TextView changeStation;

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if(requestCode == 1){
            return;
        }

        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanResult != null) {

            barcodeEditText.setText(scanResult.getContents());

        }

    }

    public void initialise(){

        scanBarcode = findViewById(R.id.activity_main_scan_barcode_button);
        barcodeEditText = findViewById(R.id.activity_main_enter_barcode_edit_text);
        changeStation = findViewById(R.id.activity_main_change_text_view);

    }

    public void setOnClickListeners(){

        scanBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);

                }else {

                    new IntentIntegrator(MainActivity.this).initiateScan();

                }
            }
        });

        changeStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StationTrackDialogFragment stationTrackDialogFragment = new StationTrackDialogFragment();

                stationTrackDialogFragment.setCancelable(false);

                stationTrackDialogFragment.show(getSupportFragmentManager(),"dialog");

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(this).inflate(R.menu.activity_main_menu,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.activity_main_menu_reports:
                startActivity(new Intent(this,ReportsActivity.class));
                break;

        }

        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){

            getSupportActionBar().setTitle("Roll Out");

        }

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);

        }

        initialise();

        setOnClickListeners();

        StationTrackDialogFragment stationTrackDialogFragment = new StationTrackDialogFragment();

        stationTrackDialogFragment.setCancelable(false);
        stationTrackDialogFragment.show(getSupportFragmentManager(),"dialog");

    }
}
