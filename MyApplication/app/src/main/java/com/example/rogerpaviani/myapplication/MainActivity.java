package com.example.rogerpaviani.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edShow;
    private TextView txtResult;
    private Button number0;
    private Button number1;
    private Button number2;
    private Button number3;
    private Button number4;
    private Button number5;
    private Button number6;
    private Button number7;
    private Button number8;
    private Button number9;
    private Integer int1;

    private Integer operation;
    private static final Integer ADD = 1;
    private static final Integer MINUS = 2;
    private static final Integer MULT = 3;
    private static final Integer DIVIDE = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int1 = 0;
        edShow = (EditText) findViewById(R.id.ed_show);
        txtResult = (TextView) findViewById(R.id.txt_result);
        number0 = (Button) findViewById(R.id.btn_number_0);
        number1 = (Button) findViewById(R.id.btn_number_1);
        number2 = (Button) findViewById(R.id.btn_number_2);
        number3 = (Button) findViewById(R.id.btn_number_3);
        number4 = (Button) findViewById(R.id.btn_number_4);
        number5 = (Button) findViewById(R.id.btn_number_5);
        number6 = (Button) findViewById(R.id.btn_number_6);
        number7 = (Button) findViewById(R.id.btn_number_7);
        number8 = (Button) findViewById(R.id.btn_number_8);
        number9 = (Button) findViewById(R.id.btn_number_9);

        number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edShow.getText().toString().trim();
                edShow.setText(text + "0");
            }
        });

        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edShow.getText().toString().trim();
                edShow.setText(text + "1");
            }
        });

        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edShow.getText().toString().trim();
                edShow.setText(text + "2");
            }
        });

        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edShow.getText().toString().trim();
                edShow.setText(text + "3");
            }
        });

        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edShow.getText().toString().trim();
                edShow.setText(text + "4");
            }
        });

        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edShow.getText().toString().trim();
                edShow.setText(text + "5");
            }
        });

        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edShow.getText().toString().trim();
                edShow.setText(text + "6");
            }
        });

        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edShow.getText().toString().trim();
                edShow.setText(text + "7");
            }
        });

        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edShow.getText().toString().trim();
                edShow.setText(text + "8");
            }
        });

        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edShow.getText().toString().trim();
                edShow.setText(text + "9");
            }
        });
    }

    public void onClickLimpar(View view) {
        int1 = 0;
        edShow.setText("");
        txtResult.setText("");
    }

    public void onClickAdd(View view) {
        int1 = int1 + ;
        txtResult.setText(int1.toString()+ "+");
        operation = ADD;
    }

    private Integer executeLastOperation(){
        Integer currValue = Integer.parseInt(edShow.getText().toString());
        switch (operation)
        {
            case ADD:
                return int1 + currValue;
            case MINUS:
                return int1 - currValue;
            case DIVIDE:
                return int1 / currValue;
            case MULT:
                return int1 * currValue;
        }
    }
}
