package com.devapp.vehicletracking.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devapp.vehicletracking.R;
import com.devapp.vehicletracking.activities.ReportsDetailActivity;
import com.devapp.vehicletracking.utils.DataUtils;
import com.devapp.vehicletracking.utils.StationUtils;

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

        //TODO: If server gives variable number of entries, change number of viewHolders to a variable list length
        holder.stationTextView.setText(stations[position]);

        //TODO: Bind data to text view after retrieval from server

        String stationNumberString = stations[position];

        switch(stationNumberString){

            case StationUtils.WHEEL_ALIGNMENT:
                holder.countTextView.setText(String.valueOf(DataUtils.unitsInWheelAlignment.size()));
                break;

            case StationUtils.RBT:
                holder.countTextView.setText(String.valueOf(DataUtils.unitsInRBT.size()));
                break;

            case StationUtils.CAI:
                holder.countTextView.setText(String.valueOf(DataUtils.unitsInCAI.size()));
                break;

            case StationUtils.CAI_REWORK:
                holder.countTextView.setText(String.valueOf(DataUtils.unitsInCAIRework.size()));
                break;

            case StationUtils.QC_REWORK:
                holder.countTextView.setText(String.valueOf(DataUtils.unitsInQCRework.size()));
                break;

            case StationUtils.RFD:
                holder.countTextView.setText(String.valueOf(DataUtils.unitsInRFD.size()));
                break;

            case StationUtils.WAXING:
                holder.countTextView.setText(String.valueOf(DataUtils.unitsInWaxing.size()));
                break;

            case StationUtils.YARD:
                holder.countTextView.setText(String.valueOf(DataUtils.unitsInYard.size()));
                break;

            case StationUtils.COMPLETE:
                holder.countTextView.setText(String.valueOf(DataUtils.unitsCompleted.size()));
                break;

        }

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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context,ReportsDetailActivity.class);

                    intent.putExtra("station",stations[getAdapterPosition()]);

                    context.startActivity(intent);

                }
            });

        }

    }

}
