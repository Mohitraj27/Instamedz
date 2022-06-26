package com.example.instamedz.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.instamedz.databinding.OtpSendBinding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class otp_send extends AppCompatActivity {
private OtpSendBinding binding;
private FirebaseAuth mAuth;
private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=OtpSendBinding.inflate(getLayoutInflater());
        mAuth = FirebaseAuth.getInstance();
        setContentView(binding.getRoot());
        FirebaseApp.initializeApp(/*context=*/ this);
        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
        firebaseAppCheck.installAppCheckProviderFactory(
                SafetyNetAppCheckProviderFactory.getInstance());

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.etPhone.getText().toString().trim().isEmpty()){
                    Toast.makeText(otp_send.this,"Invalid Phone Number",Toast.LENGTH_SHORT).show();

                } else if(binding.etPhone.getText().toString().trim().length() !=10){
                    Toast.makeText(otp_send.this,"Invalid Phone Number",Toast.LENGTH_SHORT).show();

                }else{
                        otpSend();
                }
            }
        });
    }

    private void otpSend() {
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.btnSend.setVisibility(View.INVISIBLE);
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                binding.progressBar.setVisibility(View.GONE);
                binding.btnSend.setVisibility(View.GONE);
                Toast.makeText(otp_send.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                binding.progressBar.setVisibility(View.GONE);
                binding.btnSend.setVisibility(View.GONE);
                Toast.makeText(otp_send.this,"OTP Successfully sent",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(otp_send.this,otp_verify.class);
                intent.putExtra("phone",binding.etPhone.getText().toString().trim());
                intent.putExtra("verificationId",verificationId);
                startActivity(intent);
            }
        };
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+binding.etPhone.getText().toString().trim())      // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}