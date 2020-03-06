package com.example.mathquiz;

import android.util.Log;

import java.io.Console;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Question {

    private int firstNumber;
    private int secondNumber;
    private int answer;


    // for possible choices for the user to pick from
    private int [] answerArray;

    //which of the four positions is correct;
    private int answerPosition;

    //Maximum value of first or second number
    private int upperLimit;

    //string output of the problem

    private String questionPhrase;

    public Question(int upperLimit){

        this.upperLimit = upperLimit;
        Random randomNumberMaker = new Random();

        this.firstNumber = randomNumberMaker.nextInt(upperLimit);
        this.secondNumber = randomNumberMaker.nextInt(upperLimit);
        this.answer = this.firstNumber+this.secondNumber;
        this.questionPhrase = this.firstNumber + " + " + this.secondNumber + " = ";

        this.answerPosition = randomNumberMaker.nextInt(4);
        this.answerArray = new int[] {0,1,2,3};


        //mechanic: get answer + (Make a Random number multiply that by a -1


        //far off answer
        this.answerArray[0] = (int) (randomNumberMaker.nextInt(upperLimit)-(answer*Math.pow(-1,3)));

        //close answers;
        int x1 = randomNumberMaker.nextInt(5)+1;
        int x2 = randomNumberMaker.nextInt(3)+1;
        int x3 = (int) Math.pow(-1,randomNumberMaker.nextInt(5)+1);

        this.answerArray[1] = answer + x1;
        this.answerArray[2] = answer + (x2*-1);
        this.answerArray[3] = answer + x3;

        Collections.shuffle(Arrays.asList(answerArray));
        if (Arrays.asList(answerArray).contains(answer)){
            int alreadyexist = Arrays.asList(answerArray).indexOf(answer);
            answerArray[alreadyexist] = answer;
        }else {
            answerArray[answerPosition] = answer;
        }
    }





    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}
