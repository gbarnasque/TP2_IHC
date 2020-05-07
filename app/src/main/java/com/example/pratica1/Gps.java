package com.example.pratica1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Gps extends AppCompatActivity {

    TextView lat;
    TextView lon;

    Button gpsBtn;

    GpsTracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        lat = findViewById(R.id.latitude);
        lon = findViewById(R.id.longitude);

        ActivityCompat.requestPermissions(Gps.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 123);

        gpsBtn = findViewById(R.id.btn_buscarLatLong);

        tracker = new GpsTracker(getApplicationContext());

        gpsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location l = tracker.getLocation();
                if(l != null){
                    lat.setText("Latitude: " + l.getLatitude() + " graus");
                    lon.setText("Longitude: "+ l.getLongitude() + " graus");
                }
                else{
                    lat.setText("Latitude: -");
                    lon.setText("Longitude: -");
                    Toast.makeText(getApplicationContext(), "Não foi possível buscar a latitude e longitude.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
