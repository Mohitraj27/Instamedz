package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Nutri_options extends AppCompatActivity {
ImageView prograin,diet,water,tips,doc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutri_options);
        tips =findViewById(R.id.nutri_tips_button);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LogInPage=new Intent(Nutri_options.this, nutri_tips.class);
                startActivity(LogInPage);
            }
        });
        prograin =findViewById(R.id.prograin_button);
        prograin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LogInPage=new Intent(Nutri_options.this, nutri_prograin.class);
                startActivity(LogInPage);
            }
        });
    }
}