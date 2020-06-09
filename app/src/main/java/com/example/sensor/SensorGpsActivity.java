package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class SensorGpsActivity extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_gps);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1, this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.removeUpdates(this);
    }

    @SuppressLint({"DefaultLocale", "SimpleDateFormat"})
    @Override
    public void onLocationChanged(Location location) {
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText(String.format("%.5f", location.getLatitude()));

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(String.format("%.5f", location.getLongitude()));

        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText(String.format("%.5f", location.getAltitude()));

        TextView textView4 = findViewById(R.id.textView4);
        textView4.setText(String.format("%.5f", location.getAccuracy()));

        TextView textView5 = findViewById(R.id.textView5);
        textView5.setText(String.format("%.5f", location.getBearing()));

        TextView textView6 = findViewById(R.id.textView6);
        textView6.setText(String.format("%.5f", location.getSpeed()));

        TextView textView7 = findViewById(R.id.textView7);
        textView7.setText(new SimpleDateFormat("HH:mm:ss").format(location.getTime()));

        TextView textView8 = findViewById(R.id.textView8);
        textView8.setText(location.getProvider());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // Nothing to do.
    }

    @Override
    public void onProviderEnabled(String provider) {
        // Nothing to do.
    }

    @Override
    public void onProviderDisabled(String provider) {
        // Nothing to do.
    }
}
