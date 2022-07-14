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

public class Nutri_care extends Home_Page {
ImageView next_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //For Nutri  Care Service Notification
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("Heart_careNotification", "Heart_careNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager =getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"Heart_careNotification")
                .setContentTitle("Welcome to our Nutri Care Service")
                .setSmallIcon(R.drawable.health_care_icon)
                .setAutoCancel(true)
                .setContentText("Explore our Prograin 11 Product.");

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(111111,builder.build());


        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_nutri_care, null, false);
        drawerLayout.addView(contentView, 0);
        fab.hide();
        alreadyExecuted=true;
        ToastAlreadyExecuted=true;
        next_button =findViewById(R.id.nutri_next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LogInPage=new Intent(Nutri_care.this, Nutri_options.class);
                startActivity(LogInPage);
            }
        });
    }
}