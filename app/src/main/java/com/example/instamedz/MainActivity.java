package com.example.instamedz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.instamedz.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {


    private Button GetStarted;
    private TextView Already_Have_A_account;
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
        Already_Have_A_account=findViewById(R.id.Already_have_a_account_text);
        Already_Have_A_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LogInPage=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(LogInPage);
            }
        });
    }
}