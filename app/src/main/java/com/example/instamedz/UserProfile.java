package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;
    private Button logout;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        final TextView nameTextView = (TextView) findViewById(R.id.userName);
        final TextView emailTextView=(TextView) findViewById(R.id.userEmail);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("229501187991-uaj4m0o1fohia7lh6omkm0h6tc6jgnic.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(this);
        if(account!=null){
            String Name=account.getDisplayName();

            String Mail=account.getEmail();
            nameTextView.setText(Name);
            emailTextView.setText(Mail);
            Glide.with(this).load(account.getPhotoUrl()).circleCrop().into((ImageView) findViewById(R.id.Userpic));
        }
        logout=(Button) findViewById(R.id.logoutButton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserProfile.this, MainActivity.class));
            }
        });

        user=FirebaseAuth.getInstance().getCurrentUser();

        reference= FirebaseDatabase.getInstance("https://instamedz-f5dcf-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Users");
        userID=user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile =snapshot.getValue(User.class);
                if(userProfile !=null){
                    String name=user.getDisplayName();
                    String email= user.getEmail();
                    findViewById(R.id.Userpic).setVisibility(View.INVISIBLE);
                    nameTextView.setText(name);
                    emailTextView.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserProfile.this,"Something wrong happened!",Toast.LENGTH_LONG).show();
            }
        });
    }
}