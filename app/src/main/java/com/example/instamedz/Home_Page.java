package com.example.instamedz;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class Home_Page extends AppCompatActivity {
      ImageView Whatsapp_icon_heart_care;
      ImageView Whatsapp_icon_health_care;
      ImageView Whatsapp_icon_eye_care;
      ImageView Whatsapp_icon_bussiness_care;
     ImageView Whatsapp_icon_Soul_care;

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

       Whatsapp_icon_health_care=findViewById(R.id.whatsapp_icon_health_care);
        Whatsapp_icon_heart_care =findViewById(R.id.whatsapp_icon_heart_care);
        Whatsapp_icon_eye_care=findViewById(R.id.whatsapp_icon_eye_care);
        Whatsapp_icon_Soul_care=findViewById(R.id.whatsapp_icon_soul_care);
        Whatsapp_icon_bussiness_care=findViewById(R.id.whatsapp_icon_business_care);


       final  String num= "+7415070882";
        final        String text_heart_care ="I Just Clicked on Heart Care whatsapp icon";
        final String text_health_care="I Just Clicked on Health Care whatsapp icon";
        final String text_eye_care="I Just Clicked on Eye Care Whatsapp icon";
        final String text_soul_care="I Just Clicked on Soul Care Whatsapp icon";
       final String text_bussines_care="I Just Clicked on Bussiness Care Whatsapp icon";


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



}
