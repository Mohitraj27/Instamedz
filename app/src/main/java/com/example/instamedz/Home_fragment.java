package com.example.instamedz;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.instamedz.chatBot.ChatBot;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home_fragment extends Fragment implements View.OnClickListener {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    ImageView Whatsapp_icon_heart_care;
    ImageView Whatsapp_icon_health_care;
    ImageView Whatsapp_icon_eye_care;
    ImageView Whatsapp_icon_bussiness_care;
    ImageView Whatsapp_icon_Soul_care;
    ImageView UserProfilePic;
    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FrameLayout frameLayout;
    ImageView onCLick_menu_bar;
    ImageView Eye_Care;
    ImageView Health_Care;
    ImageView Heart_care;
    ImageView Soul_care;
    ImageView Business_care;
    private FirebaseUser user, currentUser;
    private DatabaseReference reference;
    private String userID, username = "Guest";
    private ActionBarDrawerToggle toggle;


    public Home_fragment() {
        // Required empty public constructor
    }


    public static Home_fragment newInstance(String param1, String param2) {
        Home_fragment fragment = new Home_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_fragment, container, false);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        frameLayout = v.findViewById(R.id.framelayout);
        user = FirebaseAuth.getInstance().getCurrentUser();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());
        if (user != null) {
            userID = user.getUid();
            username = user.getDisplayName();
//            Glide.with(this).load(account.getPhotoUrl()).circleCrop().into((ImageView) findViewById(R.id.profilePic));
        }
        reference = FirebaseDatabase.getInstance("https://instamedz-f5dcf-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Users");
        Whatsapp_icon_health_care = v.findViewById(R.id.whatsapp_icon_health_care);
        Whatsapp_icon_heart_care = v.findViewById(R.id.whatsapp_icon_heart_care);
        Whatsapp_icon_eye_care = v.findViewById(R.id.whatsapp_icon_eye_care);
        Whatsapp_icon_Soul_care = v.findViewById(R.id.whatsapp_icon_soul_care);
        Whatsapp_icon_bussiness_care = v.findViewById(R.id.whatsapp_icon_business_care);


        final String num = "+7415070882";
        final String text_heart_care = "I Just Clicked on Heart Care whatsapp icon";
        final String text_health_care = "I Just Clicked on Health Care whatsapp icon";
        final String text_eye_care = "I Just Clicked on Eye Care Whatsapp icon";
        final String text_soul_care = "I Just Clicked on Soul Care Whatsapp icon";
        final String text_bussines_care = "I Just Clicked on Bussiness Care Whatsapp icon";

        Whatsapp_icon_Soul_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean installed = isAppInstalled("com.whatsapp");
                if (installed) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + num + "&text=" + text_soul_care));
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "Whatsapp is not installed!", Toast.LENGTH_SHORT);
                }

            }

            private boolean isAppInstalled(String s) {
                PackageManager packageManager = getActivity().getPackageManager();
                boolean is_installed;
                try {
                    packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
                    is_installed = true;
                } catch (PackageManager.NameNotFoundException e) {
                    is_installed = false;
                    e.printStackTrace();
                }
                return is_installed;
            }
        });


        Whatsapp_icon_bussiness_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean installed = isAppInstalled("com.whatsapp");
                if (installed) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + num + "&text=" + text_bussines_care));
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "Whatsapp is not installed!", Toast.LENGTH_SHORT);
                }

            }

            private boolean isAppInstalled(String s) {


                PackageManager packageManager = getActivity().getPackageManager();
                boolean is_installed;
                try {
                    packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
                    is_installed = true;
                } catch (PackageManager.NameNotFoundException e) {
                    is_installed = false;
                    e.printStackTrace();
                }
                return is_installed;
            }


        });

        Whatsapp_icon_eye_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean installed = isAppInstalled("com.whatsapp");
                if (installed) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + num + "&text=" + text_eye_care));
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "Whatsapp is not installed!", Toast.LENGTH_SHORT);
                }


            }

            private boolean isAppInstalled(String s) {
                PackageManager packageManager = getActivity().getPackageManager();
                boolean is_installed;
                try {
                    packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
                    is_installed = true;
                } catch (PackageManager.NameNotFoundException e) {
                    is_installed = false;
                    e.printStackTrace();
                }
                return is_installed;
            }

        });


        Whatsapp_icon_health_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean installed = isAppInstalled("com.whatsapp");
                if (installed) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + num + "&text=" + text_health_care));
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "Whatsapp is not installed!", Toast.LENGTH_SHORT);
                }
            }

            private boolean isAppInstalled(String s) {

                PackageManager packageManager = getActivity().getPackageManager();
                boolean is_installed;
                try {
                    packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
                    is_installed = true;
                } catch (PackageManager.NameNotFoundException e) {
                    is_installed = false;
                    e.printStackTrace();
                }
                return is_installed;
            }

        });


        Whatsapp_icon_heart_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean installed = isAppInstalled("com.whatsapp");
                if (installed) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + num + "&text=" + text_heart_care));
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "Whatsapp is not installed!", Toast.LENGTH_SHORT);
                }
            }

            private boolean isAppInstalled(String s) {
                PackageManager packageManager = getActivity().getPackageManager();
                boolean is_installed;
                try {
                    packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
                    is_installed = true;
                } catch (PackageManager.NameNotFoundException e) {
                    is_installed = false;
                    e.printStackTrace();
                }
                return is_installed;
            }
        });


        Eye_Care = v.findViewById(R.id.Eye_Care);
        Eye_Care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Eye_Care_Intent = new Intent(getActivity().getApplicationContext(), Eye_Care.class);
                getActivity().startActivity(Eye_Care_Intent);
            }
        });
        Health_Care = v.findViewById(R.id.health_care);
        Health_Care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Health_Care_Intent = new Intent(getActivity().getApplicationContext(), Health_Care.class);
                getActivity().startActivity(Health_Care_Intent);
            }
        });

        Heart_care = v.findViewById(R.id.heart_care);
        Heart_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Heart_Care_intent = new Intent(getActivity().getApplicationContext(), Heart_Care.class);
                getActivity().startActivity(Heart_Care_intent);
            }
        });

        Soul_care = v.findViewById(R.id.soul_care);
        Soul_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Soul_care_Intent = new Intent(getActivity().getApplicationContext(), Soul_care.class);
                getActivity().startActivity(Soul_care_Intent);
            }
        });

        Business_care = v.findViewById(R.id.bussiness_care);
        Business_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Bussiness_care = new Intent(getActivity().getApplicationContext(), com.example.instamedz.Bussiness_care.class);
                getActivity().startActivity(Bussiness_care);
            }
        });
        return v;
    }


    public void onClick(View view) {

    }


    public boolean onOptionsItemsSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void Chatbot(View view) {
        Intent Chatbot = new Intent(getActivity().getApplicationContext(), ChatBot.class);
        getActivity().startActivity(Chatbot);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }



    }


