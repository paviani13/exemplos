package com.example.android.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.graphics.Color.GREEN;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView =  new TextView(this);

        textView.setText("Olar");
        textView.setTextColor(Color.GREEN);
        textView.setTextSize(18);
        setContentView(R.layout.activity_main);
    }
}
