package com.example.pratica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ChangeViewToCalculator(View view){
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }

    public void ChangeViewToAccelerometer(View view){
        Intent intent = new Intent(this, Accelerometer.class);
        startActivity(intent);
    }

    public void ChangeViewToLuminosity(View view){
        Intent intent = new Intent(this, Luminosity.class);
        startActivity(intent);
    }

    public void ChangeViewToGyroscope(View view){
        Intent intent = new Intent(this, Gyroscope.class);
        startActivity(intent);
    }

    public void ChangeViewToGps(View view){
        Intent intent = new Intent(this, Gps.class);
        startActivity(intent);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessage.class);
        EditText textToSend = (EditText) findViewById(R.id.text);
        String message = textToSend.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
