package com.example.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

public class Goals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        setTitle("Saving Towards a Goal");
        Intent intent = getIntent();
        String savingType = intent.getStringExtra("savingType");
        final  Button createGoal = (Button) findViewById(R.id.create);
        final EditText goal = (EditText) findViewById(R.id.goalDesc);
        final EditText goalValue = (EditText) findViewById(R.id.goalValue);




        String[] savingGoals = { "Buy a House\nSaved:                    $2,000", "Buy a new Car\nSaved:                    $4,000", "Buy a new iPhone\nSaved:                    $200"};

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,savingGoals);
        ListView listView = (ListView) findViewById(R.id.goals);
        listView.setAdapter(adapter);

        createGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!goal.getText().toString().trim().isEmpty() && !goalValue.getText().toString().isEmpty()){

                    String goalDesc =goal.getText().toString().trim();
                    double  maxValue = Double.parseDouble(goalValue.getText().toString());
                    Log.d("Goal desc", goalDesc);
                    Log.d("Goal value", String.valueOf(maxValue));

                }
            }
        });




    }
}