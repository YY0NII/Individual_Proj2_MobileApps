package com.example.individualproject2_carrera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LatestScore extends AppCompatActivity {

    TextView score;
    SharedPreferences p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_score);

        p = getSharedPreferences("userInfo", MODE_PRIVATE);
        score = (TextView) findViewById(R.id.score);

        score.setText(p.getString("score",""));


    }

    public void playAgain(View view) {
        startActivity(new Intent(LatestScore.this, MainActivity.class));
        finish();
    }
}