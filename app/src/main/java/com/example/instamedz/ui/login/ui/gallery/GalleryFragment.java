/*
package com.example.instamedz.ui.login.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.instamedz.MainActivity;
import com.example.instamedz.R;
import com.example.instamedz.User;
import com.example.instamedz.UserProfile;
import com.example.instamedz.databinding.FragmentHomeBinding;
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
//Gallery_Fragement is Dashboard section of the page of Navigation

public class GalleryFragment extends Fragment {
    private FirebaseUser user;
    private DatabaseReference reference;
    private FragmentHomeBinding binding;
    private String userID;
    private Button logout;
    private GoogleSignInClient mGoogleSignInClient;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GalleryFragment() {
        // Required empty public constructor
    }

    */
/**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dashfrag.
     *//*

    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = getView();
        final TextView nameTextView = (TextView) v.findViewById(R.id.userName);
        final TextView emailTextView = (TextView) v.findViewById(R.id.userEmail);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("229501187991-uaj4m0o1fohia7lh6omkm0h6tc6jgnic.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            String Name = account.getDisplayName();

            String Mail = account.getEmail();
            nameTextView.setText(Name);
            emailTextView.setText(Mail);
            Glide.with(this).load(account.getPhotoUrl()).circleCrop().into((ImageView) findViewById(R.id.Userpic));
        }
        logout = (Button) findViewById(R.id.logoutButton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserProfile.this, MainActivity.class));
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();

        reference = FirebaseDatabase.getInstance("https://instamedz-f5dcf-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Users");
        userID = user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if (userProfile != null) {
                    String name = user.getDisplayName();
                    String email = user.getEmail();
                    findViewById(R.id.Userpic).setVisibility(View.INVISIBLE);
                    nameTextView.setText(name);
                    emailTextView.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserProfile.this, "Something wrong happened!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);

        View v = getView();
        final TextView nameTextView = (TextView) v.findViewById(R.id.userName);
        final TextView emailTextView = (TextView) v.findViewById(R.id.userEmail);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("229501187991-uaj4m0o1fohia7lh6omkm0h6tc6jgnic.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            String Name = account.getDisplayName();

            String Mail = account.getEmail();
            nameTextView.setText(Name);
            emailTextView.setText(Mail);
            Glide.with(this).load(account.getPhotoUrl()).circleCrop().into((ImageView) findViewById(R.id.Userpic));
        }
        logout = (Button) findViewById(R.id.logoutButton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserProfile.this, MainActivity.class));
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();

        reference = FirebaseDatabase.getInstance("https://instamedz-f5dcf-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Users");
        userID = user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if (userProfile != null) {
                    String name = user.getDisplayName();
                    String email = user.getEmail();
                    findViewById(R.id.Userpic).setVisibility(View.INVISIBLE);
                    nameTextView.setText(name);
                    emailTextView.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserProfile.this, "Something wrong happened!", Toast.LENGTH_LONG).show();
            }
        });
    }
}*/
