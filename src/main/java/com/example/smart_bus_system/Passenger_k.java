package com.example.smart_bus_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.smart_bus_system.BusOwner.Screens.Driver_Profile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Passenger_k extends AppCompatActivity {

    TextView a;
    Button btn;
    DatabaseReference reft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_k);




        a=(TextView)findViewById(R.id.count);

        btn =(Button)findViewById(R.id.show);






        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reft = FirebaseDatabase.getInstance().getReference().child("count");
                reft.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String passenger = snapshot.child("passenger").getValue().toString();
                        int newVal=Integer.parseInt(passenger);
                        String overload = snapshot.child("overload").getValue().toString();
                        int newVal2=Integer.parseInt(overload);


                        if(newVal >= newVal2 ){

                            a.setText("Overload");
                        }
                        else if(newVal <= 0 ){

                            a.setText("No Passengers");
                        }
                        else{
                            a.setText(passenger+"/"+overload);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }


                });




            }
        });
    }

}



