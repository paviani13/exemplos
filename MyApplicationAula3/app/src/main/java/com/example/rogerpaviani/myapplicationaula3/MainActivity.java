package com.example.rogerpaviani.myapplicationaula3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text1;
    private int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cont = 1;
        text1 = (TextView) findViewById(R.id.text_1);
        String strHello = getResources().getString(R.string.hello_world);
        text1.setText(strHello + " !!!");

        ImageView img1 = (ImageView) findViewById(R.id.img_1);
        Drawable photo = getResources().getDrawable(R.drawable.foto);

        img1.setImageDrawable(photo);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cont *= 2;
                text1.setBackgroundColor(0xaaaa + cont);
                Log.d("new color", String.valueOf(cont));
            }
        });

        Log.d("aula3", "oncreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("aula3", "onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("aula3", "onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("aula3", "onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("aula3", "onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("aula3", "ondestroy");
    }
}