package com.example.rogerpaviani.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("robson", "oncreate");

        botao = (Button) findViewById(R.id.btn1);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText texto = (EditText) findViewById(R.id.text1);
                String textoDigitado = texto.getText().toString();
                Toast.makeText(MainActivity.this, "Olá!!!! " + textoDigitado, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("robson", "onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("robson", "onresume");
    }

    public void clickButton(View view) {
        Toast.makeText(this, "oi", Toast.LENGTH_SHORT).show();
    }
}
