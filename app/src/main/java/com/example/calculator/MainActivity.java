package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int firstValue, secondValue,resultOp;
    private String operation;
    private Button clearBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.calc_title_tv);
        clearBtn = findViewById(R.id.clear_btn);
        clearBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                textView.setText("");
                return true;
            }
        });
    }

    public void onNumberClick(View view){
        switch (view.getId()){
            case R.id.nine_btn:
                textView.append("9");
                break;
                case R.id.eight_btn:
                textView.append("8");
                break;
                case R.id.seven_btn:
                textView.append("7");
                break;
                case R.id.six_btn:
                textView.append("6");
                break;
                case R.id.five_btn:
                textView.append("5");
                break;
                case R.id.four_btn:
                textView.append("4");
                break;
                case R.id.three_btn:
                textView.append("3");
                break;
                case R.id.two_btn:
                textView.append("2");
                break;
                case R.id.one_btn:
                textView.append("1");
                break;
                case R.id.zero_btn:
                textView.append("0");
                break;

        }
    }

    public void onActionClick(View view){
        switch (view.getId()){
            case R.id.clear_btn:
                textView.setText(textView.getText().toString().substring(0,textView.getText().toString().length() - 1));
                break;
            case R.id.plus_btn:
                firstValue = Integer.valueOf(textView.getText().toString());
                textView.setText(firstValue + "+");
                operation = "+";
                break;
            case R.id.equal_btn:
                if(operation!=null){
                    String two = textView.getText().toString().replace(String.valueOf(firstValue) + operation, "");
                    secondValue = Integer.parseInt(two);
                    switch (operation){
                        case "+":
                            plus();
                            break;
                    }
                }
                break;


        }
    }

    private void plus() {
        resultOp = firstValue + secondValue;
        textView.setText(firstValue + "+" + secondValue + "=" + resultOp);

    }


}