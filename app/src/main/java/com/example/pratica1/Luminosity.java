package com.example.pratica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class Luminosity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;

    TextView luminosityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luminosity);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        luminosityText = findViewById(R.id.luminosityText);

        if(sensor != null){
            sensorManager.registerListener(Luminosity.this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else{
            luminosityText.setText("Sensor não suportado.");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if(sensor.getType() == Sensor.TYPE_LIGHT){
            luminosityText.setText("Intensidade da luz: " + event.values[0] + " lx");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
