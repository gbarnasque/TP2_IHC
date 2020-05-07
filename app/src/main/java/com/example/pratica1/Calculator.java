package com.example.pratica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    TextView op_1;
    TextView op_2;

    Button sum;
    Button sub;
    Button mult;
    Button divide;

    TextView resultCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        op_1 = findViewById(R.id.num_1);
        op_2 = findViewById(R.id.num_2);

        sum = findViewById(R.id.btn_sum);
        sum.setOnClickListener(myListener);

        sub = findViewById(R.id.btn_sub);
        sub.setOnClickListener(myListener);

        mult = findViewById(R.id.btn_mult);
        mult.setOnClickListener(myListener);

        divide = findViewById(R.id.btn_divide);
        divide.setOnClickListener(myListener);

        resultCalculator = findViewById(R.id.resCalculator);
    }

    public void Executesum(){
        try{
            setResult(getOp1() + getOp2());
        }
        catch (Exception e){

        }
    }
    public void Executesub(){
        try{
            setResult(getOp1() - getOp2());
        }
        catch (Exception e){

        }
    }
    public void Executemult(){
        try{
            setResult(getOp1() * getOp2());
        }
        catch (Exception e){

        }
    }
    public void Executedivision(){
        try{
            setResult(getOp1() / getOp2());
        }
        catch (Exception e){

        }
    }

    public float getOp1(){
        return Float.parseFloat(op_1.getText().toString());
    }
    public float getOp2(){
        return Float.parseFloat(op_2.getText().toString());
    }

    public void setResult(float result) {
        resultCalculator.setText(String.format("Resultado: %s", result));
    }

    private View.OnClickListener myListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_sum:
                    Log.wtf("aqui", "tests");
                    Executesum();
                    break;
                case R.id.btn_sub:
                    Executesub();
                    break;
                case R.id.btn_mult:
                    Executemult();
                    break;
                case R.id.btn_divide:
                    Executedivision();
                    break;
            }
        }
    };
}
