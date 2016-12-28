package com.example.rogerpaviani.myapplication33;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        Intent intent = getIntent();
        String bgColor = intent.getStringExtra("MINHA_COR");
        if (!bgColor.startsWith("#"))
        {
            bgColor = "#" + bgColor;
        }

        int color;
        try {
            color = Color.parseColor(bgColor);
        } catch (IllegalArgumentException iae) {
            color = Color.WHITE;
        }

        LinearLayout linear = (LinearLayout) findViewById(R.id.activity_color);
        linear.setBackgroundColor(color);
    }

    public void clickVoltar(View view) {
        finish();
    }
}
