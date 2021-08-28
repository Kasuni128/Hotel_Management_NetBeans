package com.example.smart_bus_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Message;
import android.telephony.SmsManager;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.smart_bus_system.BusOwner.Screens.Driver_Profile;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Timer;

public class Message_k extends AppCompatActivity {


    Button btnmap;
    TextView textView1, textView2, textView3, textView4, textView5,text;
    DatabaseReference ref;
    FirebaseDatabase database;

    FusedLocationProviderClient fusedLocationProviderClient;
    Timer timer;
    private TextView counterText;
    private BroadcastReceiver minuteUpdateReceiver;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_k);


        counterText = (TextView) findViewById(R.id.counter_text);







        btnmap=findViewById(R.id.btn_Map);
        textView1 = findViewById(R.id.textView_1);
        textView2 = findViewById(R.id.textView_2);
        textView3 = findViewById(R.id.textView_3);
        textView4 = findViewById(R.id.textView_4);
        textView5 = findViewById(R.id.textView_5);
        text=findViewById(R.id.text_counting);






        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Message_k.this,Bus_Location.class);
                startActivity(intent);
            }
        });

        //Initialize fusedLocationProviderClient

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        //check permission
        if (ActivityCompat.checkSelfPermission(Message_k.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //when permisson granted
            getLocation();

        } else {
            //when permission denied
            ActivityCompat.requestPermissions(Message_k.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

        }

        ActivityCompat.requestPermissions(Message_k.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);


        ref = FirebaseDatabase.getInstance().getReference().child("count");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String passenger = snapshot.child("passenger").getValue().toString();
                int newVal = Integer.parseInt(passenger);
                String overload = snapshot.child("overload").getValue().toString();
                int newVal2 = Integer.parseInt(overload);
                getLocation();

                String title = textView4.getText().toString();
                String address = textView5.getText().toString();

                if(title.contains("anwella")){

                    if (newVal > newVal2) {

                        String message = "Overload Bus"+address;
                        String number = "0716528117";

                        SmsManager mySmsManager = SmsManager.getDefault();
                        mySmsManager.sendTextMessage(number, null, message, null, null);

                        text.setText("Overload");
                    }
                    if(newVal <= 0 ){

                        text.setText("No Passengers");
                    }
                    else{
                        text.setText(passenger+"/"+overload);
                    }
                }

                else if(title.contains("aluaggala")){

                    if (newVal > newVal2) {

                        String message = "Overload Bus"+address;
                        String number = "0716528117";

                        SmsManager mySmsManager = SmsManager.getDefault();
                        mySmsManager.sendTextMessage(number, null, message, null, null);

                        text.setText("Overload");
                    } if(newVal <= 0 ){

                        text.setText("No Passengers");
                    }
                    else{
                        text.setText(passenger+"/"+overload);
                    }
                }

                else if(title.contains("iripola")){

                    if (newVal > newVal2) {

                        String message = "Overload Bus"+address;
                        String number = "0716528117";

                        SmsManager mySmsManager = SmsManager.getDefault();
                        mySmsManager.sendTextMessage(number, null, message, null, null);

                        text.setText("Overload");
                    } if(newVal <= 0 ){

                        text.setText("No Passengers");
                    }
                    else{
                        text.setText(passenger+"/"+overload);
                    }
                }

                else if(title.contains("duwa")){

                    if (newVal > newVal2) {

                        String message = "Overload Bus"+address;
                        String number = "0716528117";

                        SmsManager mySmsManager = SmsManager.getDefault();
                        mySmsManager.sendTextMessage(number, null, message, null, null);

                        text.setText("Overload");
                    } if(newVal <= 0 ){

                        text.setText("No Passengers");
                    }
                    else{
                        text.setText(passenger+"/"+overload);
                    }
                }

                else if(title.contains("aga")){

                    if (newVal > newVal2) {

                        String message = "Overload Bus"+address;
                        String number = "0712957960";

                        SmsManager mySmsManager = SmsManager.getDefault();
                        mySmsManager.sendTextMessage(number, null, message, null, null);

                        text.setText("Overload");
                    } if(newVal <= 0 ){

                        text.setText("No Passengers");
                    }
                    else{
                        text.setText(passenger+"/"+overload);
                    }
                }

                else if(title.contains("elikanna")){

                    if (newVal > newVal2) {

                        String message = "Overload Bus"+address;
                        String number = "0712957960";

                        SmsManager mySmsManager = SmsManager.getDefault();
                        mySmsManager.sendTextMessage(number, null, message, null, null);

                        text.setText("Overload");
                    } if(newVal <= 0 ){

                        text.setText("No Passengers");
                    }
                    else{
                        text.setText(passenger+"/"+overload);
                    }
                }

                else if(title.contains("ridapola")){

                    if (newVal > newVal2) {

                        String message = "Overload Bus"+address;
                        String number = "0712957960";

                        SmsManager mySmsManager = SmsManager.getDefault();
                        mySmsManager.sendTextMessage(number, null, message, null, null);

                        text.setText("Overload");
                    } if(newVal <= 0 ){

                        text.setText("No Passengers");
                    }
                    else{
                        text.setText(passenger+"/"+overload);
                    }
                }

                else if(title.contains("abugama")){

                    if (newVal > newVal2) {

                        String message = "Overload Bus"+address;
                        String number = "0712957960";

                        SmsManager mySmsManager = SmsManager.getDefault();
                        mySmsManager.sendTextMessage(number, null, message, null, null);

                        text.setText("Overload");
                    } if(newVal <= 0 ){

                        text.setText("No Passengers");
                    }
                    else{
                        text.setText(passenger+"/"+overload);
                    }
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }



    private void getLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                //Initialize location
                Location location = task.getResult();
                if (location != null) {

                    try {
                        //initialize geoCoder
                        Geocoder geocoder = new Geocoder(Message_k.this, Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                        //set latitude on text
                        textView1.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Latitude : </b> <br></font>"
                                        + addresses.get(0).getLatitude()

                        ));

                        //set longtitude
                        textView2.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Longtitude : </b> <br></font>"
                                        + addresses.get(0).getLongitude()

                        ));

                        //set Country name
                        textView3.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Country : </b> <br></font>"
                                        + addresses.get(0).getCountryName()

                        ));

                        //set Locacity
                        textView4.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Locality : </b> <br></font>"
                                        + addresses.get(0).getLocality()

                        ));

                        //set Address
                        textView5.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Address : </b> <br></font>"
                                        + addresses.get(0).getAddressLine(0)

                        ));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    public void startMinuteUpdater() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        minuteUpdateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                counter++;
                counterText.setText("" + counter);
            }

        };
        registerReceiver(minuteUpdateReceiver, intentFilter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        startMinuteUpdater();
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(minuteUpdateReceiver);
    }



}