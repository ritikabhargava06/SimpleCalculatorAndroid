package com.example.simplecalculatorassignment1ritika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
    Button bHistory;
    TextView resultView;
    TextView historyView;
    Calculator cal = new Calculator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    bHistory = findViewById(R.id.buttonadvance);

    resultView = findViewById(R.id.resultTextView);
    historyView = findViewById(R.id.historyTextView);
    historyView.setText(((MyApp)getApplication()).calculationHistory);
    historyView.setVisibility(View.INVISIBLE);

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
    bHistory.setOnClickListener(this);
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
                String input = (String) resultView.getText();
                if (cal.push(input)){
                    int finalRes = cal.calculate();
                    if (cal.divisorIsZero){
                        Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_LONG).show();
                        resultView.setText("");
                    }else{
                        resultView.setText(String.valueOf(finalRes));
                        if (((MyApp)getApplication()).calculationHistory.equals("")){
                            ((MyApp)getApplication()).calculationHistory = input+"="+finalRes;
                        }else{
                            ((MyApp)getApplication()).calculationHistory = ((MyApp)getApplication()).calculationHistory+"\n"+input+"="+finalRes;
                        }
                        historyView.setText(((MyApp)getApplication()).calculationHistory);
                    }
                }else{
                    Toast.makeText(this, "Please enter a valid input", Toast.LENGTH_LONG).show();
                    resultView.setText("");
                }
            }else{
                Toast.makeText(this,"Please provide an input", Toast.LENGTH_SHORT).show();
            }
        }else if (v.getId()==R.id.buttonadvance){
            if (bHistory.getText().equals("ADVANCE - WITH HISTORY")){
                bHistory.setText(R.string.standard_button_text);
                historyView.setVisibility(View.VISIBLE);
            }else {
                bHistory.setText(R.string.history_button_text);
                historyView.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void setResultView(Button pressedButton){
        String resultText = (String) resultView.getText();
        String newResult = resultText+pressedButton.getText();
        resultView.setText(newResult);
    }
}