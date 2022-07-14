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
                .setMessage("Asparagus helps to increase blood flow and is rich in fiber, which helps in reducing high blood pressure and diabetes and also decreases the risks of coronary artery disease and stroke. ")
                .setPositiveButton("Okay", null)
                .show();
    }

    public void Broccoli_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Broccoli")
                .setMessage("Broccoli when consumed in steamed condition helps in reducing cholesterol whose increase is the cause of many heart related issues and heart attacks. ")
                .setPositiveButton("Okay", null)
                .show();
    }

    public void Choc_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Dark chocolates")
                .setMessage("It helps in preventing stiffness of arteries and white blood cells adhesion with the blood vessels. Its flavor helps in decreasing the risk of heart attack and stroke. ")
                .setPositiveButton("Okay", null)
                .show();
    }

    public void liver_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Liver meat")
                .setMessage("Liver is rich in copper, folic acid, zinc and chromium. Out of all the organs of meat, the liver is the most nutrient-rich. It helps in increasing hemoglobin level and keeps the heart healthy.")
                .setPositiveButton("Okay", null)
                .show();
    }

    public void Avocados_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Avocados")
                .setMessage("They are known to lower cholesterol and help in reducing risks of heart attacks.")
                .setPositiveButton("Okay", null)
                .show();
    }

    public void Fish_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Fish and Fish Oil")
                .setMessage("Fatty fish like salmon, mackerel, sardines, and tuna are loaded with omega-3 fatty acids, which have been studied extensively for their heart-health benefits.")
                .setPositiveButton("Okay", null)
                .show();
    }

    public void Walnuts_dialog(View view) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("About Walnuts")
                .setMessage("Walnuts are a great source of fiber and micronutrients like magnesium, copper, and manganese. Evidence for cardiovascular disease prevention is strong for some varieties of tree nuts, particularly walnuts.")
                .setPositiveButton("Okay", null)
                .show();
    }
}
