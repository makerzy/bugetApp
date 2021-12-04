package com.example.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        ArrayList<String> savingGoals = new ArrayList<String>();

        savingGoals.add( "Buy a House\nSaved:                    $2,000");
        savingGoals.add("Buy a new Car\nSaved:                    $4,000");
        savingGoals.add("Buy a new iPhone\nSaved:                    $200");


        editor.putString("key1", "$100,000.00");
        editor.putString("key2", "$40,000.00");
        editor.putString("key3", "$900.00");
        editor.commit();

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
                    int position = savingGoals.size();
                    editor.putString("key"+position,  String.valueOf(maxValue));
                    Log.d("Goal desc", goalDesc);
                    Log.d("Goal value", String.valueOf(maxValue));
                    String newGoal = goalDesc + "\n" + "Saved:             $0.00";
                    adapter.add(newGoal);
                    adapter.notifyDataSetChanged();
                    editor.commit();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                Log.d("item clicked: ", selectedItem);
                Intent savingIntent = new Intent(Goals.this, SavingDetails.class);
                savingIntent.putExtra("position", position); //Optional parameters
                Goals.this.startActivity(savingIntent);
            }
        });


    }
}