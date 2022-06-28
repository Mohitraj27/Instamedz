package com.example.instamedz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private ImageView GetStarted;

private Button Login_button;
    private FirebaseAuth mAuth;
    private long pressedTime;


private TextView Guest_page;


    //Dashboard Intent

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

Guest_page=findViewById(R.id.Guest_button);
Guest_page.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent= new Intent(MainActivity.this, Guest_page.class);
        startActivity(intent);
    }
});

        GetStarted = findViewById(R.id.Get_started);
        GetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SigUpPage=new Intent(MainActivity.this, SignUP.class);
                startActivity(SigUpPage);
            }
        });




    }
    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

    //Put in your activity you want to be enabled with "double back exit"
  /*  @Override
    public void onBackPressed() {
        doubleBackPressTrigger();
    }*/

    private void doubleBackPressTrigger() {
    }

    /*@Override
    public boolean onOptionsItemsSelected(MenuItem item) {
        return false;
    }*/
}