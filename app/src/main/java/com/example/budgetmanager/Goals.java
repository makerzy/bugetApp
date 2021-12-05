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

public class Goals extends AppCompatActivity {
    GoalObject house= new GoalObject("Buy a House", 100000);
    GoalObject car = new GoalObject("Buy a new Car", 40000);
    GoalObject phone = new GoalObject("Buy a new iPhone" , 9000);

    ArrayList<GoalObject> goalObjects = new ArrayList<GoalObject>();
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

        initGoals ();

        ArrayList <String> keys = new ArrayList<String>();
        keys.add("house");
        keys.add("car") ;
        keys.add("phone");
        ArrayList <String> savingGoals = new ArrayList<String>();

        savingGoals.add(getGoalString(0));
        savingGoals.add(getGoalString(1));
        savingGoals.add(getGoalString(2));


        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,savingGoals);
        ListView listView = (ListView) findViewById(R.id.goals);
        listView.setAdapter(adapter);
        // Todo use editor for value storage
        createGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!goal.getText().toString().trim().isEmpty() && !goalValue.getText().toString().isEmpty()){

                    String goalDesc =goal.getText().toString().trim();
                    double  maxValue = Double.parseDouble(goalValue.getText().toString());
                    int position = savingGoals.size();
                    goalObjects.add(new GoalObject(goalDesc, maxValue));
                    Log.d("Size", String.valueOf(position));
                    keys.add("key-"+position);
                    savingGoals.add(getGoalString(position));
                    Log.d("Goal desc", goalDesc);
                    Log.d("Goal value", String.valueOf(maxValue));
                    adapter.add(getGoalString(position));
                    adapter.notifyDataSetChanged();
                    editor.commit();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);


                Intent savingIntent = new Intent(Goals.this, SavingDetails.class);
                savingIntent.putExtra("position", position); //Optional parameters

                Goals.this.startActivity(savingIntent);
            }
        });


    }
    public void initGoals (){
        house.setSaved(2000);
        car.setSaved(10000);
        phone.setSaved(300);

        goalObjects.add(house);
        goalObjects.add( car);
        goalObjects.add( phone);
    }

    private String getGoalString(int goalIndex) {

        GoalObject goal = getGoal(goalIndex);
        return goal.getGoalDesc() + "\n" + "Saved:       "+ Utils.formatCurrency(goal.getSaved());
    }

    public GoalObject getGoal(int index){

        return goalObjects.get(index);
    }

}