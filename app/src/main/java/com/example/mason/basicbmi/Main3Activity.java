package com.example.mason.basicbmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity{

    private static final String Tag = "MainActivity3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {






        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button btn = findViewById(R.id.bck);
        RecyclerView mRecyclerView;
        RecyclerView.LayoutManager mLayoutManager;
        RecyclerView.Adapter mAdapter;
        ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MainAdapter(myList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);








        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bckActivity();
            }
        });



    }

    public void bckActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
