package com.example.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_answer1, btn_answer2, btn_answer3, btn_answer4;

    TextView tv_timer, tv_equation, tv_points, tv_bottom;

    ProgressBar pro_timer;

    Boolean gameSTARTU = false;

    private static final String TAG = "MainActivity";

    Game g = new Game();

    int secondsRemaining = 30;
    int totalSeconds = 30;
    int endscreenSeconds = 5;

    CountDownTimer timer = new CountDownTimer(totalSeconds*1000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secondsRemaining--;
            tv_timer.setText(Integer.toString(secondsRemaining)+"sec");
            pro_timer.setMax(totalSeconds);
            pro_timer.setProgress(pro_timer.getMax()-secondsRemaining);
        }

        @Override
        public void onFinish() {
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            btn_answer4.setEnabled(false);
            tv_bottom.setText("Time is up! "+g.getNumberCorrect() +"/"+(g.getTotalQuestions()-1));
            pro_timer.setProgress(totalSeconds);
            final Handler myHandler = new Handler();

            myHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_start.setVisibility(View.VISIBLE);
                    gameSTARTU = false;
                }
            },endscreenSeconds*1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_start = findViewById(R.id.btn_Start);

        btn_answer1 = findViewById(R.id.btn_Answer1);
        btn_answer2 = findViewById(R.id.btn_Answer2);
        btn_answer3 = findViewById(R.id.btn_Answer3);
        btn_answer4 = findViewById(R.id.btn_Answer4);

        tv_timer = findViewById(R.id.tv_Timer);
        tv_equation = findViewById(R.id.tv_Equation);
        tv_points = findViewById(R.id.tv_Points);
        tv_bottom = findViewById(R.id.tv_Bottom);

        pro_timer = findViewById(R.id.prog_Timer);


        tv_timer.setText("0sec");
        tv_equation.setText("");
        tv_points.setText("0pts");
        tv_bottom.setText("");

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testtest(v);
            }
        });

        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);
        btn_answer4.setOnClickListener(answerButtonClickListener);


        Question hello = new Question(15);
    }

    View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v instanceof Button){
                final Button suspect = (Button) v;
                int answerSelected = Integer.parseInt(suspect.getText().toString());
                //Toast.makeText(MainActivity.this, "AnswerSelected = "+answerSelected, Toast.LENGTH_SHORT).show();

                g.checkAnswer(answerSelected);
                if (!g.checkAnswer(answerSelected)){

                }
                tv_points.setText(Integer.toString(g.getScore())+"pts");
                nextTurn();
            }
        }
    };

    public void nextTurn(){
        g.makeNewQuestion();
        int [] answers = g.getCurrentQuestion().getAnswerArray();

        //Set the buttons as one of the possible answers
        btn_answer1.setText(Integer.toString(answers[0]));
        btn_answer2.setText(Integer.toString(answers[1]));
        btn_answer3.setText(Integer.toString(answers[2]));
        btn_answer4.setText(Integer.toString(answers[3]));

        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);
        btn_answer4.setEnabled(true);

        tv_equation.setText(g.getCurrentQuestion().getQuestionPhrase());
        tv_bottom.setText(g.getNumberCorrect() + "/" + (g.getTotalQuestions()-1));
    }

    public void testtest(View view){
        if (view instanceof Button){
            Button x = (Button) view;
            if (x.getId() == R.id.btn_Start){
                if (!gameSTARTU){
                    gameSTARTU = true;
                    btn_start.setVisibility(View.INVISIBLE);
                    secondsRemaining = totalSeconds;
                    g = new Game();
                    nextTurn();
                    timer.start();
                }
            }
        }
    }


    public void startThread(View view){
        ExampleRunnable runnable = new ExampleRunnable(5);
        new Thread(runnable).start();

    }

    public void stopThread(View view){

    }


    //Thread;
    class ExampleThread extends Thread{

        int seconds;

        ExampleThread(int seconds){
            this.seconds = seconds;
        }

        @Override
        public void run(){
            for (int i = 0; i < seconds; i++) {
                Log.d(TAG, "startThread: "+i);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }


    //Runnable
    class ExampleRunnable implements Runnable {

        int seconds;

        ExampleRunnable(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            btn_start = findViewById(R.id.btn_Start);
            for (int i = 0; i < seconds; i++) {
                if (i == 2){
                    /*
                    Handler threadHandler = new Handler(Looper.getMainLooper());
                    threadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            int colorid = ((ColorDrawable)btn_start.getBackground()).getColor();
                            if (R.color.WrongAnswer == colorid){
                                Log.d(TAG, "run: samesame");
                            }
                            Log.d(TAG, "background " + btn_start.getBackground());
                            btn_start.setBackgroundResource(R.color.WrongAnswer);
                        }
                    });
                     */
                    /*
                    btn_start.post(new Runnable() {
                        @Override
                        public void run() {
                            btn_start.setBackgroundResource(R.color.WrongAnswer);
                        }
                    });
                     */
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            btn_start.setBackgroundResource(R.color.WrongAnswer);
                        }
                    });
                }

                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
