package com.example.rogerpaviani.meuapp61broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by roger.paviani on 14/12/2016.
 */

public class InternetChange extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (isOnline(context)) {
            Log.d("InternetChange", "onReceive HABEMUS INTERNET");
        } else {
            Log.d("InternetChange", "onReceive NONONONO INTERNET");
        }
    }

    private boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }
}
