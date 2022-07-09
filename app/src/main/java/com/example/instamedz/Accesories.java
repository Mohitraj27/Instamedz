package com.example.instamedz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Accesories extends Home_Page {
private ImageView impulse_12_intent;

    ViewFlipper flipper;
    ImageView prev_Button, next_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_accesories, null, false);
        drawerLayout.addView(contentView, 0);
        fab.hide();
        alreadyExecuted=true;
        ToastAlreadyExecuted=true;


        flipper = findViewById(R.id.view_flipper);
        prev_Button = findViewById(R.id.prev_button);
        next_Button = findViewById(R.id.next_button);

        prev_Button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        // It is used to set the in and out
                        // animation of View flipper.
                        flipper.setInAnimation(Accesories.this,
                                R.anim.slide_right);
                        flipper.setOutAnimation(Accesories.this,
                                R.anim.slide_left);

                        // It shows previous item.
                        flipper.showPrevious();
                    }
                });

        next_Button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        // It is used to set the in and out
                        // animation of View flipper.
                        flipper.setInAnimation(Accesories.this,
                                android.R.anim.slide_out_right);
                        flipper.setOutAnimation(Accesories.this,
                                android.R.anim.slide_in_left);

                        // It shows next item.
                        flipper.showNext();
                    }
                });


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