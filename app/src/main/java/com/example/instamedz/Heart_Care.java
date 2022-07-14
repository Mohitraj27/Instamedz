package com.example.instamedz;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Heart_Care extends Home_Page {


private ImageView Are_u_a_doctor_button;
private ImageView Heart_patient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //For Heart  Care Service Notification
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("Heart_careNotification", "Heart_careNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager =getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"Heart_careNotification")
                .setContentTitle("Welcome to our Heart Care Service")
                .setSmallIcon(R.drawable.heart_care_icon)
                .setAutoCancel(true)
                .setContentText("Explore our World's Smallest Digital ECG Machine.");

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(111,builder.build());


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