package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class Home_Page extends AppCompatActivity {

    DrawerLayout drawerLayout;
   ImageView onCLick_menu_bar;
   ImageView Eye_Care;
   ImageView Health_Care;
   ImageView Heart_care;
   ImageView Soul_care;
   ImageView Business_care;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);
  Eye_Care=findViewById(R.id.Eye_Care);
  Eye_Care.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          Intent Eye_Care_Intent=new Intent(Home_Page.this,Eye_Care.class);
          startActivity(Eye_Care_Intent);
      }
  });
  Health_Care=findViewById(R.id.health_care);
  Health_Care.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          Intent Health_Care_Intent=new Intent(Home_Page.this, Health_Care.class);
          startActivity(Health_Care_Intent);
      }
  });

Heart_care=findViewById(R.id.heart_care);
Heart_care.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent Heart_Care_intent=new Intent(Home_Page.this,Heart_Care.class);
        startActivity(Heart_Care_intent);
    }
});

Soul_care=findViewById(R.id.soul_care);
Soul_care.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent Soul_care_Intent=new Intent(Home_Page.this, Soul_care.class);
        startActivity(Soul_care_Intent);
    }
});

Business_care=findViewById(R.id.bussiness_care);
Business_care.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent Bussiness_care=new Intent(Home_Page.this, com.example.instamedz.Bussiness_care.class);
        startActivity(Bussiness_care);
    }
});
    }



}
