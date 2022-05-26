package com.example.instamedz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.instamedz.ui.login.LoginActivity;

public class SignUP extends AppCompatActivity {



     private TextView LogIn_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        LogIn_text=findViewById(R.id.login_text);
        LogIn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LogIn_Text=new Intent(SignUP.this, LoginActivity.class);
                startActivity(LogIn_Text);
            }
        });
    }
}