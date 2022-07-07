package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Benifits extends AppCompatActivity {


    private ImageView accessories_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benifits);
        accessories_intent =findViewById(R.id.accessories_intent);
        accessories_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Benifits.this,Accesories.class);
                startActivity(intent);
            }
        });
          }

    }
