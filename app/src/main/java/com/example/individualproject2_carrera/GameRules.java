package com.example.individualproject2_carrera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameRules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_rules);
    }

    public void game(View view) {
        startActivity(new Intent(GameRules.this, MainActivity.class));
        finish();
    }

    public void seeScore(View view) {
        startActivity(new Intent(GameRules.this, LatestScore.class));
        finish();
    }
}