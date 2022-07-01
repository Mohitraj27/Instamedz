package com.example.instamedz.ui.login;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link User_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class User_Frag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID,name, email;
    private Button logout;
    private GoogleSignInClient mGoogleSignInClient;
    private TextView nameTextView;
    private TextView emailTextView;

    public User_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment User_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static User_Frag newInstance(String param1, String param2) {
        User_Frag fragment = new User_Frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_user, container, false);
        nameTextView = (TextView) v.findViewById(R.id.userName);
        emailTextView = (TextView) v.findViewById(R.id.userEmail);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("229501187991-uaj4m0o1fohia7lh6omkm0h6tc6jgnic.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getActivity());
        logout = (Button) v.findViewById(R.id.logoutButton);
        user = FirebaseAuth.getInstance().getCurrentUser();
        if ((account != null)&&(user!=null)) {
            String Name = account.getDisplayName();

            String Mail = account.getEmail();
            nameTextView.setText(Name);
            emailTextView.setText(Mail);
            Glide.with(this).load(account.getPhotoUrl()).circleCrop().into((ImageView) v.findViewById(R.id.Userpic));

            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirebaseAuth.getInstance().signOut();
                    Intent myIntent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                    getActivity().startActivity(myIntent);
                }
            });



            reference = FirebaseDatabase.getInstance("https://instamedz-f5dcf-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Users");
            userID = user.getUid();

            reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User userProfile = snapshot.getValue(User.class);
                    if (userProfile != null) {
                        name = user.getDisplayName();
                        email = user.getEmail();
                        v.findViewById(R.id.Userpic).setVisibility(View.INVISIBLE);
                        nameTextView.setText(name);
                        emailTextView.setText(email);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getContext(), "Something wrong happened!", Toast.LENGTH_LONG).show();
                }
            });
        }
        else{
            name="Guest";
            email="Please sign in to register your email!";
            logout.setText("Log in");
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(getContext(), MainActivity.class));
                }
            });
            nameTextView.setText(name);
            emailTextView.setText(email);}

        return v;

    }
    }