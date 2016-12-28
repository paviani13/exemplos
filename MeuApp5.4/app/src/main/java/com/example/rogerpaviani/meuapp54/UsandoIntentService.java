package com.example.rogerpaviani.meuapp54;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by roger.paviani on 13/12/2016.
 */

public class UsandoIntentService extends IntentService {

    public UsandoIntentService(){
        super("UsandoIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int total = 150;
        int cont = 0;

        while(cont < total)
        {
            synchronized(this){
                try{
                    wait(1000);
                    Log.d("UsandoIntentService", cont + "");
                }
                catch (Exception e){
                    Log.e("UsandoIntentService", e.getMessage());
                }
                finally{
                    //
                }
            }
        }
    }
}
