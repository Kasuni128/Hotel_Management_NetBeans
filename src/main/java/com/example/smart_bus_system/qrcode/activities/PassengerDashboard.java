package com.example.smart_bus_system.qrcode.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.qrcode.config.UserState;
import com.example.smart_bus_system.qrcode.fragments.PassengerJourneyListFragment;
import com.example.smart_bus_system.qrcode.fragments.PassengerListFragment;
import com.example.smart_bus_system.qrcode.fragments.QRCodeFragment;
import com.example.smart_bus_system.qrcode.fragments.QRCodeScannerFragment;
import com.example.smart_bus_system.qrcode.listeners.JourneyListAdapterListener;
import com.example.smart_bus_system.qrcode.listeners.OnCodeRetrieved;
import com.example.smart_bus_system.qrcode.listeners.OnDialogStateChangedListener;
import com.example.smart_bus_system.qrcode.models.BusDriver;
import com.example.smart_bus_system.qrcode.models.Journey;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import im.delight.android.location.SimpleLocation;

import static com.example.smart_bus_system.qrcode.activities.LoginScreen.BUSES_FIREBASE_ROOT_PATH;
import static com.example.smart_bus_system.qrcode.activities.LoginScreen.PASSENGER_FIREBASE_ROOT_PATH;

public class PassengerDashboard extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private FrameLayout frame_layout;

    private PassengerJourneyListFragment passengerJourneyListFragment;
    private QRCodeScannerFragment qrCodeScannerFragment;
    private AlertDialog.Builder dialog;

    private ProgressDialog progressDialog;

    private SimpleLocation location;

    private NavigationView navigationView;
    private Journey selectedJourney;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 300)
        {
            if(resultCode == RESULT_OK)
            {
                setUpExitConfig(selectedJourney);
            }
            else if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this, "You have scanned a wrong bus!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        location = new SimpleLocation(getApplicationContext());


        progressDialog = new ProgressDialog(PassengerDashboard.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("In progress");


        frame_layout = findViewById(R.id.frame_layout);

        passengerJourneyListFragment = new PassengerJourneyListFragment(getApplicationContext(), new OnDialogStateChangedListener() {
            @Override
            public void show() {

                progressDialog.show();
            }

            @Override
            public void hide() {

                progressDialog.hide();
            }

            @Override
            public void finishActivity() {

            }
        }, new JourneyListAdapterListener() {
            @Override
            public void onScanButtonPressed(Journey journey)
            {
                selectedJourney = journey;
                Intent intent = new Intent(PassengerDashboard.this,Scanner.class);
                intent.putExtra("CODE",journey.getBusNo());
                startActivityForResult(intent,300);
            }
        });
        qrCodeScannerFragment = new QRCodeScannerFragment(getApplicationContext(), new OnCodeRetrieved() {
            @Override
            public void onSuccess(String code)
            {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference(BUSES_FIREBASE_ROOT_PATH);
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot)
                    {
                        for (DataSnapshot dss : snapshot.getChildren())
                        {
                            BusDriver driver = dss.getValue(BusDriver.class);
                            if (driver != null)
                            {
                                if (driver.getBusNo().equals(code))
                                {
                                    addNewJourneyToDatabase(driver);
                                    break;
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error)
                    {

                    }
                });
            }

            @Override
            public void onFailed()
            {

            }
        });

        dialog = new AlertDialog.Builder(PassengerDashboard.this);
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                UserState.deletePassenger(getApplicationContext());
                Intent intent = new Intent(PassengerDashboard.this,SplashScreen.class);
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
        navigationView = findViewById(R.id.nav_view);


        navigationView.setCheckedItem(R.id.journey_list);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                if(item.getItemId() == R.id.journey_list)
                {
                    getSupportFragmentManager().beginTransaction().replace(frame_layout.getId(),passengerJourneyListFragment).commit();
                    drawer.closeDrawers();
                    return true;
                }
                else if(item.getItemId() == R.id.scan)
                {
                    getSupportFragmentManager().beginTransaction().replace(frame_layout.getId(),qrCodeScannerFragment).commit();
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

        getSupportFragmentManager().beginTransaction().replace(frame_layout.getId(),passengerJourneyListFragment).commit();

        ImageView navigation_icon = findViewById(R.id.navigation_icon);
        TextView activity_name = findViewById(R.id.activity_name);
        navigation_icon.setOnClickListener(view-> {

            drawer.open();
        });
        activity_name.setText("Passenger Dashboard");
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
    private void addNewJourneyToDatabase(BusDriver driver)
    {

        navigationView.setCheckedItem(R.id.journey_list);
        getSupportFragmentManager().beginTransaction().replace(frame_layout.getId(),passengerJourneyListFragment).commit();


        Journey journey = new Journey();
        journey.setBusNo(driver.getBusNo());
        journey.setBusRoot(driver.getBusRoot());
        journey.setJourneyId(String.valueOf(System.currentTimeMillis()));

        String passengerId = UserState.getPassengerId(getApplicationContext());
        String usersName = UserState.getUsersName(getApplicationContext());

        journey.setPassengerId(passengerId);
        if(usersName != null)
        {
            journey.setPassengerName(usersName);
        }

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        journey.setEnteredDate(date);

        String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
        journey.setEnteredTime(currentTime);



        journey.setEnteredLatitude(location.getLatitude());
        journey.setEnteredLongitude(location.getLongitude());


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PASSENGER_FIREBASE_ROOT_PATH).child(passengerId);
        reference.child("AllJourneys").child(journey.getJourneyId()).setValue(journey);

        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference(BUSES_FIREBASE_ROOT_PATH).child(driver.getBusNo());
        reference2.child("AllPassengers").child(journey.getJourneyId()).setValue(journey);
    }

    @Override
    protected void onResume() {
        super.onResume();
        location.beginUpdates();
    }

    @Override
    protected void onStop() {
        location.endUpdates();
        super.onStop();
    }
    private void setUpExitConfig(Journey selectedJourney)
    {
        String passengerId = UserState.getPassengerId(getApplicationContext());


        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PASSENGER_FIREBASE_ROOT_PATH).child(passengerId);
        reference.child("AllJourneys").child(selectedJourney.getJourneyId()).child("exitLatitude").setValue(latitude);
        reference.child("AllJourneys").child(selectedJourney.getJourneyId()).child("exitLongitude").setValue(longitude);
        reference.child("AllJourneys").child(selectedJourney.getJourneyId()).child("ExitDate").setValue(date);
        reference.child("AllJourneys").child(selectedJourney.getJourneyId()).child("ExitTime").setValue(currentTime);

        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference(BUSES_FIREBASE_ROOT_PATH).child(selectedJourney.getBusNo());
        reference2.child("AllPassengers").child(selectedJourney.getJourneyId()).child("exitLatitude").setValue(latitude);
        reference2.child("AllPassengers").child(selectedJourney.getJourneyId()).child("exitLongitude").setValue(longitude);
        reference2.child("AllPassengers").child(selectedJourney.getJourneyId()).child("ExitDate").setValue(date);
        reference2.child("AllPassengers").child(selectedJourney.getJourneyId()).child("ExitTime").setValue(currentTime);
    }
}