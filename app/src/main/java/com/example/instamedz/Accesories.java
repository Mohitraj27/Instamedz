package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Accesories extends AppCompatActivity {
private ImageView impulse_12_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accesories);
   impulse_12_intent=findViewById(R.id.impulse_12);
   impulse_12_intent.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent=new Intent(Accesories.this,impulse_12.class);
           startActivity(intent);
       }
   });

    }
}