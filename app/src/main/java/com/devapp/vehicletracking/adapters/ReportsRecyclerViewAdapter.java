package com.devapp.vehicletracking.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devapp.vehicletracking.R;

public class ReportsRecyclerViewAdapter extends RecyclerView.Adapter<ReportsRecyclerViewAdapter.ReportViewHolder> {

    private Context context;

    public static String[] stations = {"Wheel Alignment", "RBT", "CAI", "CAI REWORK", "QC REWORK", "RFD", "Waxing", "Yard", "Completed"};

    public ReportsRecyclerViewAdapter(Context context){

        this.context = context;

    }

    @Override
    public ReportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReportViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_report_recycler_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ReportViewHolder holder, int position) {

        //TODO: Bind data to text view after retrieval from server
        holder.countTextView.setText("0");

        //TODO: If server gives variable number of entries, change number of viewHolders to a variable list length
        holder.stationTextView.setText(stations[position]);

    }

    @Override
    public int getItemCount() {
        return stations.length;
    }

    class ReportViewHolder extends RecyclerView.ViewHolder{

        TextView stationTextView;
        TextView countTextView;

        ReportViewHolder(View itemView) {
            super(itemView);

            stationTextView = itemView.findViewById(R.id.activity_report_recycler_view_item_station_text_view);
            countTextView = itemView.findViewById(R.id.activity_report_recycler_view_item_count_text_view);

        }

    }

}
