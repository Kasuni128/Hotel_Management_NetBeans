package com.example.smart_bus_system.qrcode.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.smart_bus_system.qrcode.models.BusDriver;
import com.example.smart_bus_system.qrcode.models.Passenger;

public class UserState
{

    private static final String SHARED_PREF_NAME = "com.sample.qrcode.common.config";
    private static final String USER_ID_KEY = "USER_ID";
    private static final String USER_TYPE = "USER_TYPE";

    private static final String USER_NAME = "USER_NAME";


    public static final int PASSENGER  = 0;
    public static final int BUS_DRIVER  = 1;
    public static final int EMPTY_USER  = -1;

    public static void saveBus(Context context, BusDriver busDriver)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(USER_ID_KEY, busDriver.getBusNo());
        editor.putString(USER_NAME,busDriver.getDriversName());
        editor.putInt(USER_TYPE,BUS_DRIVER);
        editor.apply();
    }
    public static String getBusId(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(USER_ID_KEY,null);

    }
    public static String getPassengerId(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(USER_ID_KEY,null);

    }
    public static void savePassenger(Context context, Passenger passenger)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(USER_ID_KEY, passenger.getPassengerId());
        editor.putString(USER_NAME,passenger.getFirstName() + " "+ passenger.getLastName());
        editor.putInt(USER_TYPE,PASSENGER);
        editor.apply();
    }
    public static String getUsersName(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(USER_NAME,null);
    }
    public static void deletePassenger(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove(USER_ID_KEY);
        editor.remove(USER_TYPE);
        editor.apply();
    }
    public static int getUserType(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getInt(USER_TYPE,EMPTY_USER);
    }
    public static void deleteBus(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove(USER_ID_KEY);
        editor.remove(USER_TYPE);
        editor.apply();
    }
}
