package com.example.individualproject2_carrera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    private EditText firstName;
    private EditText familyName;
    private EditText dob;
    private EditText email;
    private EditText passWord2;

    SharedPreferences sharedPref; // Creates sharedpreference object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstName = (EditText) findViewById(R.id.firstName);
        familyName = (EditText) findViewById(R.id.familyName);
        dob = (EditText) findViewById(R.id.dateOfBirth);
        email = (EditText) findViewById(R.id.email);
        passWord2 = (EditText) findViewById(R.id.password2);

        sharedPref = getSharedPreferences("userInfo", MODE_PRIVATE); // set my object to the file I'm going to use

    }


    public void registerUser(View view) {

        // For the validation here I wasn't quite sure how in depth we had to go so I used some general
        // "Guidelines" like length and making sure certain entries contained certain characters
        // leaving out however the logic that would make sure something like 11/00000000 doesn't get through as
        // a date
        if (firstName.getText().toString().isEmpty() || familyName.getText().toString().isEmpty() ||
                dob.getText().toString().isEmpty() ||email.getText().toString().isEmpty() ||
                passWord2.getText().toString().isEmpty()){

            //Learned how to make a toast by messing around with the login activity that's already on android
            Toast.makeText(getApplicationContext(),"Please do not leave any fields empty", Toast.LENGTH_LONG).show();
        }
        else if(firstName.getText().toString().length() < 3 || firstName.getText().toString().length() > 30){
            Toast.makeText(getApplicationContext(),"Enter a valid first name", Toast.LENGTH_LONG).show();
        }
        else if(familyName.getText().toString().length() < 3 || familyName.getText().toString().length() > 30){
            Toast.makeText(getApplicationContext(),"Enter a valid family name", Toast.LENGTH_LONG).show();
        }
        else if( dob.getText().toString().length() < 9 || !dob.getText().toString().contains("/")){
            Toast.makeText(getApplicationContext(),"Enter a valid Date of birth", Toast.LENGTH_LONG).show();
        }
        else if(!email.getText().toString().contains("@") || !email.getText().toString().contains(".") ||
                email.getText().toString().length() < 7){
            Toast.makeText(getApplicationContext(),"Enter a valid email address", Toast.LENGTH_LONG).show();
        }
        else if(passWord2.getText().toString().length() < 8){
            Toast.makeText(getApplicationContext(),"Enter a valid password", Toast.LENGTH_LONG).show();
        }
        else{
            SharedPreferences.Editor editor = sharedPref.edit(); // Lets me write to the file

            editor.putString("first name", firstName.getText().toString()); // Writes the user info to the file
            editor.putString("family name", familyName.getText().toString());
            editor.putString("Date of Birth", dob.getText().toString());
            editor.putString("email", email.getText().toString());
            editor.putString("password", passWord2.getText().toString());
            editor.apply(); // Applies the changes

            startActivity(new Intent(Registration.this, Login.class));
        }


    }


}