package com.example.smart_bus_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage_k extends AppCompatActivity {


    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_k);
        bt1 = (Button)findViewById(R.id.homebtn1);
        bt2 = (Button)findViewById(R.id.homebtn2);




        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePage_k.this,Message_k.class);
                startActivity(intent);

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePage_k.this,Passenger_k.class);
                startActivity(intent);

            }
        });
    }
}