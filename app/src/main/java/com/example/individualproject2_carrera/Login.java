package com.example.individualproject2_carrera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private Button loginBtn;
    private Button registerBtn;
    private String storedUsername, storedPassword;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final EditText userName = findViewById(R.id.username);
        final EditText passWord = findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.login);
        registerBtn = (Button) findViewById(R.id.register);

        preferences = getSharedPreferences("userInfo", MODE_PRIVATE);

        storedUsername = preferences.getString("email", "");
        storedPassword = preferences.getString("password", "");

        //enables the login btn if there is registered data
        if(!storedPassword.equals("") || !storedUsername.equals("")){
            loginBtn.setEnabled(true);
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validates the login info (Checks if the user actually has a registered account)
                if ( userName.getText().toString().equals(storedUsername) && passWord.getText().toString().equals(storedPassword)){
                    startActivity(new Intent(Login.this, GameRules.class));
                    finish();
                }
            }
        });
    }

    public void register(View view){
        startActivity(new Intent(Login.this, Registration.class));
        finish();
    }
}