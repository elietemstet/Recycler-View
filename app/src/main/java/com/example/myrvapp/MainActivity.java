package com.example.myrvapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<DataModel> dataset;
    private LinearLayoutManager layoutManager;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleViewCon);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dataset = new ArrayList<DataModel>();

        for ( int i=0 ; i<MyDATA.nameArray.length ; i++){

            dataset.add(new DataModel( MyDATA.nameArray[i],MyDATA.versionArray[i],
                    MyDATA.id_[i],MyDATA.drawableArray[i]));
        }

        adapter = new CustomAdapter(dataset);
        recyclerView.setAdapter(adapter);

    }
}