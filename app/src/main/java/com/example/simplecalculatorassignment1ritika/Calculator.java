package com.example.simplecalculatorassignment1ritika;
import java.util.ArrayList;
public class Calculator {
    ArrayList<String> inputArrayList;
    boolean divisorIsZero=false;

    public boolean push(String userInput){
        boolean pushSuccessful = true;
        inputArrayList = new ArrayList<>();
        for (int i=0;i<userInput.length();i++) {
            inputArrayList.add(String.valueOf(userInput.charAt(i)));
        }
        if(!validate()){
            pushSuccessful=false;
        }
        return pushSuccessful;
    }

    public int calculate(){
        int result = 0;
        int num1;
        String operator;
        int num2;

        while (inputArrayList.size()>1){
            num1 = Integer.parseInt(inputArrayList.get(0));
            inputArrayList.remove(0);
            operator = inputArrayList.get(0);
            inputArrayList.remove(0);
            num2 = Integer.parseInt(inputArrayList.get(0));
            inputArrayList.remove(0);

            switch (operator){
                case "+": result = num1+num2; break;
                case "-": result = num1-num2; break;
                case "*": result = num1*num2; break;
                case "/":
                    if(num2==0) divisorIsZero = true;
                    else result = num1/num2;
                    break;
            }
            inputArrayList.add(0, String.valueOf(result));
        }
        return  result;
    }
    boolean validate(){
        boolean validInput = true;
        boolean lastElement = false;

        if(inputArrayList.size()>2&&inputArrayLengthIsOdd(inputArrayList.size())){
            for(int index=0;index<inputArrayList.size();){
                if(checkForOperator(inputArrayList.get(index))){
                    validInput=false;
                    break;
                }else{
                    if(lastElement){
                        break;
                    }
                    index++;
                    if(checkForOperator(inputArrayList.get(index))){
                        index++;
                        if (index==inputArrayList.size()-1) lastElement=true;
                    }else{
                        validInput=false;
                        break;
                    }
                }
            }
        }else validInput=false;
        return validInput;
    }

    private boolean inputArrayLengthIsOdd(int length) {
        return length % 2 != 0;
    }

    private boolean checkForOperator(String e){
        return e.equals("+") || e.equals("-") || e.equals("*") || e.equals("/");
    }
}
