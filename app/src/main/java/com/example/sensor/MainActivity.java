package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        adapter.add(getString(R.string.sensor1));
        adapter.add(getString(R.string.sensor2));
        adapter.add(getString(R.string.sensor3));
        adapter.add(getString(R.string.sensor7));

        ListView lv = findViewById(R.id.listview);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SensorPressureActivity.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SensorLightActivity.class);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SensorAnglesActivity.class);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SensorGpsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
