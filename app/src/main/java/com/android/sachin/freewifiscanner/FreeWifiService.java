package com.android.sachin.freewifiscanner;

import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.List;

/**
 * Created by sachin on 25/12/16.
 */

public class FreeWifiService extends Service {

    String networkSSID = "";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this,"Service Started",Toast.LENGTH_SHORT).show();

        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = "\"" + networkSSID + "\"";   // Please note the quotes. String should contain ssid in quotes

        WifiManager wifiManager = (WifiManager)this.getSystemService(this.WIFI_SERVICE);
        wifiManager.addNetwork(conf);

        List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
        for( WifiConfiguration i : list ) {
            if(i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
               /* wifiManager.disconnect();
                wifiManager.enableNetwork(i.networkId, true);
                wifiManager.reconnect();*/
                Toast.makeText(this,"Avi Connected",Toast.LENGTH_SHORT).show();
                break;
            }
        }

       /* if(conf.SSID=="AviNetgear")
            Toast.makeText(this,"Avi Connected",Toast.LENGTH_SHORT).show();*/

        return super.onStartCommand(intent, flags, startId);
    }
}
