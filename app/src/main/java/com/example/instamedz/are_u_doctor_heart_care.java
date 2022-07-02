package com.example.instamedz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.instamedz.chatBot.ChatBot;

public class are_u_doctor_heart_care extends Home_Page {



    ImageView ChatBot_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_are_udoctor_heart_care, null, false);
        drawerLayout.addView(contentView, 0);
        fab.hide();
        alreadyExecuted=true;
        ToastAlreadyExecuted=true;
    }



        public void Chatbot(View view) {
            ChatBot_icon=findViewById(R.id.floatingActionButton2);
            ChatBot_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(are_u_doctor_heart_care.this, ChatBot.class);
                    startActivity(intent);
                }
            });
    }
}