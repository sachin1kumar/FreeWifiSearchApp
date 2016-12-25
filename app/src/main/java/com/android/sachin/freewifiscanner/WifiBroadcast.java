package com.android.sachin.freewifiscanner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

/**
 * Created by sachin on 25/12/16.
 */

public class WifiBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if(wifi.isWifiEnabled()) {
            //Toast.makeText(context, "Enabled", Toast.LENGTH_SHORT).show();
            context.startService(new Intent(context,FreeWifiService.class));
        }else
            Toast.makeText(context,"Disabled",Toast.LENGTH_SHORT).show();
    }
}
