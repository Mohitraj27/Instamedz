package com.example.instamedz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private Button GetStarted;
    private TextView Already_Have_A_account;
private Button Login_button;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetStarted = findViewById(R.id.Get_started);
        GetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SigUpPage=new Intent(MainActivity.this, SignUP.class);
                startActivity(SigUpPage);
            }
        });
        Already_Have_A_account=findViewById(R.id.Home_Page_Default_button);
        Already_Have_A_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LogInPage=new Intent(MainActivity.this,Home_Page.class);
                startActivity(LogInPage);
            }
        });


    }
}