package com.example.instamedz;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.instamedz.EyecareBot.Eyecarebot;
import com.example.instamedz.ui.login.Appoint_frag;
import com.example.instamedz.ui.login.User_Frag;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home_Page extends AppCompatActivity implements View.OnClickListener, Home_Page1 {





     ImageView UserProfilePic;
     public MaterialToolbar toolbar;
     public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public FrameLayout frameLayout;
   ImageView onCLick_menu_bar;
   ImageView Eye_Care;
   ImageView Health_Care;
   ImageView Heart_care;
   ImageView Soul_care;
   ImageView Business_care;
    private FirebaseUser user, currentUser;
    private DatabaseReference reference;
    private String userID,username="Guest";
    private ActionBarDrawerToggle toggle;
    public FloatingActionButton fab;
    public boolean alreadyExecuted;
    public boolean ToastAlreadyExecuted;

    @Override
    protected void onStart() {
        super.onStart();
        if(!alreadyExecuted)
        {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primary_blue)));
            replaceFragment(new Home_fragment());
            alreadyExecuted=true;
            Toast.makeText(this,"Welcome "+username,Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.top_app_bar, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_home_page);


        //For Notification
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel Home_page_channel=new NotificationChannel("HomePage_notification", "HomePage_notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager Home_page_manager =getSystemService(NotificationManager.class);
            Home_page_manager.createNotificationChannel(Home_page_channel);
        }
         NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"HomePage_notification")
                 .setContentTitle("Welcome to Instamedz")
                 .setSmallIcon(R.drawable.instamedz2)
                 .setAutoCancel(true)
                 .setContentText("We are committed towards your holistic well-being !!\n ");

        NotificationManagerCompat Home_page_manager = NotificationManagerCompat.from(this);
        Home_page_manager.notify(1,builder.build());



        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        frameLayout=findViewById(R.id.Home_FrameLayout);
        drawerLayout=findViewById(R.id.drawer_layout_home);
        navigationView=findViewById(R.id.nav_view);
        toggle=new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        fab.show();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {
                    case R.id.home_item:
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primary_blue)));
                        replaceFragment(new Home_fragment()); fab.show(); break;
                    case R.id.User_item:
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primary_blue)));
                        replaceFragment(new User_Frag());fab.hide(); break;
                    case R.id.appointment_item:
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primary_blue)));
                        replaceFragment(new Appoint_frag());fab.hide();break;
                    case R.id.eye_care_item:
                        Intent Eye_Care_Intent = new Intent(Home_Page.this, Eye_Care.class);
                        startActivity(Eye_Care_Intent); break;
                    case R.id.heart_care_item:
                        Intent Heart_care_intent = new Intent(Home_Page.this, Heart_Care.class);
                        startActivity(Heart_care_intent); break;
                    case R.id.soul_care_item:
                        Intent Soul_care_intent = new Intent(Home_Page.this, Soul_care.class);
                        startActivity(Soul_care_intent);break;
                    case R.id.health_care_item:
                        Intent Health_Care_Intent = new Intent(Home_Page.this, Health_Care.class);
                        startActivity(Health_Care_Intent); break;
                    case R.id.business_care_item:
                        Intent Bus_Care_Intent = new Intent(Home_Page.this, com.example.instamedz.Business_care.class);
                        startActivity(Bus_Care_Intent); break;
                    case R.id.share_item:
                        ShareWebsite(); break;
                    case R.id.nutri_care_item:
                        Intent Nutri_care_Intent = new Intent(Home_Page.this, Nutri_care.class);
                        startActivity(Nutri_care_Intent); break;
                    case R.id.about_us_item:
                        Intent About_us_Intent = new Intent(Home_Page.this, About_us.class);
                        startActivity(About_us_Intent); break;
                    default:
                        return true;
                }
                return true;
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id=item.getItemId();
                item.setChecked(true);
                switch(id)
                {
                    case R.id.profile_toolbar:
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primary_blue)));
                        replaceFragment(new User_Frag());
                    default:
                        return true;

                }

            }
        });

        user= FirebaseAuth.getInstance().getCurrentUser();
        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);
        if(user!=null)
        {
            userID=user.getUid();
            username=user.getDisplayName();
           // Glide.with(this).load(account.getPhotoUrl()).circleCrop().into((ImageView) findViewById(R.id.profilePic));
        }
        reference= FirebaseDatabase.getInstance("https://instamedz-f5dcf-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Users");

/*
        /*UserProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new User_Frag());
            }
        });
*/


    }

   /* @Override
    public void onBackPressed() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Exit InstaMedz")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Home_Page.this.finishAffinity();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }*/
    /*@Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Exit InstaMedz")
                    .setMessage("Are you sure you want to exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Home_Page.this.finishAffinity();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        } else {
            getSupportFragmentManager().popBackStack();
        }

    }*/


    @Override
    public void onClick(View view) {

    }



    @Override
    public boolean onOptionsItemsSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
        
    }

    public void Chatbot(View view) {
        Intent Chatbot=new Intent(Home_Page.this, Eyecarebot.class);
        startActivity(Chatbot);
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.Home_FrameLayout, fragment)
                .commit();
    }
    private void ShareWebsite()
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "www.instamedz.in \n InstaMedz: One app for all your medical needs!");
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent, "Share our app with:");
        startActivity(shareIntent);
    }
}






