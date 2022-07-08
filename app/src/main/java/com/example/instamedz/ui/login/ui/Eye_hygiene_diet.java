package com.example.instamedz.ui.login.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.instamedz.Home_Page;
import com.example.instamedz.R;

public class Eye_hygiene_diet extends Home_Page {
    ViewFlipper flipper;
    ImageView prev_Button, next_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_eye_hygiene_diet, null, false);
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
                        flipper.setInAnimation(Eye_hygiene_diet.this,
                                R.anim.slide_right);
                        flipper.setOutAnimation(Eye_hygiene_diet.this,
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
                        flipper.setInAnimation(Eye_hygiene_diet.this,
                                android.R.anim.slide_out_right);
                        flipper.setOutAnimation(Eye_hygiene_diet.this,
                                android.R.anim.slide_in_left);

                        // It shows next item.
                        flipper.showNext();
                    }
                });



    }
}