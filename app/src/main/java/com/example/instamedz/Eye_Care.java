package com.example.instamedz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.instamedz.chatBot.ChatBot;
import com.example.instamedz.ui.login.ui.Nayan_care_option_page;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Eye_Care extends Home_Page {


    private  ImageView EyeCare_User_logout;
private ImageView Nayan_care_Button;
private FloatingActionButton ChatBot_icon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fab.hide();
        //Next 3 lines are for navigation drawer
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_eye_care, null, false);
        drawerLayout.addView(contentView, 0);
        alreadyExecuted=true;
        ToastAlreadyExecuted=true;



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