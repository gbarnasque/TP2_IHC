package com.example.pratica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Gyroscope extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;

    TextView coordinateX;
    TextView coordinateY;
    TextView coordinateZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        coordinateX = findViewById(R.id.sensorX_g);
        coordinateY = findViewById(R.id.sensorY_g);
        coordinateZ = findViewById(R.id.sensorZ_g);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType()== Sensor.TYPE_GYROSCOPE) {
            coordinateX.setText("X: " + event.values[0]);
            coordinateY.setText("Y: " + event.values[1]);
            coordinateZ.setText("Z: " + event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
