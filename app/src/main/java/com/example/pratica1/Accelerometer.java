package com.example.pratica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    TextView coordinateX;
    TextView coordinateY;
    TextView coordinateZ;

    boolean firstIteraction;
    float oldXValue;
    float oldYValue;
    float oldZValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        coordinateX = findViewById(R.id.sensorX);
        coordinateY = findViewById(R.id.sensorY);
        coordinateZ = findViewById(R.id.sensorZ);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        firstIteraction = true;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            if(firstIteraction){
                oldXValue = event.values[0];
                oldYValue = event.values[0];
                oldZValue = event.values[0];
                firstIteraction = false;
            }
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];

            if(Math.abs(oldXValue - sensorX) > 15.0 || Math.abs(oldYValue - sensorY)  > 15.0 ||  Math.abs(oldZValue - sensorZ) > 15.0){
                Intent intent = new Intent(this, AccelerometerMessage.class);
                startActivity(intent);
            }

            coordinateX.setText("X: "+ sensorX);
            coordinateY.setText("Y: "+ sensorY);
            coordinateZ.setText("Z: "+ sensorZ);

            oldXValue = sensorX;
            oldYValue = sensorY;
            oldZValue = sensorZ;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        firstIteraction = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
