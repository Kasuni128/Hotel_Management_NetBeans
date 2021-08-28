package com.example.smart_bus_system.qrcode.activities;

import androidx.annotation.NonNull;
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
import android.widget.Button;

import com.example.smart_bus_system.R;

public class SetupActivity extends AppCompatActivity {

    private boolean isFirstTimeOnResume = true;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(checkPermission())
        {
            openSplashScreen();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(!isFirstTimeOnResume)
        {
            if(checkPermission())
            {
                openSplashScreen();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        Button setup_btn = findViewById(R.id.setup_btn);
        setup_btn.setOnClickListener(view-> {

            if(checkPermission())
            {
                openSplashScreen();
            }

        });


    }
    public boolean checkPermission()
    {
        boolean isAllOkay = true;

        if(!isCameraGranted())
        {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, 100);
            isAllOkay = false;
        }
        else if(!isCoarseLocationGranted())
        {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
            isAllOkay = false;
        }
        else if(!isFineLocationGranted())
        {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 102);
            isAllOkay = false;
        }
        else if(!checkGPSisEnabled())
        {
            showGPSDisabledDialog();
            isAllOkay = false;
        }

        return isAllOkay;
    }
    public void openSplashScreen()
    {
        startActivity(new Intent(SetupActivity.this,SplashScreen.class));
        finish();
    }
    private boolean isFineLocationGranted()
    {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if(result == PackageManager.PERMISSION_GRANTED)
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
    public void showGPSDisabledDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("GPS Disabled");
        builder.setMessage("Gps is disabled, in order to use the application properly you need to enable GPS of your device");
        builder.setPositiveButton("Enable GPS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                isFirstTimeOnResume = false;
                startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 105);
            }
        });
        builder.show();
    }
}