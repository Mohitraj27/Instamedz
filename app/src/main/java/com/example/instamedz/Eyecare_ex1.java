package com.example.instamedz;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Eyecare_ex1 extends Home_Page {
    TextView textView;
    long duration = TimeUnit.MINUTES.toMillis(1);
    long START_TIME_IN_MILLIS=60000;
    Button startButton;
    Boolean TimerStarted;
    CountDownTimer mCountDownTimer;
    boolean mTimerRunning;
    long mTimeLeftInMillis=START_TIME_IN_MILLIS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_eyecare_ex1, null, false);
        drawerLayout.addView(contentView, 0);
        fab.hide();
        alreadyExecuted = true;
        ToastAlreadyExecuted = true;
        textView = findViewById(R.id.text_View);
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
                    Toast.makeText(getApplicationContext(),"Excercise Complete",Toast.LENGTH_LONG).show();
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
}