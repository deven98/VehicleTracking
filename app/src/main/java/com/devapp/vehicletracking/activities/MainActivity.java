package com.devapp.vehicletracking.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.devapp.vehicletracking.R;
import com.devapp.vehicletracking.fragments.StationTrackDialogFragment;
import com.devapp.vehicletracking.utils.DataUtils;
import com.devapp.vehicletracking.utils.NetworkUtils;
import com.devapp.vehicletracking.utils.StationUtils;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    Button scanBarcode;
    EditText barcodeEditText;
    TextView changeStation;
    Button insertWithIDButton;

    FloatingActionButton refreshFAB;

    public static String CURRENT_STATION = StationUtils.ROLL_OUT;

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if(requestCode == 1){
            return;
        }

        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanResult != null) {

            if(DataUtils.carIDs.contains(scanResult.getContents())) {

                try {
                    NetworkUtils.changeCarStationNumber(this, scanResult.getContents(), StationUtils.stationMatcher(CURRENT_STATION));

                    new AlertDialog.Builder(this)
                            .setIcon(R.mipmap.ic_launcher)
                            .setTitle("Barcode scanned and updated")
                            .setMessage("Vehicle ID scanned: " + scanResult.getContents())
                            .setPositiveButton("OK",null)
                            .show();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public void initialise(){

        scanBarcode = findViewById(R.id.activity_main_scan_barcode_button);
        barcodeEditText = findViewById(R.id.activity_main_enter_barcode_edit_text);
        changeStation = findViewById(R.id.activity_main_change_text_view);
        refreshFAB = findViewById(R.id.activity_main_refresh_floating_action_button);
        insertWithIDButton = findViewById(R.id.activity_main_insert_with_barcode_number_button);

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

        refreshFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AsyncTask<Void,Void,Void>(){

                    @Override
                    protected Void doInBackground(Void... voids) {

                        try {
                            NetworkUtils.retrieveCarIDList();
                        } catch (SQLException e) {
                            e.printStackTrace();
                            Log.d("ERROR",e.getMessage());
                        }

                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);
                        Toast.makeText(MainActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
                    }
                }.execute();

            }
        });

        insertWithIDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(DataUtils.carIDs.contains(barcodeEditText.getText().toString())) {

                    try {
                        NetworkUtils.changeCarStationNumber(getApplicationContext(), barcodeEditText.getText().toString(), StationUtils.stationMatcher(CURRENT_STATION));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    barcodeEditText.setText("");
                }else{

                    Toast.makeText(MainActivity.this, "ID not found", Toast.LENGTH_SHORT).show();

                }
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

            case R.id.activity_main_menu_change_station:
                StationTrackDialogFragment stationTrackDialogFragment = new StationTrackDialogFragment();
                stationTrackDialogFragment.show(getSupportFragmentManager(),"dialog");
                break;

        }

        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){

            getSupportActionBar().setTitle(CURRENT_STATION);

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

    public void refreshStation(){

        if(getSupportActionBar() != null){

            getSupportActionBar().setTitle(CURRENT_STATION);

        }

    }

}
