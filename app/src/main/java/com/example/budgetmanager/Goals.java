package com.example.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Goals extends AppCompatActivity {
    GoalObject house = new GoalObject("Buy a House", 100000);
    GoalObject car = new GoalObject("Buy a new Car", 40000);
    GoalObject phone = new GoalObject("Buy a new iPhone", 9000);
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    ArrayList<GoalObject> goalObjects = new ArrayList<GoalObject>();

    public void Goals() {
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPref.edit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        setTitle("Saving Towards a Goal");
        Intent intent = getIntent();
        String savingType = intent.getStringExtra("savingType");
        final Button createGoal = (Button) findViewById(R.id.create);
        final EditText goal = (EditText) findViewById(R.id.goalDesc);
        final EditText goalValue = (EditText) findViewById(R.id.goalValue);

        ArrayList<String> savingGoals = new ArrayList<String>();
        initGoals();

        savingGoals.add(getGoalString(0));
        savingGoals.add(getGoalString(1));
        savingGoals.add(getGoalString(2));


        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, savingGoals);
        ListView listView = (ListView) findViewById(R.id.goals);
        listView.setAdapter(adapter);
        // Todo use editor for value storage
        createGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!goal.getText().toString().trim().isEmpty() && !goalValue.getText().toString().isEmpty()) {

                    String goalDesc = goal.getText().toString().trim();
                    double maxValue = Double.parseDouble(goalValue.getText().toString());
                    int position = savingGoals.size();
                    GoalObject newGoal = new GoalObject(goalDesc, maxValue);
                    newGoal.setSaved(0.00);
                    goalObjects.add(newGoal);
                    Log.d("Size", String.valueOf(position));
                    savingGoals.add(getGoalString(position));
                    Set<String> hashStr = new HashSet<String>();
                    hashStr.add(goalDesc);
                    hashStr.add(String.valueOf(maxValue));
                    hashStr.add(String.valueOf(0.00));
                    editor.putStringSet("key" + position, hashStr);
                    adapter.notifyDataSetChanged();
                    editor.commit();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedItem = (String) parent.getItemAtPosition(position);


                Intent savingIntent = new Intent(Goals.this, SavingDetails.class);
                savingIntent.putExtra("position", position); //Optional parameters

                Goals.this.startActivity(savingIntent);
            }
        });


    }

    public void initGoals() {

        house.setSaved(Double.compare(Double.parseDouble(sharedPref.getString(house.getGoalId(), "0.00")), 0) == 0 ? 2000 : Double.parseDouble(sharedPref.getString(house.getGoalId(), "0.00")));
        car.setSaved(Double.compare(Double.parseDouble(sharedPref.getString(car.getGoalId(), "0.00")), 0) == 0 ? 10000 : Double.parseDouble(sharedPref.getString(car.getGoalId(), "0.00")));

        phone.setSaved(Double.compare(Double.parseDouble(sharedPref.getString(phone.getGoalId(), "0.00")), 0) == 0 ? 300 : Double.parseDouble(sharedPref.getString(phone.getGoalId(), "0.00")));


        goalObjects.add(house);
        goalObjects.add(car);
        goalObjects.add(phone);


    }

    private String getGoalString(int goalIndex) {

        GoalObject goal = getGoal(goalIndex);
        return goal.getGoalDesc() + "\n" + "Saved:       " + Utils.formatCurrency(goal.getSaved());
    }

    public GoalObject getGoal(int index) {

        return goalObjects.get(index);
    }

    public ArrayList<GoalObject> getGoals() {
        return goalObjects;
    }

    public ArrayList<String> getGoalsId() {
        ArrayList<String> ids = new ArrayList<String>();
        for (int i = 0; i < goalObjects.size(); i++) {
            ids.add(goalObjects.get(i).getGoalId());
        }

        return ids;
    }
}