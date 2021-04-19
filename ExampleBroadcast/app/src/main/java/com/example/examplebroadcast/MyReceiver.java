package com.example.examplebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

public class MyReceiver extends BroadcastReceiver {
         ImageView iv;
    public MyReceiver(ImageView iv) {
        this.iv=iv;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction())
        {
            case Intent.ACTION_POWER_CONNECTED:
                iv.setImageResource(R.drawable.ic_baseline_battery_charging_full_24);
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                iv.setImageResource(R.drawable.ic_baseline_battery_alert_24);
                break;
        }

    }
}