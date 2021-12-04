package com.example.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.budgetmanager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    int globalId = 0;
    BankClass[] banks;
    ActivityMainBinding binding;
    Intent mainIntent;
    String[] bankNames = {"chase", "discover", "wells_fargo", "citi_bank"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView) findViewById(R.id.gridView);
        grid.setAdapter(new ImageAdapter((this)));
        Button seeMore = (Button) findViewById(R.id.seeMore);
        Button goals = (Button) findViewById(R.id.vGoals);
        TextView saveGoal = (TextView) findViewById(R.id.feature1);
        TextView buyHouse = (TextView) findViewById(R.id.feature2);
        TextView buyCrypto = (TextView) findViewById(R.id.feature3);


        mainIntent = new Intent(MainActivity.this, CardTransactions.class);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.v("Position", "" + position);
                mainIntent.putExtra("cardTrx", bankNames[position]); //Optional parameters
                MainActivity.this.startActivity(mainIntent);
            }
        });

        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainIntent.putExtra("cardTrx", "allTrx"); //Optional parameters
                MainActivity.this.startActivity(mainIntent);
            }
        });

        goals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainIntent = new Intent(MainActivity.this, Goals.class);
                MainActivity.this.startActivity(mainIntent);
            }
        });



    }


}