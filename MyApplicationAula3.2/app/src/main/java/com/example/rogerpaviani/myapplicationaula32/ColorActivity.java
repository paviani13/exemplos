package com.example.rogerpaviani.myapplicationaula32;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        Intent intent = getIntent();
        String color = intent.getStringExtra("MINHA_COR");

        LinearLayout linear = (LinearLayout) findViewById(R.id.activity_color);
        linear.setBackgroundColor(Color.parseColor(color));
    }
}
