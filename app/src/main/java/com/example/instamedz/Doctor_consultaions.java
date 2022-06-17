package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Doctor_consultaions extends AppCompatActivity {

private ImageButton Online_drs1;
private ImageButton Online_drs2;
private ImageButton Online_drs3;
    private Button Offline_doctors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_consultaions);
        Offline_doctors =findViewById(R.id.offline_doctors);
        Offline_doctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Doctor_consultaions.this, offline_doctors.class);
                startActivity(intent);
            }
        });
        Online_drs1 =findViewById(R.id.Online_dr1);
        Online_drs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Doctor_consultaions.this, appointment_details.class);
                startActivity(intent);
            }
        });

        Online_drs2 =findViewById(R.id.Onlinedr2);
        Online_drs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Doctor_consultaions.this, appointment_details.class);
                startActivity(intent);
            }
        });

        Online_drs3 =findViewById(R.id.Online_dr3);
        Online_drs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Doctor_consultaions.this, appointment_details.class);
                startActivity(intent);
            }
        });


    }



}