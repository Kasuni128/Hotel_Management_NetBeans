package com.example.smart_bus_system;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smart_bus_system.User.Screens.Home.LocationHelper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


public class Bus_Location extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Location location;
    private LocationListener locationListener;
    private LocationManager locationManager;
    private LocationRequest locationRequest;
    private long update_interval =2000;
    private long fatest_interval = 5000;
    private boolean isPermission;
    private DatabaseReference databaseReference;
    private Ringtone ringtone;
    private TextToSpeech textToSpeech;


    private final long MIN_TIME = 1000; // 1 second
    private final long MIN_DIST = 5; // 5 Meters

    private LatLng latLng;
    Timer timer;

    DatabaseReference reft;




    ArrayList<LatLng> arrayList=new ArrayList<LatLng>();



    LatLng Labugama = new LatLng(6.8577869, 80.1749133);
    LatLng Iridapola = new LatLng(6.8714563, 80.1433532);
    LatLng Welikanna = new LatLng(6.8845, 80.1398732371);
    LatLng Kahahena = new LatLng(6.8925463, 80.1304786);
    LatLng Neluwattuduwa = new LatLng(6.9024306, 80.120651);
    LatLng Niripola = new LatLng(6.9119846, 80.1073472);
    LatLng Kaluaggala = new LatLng(6.9150307, 80.1005022);
    LatLng Hanwella = new LatLng(6.8916058, 80.0677161);



    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus__location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);


        databaseReference = FirebaseDatabase.getInstance().getReference("Location");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    String databaseLatitudeString = dataSnapshot.child("latitude").getValue().toString().substring(1, dataSnapshot.child("latitude").getValue().toString().length()-1);
                    String databaseLongitudedeString = dataSnapshot.child("longitude").getValue().toString().substring(1, dataSnapshot.child("longitude").getValue().toString().length()-1);

                    String[] stringLat = databaseLatitudeString.split(", ");
                    Arrays.sort(stringLat);
                    String latitude = stringLat[stringLat.length-1].split("=")[1];

                    String[] stringLong = databaseLongitudedeString.split(", ");
                    Arrays.sort(stringLong);
                    String longitude = stringLong[stringLong.length-1].split("=")[1];


                    LatLng latLng = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));

                    mMap.addMarker(new MarkerOptions().position(latLng).title(latitude + " , " + longitude));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));


                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        arrayList.add(Labugama);
        arrayList.add(Iridapola);
        arrayList.add(Welikanna);
        arrayList.add(Kahahena);
        arrayList.add(Neluwattuduwa);
        arrayList.add(Niripola);
        arrayList.add(Kaluaggala);
        arrayList.add(Hanwella);



//        textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//
//                textToSpeech.setLanguage(Locale.US);
//                textToSpeech.setSpeechRate((float)0.5);
//
//            }
//        });
//
//
//
//
//
//
//
//
//        ringtone = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
//
//
//
//        b=findViewById(R.id.backBtn);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Bus_Location.this,Message_k.class);
//                startActivity(intent);
//            }
//        });
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

       /* mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/

        for(int i =0 ; i<arrayList.size();i++){

            mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Bus Halt"));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }


        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                try {


                    LocationHelper helper = new LocationHelper(
                            location.getLongitude(),
                            location.getLatitude()
                    );

                    FirebaseDatabase.getInstance().getReference("Current Location")
                            .setValue(helper).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Bus_Location.this, "Location Saved", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(Bus_Location.this, "Location Not Saved", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                    latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title("Bus Location"));


                    for(int i =0 ; i<arrayList.size();i++){



                        mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

                    }

                }
                catch (SecurityException e){
                    e.printStackTrace();
                }
            }
        };

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DIST, locationListener);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DIST, locationListener);

        }
        catch (SecurityException e){
            e.printStackTrace();
        }


        reft = FirebaseDatabase.getInstance().getReference().child("count");
        reft.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String a = snapshot.child("passenger").getValue().toString();
                int i = Integer.parseInt(a);

                String b = snapshot.child("overload").getValue().toString();
                int j = Integer.parseInt(b);

               /* if(1==1){

                    String m = "Please Attention Please , Your bus is nearest to overload";


                    textToSpeech.speak(m, TextToSpeech.QUEUE_FLUSH, null,null);

                    ringtone.play();



                }*/

                if(j<i){
                    Intent intent = new Intent(Bus_Location.this, Message_k.class);
                    startActivity(intent);

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }

    public void stopButton(View view){
        ringtone.stop();
    }



}