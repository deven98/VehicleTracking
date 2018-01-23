package com.devapp.vehicletracking;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class StationTrackDialogFragment extends DialogFragment {

    Context context;

    Spinner stationSpinner;

    ArrayAdapter<String> arrayAdapter;

    Button okButton;
    Button cancelButton;

    public static String[] stations = {"CHANGE STATION", "Roll Out", "Wheel Alignment", "RBT", "CAI", "CAI REWORK", "QC REWORK", "RFD", "Waxing", "Yard"};

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.station_track_alert_dialog,container,false);

        stationSpinner = v.findViewById(R.id.station_track_alert_dialog_station_spinner);

        arrayAdapter = new ArrayAdapter<>(context,android.R.layout.simple_list_item_1,stations);

        stationSpinner.setAdapter(arrayAdapter);

        okButton = v.findViewById(R.id.station_track_alert_dialog_ok_button);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getDialog().dismiss();

            }
        });

        return v;
    }
}
