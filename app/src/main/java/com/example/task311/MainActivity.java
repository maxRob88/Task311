package com.example.task311;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CalculatorModel calculator;

    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int[] numbId = new int[]{
                R.id.btn_one,
                R.id.btn_two,
                R.id.btn_three,
                R.id.btn_four,
                R.id.btn_five,
                R.id.btn_six,
                R.id.btn_seven,
                R.id.btn_eight,
                R.id.btn_nine,
                R.id.btn_zero
        };

        int[] actionId = new int[]{
                R.id.btnPlus,
                R.id.btnMinus,
                R.id.btnMultip,
                R.id.btn_division,
                R.id.btn_equally
        };

        text = findViewById(R.id.textViewNumb);

        calculator = new CalculatorModel();

        View.OnClickListener numbBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPresses(view.getId());
                text.setText(calculator.getText());
            }
        };



        View.OnClickListener actionBtnOnCliclListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                text.setText(calculator.getText());

            }
        };

        for(int i = 0; i < numbId.length; i++){
            findViewById(numbId[i]).setOnClickListener(numbBtnClickListener);
        }

        for (int i = 0; i < actionId.length; i++){
            findViewById(actionId[i]).setOnClickListener(actionBtnOnCliclListener);
        }


    }




}
