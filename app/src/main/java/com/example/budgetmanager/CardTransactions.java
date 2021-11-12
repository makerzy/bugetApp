package com.example.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;

public class CardTransactions extends AppCompatActivity {
    String[] citi_bank_trx = {"Purchase @ Starbucks: $3.99 \nDate: 11/05/2021 @ 11:12 PM",
            "Purchase @ Macy's: $345.98 \nDate: 11/05/2021 @ 02:56 PM", "Purchase @ Walmart: $165.79 \nDate: 11/06/2021 @ 01:56 PM",
            "Purchase @ Marshalls: $457.98 \nDate: 11/11/2021 @ 10:15 PM", "Purchase @ Encore: $299.76 \nDate: 11/10/2021 @ 04:56 PM"};
    String[] wells_fargo_trx = {"Purchase @ Target: $249.65\nDate: 10/30/2021 @ 12:56 PM ",
            "Purchase @ Liberty: $2.35 \nDate: 11/08/2021 @ 07:26 PM",
            "Purchase @ Shell: $10.99 \nDate: 10/05/2021 @ 12:56 PM", "Purchase @ Macy's: $345.98 \nDate: 11/07/2021 @ 06:56 PM",
            "Purchase @ TJMaxx: $78.96 \nDate: 11/05/2021 @ 12:46 PM"};
    String[] discover_trx = {"Purchase @ Marshalls: $457.98 \nDate: 11/05/2021 @ 12:56 PM",
            "Purchase @ Encore: $299.76 \nDate: 11/13/2021 @ 12:34 PM", "Purchase @ Lush: $5 \nDate: 11/08/2021 @ 08:56 AM",
            "Purchase @ Starbucks: $3.99 \nDate: 11/09/2021 @ 12:36 PM", "Purchase @ Greenwise: $20.35 \nDate: 11/05/2021 @ 12:56 PM"};
    String[] chase_trx = {"Purchase @ Greenwise: $20.35 \nDate: 11/04/2021 @ 10:15 PM", "Purchase @ Verizon: $189 \nDate: 11/05/2021 @ 12:56 PM",
            "Purchase @ TJMaxx: $78.96 \nDate: 11/09/2021 @ 01:12 PM", "Purchase @ Bulls: $47.13 \nDate: 11/05/2021 @ 10:10 PM",
            "Purchase @ Starbucks: $3.99 \nDate: 11/05/2021 @ 10:56 PM", "Purchase @ Macy's: $345.98 \nDate: 11/10/2021 @ 04:56 PM"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_transactions);
        Intent intent = getIntent();
        String cardTrx = intent.getStringExtra("cardTrx");
        ArrayAdapter<String> adapter;
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, android.R.layout.simple_list_item_1);

        if (cardTrx.equals("chase")) {
            setTitle("Chase Recent Transactions");
            Log.v("CardTx", cardTrx);
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,chase_trx);
            ListView listView = (ListView) findViewById(R.id.transaction);
            listView.setAdapter(adapter);

        } else if (cardTrx.equals("wells_fargo")) {
            setTitle("Wells Fargo Recent Transactions");
            Log.v("CardTx", cardTrx);
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,wells_fargo_trx);
            ListView listView = (ListView) findViewById(R.id.transaction);
            listView.setAdapter(adapter);
        } else if (cardTrx.equals("citi_bank")) {
            setTitle("CitiBank Recent Transactions");
            Log.v("CardTx", cardTrx);
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,citi_bank_trx);
            ListView listView = (ListView) findViewById(R.id.transaction);
            listView.setAdapter(adapter);
        } else if (cardTrx.equals("discover")) {
            setTitle("Discover Recent Transactions");
            Log.v("CardTx", cardTrx);
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,discover_trx);
            ListView listView = (ListView) findViewById(R.id.transaction);
            listView.setAdapter(adapter);
        }else{
//            Render all the transactions here
        }
    }
}