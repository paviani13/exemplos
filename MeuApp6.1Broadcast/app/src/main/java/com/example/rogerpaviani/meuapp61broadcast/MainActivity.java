package com.example.rogerpaviani.meuapp61broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(new CustomBroadcast(), new IntentFilter("CACHORRO"));
    }

    public void onClickBroadcast(View view) {
        Intent intent = new Intent("CACHORRO");
        sendBroadcast(intent);
    }
}
