package com.app.calculator;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Page2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button buttonNext = findViewById(R.id.btnGeriBack);
        Log.i(TAG, "onClick: aaa");

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Log.i(TAG, "onClick: ter");
                //setContentView(R.layout.activity_main);
                //Log.i(TAG, "onClick: 1");
            }
        });
    }

    @Override
    public void onBackPressed() {
        Log.i(TAG, "onClick: ter");
        super.onBackPressed();
        this.finish();
    }
}
