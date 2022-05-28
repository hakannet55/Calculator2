package com.app.calculator;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonNext = findViewById(R.id.nextPageBTN);
        Button delBtn = findViewById(R.id.delBtn);
        EditText input = this.getTextInputObj();

        this.numberListeners();
        this.calculateBtn();

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = input.getText().toString();
                input.setText(Utils.removeLastChar(val));
            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setContentView(R.layout.activity_main2);
                Intent act = new Intent(getApplicationContext(), Page2Activity.class);
                startActivity(act);
                Log.i(TAG, "onClick:x ");
            }
        });
    }

    public EditText getTextInputObj() {
        return findViewById(R.id.inputDigitID);
    }

    private void calculateBtn() {
        Button submitBtn = findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double result = 0.0;
                EditText input = findViewById(R.id.inputDigitID);
                String valRawText = input.getText().toString();
                String[] parts;
                if (valRawText.contains("+")) {
                    parts = valRawText.split("\\+");
                    result = Double.valueOf(parts[0]) + Double.valueOf(parts[1]);
                }
                if (valRawText.contains("-")) {
                    parts = valRawText.split("-");
                    result = Double.valueOf(parts[0]) - Double.valueOf(parts[1]);
                }
                if (valRawText.contains("x")) {
                    parts = valRawText.split("x");
                    result = Double.valueOf(parts[0]) * Double.valueOf(parts[1]);
                }
                Log.i(TAG, "onClick: " + result);
                String resVal = String.valueOf(result);
                if (resVal.contains(".")) {
                    Log.i(TAG, "onClick:1 " + resVal);
                    parts = resVal.split("\\.");
                    if (Integer.parseInt(parts[1]) == 0) {
                        Log.i(TAG, "onClick:11: " + parts[0]);
                        Log.i(TAG, "onClick: 42:" + parts[1]);
                        Log.i(TAG, "onClick: Integer.parseInt(parts[1])" + Integer.parseInt(parts[1]));
                        resVal = parts[0];
                    }
                }
                Log.i(TAG, "onClick:2 " + resVal);
                Log.i(TAG, "onClick: xcvcv" + result);
                input.setText(resVal);
            }
        });
    }

    void numberListeners() {
        EditText input = findViewById(R.id.inputDigitID);
        Arrays.asList(
                R.id.bt1, R.id.bt2,
                R.id.bt3, R.id.bt4,
                R.id.bt5, R.id.bt6,
                R.id.bt7, R.id.bt8,
                R.id.bt9, R.id.bt0,
                R.id.btnEksi, R.id.btn_art,
                R.id.btnX).forEach(item -> {
            Button btnTmp = findViewById(item);
            btnTmp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button btn = (Button) view;
                    String inputText = input.getText().toString();
                    input.setText(inputText + btn.getText());

                    Log.i(TAG, "onClickkkkk: " + btn.getText());
                }
            });
        });
    }

}