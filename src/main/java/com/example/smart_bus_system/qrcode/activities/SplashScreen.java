package com.example.smart_bus_system.qrcode.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;

import com.example.smart_bus_system.R;
import com.example.smart_bus_system.qrcode.config.UserState;

import static com.example.smart_bus_system.qrcode.config.UserState.BUS_DRIVER;
import static com.example.smart_bus_system.qrcode.config.UserState.EMPTY_USER;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        init();

    }

    private void init()
    {
        Intent intent;

        if(!isCameraGranted())
        {
            intent = new Intent(SplashScreen.this, SetupActivity.class);
        }
        else if(!isCoarseLocationGranted())
        {
            intent = new Intent(SplashScreen.this, SetupActivity.class);
        }
        else if(!isFineLocationGranted())
        {
            intent = new Intent(SplashScreen.this, SetupActivity.class);
        }
        else if(!checkGPSisEnabled())
        {
            intent = new Intent(SplashScreen.this, SetupActivity.class);
        }
        else
        {
            int type = UserState.getUserType(getApplicationContext());



            if(type == EMPTY_USER)
            {
                intent = new Intent(SplashScreen.this, LoginScreen.class);
            }
            else if(type == BUS_DRIVER)
            {
                intent = new Intent(SplashScreen.this, BusDriverDashboard.class);
            }
            else
            {
                intent = new Intent(SplashScreen.this,PassengerDashboard.class);
            }


        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        openActivity(intent);
    }

    public void openActivity(Intent intent)
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },2500);

    }
    private boolean isFineLocationGranted()
    {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED)
        {
            return true;
        }
        return false;
    }
    private boolean isCoarseLocationGranted()
    {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED)
        {
            return true;
        }
        return false;
    }
    private boolean isCameraGranted()
    {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (result == PackageManager.PERMISSION_GRANTED)
        {
            return true;
        }
        return false;
    }
    private boolean checkGPSisEnabled()
    {
        final LocationManager manager = (LocationManager)getSystemService    (Context.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) )
            return false;
        return true;
    }
}