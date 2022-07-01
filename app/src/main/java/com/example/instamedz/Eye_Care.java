package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instamedz.chatBot.ChatBot;
import com.example.instamedz.ui.login.ui.Nayan_care_option_page;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Eye_Care extends AppCompatActivity {


    private  ImageView EyeCare_User_logout;
private ImageView Nayan_care_Button;
private FloatingActionButton ChatBot_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_care);




    Nayan_care_Button =findViewById(R.id.nayan_care_intro_page_button);
        Nayan_care_Button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent LogInPage=new Intent(Eye_Care.this, Nayan_care_option_page.class);
            startActivity(LogInPage);
        }
    });
}

    public void Chatbot(View view) {
        ChatBot_icon=findViewById(R.id.floatingActionButton2);
       ChatBot_icon.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(Eye_Care.this, ChatBot.class);
               startActivity(intent);
           }
       });

    }

}