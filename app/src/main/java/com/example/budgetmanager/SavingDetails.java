package com.example.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

public class SavingDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_details);
        setTitle("Saving Details");
        Intent intent = getIntent();
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String savingType = intent.getStringExtra("position");
        String item =  sharedPref.getString("key"+ savingType, "");
        Log.d("Saving type ", String.valueOf(item));
    }
}