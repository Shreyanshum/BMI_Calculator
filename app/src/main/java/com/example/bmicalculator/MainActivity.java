package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView2;

    private TextView textView4;
    private EditText weight;
    private EditText height;
    private static final DecimalFormat df = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);
        textView4 = findViewById(R.id.textView4);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ht = height.getText().toString();
                String wt = weight.getText().toString();
                double height1 = Double.parseDouble(ht);
                double weight1 = Double.parseDouble(wt);
                double bmi = weight1 / Math.pow((height1 / 100), 2);
                textView2.setText("Your BMI is " + df.format(bmi));
                if (bmi < 18.5) {
                    textView4.setText("You are underweight");
                } else if (bmi >= 18.5 && bmi < 25) {
                    textView4.setText("You are under a healthy range");
                } else if (bmi >= 25 && bmi < 30) {
                    textView4.setText("You are overweight");
                } else {
                    textView4.setText("You are obese");
                }

            }
        });
    }
}