package com.devapp.vehicletracking.utils;

import java.util.ArrayList;

public class DataUtils {

    public static ArrayList<String> carIDs = new ArrayList<>();

    public static ArrayList<String> unitsInWheelAlignment = new ArrayList<>();

    public static ArrayList<String> unitsInRBT = new ArrayList<>();

    public static ArrayList<String> unitsInCAI = new ArrayList<>();

    public static ArrayList<String> unitsInCAIRework = new ArrayList<>();

    public static ArrayList<String> unitsInQCRework = new ArrayList<>();

    public static ArrayList<String> unitsInRFD = new ArrayList<>();

    public static ArrayList<String> unitsInWaxing = new ArrayList<>();

    public static ArrayList<String> unitsInYard = new ArrayList<>();

    public static ArrayList<String> unitsCompleted = new ArrayList<>();

    public static void clearAllData(){

        carIDs.clear();
        unitsInWheelAlignment.clear();
        unitsInRBT.clear();
        unitsInCAI.clear();
        unitsInCAIRework.clear();
        unitsInQCRework.clear();
        unitsInRFD.clear();
        unitsInWaxing.clear();
        unitsInYard.clear();
        unitsCompleted.clear();

    }

}
