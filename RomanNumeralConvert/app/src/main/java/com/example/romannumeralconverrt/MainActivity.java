package com.example.romannumeralconverrt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //creating objects
    EditText ed_RomanInput, ed_NumberInput;
    Button btn_ConvertRoman, btn_ConvertNumber;
    TextView tv_NumberOut, tv_RomanOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Declare the objects
        ed_RomanInput =  findViewById(R.id.ed_RomanInput);
        ed_NumberInput = findViewById(R.id.ed_NumberInput);

        btn_ConvertRoman = findViewById(R.id.btn_ConvertRoman);
        btn_ConvertNumber = findViewById(R.id.btn_ConvertNumber);

        tv_NumberOut = findViewById(R.id.tv_NumberOut);
        tv_RomanOut = findViewById(R.id.tv_RomanOut);



        //Listeners
        btn_ConvertNumber.setOnClickListener(new View.OnClickListener() {           //Listener to convert Roman Numerals to number
            @Override
            public void onClick(View v) {
                NumberConverter numberConverter = new NumberConverter();    //create the convertion class
                String inputString = ed_RomanInput.getText().toString();
                String outputNumber = Integer.toString(numberConverter.toNumber(inputString));
                tv_NumberOut.setText(outputNumber);

            }
        });

        btn_ConvertRoman.setOnClickListener(new View.OnClickListener() {            //Listener to convert Number to Roman Numerals
            @Override
            public void onClick(View v) {
                //Converting a number to numeral
                NumberConverter numberConverter = new NumberConverter();
                int inputnumber = Integer.parseInt(ed_NumberInput.getText().toString());
                String outputRoman = numberConverter.toRoman(inputnumber);

                tv_RomanOut.setText(outputRoman);
            }
        });

    }
}
