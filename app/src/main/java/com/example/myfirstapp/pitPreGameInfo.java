package com.example.myfirstapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class pitPreGameInfo extends AppCompatActivity {
    RadioButton shuttleBot, basketBot, chamberBot, highTask, lowTask, autoYes, autoNo, shuttleAuto, basketAuto, chamberAuto;
    TextView pitTeamNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_pre_game_info);
        this.setRequestedOrientation(ActivityInfo. SCREEN_ORIENTATION_LANDSCAPE);
        pitTeamNumber =findViewById(R.id.pitTeamNumber);
        shuttleBot = findViewById(R.id.shuttleBot);
        basketBot = findViewById(R.id.basketBot);
        chamberBot = findViewById(R.id.chamberBot);
        highTask= findViewById(R.id.highTask);
        lowTask= findViewById(R.id.lowTask);
        autoYes= findViewById(R.id.autoYes);
        autoNo= findViewById(R.id.autoNo);
        shuttleAuto= findViewById(R.id.shuttleAuto);
        basketAuto= findViewById(R.id.basketAuto);
        chamberAuto=findViewById(R.id.chamberAuto);
        setPrevious();
    }
    public void Next(View view){
        Intent Next = new Intent(this, pitQr.class);
        saveData();
        startActivity(Next);
    }
    public void back(View view){
        Intent next = new Intent(this, scoutingChoice.class);
        saveData();
        startActivity(next);
    }
    public void saveData() {
        Intent save = new Intent(this, RecordsActivity.class);
        RecordsActivity.Info.pitTeamNumber = pitTeamNumber.getText().toString();
    }
    public void setPrevious() {
        Intent previous = getIntent();
        pitTeamNumber.setText(previous.getStringExtra("pitTeamNumber"));
        pitTeamNumber.setText(String.valueOf(RecordsActivity.Info.pitTeamNumber));
        if (RecordsActivity.Info.pitBotTipe == "Shuttle Bot"){
            chamberBot.setChecked(false);
            basketBot.setChecked(false);
            shuttleBot.setChecked(true);
        }
        if (RecordsActivity.Info.pitBotTipe == "basket Bot"){
            chamberBot.setChecked(false);
            shuttleBot.setChecked(false);
            basketBot.setChecked(true);
        }
        if (RecordsActivity.Info.pitBotTipe == "Chamber Bot"){
            basketBot.setChecked(false);
            shuttleBot.setChecked(false);
            chamberBot.setChecked(true);
        }
        if (RecordsActivity.Info.pitTask == "Low Task"){
            highTask.setChecked(false);
            lowTask.setChecked(true);
        }
        if (RecordsActivity.Info.pitTask == "High Task"){
            lowTask.setChecked(false);
            highTask.setChecked(true);
        }
        if (RecordsActivity.Info.pitAuto == "Yes"){
            autoNo.setChecked(false);
            autoYes.setChecked(true);
        }
        if (RecordsActivity.Info.pitAuto == "no"){
            autoYes.setChecked(false);
            autoNo.setChecked(true);
        }
        if (RecordsActivity.Info.pitAutoTipe == "Shuttle Auto"){
            chamberAuto.setChecked(false);
            basketAuto.setChecked(false);
            shuttleAuto.setChecked(true);
        }
        if (RecordsActivity.Info.pitAutoTipe == "Basket Auto"){
            chamberAuto.setChecked(false);
            shuttleAuto.setChecked(false);
            basketAuto.setChecked(true);
        }
        if (RecordsActivity.Info.pitAutoTipe == "Chamber Auto"){
            basketAuto.setChecked(false);
            shuttleAuto.setChecked(false);
            chamberAuto.setChecked(true);
        }

    }
    public void shuttleBotclick(View view){
        chamberBot.setChecked(false);
        basketBot.setChecked(false);
        shuttleBot.setChecked(true);
        RecordsActivity.Info.pitBotTipe="Shuttle Bot";
    }
    public void basketBotclick(View view){
        chamberBot.setChecked(false);
        shuttleBot.setChecked(false);
        basketBot.setChecked(true);
        RecordsActivity.Info.pitBotTipe="Basket Bot";
    }
    public void chamberBotclick(View view){
        basketBot.setChecked(false);
        shuttleBot.setChecked(false);
        chamberBot.setChecked(true);
        RecordsActivity.Info.pitBotTipe="Chamber Bot";
    }
    public void lowTaskclick(View view){
        highTask.setChecked(false);
        lowTask.setChecked(true);
        RecordsActivity.Info.pitTask="Low Task";
    }
    public void highTaskclick(View view){
        lowTask.setChecked(false);
        highTask.setChecked(true);
        RecordsActivity.Info.pitTask= "High Task";
    }
    public void pitYesClick(View view){
        autoNo.setChecked(false);
        autoYes.setChecked(true);
        RecordsActivity.Info.pitAuto="Yes";
    }
    public void pitNoClick(View view){
        autoYes.setChecked(false);
        autoNo.setChecked(true);
        RecordsActivity.Info.pitAuto="No";
    }
    public void shuttleAutoClick(View view){
        chamberAuto.setChecked(false);
        basketAuto.setChecked(false);
        shuttleAuto.setChecked(true);
        RecordsActivity.Info.pitAutoTipe= "Shuttle Auto";
    }
    public void basketAutoClick(View view){
        chamberAuto.setChecked(false);
        shuttleAuto.setChecked(false);
        basketAuto.setChecked(true);
        RecordsActivity.Info.pitAutoTipe="Basket Auto";
    }
    public void chamberAutoClick (View view){
        basketAuto.setChecked(false);
        shuttleAuto.setChecked(false);
        chamberAuto.setChecked(true);
        RecordsActivity.Info.pitAutoTipe="Chamber Auto";
    }





















}
