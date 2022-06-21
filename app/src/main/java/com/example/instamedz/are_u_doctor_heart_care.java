package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instamedz.chatBot.ChatBot;

public class are_u_doctor_heart_care extends AppCompatActivity {



    ImageView ChatBot_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_are_udoctor_heart_care);
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