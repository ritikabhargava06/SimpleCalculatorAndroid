package com.example.simplecalculatorassignment1ritika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b0;
    Button bplus;
    Button bminus;
    Button bmultiply;
    Button bdivide;
    Button bequals;
    Button bclear;
    TextView resultView;
    Calculator cal = new Calculator();
    boolean firstNum = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int bid=R.id.button1;
    b1 = findViewById(R.id.button1);
    b2 = findViewById(R.id.button2);
    b3 = findViewById(R.id.button3);
    b4 = findViewById(R.id.button4);
    b5 = findViewById(R.id.button5);
    b6 = findViewById(R.id.button6);
    b7 = findViewById(R.id.button7);
    b8 = findViewById(R.id.button8);
    b9 = findViewById(R.id.button9);
    b0 = findViewById(R.id.button0);
    bplus = findViewById(R.id.buttonplus);
    bminus = findViewById(R.id.buttonminus);
    bmultiply = findViewById(R.id.buttonmultiply);
    bdivide = findViewById(R.id.buttondivide);
    bequals = findViewById(R.id.buttonequals);
    bclear = findViewById(R.id.buttonclear);

    resultView = findViewById(R.id.resultTextView);
    b1.setOnClickListener(this);
    b2.setOnClickListener(this);
    b3.setOnClickListener(this);
    b4.setOnClickListener(this);
    b5.setOnClickListener(this);
    b6.setOnClickListener(this);
    b7.setOnClickListener(this);
    b8.setOnClickListener(this);
    b9.setOnClickListener(this);
    b0.setOnClickListener(this);
    bplus.setOnClickListener(this);
    bminus.setOnClickListener(this);
    bmultiply.setOnClickListener(this);
    bdivide.setOnClickListener(this);
    bequals.setOnClickListener(this);
    bclear.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button1){
            setResultView(b1);
        }else if (v.getId()==R.id.button2){
            setResultView(b2);
        }else if (v.getId()==R.id.button3){
            setResultView(b3);
        }else if (v.getId()==R.id.button4){
            setResultView(b4);
        }else if (v.getId()==R.id.button5){
            setResultView(b5);
        }else if (v.getId()==R.id.button6){
            setResultView(b6);
        }else if (v.getId()==R.id.button7){
            setResultView(b7);
        }else if (v.getId()==R.id.button8){
            setResultView(b8);
        }else if (v.getId()==R.id.button9){
            setResultView(b9);
        }else if (v.getId()==R.id.button0){
            setResultView(b0);
        }else if (v.getId()==R.id.buttonplus){
            setResultView(bplus);
        }else if (v.getId()==R.id.buttonminus){
            setResultView(bminus);
        }else if (v.getId()==R.id.buttonmultiply){
            setResultView(bmultiply);
        }else if (v.getId()==R.id.buttondivide){
            setResultView(bdivide);
        }else if (v.getId()==R.id.buttonclear){
            resultView.setText("");
        }else if (v.getId()==R.id.buttonequals){
            cal.divisorIsZero=false;
            if(resultView.getText()!=""){
                if (cal.push((String) resultView.getText())){
                    int finalRes = cal.calculate();
                    if (cal.divisorIsZero){
                        //alert user that cant divide by 0
                        Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_LONG).show();
                        Log.d("Error", "Cant divide by 0");
                    }else{
                        resultView.setText(String.valueOf(finalRes));
                        Log.d("final result", String.valueOf(finalRes));
                    }
                }else{
                    //alert user to enter valid input
                    Toast.makeText(this, "Please enter a valid input", Toast.LENGTH_LONG).show();
                }
            }else{
                //alert the user to enter input
                Toast.makeText(this,"Please provide an input", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void setResultView(Button pressedButton){
        String resultText = (String) resultView.getText();
        String newResult = resultText+pressedButton.getText();
        resultView.setText(newResult);
    }

}