package com.example.instamedz;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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



      ImageView Whatsapp_icon_heart_care;
      ImageView Whatsapp_icon_health_care;
      ImageView Whatsapp_icon_eye_care;
      ImageView Whatsapp_icon_bussiness_care;
     ImageView Whatsapp_icon_Soul_care;
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
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_home_page);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        frameLayout=findViewById(R.id.framelayout);
        drawerLayout=findViewById(R.id.drawer_layout_home);
        navigationView=findViewById(R.id.nav_view);
        toggle=new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        replaceFragment(new Home_fragment());
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
                        replaceFragment(new Home_fragment()); fab.show(); break;
                    case R.id.User_item:
                        replaceFragment(new User_Frag());fab.hide(); break;
                    case R.id.dashboard_item:
                        Toast.makeText(Home_Page.this,"Dashboard is clicked",Toast.LENGTH_SHORT).show(); break;
                    case R.id.appointment_item:
                        replaceFragment(new Appoint_frag());fab.hide();break;
                    default:
                        return true;
                }
                return true;
            }
        });
        /*mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_profile)
                .setOpenableLayout(drawerLayout)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);*/
        user= FirebaseAuth.getInstance().getCurrentUser();
        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);
        if(user!=null)
        {
            userID=user.getUid();
            username=user.getDisplayName();
//            Glide.with(this).load(account.getPhotoUrl()).circleCrop().into((ImageView) findViewById(R.id.profilePic));
        }
        reference= FirebaseDatabase.getInstance("https://instamedz-f5dcf-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Users");
        Toast.makeText(this,"Welcome "+username,Toast.LENGTH_LONG).show();
        UserProfilePic=(ImageView) findViewById(R.id.profilePic);
        UserProfilePic.setOnClickListener(Home_Page.this);
       Whatsapp_icon_health_care=findViewById(R.id.whatsapp_icon_health_care);
        Whatsapp_icon_heart_care =findViewById(R.id.whatsapp_icon_heart_care);
        Whatsapp_icon_eye_care=findViewById(R.id.whatsapp_icon_eye_care);
        Whatsapp_icon_Soul_care=findViewById(R.id.whatsapp_icon_soul_care);
        Whatsapp_icon_bussiness_care=findViewById(R.id.whatsapp_icon_business_care);


       final String num= "+7415070882";
        final String text_heart_care ="I Just Clicked on Heart Care whatsapp icon";
        final String text_health_care="I Just Clicked on Health Care whatsapp icon";
        final String text_eye_care="I Just Clicked on Eye Care Whatsapp icon";
        final String text_soul_care="I Just Clicked on Soul Care Whatsapp icon";
       final String text_bussines_care="I Just Clicked on Bussiness Care Whatsapp icon";
       /* toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
                    drawerLayout.closeDrawers();
                } else {
                    drawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });*/
        UserProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new User_Frag());
            }
        });
        Whatsapp_icon_Soul_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean installed=isAppInstalled("com.whatsapp");
                if (installed)
                {
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+num+"&text="+text_soul_care));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Home_Page.this,"Whatsapp is not installed!",Toast.LENGTH_SHORT);
                }

            }

            private boolean isAppInstalled(String s) {
                PackageManager packageManager=getPackageManager();
                boolean is_installed;
                try {
                    packageManager.getPackageInfo(s,PackageManager.GET_ACTIVITIES);
                    is_installed=true;
                } catch (PackageManager.NameNotFoundException e) {
                    is_installed=false;
                    e.printStackTrace();
                }
                return  is_installed;
            }
        });



        Whatsapp_icon_bussiness_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean installed=isAppInstalled("com.whatsapp");
                if (installed)
                {
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+num+"&text="+text_bussines_care));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Home_Page.this,"Whatsapp is not installed!",Toast.LENGTH_SHORT);
                }

            }

            private boolean isAppInstalled(String s) {



                PackageManager packageManager=getPackageManager();
                boolean is_installed;
                try {
                    packageManager.getPackageInfo(s,PackageManager.GET_ACTIVITIES);
                    is_installed=true;
                } catch (PackageManager.NameNotFoundException e) {
                    is_installed=false;
                    e.printStackTrace();
                }
                return  is_installed;
            }




        });

        Whatsapp_icon_eye_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean installed=isAppInstalled("com.whatsapp");
                if (installed)
                {
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+num+"&text="+text_eye_care));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Home_Page.this,"Whatsapp is not installed!",Toast.LENGTH_SHORT);
                }


            }

            private boolean isAppInstalled(String s) {
                PackageManager packageManager=getPackageManager();
                boolean is_installed;
                try {
                    packageManager.getPackageInfo(s,PackageManager.GET_ACTIVITIES);
                    is_installed=true;
                } catch (PackageManager.NameNotFoundException e) {
                    is_installed=false;
                    e.printStackTrace();
                }
                return  is_installed;
            }

        });





        Whatsapp_icon_health_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean installed=isAppInstalled("com.whatsapp");
                if (installed)
                {
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+num+"&text="+text_health_care));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Home_Page.this,"Whatsapp is not installed!",Toast.LENGTH_SHORT);
                }
            }

            private boolean isAppInstalled(String s) {

                PackageManager packageManager=getPackageManager();
                boolean is_installed;
                try {
                    packageManager.getPackageInfo(s,PackageManager.GET_ACTIVITIES);
                    is_installed=true;
                } catch (PackageManager.NameNotFoundException e) {
                    is_installed=false;
                    e.printStackTrace();
                }
                return  is_installed;
            }

        });


                 Whatsapp_icon_heart_care.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean installed=isAppInstalled("com.whatsapp");
                          if (installed)
                          {
                              Intent intent=new Intent(Intent.ACTION_VIEW);
                              intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+num+"&text="+text_heart_care));
                              startActivity(intent);
                          }
                          else
                          {
                              Toast.makeText(Home_Page.this,"Whatsapp is not installed!",Toast.LENGTH_SHORT);
                          }
                    }

                    private boolean isAppInstalled(String s) {
                        PackageManager packageManager=getPackageManager();
                        boolean is_installed;
                        try {
                            packageManager.getPackageInfo(s,PackageManager.GET_ACTIVITIES);
                            is_installed=true;
                        } catch (PackageManager.NameNotFoundException e) {
                            is_installed=false;
                            e.printStackTrace();
                        }
                        return  is_installed;
                    }
                });


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

    /*@Override
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
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }
}






