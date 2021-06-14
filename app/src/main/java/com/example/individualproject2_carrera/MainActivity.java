package com.example.individualproject2_carrera;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView questionNumber, question;
    Button choice1, choice2, choice3, choice4, btn1;
    MultipleChoiceQuestion q1, q2, q3, q4, q5;
    MultipleChoiceQuestion[] questions;
    int counter = 0;
    double correct = 0;
    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("userInfo", MODE_PRIVATE);

        questionNumber = (TextView) findViewById(R.id.qNum);
        question = (TextView) findViewById(R.id.question);

        choice1 = (Button) findViewById(R.id.c1);
        choice1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                final ViewGroup subView = (ViewGroup) getLayoutInflater().// inflater view
                        inflate(R.layout.costum_alert_view, null, false);
                AlertDialog dialog = new AlertDialog.Builder( MainActivity.this)
                        .setTitle("Confirm your choice")
                        .setView(subView)
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (questions[counter].isCorrect(choice1.getText().toString())){
                                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
                                    correct++;
                                }else {
                                    Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_LONG).show();
                                }

                                counter++;
                                changeQuestion();
                                enableEnd();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                dialog.show();
            }
        });

        choice2 = (Button) findViewById(R.id.c2);
        choice2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                final ViewGroup subView = (ViewGroup) getLayoutInflater().// inflater view
                        inflate(R.layout.costum_alert_view, null, false);
                AlertDialog dialog = new AlertDialog.Builder( MainActivity.this)
                        .setTitle("Confirm your choice")
                        .setView(subView)
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (questions[counter].isCorrect(choice2.getText().toString())){
                                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
                                    correct++;
                                }else {
                                    Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_LONG).show();
                                }

                                counter++;
                                changeQuestion();
                                enableEnd();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                dialog.show();
            }
        });


        choice3 = (Button) findViewById(R.id.c3);
        choice3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                final ViewGroup subView = (ViewGroup) getLayoutInflater().// inflater view
                        inflate(R.layout.costum_alert_view, null, false);
                AlertDialog dialog = new AlertDialog.Builder( MainActivity.this)
                        .setTitle("Confirm your choice")
                        .setView(subView)
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (questions[counter].isCorrect(choice3.getText().toString())){
                                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
                                    correct++;
                                }else {
                                    Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_LONG).show();
                                }

                                counter++;
                                changeQuestion();
                                enableEnd();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                dialog.show();
            }
        });


        choice4 = (Button) findViewById(R.id.c4);
        choice4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                final ViewGroup subView = (ViewGroup) getLayoutInflater().// inflater view
                        inflate(R.layout.costum_alert_view, null, false);
                AlertDialog dialog = new AlertDialog.Builder( MainActivity.this)
                        .setTitle("Confirm your choice")
                        .setView(subView)
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (questions[counter].isCorrect(choice4.getText().toString())){
                                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
                                    correct++;
                                }else {
                                    Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_LONG).show();
                                }

                                counter++;
                                changeQuestion();
                                enableEnd();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                dialog.show();
            }

        });

        btn1 = (Button) findViewById(R.id.end);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter == 5){
                    double score = calculateScore();

                    SharedPreferences.Editor editor = pref.edit(); // Lets me write to the file

                    editor.putString("score", Double.toString(score)); // Writes the user info to the file
                    editor.apply(); // Applies the changes
                    startActivity(new Intent(MainActivity.this, LatestScore.class));
                    finish();
                }
            }

        });





        q1 = new MultipleChoiceQuestion("_____ enable objects to communicate and interact as they perform business functions and transactions required by a system.",
                "Relationships", new String[]{"Linkages", "Clusters", "Relationships", "Aggregates"});
        q2 = new MultipleChoiceQuestion("The Unified Modeling Language (UML) represents an object as a _____ with the object name at the top, followed by the object's attributes and methods.",
                "rectangle", new String[]{"circle", "rhombus", "pentagon", "rectangle"});
        q3 = new MultipleChoiceQuestion("An _____ shows the objects and how they interact to perform business functions and transactions.",
                "object relationship diagram", new String[]{"object relationship diagram", "object precedent chart",
                "object antecedent chart", "object interaction diagram"});
        q4 = new MultipleChoiceQuestion("The _____ of an object is an adjective that describes the object's current status.",
                "state", new String[]{"encapsulation", "polymorphism", "resemblance", "state"});
        q5 = new MultipleChoiceQuestion("An object's _____ are the tasks or functions that the object performs when it receives a command to do so.",
                "methods", new String[]{"utilities", "instances", "roles", "methods"});

        questions = new MultipleChoiceQuestion[] { q1, q2, q3, q4, q5 };

        questionNumber.setText("Question 1:");
        question.setText(questions[counter].getQuestion());
        choice1.setText(questions[counter].getChoices()[0]);
        choice2.setText(questions[counter].getChoices()[1]);
        choice3.setText(questions[counter].getChoices()[2]);
        choice4.setText(questions[counter].getChoices()[3]);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void changeQuestion()
    {
        //Check counter change layout accordingly
        if (counter == 1){
            questionNumber.setText("Question 2:");
            question.setText(questions[counter].getQuestion());
            choice1.setText(questions[counter].getChoices()[0]);
            choice2.setText(questions[counter].getChoices()[1]);
            choice3.setText(questions[counter].getChoices()[2]);
            choice4.setText(questions[counter].getChoices()[3]);
        }else if (counter == 2){
            questionNumber.setText("Question 3:");
            question.setText(questions[counter].getQuestion());
            choice1.setText(questions[counter].getChoices()[0]);
            choice2.setText(questions[counter].getChoices()[1]);
            choice3.setText(questions[counter].getChoices()[2]);
            choice4.setText(questions[counter].getChoices()[3]);
        }else if (counter == 3){
            questionNumber.setText("Question 4:");
            question.setText(questions[counter].getQuestion());
            choice1.setText(questions[counter].getChoices()[0]);
            choice2.setText(questions[counter].getChoices()[1]);
            choice3.setText(questions[counter].getChoices()[2]);
            choice4.setText(questions[counter].getChoices()[3]);
        }else if (counter == 4){
            questionNumber.setText("Question 5:");
            question.setText(questions[counter].getQuestion());
            choice1.setText(questions[counter].getChoices()[0]);
            choice2.setText(questions[counter].getChoices()[1]);
            choice3.setText(questions[counter].getChoices()[2]);
            choice4.setText(questions[counter].getChoices()[3]);

        }

    }

    public double calculateScore()
    {
        return (correct / 5.0) * 100;
    }

    public void enableEnd()
    {
        if (counter == 5){
            btn1.setEnabled(true);
        }
    }
}