package com.example.pratica1;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.List;

public class GpsTracker implements LocationListener {
    Context context;

    LocationManager lm;
    Location l;

    public GpsTracker(Context c){
        context = c;
        lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    public Location getLocation(){
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(context, "Permissão de localização não concedida!", Toast.LENGTH_LONG).show();
            return null;
        }

        List<String> providers = lm.getAllProviders();

        for (String provider : providers){
            if(updateLocationManager(provider)){
                Location l = lm.getLastKnownLocation(provider);
                if(l != null){
                    return l;
                }
            }
        }

        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public boolean updateLocationManager(String provider){

        if(lm.isProviderEnabled(provider)) {
            lm.requestLocationUpdates(provider, 6000, 10, this);
            return true;
        }

        Toast.makeText(context, "Por gentileza, ative o GPS.", Toast.LENGTH_LONG).show();
        return false;
    }
}
