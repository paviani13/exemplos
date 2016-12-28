package com.example.rogerpaviani.meuapp61broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by roger.paviani on 14/12/2016.
 */

public class CustomBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("CustomBroadcast", "onReceive");
    }
}
