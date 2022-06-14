package com.example.instamedz.ui.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instamedz.Doctor_consultaions;
import com.example.instamedz.R;

public class Nayan_care_option_page extends AppCompatActivity {



    private ImageView Eye_excercise;
    private  ImageView Eye_Hygiene_Diet;
    private  ImageView Doctor_consulations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nayan_care_option_page);


        Eye_excercise =findViewById(R.id.Eye_care_exercise_button);
        Eye_excercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Nayan_care_option_page.this, Eye_Exercise.class);
                startActivity(intent);
            }
        });
        Eye_Hygiene_Diet =findViewById(R.id.Eye_hygiene_button);
        Eye_Hygiene_Diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Nayan_care_option_page.this, Eye_hygiene_diet.class);
                startActivity(intent);
            }
        });

        Doctor_consulations =findViewById(R.id.doctors_consulations_button);
        Doctor_consulations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Nayan_care_option_page.this, Doctor_consultaions.class);
                startActivity(intent);
            }
        });


    }
}