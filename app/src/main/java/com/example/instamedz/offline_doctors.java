package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class offline_doctors extends AppCompatActivity {

    private Button Online_doctors;
private ImageButton Online_dr1;
    private ImageButton Online_dr2;
    private ImageButton Online_dr3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_doctors);


        Online_doctors = findViewById(R.id.online_doctors);
        Online_doctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(offline_doctors.this,Doctor_consultaions.class);
                startActivity(intent);
            }
        });


        Online_dr1 = findViewById(R.id.dr1);
        Online_dr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(offline_doctors.this,appointment_details.class);
                startActivity(intent);
            }
        });

        Online_dr2 = findViewById(R.id.dr2);
        Online_dr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(offline_doctors.this,appointment_details.class);
                startActivity(intent);
            }
        });
        Online_dr3 = findViewById(R.id.dr3);
        Online_dr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(offline_doctors.this,appointment_details.class);
                startActivity(intent);
            }
        });





    }
}