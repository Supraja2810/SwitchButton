package com.example.switchbutton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    SwitchCompat switchCompat;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchCompat = findViewById(R.id.switchButton);
        imageView = findViewById(R.id.iv);

      imageView.setImageResource(R.drawable.ic_wifi);


        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCompat.isChecked())
                {
                    imageView.setImageResource(R.drawable.ic_wifib);
                    WifiManager wifiManager = (WifiManager)getApplicationContext()
                            .getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(true);
                }
                else
                {
                    imageView.setImageResource(R.drawable.ic_wifi);
                    WifiManager wifiManager = (WifiManager)getApplicationContext()
                            .getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(false);
                }
            }
        });


    }
}
