package com.example.mason.basicbmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.AddBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumber);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumber);
                TextView resultTextView = (TextView) findViewById(R.id.resultsView);

                double  num1 = Integer.parseInt(firstNumEditText.getText().toString());
                double  num2 = Integer.parseInt(secondNumEditText.getText().toString());
                double  bmiResult = num1/Math.pow(num2, 2) * 703;
                bmiResult = Math.round(bmiResult*10.0)/10.;
                resultTextView.setText(bmiResult +"");
            }
        });
    }
}
