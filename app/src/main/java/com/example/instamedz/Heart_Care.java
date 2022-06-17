package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class Heart_Care<v_flippper> extends AppCompatActivity {

ViewFlipper v_flipper;

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

        //Flipper images in heart care page

        int images[] = {R.drawable.heart_care, R.drawable.heart_care_image1, R.drawable.heart_care_clinic_dwarka_delhi, R.drawable.holy_family_heart_care};


        v_flipper = findViewById(R.id.v_flipper);
//for loop
     /*   for(int i=0;i<image.length;i++){
            flipperImages(image(i));
        }*/
//but I prefer Forreach
        for (int image : images) {
            flipperImages(image);
        }



    }


    //for movement of live images in front Page
    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);


        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(1500);//2sec
        v_flipper.setAutoStart(true);


        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }





}