package com.example.instamedz;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Soul_care extends Home_Page {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //For Eye Care Service Notification
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("Eye_careNotification", "Eye_careNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager Eye_manager =getSystemService(NotificationManager.class);
            Eye_manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"Eye_careNotification")
                .setContentTitle("Welcome to our Soul Care Service")
                .setSmallIcon(R.drawable.eye_care_icon)
                .setAutoCancel(true)

                .setContentText("We believe in the purposeful care of one’s mind. WILL + EMOTION.   ");

        NotificationManagerCompat Eye_manager = NotificationManagerCompat.from(this);
        Eye_manager.notify(1111111,builder.build());


        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_soul_care, null, false);
        drawerLayout.addView(contentView, 0);
        fab.hide();
        alreadyExecuted=true;
        ToastAlreadyExecuted=true;
    }
}