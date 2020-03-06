package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_Rock, btn_Paper, btn_Scissors;

    TextView tv_Score;

    ImageView iv_ComputerChoice, iv_HumanChoice;

    int HumanScore = 0, ComputerScore = 0;

    private String playTurn(String humanChoice){
        String comp_choice = "";
        Random rando = new Random();


        //choice 1-3
        int comp_choice_num = rando.nextInt(3)+1;
        if (comp_choice_num==1){
            comp_choice = "rock";
        }else if (comp_choice_num==2){
            comp_choice = "paper";
        }else if (comp_choice_num==3){
            comp_choice = "scissors";
        }

        if (comp_choice=="rock"){
            iv_ComputerChoice.setImageResource(R.drawable.rock);
        }else if (comp_choice =="paper"){
            iv_ComputerChoice.setImageResource(R.drawable.paper);
        }else if (comp_choice=="scissors"){
            iv_ComputerChoice.setImageResource(R.drawable.scissors);
        }


        //Calculate who won
        if (comp_choice == humanChoice){
            return "Draw. Nobody Won.";
        }
        else if (humanChoice == "rock" && comp_choice == "scissors"){
            HumanScore++;
            return "Rock crushes scissors. You Win!";
        }
        else if (humanChoice == "scissors" && comp_choice == "paper"){
            HumanScore++;
            return "Scissors cut paper. You Win!";
        }
        else if (humanChoice == "paper" && comp_choice == "rock"){
            HumanScore++;
            return "Paper covers rock. You Win!";
        }
        else if (comp_choice == "rock" && humanChoice == "scissors"){
            ComputerScore++;
            return "Rock crushes scissors. You Lose!";
        }
        else if (comp_choice == "scissors" && humanChoice == "paper"){
            ComputerScore++;
            return "Scissors cut paper. You Lose!";
        }
        else if (comp_choice == "paper" && humanChoice == "rock"){
            ComputerScore++;
            return "Paper covers rock. You Lose!";
        }
        else {
            return "Not Sure";
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Rock = findViewById(R.id.btn_Rock);
        btn_Paper = findViewById(R.id.btn_Paper);
        btn_Scissors = findViewById(R.id.btn_Scissors);

        tv_Score = findViewById(R.id.tv_ScoreTracker);

        iv_ComputerChoice = findViewById(R.id.iv_Computer);
        iv_HumanChoice = findViewById(R.id.iv_Human);

        btn_Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.rock);
                String message = playTurn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_Score.setText("Human: "+Integer.toString(HumanScore)+" || Computer: "+Integer.toString(ComputerScore));
            }
        });

        btn_Paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.paper);
                String message = playTurn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_Score.setText("Human: "+Integer.toString(HumanScore)+" || Computer: "+Integer.toString(ComputerScore));

            }
        });


        btn_Scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.scissors);
                String message = playTurn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_Score.setText("Human: "+Integer.toString(HumanScore)+" || Computer: "+Integer.toString(ComputerScore));

            }
        });



    }
}
