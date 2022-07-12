package com.example.instamedz;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Diet_heart_care extends Home_Page {

    // creating object of ViewPager
    ViewFlipper flipper;
    ImageView prev_Button, next_Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_diet_heart_care, null, false);
        drawerLayout.addView(contentView, 0);
        fab.hide();
        alreadyExecuted = true;
        ToastAlreadyExecuted = true;

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


    public void Asparagus_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Asparagus")
                .setMessage("Info")
                .setPositiveButton("Okay", null)
                .show();
    }

    public void Broccoli_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Broccoli")
                .setMessage("Info")
                .setPositiveButton("Okay", null)
                .show();
    }

    public void Choc_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Dark chocolates")
                .setMessage("Info")
                .setPositiveButton("Okay", null)
                .show();
    }

    public void liver_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Liver meat")
                .setMessage("Info")
                .setPositiveButton("Okay", null)
                .show();
    }

    public void Avocados_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Avocados")
                .setMessage("Info")
                .setPositiveButton("Okay", null)
                .show();
    }

    public void Fish_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Fish and Fish Oil")
                .setMessage("Info")
                .setPositiveButton("Okay", null)
                .show();
    }

    public void Walnuts_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Walnuts")
                .setMessage("Info")
                .setPositiveButton("Okay", null)
                .show();
    }
}
