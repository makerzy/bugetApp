package com.example.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SavingDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_details);
        setTitle("Saving Details");

        final TextView goalTxtView = (TextView) findViewById(R.id.goalDetail);
        final TextView maxCap = (TextView) findViewById(R.id.maxCap);
        final TextView savedTxtView = (TextView) findViewById(R.id.savedDetail);
        final Button saveBtn = (Button) findViewById(R.id.btnSave);
        final EditText savingTxt = (EditText) findViewById(R.id.savingVal);
        Bundle extras = getIntent().getExtras();
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        int savingType = extras.getInt("position");

        GoalObject goalObject;
        double goalValue;
        String goalDesc;
        double saved;

        Goals goals = new Goals();
        goals.initGoals();

        if (savingType > 2) {

            Set<String> stringSet = sharedPref.getStringSet("key" + savingType, new HashSet<String>());
            List<String> stringSetList = new ArrayList<>(stringSet);
            ArrayList<String> ids = goals.getGoalsId();

            String id = Utils.toId(stringSetList.get(2), stringSetList.get(1));
            if (ids.contains(id)) {
                goalObject = goals.getGoal(savingType);

            } else {
                goalObject = new GoalObject(stringSetList.get(2), Double.parseDouble(stringSetList.get(1)));

            }

        } else {
            goalObject = goals.getGoal(savingType);

        }

        goalValue = goalObject.getValue();
        goalDesc = goalObject.getGoalDesc();
        saved = goalObject.getSaved();
        goalTxtView.setText(goalDesc);
        maxCap.setText(Utils.formatCurrency(goalValue));
        savedTxtView.setText(Utils.formatCurrency(saved));

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (savingTxt.getText().toString().isEmpty()) return;
                goalObject.setSaved(Double.parseDouble(savingTxt.getText().toString()));

                savedTxtView.setText(Utils.formatCurrency(goalObject.getSaved()));
                editor.putString(goalObject.getGoalId(), String.valueOf(goalObject.getSaved()));
                editor.commit();
            }
        });
    }
}