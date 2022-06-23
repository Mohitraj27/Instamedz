package com.example.instamedz.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.instamedz.ForgotPassword;
import com.example.instamedz.Home_Page;
import com.example.instamedz.R;
import com.example.instamedz.SignUP;
import com.example.instamedz.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;
    private TextView forgotPass;
    private TextView signup;
    private EditText editTextEmail, editTextPassword;
    private Button login;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
//BY gunal
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_login);

        signup=(TextView)findViewById(R.id.sign_UP_text);
        signup.setOnClickListener(this);

        login=(Button) findViewById(R.id.login);
        login.setOnClickListener(this);

        editTextEmail=(EditText) findViewById(R.id.username);
        editTextPassword=(EditText)findViewById(R.id.password);
        progressBar=(ProgressBar)findViewById(R.id.progressBarlogin);

        mAuth = FirebaseAuth.getInstance();
        forgotPass=(TextView) findViewById(R.id.forget_pass);
        forgotPass.setOnClickListener(this);
    }
//BY Gunal
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_UP_text:
                startActivity(new Intent(this, SignUP.class));
                break;
            case R.id.login:
                userLogin();
                break;
            case R.id.forget_pass:
                startActivity(new Intent(this, ForgotPassword.class));
                break;
        }
    }

    private void userLogin() {
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();

        if(email.isEmpty()){
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a valid email!");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            editTextPassword.setError("Min password length is 6 characters!");
            editTextPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                    if(user.isEmailVerified()) {
                        startActivity(new Intent(LoginActivity.this, Home_Page.class));
                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(LoginActivity.this,"Check your email to verify your account!",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this,"Failed to Login! Please check credentials",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}