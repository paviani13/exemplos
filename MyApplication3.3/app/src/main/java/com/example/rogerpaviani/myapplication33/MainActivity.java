package com.example.rogerpaviani.myapplication33;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        color = (EditText) findViewById(R.id.txt_color);
    }

    public void clickShowColor(View view) {
        Intent intent = new Intent(MainActivity.this, ColorActivity.class);
        intent.putExtra("MINHA_COR", color.getText().toString());

        startActivity(intent);
    }
}
