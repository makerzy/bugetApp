package com.example.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    final String password = "CNT5517";
    final String email = "gradclass@famu.edu";
    final String username = "gradclass";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("BetterBudget Login");
        final EditText usernameTxt = (EditText) findViewById(R.id.username);
        final EditText passwordTxt = (EditText) findViewById(R.id.password);
        final Button login = (Button) findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!usernameTxt.getText().toString().trim().isEmpty() && !passwordTxt.getText().toString().isEmpty()){
                    String passTxt = passwordTxt.getText().toString();
                    String usernameStr = usernameTxt.getText().toString();
                    if((usernameStr.equals(username) || usernameStr.equals(email)) && passTxt.equals(password) ){
                        Intent mainIntent = new Intent(Login.this, MainActivity.class);
                        Login.this.startActivity(mainIntent);
                    }
                    else {
                        Toast.makeText(Login.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}