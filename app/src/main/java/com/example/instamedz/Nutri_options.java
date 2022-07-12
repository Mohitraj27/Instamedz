package com.example.instamedz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class Nutri_options extends Home_Page {
ImageView prograin,diet,water,tips,doc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_nutri_options, null, false);
        drawerLayout.addView(contentView, 0);
        fab.hide();
        alreadyExecuted = true;
        ToastAlreadyExecuted = true;
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
        doc=findViewById(R.id.nutri_doc_button);
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Nutri_options.this, Doctor_consultaions.class);
                startActivity(intent);
            }
        });
    }
}