package com.example.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        int savingType = extras.getInt("position");



        Goals goals = new Goals();
        goals.initGoals();
        GoalObject goalObject = goals.getGoal(savingType);
        double goalValue = goalObject.getValue();
        String goalDesc = goalObject.getGoalDesc();
        double saved  = goalObject.getSaved();

        goalTxtView.setText(goalDesc );
        maxCap.setText(Utils.formatCurrency(goalValue));
        savedTxtView.setText(Utils.formatCurrency(saved));

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (savingTxt.getText().toString().isEmpty()) return;
                goalObject.setSaved(Double.parseDouble(savingTxt.getText().toString()));

                savedTxtView.setText(Utils.formatCurrency(goalObject.getSaved()));
            }
        });
    }
}