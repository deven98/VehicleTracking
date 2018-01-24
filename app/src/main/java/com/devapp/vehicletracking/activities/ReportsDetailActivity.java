package com.devapp.vehicletracking.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.devapp.vehicletracking.R;
import com.devapp.vehicletracking.adapters.ReportsDetailRecyclerViewAdapter;

public class ReportsDetailActivity extends AppCompatActivity {

    RecyclerView reportsDetailRecyclerView;
    ReportsDetailRecyclerViewAdapter reportsDetailRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_detail);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        reportsDetailRecyclerView = findViewById(R.id.activity_report_detail_recycler_view);
        reportsDetailRecyclerViewAdapter = new ReportsDetailRecyclerViewAdapter(this);

        reportsDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        reportsDetailRecyclerView.setAdapter(reportsDetailRecyclerViewAdapter);

    }
}
