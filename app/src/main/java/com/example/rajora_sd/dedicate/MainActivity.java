package com.example.rajora_sd.dedicate;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import me.itangqi.waveloadingview.WaveLoadingView;

public class MainActivity extends AppCompatActivity {

    MyCountDownTimer myCountDownTimer;

    WaveLoadingView waveLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waveLoadingView = (WaveLoadingView) findViewById(R.id.waveLoadingView);
        waveLoadingView.setProgressValue(0);
        waveLoadingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer = new MyCountDownTimer(7200000, 1000);
                myCountDownTimer.start();
            }
        });
    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            int progress = (int) (millisUntilFinished/1000);
            int seconds = (int) (millisUntilFinished / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            waveLoadingView.setCenterTitleSize(64);
            waveLoadingView.setCenterTitle(String.format("%02d", minutes)
                    + ":" + String.format("%02d", seconds));

            waveLoadingView.setProgressValue((7200-progress)/100);
            Toast.makeText(MainActivity.this," "+((7200-progress)/100), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFinish() {
            finish();
            myCountDownTimer.cancel();
        }
    }

    @Override
    public void onBackPressed() {

    }
}