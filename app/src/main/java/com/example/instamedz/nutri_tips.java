package com.example.instamedz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class nutri_tips extends Home_Page {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_nutri_tips, null, false);
        drawerLayout.addView(contentView, 0);
        fab.hide();
        alreadyExecuted=true;
        ToastAlreadyExecuted=true;
    }

    public void Nutri_exc_dialog(View view) {
        Intent LogInPage=new Intent(nutri_tips.this, Nutri_exc.class);
        startActivity(LogInPage);
    }

    public void Nutri_sleep_dialog(View view) {
        Intent LogInPage=new Intent(nutri_tips.this, Nutri_sleep.class);
        startActivity(LogInPage);
    }

    public void Nutri_hydrate_dialog(View view) {
        Intent LogInPage=new Intent(nutri_tips.this, Nutri_hydrate.class);
        startActivity(LogInPage);
    }

    public void Nutri_addiction_dialog(View view) {
        Intent LogInPage=new Intent(nutri_tips.this, Nutri_addiction.class);
        startActivity(LogInPage);
    }

    public void Nutri_junk_dialog(View view) {
        Intent LogInPage=new Intent(nutri_tips.this, Nutri_food.class);
        startActivity(LogInPage);
    }
}