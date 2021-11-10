package com.example.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.budgetmanager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    int globalId = 0;
    BankClass [] banks;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String [] bankNames = {"Wells Fargo", "CitiBank","Discover", "Chase" };
        int[] images = { R.drawable.wells_fargo, R.drawable.citibank, R.drawable.discover, R.drawable.chase};

    }


//    private BankClass createBank(String name, int logo){
//        globalId++;
//        return new BankClass(name, globalId, logo);
//    }
}