package com.example.smart_bus_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.smart_bus_system.User.UserMainNav;

public class Home extends AppCompatActivity {

    Button b1,b2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        b1=findViewById(R.id.driver_timekeeper);
        b2=findViewById(R.id.passenger);
        t1=findViewById(R.id.textView8);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( Home.this, LoginActivity.class));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( Home.this, UserMainNav.class));
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( Home.this, Message_k.class));
            }
        });


    }
}