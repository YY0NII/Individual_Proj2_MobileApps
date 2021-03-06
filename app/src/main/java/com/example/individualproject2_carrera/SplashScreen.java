package com.example.individualproject2_carrera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    // I didn't know what a splash screen was or how to make one so I did end up using
    // Online resources to help me out the main source I used is here:
    // https://abhiandroid.com/programming/splashscreen

    Handler handler; // This is my first time ever using a handler, Sadly I'm still not 100% sure
    // how it works but in this case we used it to hold the splash screen for 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler = new Handler(); // I don't really know why Handler gets crossed out here but without this line the code crashes

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,Login.class);
                startActivity(intent);
                finish(); // without this line the splash screen would pop back up after hitting the back button
            }
        },3000);// The 3000 delays the splashscreen for 3 seconds
    }
}