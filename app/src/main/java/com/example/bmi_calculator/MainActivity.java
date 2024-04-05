package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioButton rbtn1, rbtn2;
    EditText t1, t2, t3;
    Button btn;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbtn1 = findViewById(R.id.rbtnmale);
        rbtn2 = findViewById(R.id.rbtnfemale);
        t1 = findViewById(R.id.agetxt);
        t2 = findViewById(R.id.heighttxt);
        t3 = findViewById(R.id.weighttxt);
        btn = findViewById(R.id.btncal);
        text1 = findViewById(R.id.bmi1);
        text2 = findViewById(R.id.bmiresult);

        btn.setOnClickListener(view -> calculateBMI());

    }

    private void calculateBMI() {
        String age = t1.getText().toString();
        String height = t2.getText().toString();
        String weight = t3.getText().toString();

        int age1 = Integer.parseInt(age);
        double height1 = Double.parseDouble(height) / 100; // Convert height to meters
        double weight1 = Double.parseDouble(weight);

        double bmi = weight1 / (height1 * height1);

        // Display BMI value
        text1.setText("Your BMI is :" + String.format("%.2f", bmi));

        if (bmi <= 18.5)
        {
            text2.setText("Underweight");
        }
        else if (18.5 <= 25)
        {
            text2.setText("Normal weight");
        }
        else if (25 <= 30)
        {
            text2.setText("Overweight");
        }
        else if (30 <= 35)
        {
            text2.setText("Obese");
        }
        else
        {
            text2.setText(" Morbid obesity");
        }
    }
}