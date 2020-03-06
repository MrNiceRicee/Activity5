package com.example.romannumeralconverrt;



public class NumberConverter {

    public String toRoman(int numberInput){
        //return a string value of the numeral
        String output="";
        if (numberInput < 0 || numberInput > 10000){
            output = "";
        }

        while (numberInput>=1000){
            output += "M";
            numberInput -= 1000;
        }
        while (numberInput >= 900){
            output+="CM";
            numberInput -= 900;
        }
        while (numberInput >= 500){
            output+="D";
            numberInput -= 500;
        }
        while (numberInput >= 400){
            output+="CD";
            numberInput -= 400;
        }
        while (numberInput >= 100){
            output+="C";
            numberInput -= 100;
        }
        while (numberInput >= 90){
            output+="XC";
            numberInput -= 90;
        }
        while (numberInput >= 50){
            output+="L";
            numberInput -= 50;
        }
        while (numberInput >= 40){
            output+="XL";
            numberInput -= 40;
        }
        while (numberInput >= 10){
            output+="X";
            numberInput -= 10;
        }
        while (numberInput >= 9){
            output+="IX";
            numberInput -= 9;
        }
        while (numberInput >= 5){
            output+="V";
            numberInput -= 5;
        }
        while (numberInput >= 4){
            output+="IV";
            numberInput -= 4;
        }
        while (numberInput >= 1){
            output+="I";
            numberInput -= 1;
        }

        return output;
    }

    public int toNumber(String numberalString){
        //return an interger of the number
        int output=0;
        numberalString = numberalString.toUpperCase();      //makes everything upper case
        for (int i = 0; i < numberalString.length(); i++) {
            int stringindex = romanValue(numberalString.charAt(i));     //find the amount at the current location
            if (i+1<numberalString.length()){           //check if we can go the next char,
                int nextstring = romanValue(numberalString.charAt(i+1));

                if (stringindex>=nextstring){       //check if current char is greater than the next one
                                                    //since it's greater, we just add
                    output+=stringindex;
                }else{
                                                    //since the current char is less than
                    output = output + nextstring - stringindex;     //we add the small number, then add the greater one
                    i++;                            //plus go through the iteration twice, since we "used" two chars
                }

            }else {                                     //if the char is the last digit, we just add
                output+=stringindex;
            }
        }

        return output;
    }

    public int romanValue(char a){
        if (a=='I'){
            return 1;
        }else if (a=='V'){
            return 5;
        }else if (a=='X'){
            return 10;
        }else if (a=='L'){
            return 50;
        }else if (a=='C'){
            return 100;
        }else if (a=='D'){
            return 500;
        }else if (a=='M'){
            return 1000;
        }
        return 0;
    }

}
