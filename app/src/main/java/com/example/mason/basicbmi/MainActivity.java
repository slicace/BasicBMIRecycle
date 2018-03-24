package com.example.mason.basicbmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> mTimesnResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int[] number = {0};
        mTimesnResults = new ArrayList<>();
        mTimesnResults.add("Test");
        Button nxtBtn = (Button) findViewById(R.id.nextBtn);
        Button addBtn = (Button) findViewById(R.id.AddBtn);



        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumber);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumber);
                TextView resultTextView = (TextView) findViewById(R.id.resultsView);
                final Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                final String time = "" + format.format(calendar.getTime());

                double  num1 = Double.parseDouble(firstNumEditText.getText().toString());
                double  num2 = Double.parseDouble(secondNumEditText.getText().toString());
                double  bmiResult = num1/Math.pow(num2, 2) * 703;

                bmiResult = Math.round(bmiResult*10.0)/10.;
                resultTextView.setText(bmiResult +" ");
                switch (number[0] += 1) {
                }
                mTimesnResults.add("#" + number[0] +"BMI: "+ bmiResult + " Time: " +time);
            }
        });

        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 openActivity();
            }
        });
    }

    public void openActivity(){
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("mylist", mTimesnResults);
        startActivity(intent);
    }
}
