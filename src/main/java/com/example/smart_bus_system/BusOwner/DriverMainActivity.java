package com.example.smart_bus_system.BusOwner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.smart_bus_system.BusOwner.Screens.Home.Driver_Home;
import com.example.smart_bus_system.BusOwner.Screens.Driver_Profile;
import com.example.smart_bus_system.Bus_Location;
import com.example.smart_bus_system.Message_k;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.User.UserMainNav;
import com.example.smart_bus_system.qrcode.activities.BusDriverDashboard;
import com.example.smart_bus_system.qrcode.activities.SplashScreen;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DriverMainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_main);
        bottomNavigation = findViewById(R.id.nav_view);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        // Passing each menu ID as a set of Ids because each
        openFragment(new Driver_Home());
//        openFragment(new AvailablelBusFragment());



    }
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            //Log.d("menu event","Home");
                            openFragment(new Driver_Home());

                        case R.id.navigation_profile:
                            // Log.d("menu event","Home");
                            openFragment(new Driver_Profile());
                            return true;

                        case R.id.navigation_tracking:
                            // Log.d("menu event","Home");
                            startActivity(new Intent(DriverMainActivity.this, BusDriverDashboard.class));
                            return true;

                        case R.id.navigation_location:
                            // Log.d("menu event","Home");
                            startActivity(new Intent(DriverMainActivity.this, Message_k.class));
                            return true;
//
                    }
                    return false;
                }
            };



    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}