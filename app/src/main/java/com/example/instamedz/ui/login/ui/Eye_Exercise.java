package com.example.instamedz.ui.login.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.instamedz.Eyecare_ex1;
import com.example.instamedz.Home_Page;
import com.example.instamedz.R;

public class Eye_Exercise extends Home_Page {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_eye_exercise, null, false);
        drawerLayout.addView(contentView, 0);
        fab.hide();
        alreadyExecuted=true;
        ToastAlreadyExecuted=true;

    }
    public void EyeCareEx1(View view) {
        Intent Eyecareex=new Intent(Eye_Exercise.this, Eyecare_ex1.class);
        startActivity(Eyecareex);
    }
}