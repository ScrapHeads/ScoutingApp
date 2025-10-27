package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class preGameInfo extends AppCompatActivity {

    // --- UI Components ---
    private RadioButton red, blue, sample, noPreload, postionOne, postionTwo, specimen;
    private TextView scoutName, matchNumber, teamNumber, fealdpos;

    // --- Data Fields ---
    private byte botpostion;
    private String botAlliance, botPreload, fieldPositionNuw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Initialize UI elements
        red = findViewById(R.id.mainRedButton);
        blue = findViewById(R.id.mainBlueButton);
        scoutName = findViewById(R.id.mainScoutName);
        matchNumber = findViewById(R.id.mainMatchNumber);
        teamNumber = findViewById(R.id.mainTeamNumber);
        fealdpos = findViewById(R.id.feldposText);

        // Optional components (commented out if not used)
        // specimen = findViewById(R.id.mainSpecimen);
        // noPreload = findViewById(R.id.mainNoPreload);
        // postionOne = findViewById(R.id.mainPostionOne);
        // postionTwo = findViewById(R.id.mainPostionTwo);

        setPrevious();
    }

    private void setPrevious() {
        Intent previous = getIntent();

        scoutName.setText(RecordsActivity.Info.scoutName);
        teamNumber.setText(RecordsActivity.Info.teamNumber);
        matchNumber.setText(RecordsActivity.Info.matchNumber);

        botAlliance = RecordsActivity.Info.alliance;
        botPreload = RecordsActivity.Info.preload;
        botpostion = RecordsActivity.Info.fieldPosition;
        fieldPositionNuw = RecordsActivity.Info.fieldPositionNuw;

        // Default alliance buttons
        if ("red".equals(botAlliance)) {
            red.setChecked(true);
            blue.setChecked(false);
        } else if ("blue".equals(botAlliance)) {
            blue.setChecked(true);
            red.setChecked(false);
        }

        // Default preload buttons
        if ("specimen".equals(botPreload)) {
            specimen.setChecked(true);
        } else if ("sample".equals(botPreload)) {
            sample.setChecked(true);
        } else if ("noPreload".equals(botPreload)) {
            noPreload.setChecked(true);
        }

        // Default position buttons
        if (botpostion == 1) {
            postionOne.setChecked(true);
        } else if (botpostion == 2) {
            postionTwo.setChecked(true);
        }

        // Field position display
        fealdpos.setText(fieldPositionNuw != null ? fieldPositionNuw : "Press a Position");
    }

    private void saveData() {
        Intent save = new Intent(this, RecordsActivity.class);

        // Fallback for null fieldPositionNuw
        if (fieldPositionNuw == null || fieldPositionNuw.isEmpty()) {
            fieldPositionNuw = "Press a Position";
        }

        // Assign to RecordsActivity.Info
        RecordsActivity.Info.scoutName = scoutName.getText().toString();
        RecordsActivity.Info.teamNumber = teamNumber.getText().toString();
        RecordsActivity.Info.matchNumber = matchNumber.getText().toString();
        RecordsActivity.Info.alliance = botAlliance;
        RecordsActivity.Info.fieldPosition = botpostion;
        RecordsActivity.Info.preload = botPreload;
        RecordsActivity.Info.fieldPositionNuw = fieldPositionNuw;

        // Add extras to intent
        save.putExtra("scoutName", RecordsActivity.Info.scoutName);
        save.putExtra("teamNumber", RecordsActivity.Info.teamNumber);
        save.putExtra("matchNumber", RecordsActivity.Info.matchNumber);
        save.putExtra("alliance", RecordsActivity.Info.alliance);
        save.putExtra("botpostion", RecordsActivity.Info.fieldPosition);
        save.putExtra("botpreload", RecordsActivity.Info.preload);
        save.putExtra("fieldPositionNuw", RecordsActivity.Info.fieldPositionNuw);

        Log.d("SaveData", "Saved info: " + RecordsActivity.Info.scoutName + ", " + RecordsActivity.Info.teamNumber + ", " + fieldPositionNuw);
    }

    // --- Navigation Methods ---
    public void toSample(View view) {
        saveData();
        startActivity(new Intent(this, AutoActivity.class));
        Log.d("Navigation", "Opened AutoActivity");
    }

    public void back(View view) {
        saveData();
        startActivity(new Intent(this, scoutingChoice.class));
        Log.d("Navigation", "Returned to scoutingChoice");
    }

    // --- Button Handlers ---
    public void redClick(View view) {
        blue.setChecked(false);
        red.setChecked(true);
        botAlliance = "red";
        Log.d("Alliance", "Selected red");
    }

    public void blueClick(View view) {
        red.setChecked(false);
        blue.setChecked(true);
        botAlliance = "blue";
        Log.d("Alliance", "Selected blue");
    }

    public void specimenClick(View view) {
        noPreload.setChecked(false);
        sample.setChecked(false);
        specimen.setChecked(true);
        botPreload = "specimen";
        Log.d("Preload", "specimen selected");
    }

    public void sampleClick(View view) {
        noPreload.setChecked(false);
        specimen.setChecked(false);
        sample.setChecked(true);
        botPreload = "sample";
        Log.d("Preload", "sample selected");
    }

    public void noPreloadClick(View view) {
        sample.setChecked(false);
        specimen.setChecked(false);
        noPreload.setChecked(true);
        botPreload = "noPreload";
        Log.d("Preload", "noPreload selected");
    }

    public void postionOne(View view) {
        postionTwo.setChecked(false);
        postionOne.setChecked(true);
        botpostion = 1;
        Log.d("Position", "Set to 1");
    }

    public void postionTwo(View view) {
        postionOne.setChecked(false);
        postionTwo.setChecked(true);
        botpostion = 2;
        Log.d("Position", "Set to 2");
    }

    // --- Field Position Buttons ---
    public void bluetopright(View view) {
        updateFieldPosition("Top 1");
    }

    public void topmid(View view) {
        updateFieldPosition("Top 2");
    }

    public void redtopleft(View view) {
        updateFieldPosition("Top 3");
    }

    public void bottomright(View view) {
        updateFieldPosition("Bottom 4");
    }

    public void bottommid(View view) {
        updateFieldPosition("Bottom 5");
    }

    public void bottomleft(View view) {
        updateFieldPosition("Bottom 6");
    }

    private void updateFieldPosition(String position) {
        fieldPositionNuw = position;
        fealdpos.setText(position);
        Log.d("YELLOWBUTTONS", "fieldPositionNuw set to " + position);
    }
}




