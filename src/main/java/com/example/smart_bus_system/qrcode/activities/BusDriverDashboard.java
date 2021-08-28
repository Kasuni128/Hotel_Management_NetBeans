package com.example.smart_bus_system.qrcode.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.qrcode.config.UserState;
import com.example.smart_bus_system.qrcode.fragments.PassengerListFragment;
import com.example.smart_bus_system.qrcode.fragments.QRCodeFragment;
import com.example.smart_bus_system.qrcode.listeners.OnDialogStateChangedListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BusDriverDashboard extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private FrameLayout frame_layout;

    private QRCodeFragment qrCodeFragment;
    private PassengerListFragment passengerListFragment;
    private AlertDialog.Builder dialog;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bus_driver_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        progressDialog = new ProgressDialog(BusDriverDashboard.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("In Progress");


        qrCodeFragment = new QRCodeFragment(getApplicationContext());
        passengerListFragment = new PassengerListFragment(getApplicationContext(), new OnDialogStateChangedListener() {
            @Override
            public void show()
            {
                progressDialog.show();
            }

            @Override
            public void hide()
            {

                progressDialog.hide();
            }

            @Override
            public void finishActivity()
            {

            }
        });
        dialog = new AlertDialog.Builder(BusDriverDashboard.this);
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                UserState.deleteBus(getApplicationContext());
                Intent intent = new Intent(BusDriverDashboard.this,SplashScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        dialog.setNeutralButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
        dialog.setTitle("Logout");
        dialog.setMessage("Are u sure you want to log out?");



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        frame_layout = findViewById(R.id.frame_layout);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();


        navigationView.setCheckedItem(R.id.passenger_list);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                if(item.getItemId() == R.id.qr_code)
                {
                    getSupportFragmentManager().beginTransaction().replace(frame_layout.getId(),qrCodeFragment).commit();
                    drawer.closeDrawers();
                    return true;
                }
                else if(item.getItemId() == R.id.passenger_list)
                {
                    getSupportFragmentManager().beginTransaction().replace(frame_layout.getId(),passengerListFragment).commit();
                    drawer.closeDrawers();
                    return true;
                }
                else if(item.getItemId() == R.id.logout)
                {
                    drawer.closeDrawers();
                    dialog.show();
                    return false;
                }
                return true;
            }
        });
        getSupportFragmentManager().beginTransaction().replace(frame_layout.getId(),passengerListFragment).commit();


        ImageView navigation_icon = findViewById(R.id.navigation_icon);
        TextView activity_name = findViewById(R.id.activity_name);
        navigation_icon.setOnClickListener(view-> {

            drawer.open();
        });
        activity_name.setText("Driver Dashboard");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId() == R.id.logout)
        {
            dialog.show();
            return true;
        }

        return false;
    }
}