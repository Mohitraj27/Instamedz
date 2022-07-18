package com.example.instamedz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instamedz.ui.login.ui.Eye_Exercise;

import java.util.Locale;

public class Eyecare_ex4 extends  Home_Page {
    TextView textView;
    long START_TIME_IN_MILLIS=60000;
    Button startButton;
    CountDownTimer mCountDownTimer;
    boolean mTimerRunning=false;
    long mTimeLeftInMillis=START_TIME_IN_MILLIS;
Button Cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_eyecare_ex4, null, false);
        drawerLayout.addView(contentView, 0);
        fab.hide();
        alreadyExecuted = true;
        ToastAlreadyExecuted = true;
        textView = findViewById(R.id.text_View);




        Cancel_btn=findViewById(R.id.Cancel_Button);
        Cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Eyecare_ex4.this, Eye_Exercise.class);
                startActivity(intent);
            }
        });

        startButton = findViewById(R.id.StartButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });
    }
    void startTimer()
    {
        mCountDownTimer= new CountDownTimer(mTimeLeftInMillis,1000){

            @Override
            public void onTick(long l) {
                mTimeLeftInMillis=l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning=false;
                startButton.setText("Start");
                Toast.makeText(getApplicationContext(),"Good job! Click next to go to the next exercise",Toast.LENGTH_LONG).show();
            }
        }.start();
        mTimerRunning=true;
        startButton.setText("Pause");
    }
    void pauseTimer()
    {
        mCountDownTimer.cancel();
        mTimerRunning=false;
        startButton.setText("Resume");
    }
    void updateCountDownText(){
        int seconds=(int)(mTimeLeftInMillis/1000)%60;
        String timeLeftFormatted=String.format(Locale.getDefault(),"%02d",seconds);
        textView.setText(timeLeftFormatted);
    }

    public void EyeCareEx5(View view) {
        Intent Eyecareex=new Intent(Eyecare_ex4.this, Eyecare_ex5.class);
        startActivity(Eyecareex);
    }
    public void EyeCareEx3(View view) {
        Intent Eyecareex=new Intent(Eyecare_ex4.this, Eyecare_ex3.class);
        startActivity(Eyecareex);
    }
}