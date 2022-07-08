package com.example.instamedz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class Heart_Care extends Home_Page {


private ImageView Are_u_a_doctor_button;
private ImageView Heart_patient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_heart_care, null, false);
        drawerLayout.addView(contentView, 0);
        fab.hide();
        alreadyExecuted=true;
        ToastAlreadyExecuted=true;
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
                Intent intent=new Intent(Heart_Care.this,Diet_heart_care.class);
                startActivity(intent);
            }
        });




    }






}