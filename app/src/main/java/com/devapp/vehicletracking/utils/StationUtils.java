package com.devapp.vehicletracking.utils;

public final class StationUtils {

    public static final String CHANGE_STATION = "CHANGE STATION";

    public static final String ROLL_OUT = "Roll Out";

    public static final String WHEEL_ALIGNMENT = "Wheel Alignment";

    public static final String RBT = "RBT";

    public static final String CAI = "CAI";

    public static final String CAI_REWORK = "CAI REWORK";

    public static final String QC_REWORK = "QC REWORK";

    public static final String RFD = "RFD";

    public static final String WAXING = "Waxing";

    public static final String YARD = "Yard";

    public static final String COMPLETE = "Complete";

    public static final String FL_08 = "26";

    public static final String WHEEL_ALIGNMENT_STATION_NUMBER = "27";

    public static final String RBT_STATION_NUMBER = "28";

    public static final String CAI_STATION_NUMBER = "29";

    public static final String CAI_REWORK_STATION_NUMBER = "30";

    public static final String QC_REWORK_STATION_NUMBER = "31";

    public static final String RFD_STATION_NUMBER = "32";

    public static final String WAXING_STATION_NUMBER = "33";

    public static final String YARD_STATION_NUMBER = "34";

    public static final String COMPLETED_NUMBER = "35";

    public static String stationMatcher(String stationName){

        String result = "";

        switch (stationName){

            case WHEEL_ALIGNMENT:
                result = WHEEL_ALIGNMENT_STATION_NUMBER;
                break;

            case RBT:
                result = RBT_STATION_NUMBER;
                break;

            case CAI_REWORK:
                result = CAI_REWORK_STATION_NUMBER;
                break;

            case CAI:
                result = CAI_STATION_NUMBER;
                break;

            case QC_REWORK:
                result = QC_REWORK_STATION_NUMBER;
                break;

            case RFD:
                result = RFD_STATION_NUMBER;
                break;

            case WAXING:
                result = WAXING_STATION_NUMBER;
                break;

            case YARD:
                result = YARD_STATION_NUMBER;
                break;

            case COMPLETE:
                result = COMPLETED_NUMBER;
                break;

        }

        return result;

    }

}
