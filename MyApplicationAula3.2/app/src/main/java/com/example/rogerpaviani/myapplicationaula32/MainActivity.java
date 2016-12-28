package com.example.rogerpaviani.myapplicationaula32;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnred;
    private Button btngreen;
    private Button btnblue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnred = (Button) findViewById(R.id.btn_red);
        btngreen = (Button) findViewById(R.id.btn_green);
        btnblue = (Button) findViewById(R.id.btn_blue);

        btnred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorActivity.class);
                intent.putExtra("MINHA_COR", "#FF0000");

                startActivity(intent);
            }
        });
        btngreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorActivity.class);
                intent.putExtra("MINHA_COR", "#00FF00");

                startActivity(intent);
            }
        });
        btnblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorActivity.class);
                intent.putExtra("MINHA_COR", "#0000FF");

                startActivity(intent);
            }
        });
    }
}
