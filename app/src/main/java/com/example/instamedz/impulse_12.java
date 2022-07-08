package com.example.instamedz;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class impulse_12 extends AppCompatActivity {
    ImageView impulse_12_book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impulse_12);


        //Whatsapp for booking free demo of impulse 12

        impulse_12_book = findViewById(R.id.impulse_12_demo_book);
        final String num = "+917415070882";
        final String text_to_me = "Book My free demo now, for Impulse 12.";


        impulse_12_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean installed = isAppInstalled("com.whatsapp");
                if (installed) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + num + "&text=" + text_to_me));
                    startActivity(intent);
                } else {
                    Toast.makeText(impulse_12.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT);
                }

            }

            private boolean isAppInstalled(String s) {
                PackageManager packageManager = getPackageManager();
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

    }
}