package com.example.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Declare the stuff
    Button btn_Roll;

    TextView tv_RollNumber;

    ImageView iv_Dice, ivDice2;

    public int RollDice(ImageView iv_unit){
        Random r = new Random();
        int theRoll;
        // random number between 1-6
        theRoll = r.nextInt(6)+1;
        switch (theRoll){
            case 1: {
                iv_unit.setImageResource(R.drawable.dice1);

                break;
            }
            case 2: {
                iv_unit.setImageResource(R.drawable.dice2);

                break;
            }
            case 3: {
                iv_unit.setImageResource(R.drawable.dice3);

                break;
            }
            case 4: {
                iv_unit.setImageResource(R.drawable.dice4);

                break;
            }
            case 5: {
                iv_unit.setImageResource(R.drawable.dice5);

                break;
            }
            case 6: {
                iv_unit.setImageResource(R.drawable.dice6);

                break;
            }
        }
        return theRoll;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set the stuff
        btn_Roll = findViewById(R.id.btn_Roll);

        tv_RollNumber = findViewById(R.id.tv_RollCount);

        iv_Dice = findViewById(R.id.iv_Dice);
        ivDice2 = findViewById(R.id.iv_Dice2);


        btn_Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Dice1 = RollDice(iv_Dice);
                int Dice2 = RollDice(ivDice2);

                tv_RollNumber.setText("You rolled a " + (Dice1+Dice2));

            }
        });
    }
}
