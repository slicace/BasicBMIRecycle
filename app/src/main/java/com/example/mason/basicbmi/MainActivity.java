package com.example.mason.basicbmi;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
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
    Button nxtBtn = findViewById(R.id.nextBtn);
    FloatingActionButton addBtn =  findViewById(R.id.fab);
    final ImageView imageView = findViewById(R.id.circleresult);


    addBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        EditText firstNumEditText =  findViewById(R.id.numWeight);
        EditText secondNumEditText =  findViewById(R.id.numHeight);
        TextView resultTextView =  findViewById(R.id.resultsView);
        final Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        final String time = "" + format.format(calendar.getTime());
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        double num1 = Double.parseDouble(firstNumEditText.getText().toString());
        double num2 = Double.parseDouble(secondNumEditText.getText().toString());
        double bmiResult = num1 / Math.pow(num2, 2) * 703;

        bmiResult = Math.round(bmiResult * 10.0) / 10.;
        resultTextView.setText(bmiResult + " ");
        switch (number[0] += 1) {
        }
        mTimesnResults.add("#" + number[0] + " BMI: " + bmiResult + " Time: " + time + " Date: " + currentDate);



        if (bmiResult < 18.5)
        {
         imageView.setImageResource(R.drawable.underweight);
        }
        else if (bmiResult < 25 && bmiResult > 18.5)
        {
          imageView.setImageResource(R.drawable.normal);
        }
        else if (bmiResult > 25 && bmiResult < 30 )
        {
          imageView.setImageResource(R.drawable.overweight);
        }
        else
        {
          imageView.setImageResource(R.drawable.obese);
        }








      }
    });

    nxtBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        openActivity();
      }
    });
  }

  public void openActivity() {
    Intent intent = new Intent(this, Main3Activity.class);
    intent.putExtra("mylist", mTimesnResults);
    startActivity(intent);
  }
}
