package com.devapp.vehicletracking.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.devapp.vehicletracking.activities.MainActivity;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NetworkUtils {

    public static String IP_ADDRESS = "10.192.161.203";

    public static String PASSWORD = "mnaltcfmessql@2017";

    public static String USERNAME = "sa";

    public static String DIRECTORY_NAME = "MNALTcf";

    public static String READ_QUERY = "select distinct al_tracedatavalue4,rowinserttime,al_stationnumber from al_ordertraceeventdatacollectioninterface where al_operationtypeid ='7'";

    public static String WRITE_TABLE_NAME = "P_BLOCK_TRACKING";

    public static String connectString = "jdbc:jtds:sqlserver://" + IP_ADDRESS + ":1433/" + DIRECTORY_NAME;

    public static void retrieveCarIDList() throws SQLException {

        DataUtils.clearAllData();

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection(connectString,USERNAME,PASSWORD);

        Statement statement = conn.createStatement();

        ResultSet rs;

        rs = statement.executeQuery(READ_QUERY);

        while(rs.next()){

            String carID = rs.getString("al_tracedatavalue4");

            DataUtils.carIDs.add(carID);

            String stationNumberString = rs.getString("al_stationnumber");

            switch(stationNumberString){

                case StationUtils.WHEEL_ALIGNMENT_STATION_NUMBER:
                    DataUtils.unitsInWheelAlignment.add(carID);
                    break;

                case StationUtils.RBT_STATION_NUMBER:
                    DataUtils.unitsInRBT.add(carID);
                    break;

                case StationUtils.CAI_STATION_NUMBER:
                    DataUtils.unitsInCAI.add(carID);
                    break;

                case StationUtils.CAI_REWORK_STATION_NUMBER:
                    DataUtils.unitsInCAIRework.add(carID);
                    break;

                case StationUtils.QC_REWORK_STATION_NUMBER:
                    DataUtils.unitsInQCRework.add(carID);
                    break;

                case StationUtils.RFD_STATION_NUMBER:
                    DataUtils.unitsInRFD.add(carID);
                    break;

                case StationUtils.WAXING_STATION_NUMBER:
                    DataUtils.unitsInWaxing.add(carID);
                    break;

                case StationUtils.YARD_STATION_NUMBER:
                    DataUtils.unitsInYard.add(carID);
                    break;

                case StationUtils.COMPLETED_NUMBER:
                    DataUtils.unitsCompleted.add(carID);
                    break;

            }

        }

    }

    public static void changeCarStationNumber(final Context context, final String carModelNumber, final String stationNumber) throws SQLException {

        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {

                try {

                    try {
                        Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    Connection conn = DriverManager.getConnection(connectString, USERNAME, PASSWORD);

                    Statement statement = conn.createStatement();

                    ResultSet rs;

                    String query = "INSERT INTO " + WRITE_TABLE_NAME + " VALUES(getDate(),'"+ stationNumber +"','"+ carModelNumber +"')";

                    rs = statement.executeQuery(query);

                }catch (SQLException e){

                    e.printStackTrace();

                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
            }
        }.execute();



    }

}
