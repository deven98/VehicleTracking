package com.devapp.vehicletracking.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devapp.vehicletracking.R;

public class ReportsDetailRecyclerViewAdapter extends RecyclerView.Adapter<ReportsDetailRecyclerViewAdapter.ReportDetailViewHolder> {

    private Context context;

    public ReportsDetailRecyclerViewAdapter(Context context){

        this.context = context;

    }

    @Override
    public ReportDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReportDetailViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_report_detail_recycler_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ReportDetailViewHolder holder, int position) {

        //TODO: Bind data after retrieval

    }

    @Override
    public int getItemCount() {

        //TODO: As a demo, a dummy count has been set. Change number of items after retrieval from server.
        return 2;

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
