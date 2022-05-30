package com.example.instamedz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instamedz.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class SignUP extends AppCompatActivity implements View.OnClickListener {
    private TextView registerUser;
    private EditText editTextName, editTextEmail, editTextPassword;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;
    private TextView LogIn_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        registerUser = (Button) findViewById(R.id.sign_up_button);
        registerUser.setOnClickListener(this);

        editTextName = (EditText) findViewById(R.id.sign_up_username);
        editTextEmail = (EditText) findViewById(R.id.SignUP_email);
        editTextPassword = (EditText) findViewById(R.id.SignUP_password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_text:
                startActivity(new Intent(SignUP.this, LoginActivity.class));
                break;
            case R.id.sign_up_button:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String fullName = editTextName.getText().toString().trim();

        if (fullName.isEmpty()) {
            editTextName.setError("Name is required!");
            editTextName.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            editTextEmail.setError("Name is required!");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please provide valid email!");
            editTextEmail.requestFocus();
            return;
        }
        if(password.length()<6){
            editTextPassword.setError("Min password length should be 6 characters!");
            editTextPassword.requestFocus();
            return;
        }
    }
}