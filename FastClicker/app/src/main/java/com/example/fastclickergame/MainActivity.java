package com.example.fastclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaration
    Button btn_Start, btn_Click, btn_Click2;
    TextView tv_TimeLeft, tv_ClickCounter, tv_HighScore;

    int numberOfClicks = 0;

    int SecondsTimer = 5;
    int SecondsLeft = 0;

    int HighScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set them up
        btn_Start = findViewById(R.id.btn_start);
        btn_Click = findViewById(R.id.btn_Clicker);
        btn_Click2 = findViewById(R.id.btn_Clicker2);

        tv_TimeLeft = findViewById(R.id.tv_timeLeft);
        tv_ClickCounter = findViewById(R.id.tv_clicks);
        tv_HighScore = findViewById(R.id.tv_highscore);

        btn_Click.setEnabled(false);

        final CountDownTimer timer = new CountDownTimer(SecondsTimer*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                SecondsLeft--;
                tv_TimeLeft.setText("Time Left: "+ SecondsLeft);
            }

            @Override
            public void onFinish() {
                btn_Click.setSaveEnabled(false);
                tv_TimeLeft.setText("Times Up");
                tv_ClickCounter.setText("Clicks Done: " + numberOfClicks);
                if (numberOfClicks > HighScore){
                    HighScore = numberOfClicks;
                    tv_HighScore.setText("New Highscore: "+HighScore);
                }else {
                    tv_HighScore.setText("Current Highscore: "+ HighScore);

                }
                SecondsLeft = 0;
            }
        };


        btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondsLeft = SecondsTimer;
                numberOfClicks = 0;
                btn_Click.setEnabled(true);
                timer.start();
            }
        });

        btn_Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SecondsLeft > 0){
                    numberOfClicks++;
                    tv_ClickCounter.setText("Number of Clicks: "+numberOfClicks);
                    btn_Click2.setEnabled(true);
                    btn_Click.setEnabled(false);
                }
            }
        });

        btn_Click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SecondsLeft > 0){
                    numberOfClicks++;
                    tv_ClickCounter.setText("Number of Clicks: "+numberOfClicks);
                    btn_Click.setEnabled(true);
                    btn_Click2.setEnabled(false);
                }
            }
        });

    }
}
