package com.example.instamedz;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class Diet_heart_care extends AppCompatActivity {
    // creating object of ViewPager
    ViewFlipper flipper;
    ImageView prev_Button, next_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_heart_care);






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
                        flipper.setInAnimation(Diet_heart_care.this,
                                R.anim.slide_right);
                        flipper.setOutAnimation(Diet_heart_care.this,
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
                        flipper.setInAnimation(Diet_heart_care.this,
                                android.R.anim.slide_out_right);
                        flipper.setOutAnimation(Diet_heart_care.this,
                                android.R.anim.slide_in_left);

                        // It shows next item.
                        flipper.showNext();
                    }
                });


    }


}