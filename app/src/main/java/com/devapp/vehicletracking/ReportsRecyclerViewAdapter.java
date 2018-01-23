package com.devapp.vehicletracking;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HP on 24-01-2018.
 */

public class ReportsRecyclerViewAdapter extends RecyclerView.Adapter<ReportsRecyclerViewAdapter.ReportViewHolder> {

    @Override
    public ReportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ReportViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder{

        public ReportViewHolder(View itemView) {
            super(itemView);
        }

    }

}
