package com.devapp.vehicletracking.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.devapp.vehicletracking.R;
import com.devapp.vehicletracking.utils.DataUtils;
import com.devapp.vehicletracking.utils.StationUtils;

import java.util.ArrayList;

public class ReportsDetailRecyclerViewAdapter extends RecyclerView.Adapter<ReportsDetailRecyclerViewAdapter.ReportDetailViewHolder> {

    private Context context;
    private String stationName;

    private ArrayList<String> carIDs = new ArrayList<>();

    public ReportsDetailRecyclerViewAdapter(Context context, String stationName) {

        this.context = context;
        this.stationName = stationName;

        switch (stationName) {

            case StationUtils.WHEEL_ALIGNMENT:
                carIDs = DataUtils.unitsInWheelAlignment;
                break;

            case StationUtils.RBT:
                carIDs = DataUtils.unitsInRBT;
                break;

            case StationUtils.CAI:
                carIDs = DataUtils.unitsInCAI;
                break;

            case StationUtils.CAI_REWORK:
                carIDs = DataUtils.unitsInCAIRework;
                break;

            case StationUtils.QC_REWORK:
                carIDs = DataUtils.unitsInQCRework;
                break;

            case StationUtils.RFD:
                carIDs = DataUtils.unitsInRFD;
                break;

            case StationUtils.WAXING:
                carIDs = DataUtils.unitsInWaxing;
                break;

            case StationUtils.YARD:
                carIDs = DataUtils.unitsInYard;
                break;

            case StationUtils.COMPLETE:
                carIDs = DataUtils.unitsCompleted;
                break;
        }

    }

    @Override
    public ReportDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReportDetailViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_report_detail_recycler_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ReportDetailViewHolder holder, int position) {

        //TODO: Bind data after retrieval

        holder.modelTextView.setText(carIDs.get(position));

    }

    @Override
    public int getItemCount() {

        Toast.makeText(context, String.valueOf(carIDs.size()) , Toast.LENGTH_SHORT).show();
        return carIDs.size();

    }

    public class ReportDetailViewHolder extends RecyclerView.ViewHolder{

        TextView countTextView;
        TextView modelTextView;

        public ReportDetailViewHolder(View itemView) {
            super(itemView);

            countTextView = itemView.findViewById(R.id.activity_report_recycler_view_item_count_text_view);
            modelTextView = itemView.findViewById(R.id.activity_report_detail_recycler_view_item_model_text_view);

        }

    }

}
