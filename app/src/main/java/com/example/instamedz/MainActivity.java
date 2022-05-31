package com.example.instamedz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instamedz.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private Button GetStarted, HomePage;
    private TextView Already_Have_A_account;
private Button Login_button;
    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(MainActivity.this, Home_Page.class));
        }
    }
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
        Already_Have_A_account=findViewById(R.id.Already_have_a_account_text);
        Already_Have_A_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LogInPage=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(LogInPage);
            }
        });
        HomePage=findViewById(R.id.Home_Page_Default_button);
        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomePageInfo=new Intent(MainActivity.this,Home_Page.class);
                startActivity(HomePageInfo);
            }
        });


    }
}