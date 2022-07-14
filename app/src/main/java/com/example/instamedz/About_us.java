package com.example.instamedz;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class About_us extends Home_Page {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_about_us, null, false);
        drawerLayout.addView(contentView, 0);
        fab.hide();
        alreadyExecuted = true;
        ToastAlreadyExecuted = true;
    }
}