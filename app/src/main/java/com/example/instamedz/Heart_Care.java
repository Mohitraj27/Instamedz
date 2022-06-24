package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Heart_Care extends AppCompatActivity {


private ImageView Are_u_a_doctor_button;
private ImageView Heart_patient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_care);



        //Intent are you a doctor?
        Are_u_a_doctor_button=findViewById(R.id.are_u_a_doctor_button);
        Are_u_a_doctor_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Heart_Care.this,are_u_doctor_heart_care.class);
                startActivity(intent);
            }
        });

//Intent Hear_Patient
        Heart_patient=findViewById(R.id.are_u_a_heart_patient_button);
        Heart_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Heart_Care.this,Heart_Patient.class);
                startActivity(intent);
            }
        });




    }






}