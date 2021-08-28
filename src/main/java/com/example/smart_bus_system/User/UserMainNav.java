package com.example.smart_bus_system.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.smart_bus_system.LoginActivity;
import com.example.smart_bus_system.Passenger_k;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.User.Screens.AvailableBuses.AvailablelBusFragment;
import com.example.smart_bus_system.User.Screens.Home.HomeFragment;
import com.example.smart_bus_system.User.Screens.ProfileFragment;
import com.example.smart_bus_system.qrcode.activities.SplashScreen;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserMainNav extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main_nav);
        bottomNavigation = findViewById(R.id.nav_view);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        // Passing each menu ID as a set of Ids because each
       openFragment(new HomeFragment());
//        openFragment(new AvailablelBusFragment());



    }
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            //Log.d("menu event","Home");
                           openFragment(new HomeFragment());
                            return true;
                        case R.id.navigation_Passenger_count:
                            // Log.d("menu event","Home");
                            startActivity(new Intent(UserMainNav.this, Passenger_k.class));;
                            return true;
                        case R.id.navigation_tracking:
                            //Log.d("menu event","Home");
//                            openFragment(new HomeFragment());
                            startActivity(new Intent(UserMainNav.this, SplashScreen.class));
                            return true;

                        case R.id.navigation_profile:
                            // Log.d("menu event","Home");
                       openFragment(new ProfileFragment());

                            return true;
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