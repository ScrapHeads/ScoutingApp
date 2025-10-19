package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.util.Log;


public class preGameInfo extends AppCompatActivity {
    RadioButton red, blue, sample, noPreload, postionOne, postionTwo, specimen;
    TextView scoutName, matchNumber, teamNumber;
    byte botpostion;
    String botAlliance, botPreload, fieldPositionNuw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo. SCREEN_ORIENTATION_LANDSCAPE);
        red = findViewById(R.id.mainRedButton);
        blue = findViewById(R.id.mainBlueButton);
        //specimen = findViewById(R.id.mainSpecimen);
        //noPreload = findViewById(R.id.mainNoPreload);
        //postionOne = findViewById(R.id.mainPostionOne);
        //postionTwo = findViewById(R.id.mainPostionTwo);
        scoutName = findViewById(R.id.mainScoutName);
        matchNumber = findViewById(R.id.mainMatchNumber);
        teamNumber = findViewById(R.id.mainTeamNumber);
        setPrevious();
    }

        public void setPrevious() {
        Intent previous=getIntent();
            scoutName.setText(previous.getStringExtra("scoutName"));
            scoutName.setText(String.valueOf(RecordsActivity.Info.scoutName));
            teamNumber.setText(previous.getStringExtra("teamNumber"));
            teamNumber.setText(String.valueOf(RecordsActivity.Info.teamNumber));
            matchNumber.setText(previous.getStringExtra("matchNumder"));
            matchNumber.setText(String.valueOf(RecordsActivity.Info.matchNumber));
            botAlliance=(previous.getStringExtra("alliance"));
            botAlliance=(String.valueOf(RecordsActivity.Info.alliance));
            if (botAlliance == "red") {
                blue.setChecked(false);
                red.setChecked(true);
            }
            if (botAlliance == "blue") {
                blue.setChecked(true);
                red.setChecked(false);
            }
            previous.getStringExtra("preload");
            botPreload=(String.valueOf(RecordsActivity.Info.preload));
            if (botPreload == "specimen") {
                noPreload.setChecked(false);
                sample.setChecked(false);
                specimen.setChecked(true);
            }
            if (botPreload == "sample") {
                noPreload.setChecked(false);
                specimen.setChecked(false);
                sample.setChecked(true);
            }
            if (botPreload == "noPreload") {
                sample.setChecked(false);
                specimen.setChecked(false);
                noPreload.setChecked(true);
            }
            botpostion=(RecordsActivity.Info.fieldPosition);
            if (botpostion == 1 ) {
                postionTwo.setChecked(false);
                postionOne.setChecked(true);
            }
            if (botpostion == 2 ) {
                postionOne.setChecked(false);
                postionTwo.setChecked(true);
            }


        }

        public void saveData(){
            Intent save= new Intent(this, RecordsActivity.class);
            RecordsActivity.Info.scoutName = scoutName.getText().toString();
            save.putExtra("scoutName", scoutName.getText().toString());         Log.d("Vput",scoutName.getText().toString()); Log.d("Vput",RecordsActivity.Info.scoutName);
            RecordsActivity.Info.teamNumber = teamNumber.getText().toString();      Log.d("Vput",RecordsActivity.Info.scoutName);
            save.putExtra("teamNumber", teamNumber.getText().toString());       Log.d("Vput",teamNumber.getText().toString()); Log.d("Vput",RecordsActivity.Info.teamNumber);
            RecordsActivity.Info.matchNumber = matchNumber.getText().toString();
            save.putExtra("matchNumber", matchNumber.getText().toString());     Log.d("Vput",matchNumber.getText().toString()); Log.d("Vput",RecordsActivity.Info.matchNumber);
            RecordsActivity.Info.alliance = botAlliance;
            save.putExtra("alliance", botAlliance);                             Log.d("Vput",botAlliance); Log.d("Vput",RecordsActivity.Info.alliance);
            RecordsActivity.Info.fieldPosition = botpostion;
            save.putExtra("botpostion", botpostion);                            Log.d("Vput", String.valueOf(botpostion)); Log.d("Vput", String.valueOf(RecordsActivity.Info.fieldPosition));
            RecordsActivity.Info.preload = botPreload;
            save.putExtra("botpreload", botPreload);
            RecordsActivity.Info.fieldPositionNuw = fieldPositionNuw;
            save.putExtra("fieldPositionNuw", fieldPositionNuw);                                                                                Log.d("Vput", String.valueOf(botPreload)); Log.d("Vput", String.valueOf(RecordsActivity.Info.preload));

        }

    public void toSample(View view){
        Intent next = new Intent(this, AutoActivity.class);             Log.d("logNextClick", "Make a Page");
        saveData();                                                                 Log.d("logNextClick", "Save Data");
        startActivity(next);                                                        Log.d("logNextClick", "open Page");
    }
    public void back(View view){
        Intent next = new Intent(this, scoutingChoice.class);
        saveData();
        startActivity(next);
    }
    public void redClick(View view){    Log.d("logredClick", "starting method");
        blue.setChecked(false);         Log.d("logredClick", "set blue false");
        red.setChecked(true);           Log.d("logredClick", "set RED true");
        botAlliance="red";              Log.d("logredClick", "set botAlliance to red");
      }
    public void blueClick(View view){   Log.d("logblueClick", "starting method");
        red.setChecked(false);          Log.d("logblueClick", "set red false");
        blue.setChecked(true);          Log.d("logblueClick", "set blue true");
        botAlliance="blue";             Log.d("logredClick", "set botAlliance to blue");
    }
    public void specimenClick(View view){
        noPreload.setChecked(false);
        sample.setChecked(false);
        specimen.setChecked(true);
        botPreload="specimen";          Log.d( "botPreload", botPreload );
    }
    public void sampleClick(View view){
        noPreload.setChecked(false);
        specimen.setChecked(false);
        sample.setChecked(true);
        botPreload="sample";
    }
    public void NoPreloadClick(View view){
        sample.setChecked(false);
        specimen.setChecked(false);
        noPreload.setChecked(true);
        botPreload="noPreload";
    }
    public void PostionOne(View view){
        postionTwo.setChecked(false);
        postionOne.setChecked(true);
        botpostion = 1;
    }
    public void PostionTwo(View view){
        postionOne.setChecked(false);
        postionTwo.setChecked(true);
        botpostion = 2;
    }

    public void bluetopright() {
        fieldPositionNuw ="1";
    }
    public void topmid() {
        fieldPositionNuw ="2";
    }
    public void redtopleft() {
        fieldPositionNuw ="3";
    }
    public void bottomright() {
        fieldPositionNuw ="4";
    }
    public void bottommid() {
        fieldPositionNuw ="5";
    }
    public void bottomleft() {
        fieldPositionNuw ="6";
    }



}
