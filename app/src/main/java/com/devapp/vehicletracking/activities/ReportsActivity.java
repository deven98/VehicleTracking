package com.devapp.vehicletracking.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.devapp.vehicletracking.R;
import com.devapp.vehicletracking.adapters.ReportsRecyclerViewAdapter;

public class ReportsActivity extends AppCompatActivity {

    RecyclerView reportsRecyclerView;
    ReportsRecyclerViewAdapter reportsRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        reportsRecyclerView = findViewById(R.id.activity_reports_recycler_view);
        reportsRecyclerViewAdapter = new ReportsRecyclerViewAdapter(this);

        reportsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        reportsRecyclerView.setAdapter(reportsRecyclerViewAdapter);

    }
    
}
