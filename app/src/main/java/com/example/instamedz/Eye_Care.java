package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instamedz.ui.login.ui.Nayan_care_option_page;

public class Eye_Care extends AppCompatActivity {

private ImageView Nayan_care_Button;


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
}}