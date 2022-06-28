package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Guest_page extends AppCompatActivity {
 private ImageView Guest_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_page);
        Guest_button=findViewById(R.id.Continue_guest);
        Guest_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Guest_page.this, Home_Page.class);
                startActivity(intent);
            }
        });



    }
}