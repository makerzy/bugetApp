package com.example.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class SavingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving);
        setTitle("Saving Towards a Goal");
        Intent intent = getIntent();
        String savingType = intent.getStringExtra("savingType");


        String[] savingGoals = { "Buy a House\n", "Buy a new Car\n", "Buy a new iPhone\n"};

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,savingGoals);
        ListView listView = (ListView) findViewById(R.id.goals);
        listView.setAdapter(adapter);

        if(savingType.equals("")){

        }else if(savingType.equals("")){

        }else {

        }

    }
}