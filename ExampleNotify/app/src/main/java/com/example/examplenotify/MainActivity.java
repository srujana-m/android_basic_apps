package com.example.examplenotify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {
      NotificationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        
    }

    public void notify(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                createNotification();
                startNotificaion();
            }
        },5000);
    }

    private void startNotificaion() {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this, "VIIT");
        builder.setContentTitle("Notify");
        builder.setContentText("this is notification for you");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        nm.notify(0,builder.build());
    }

    private void createNotification() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel nc=new NotificationChannel("VIIT","APSSDC",NotificationManager.IMPORTANCE_HIGH);
            nc.enableVibration(true);
            nc.setLightColor(Color.GRAY);
            nm.createNotificationChannel(nc);
        }
    }
}