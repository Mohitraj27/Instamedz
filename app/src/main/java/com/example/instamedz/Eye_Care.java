package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instamedz.chatBot.ChatBot;
import com.example.instamedz.ui.login.ui.Nayan_care_option_page;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Eye_Care extends AppCompatActivity {

    ViewFlipper v_flipper;
private ImageView Nayan_care_Button;
private FloatingActionButton ChatBot_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_care);



        //Flipper images in heart care page

        int images[] = {R.drawable.eye_care_images1, R.drawable.eye_care_images2    };


        v_flipper = findViewById(R.id.v_flipper);
//for loop
     /*   for(int i=0;i<image.length;i++){
            flipperImages(image(i));
        }*/
//but I prefer Forreach
        for (int image : images) {
            flipperImages(image);
        }





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