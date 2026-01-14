package com.example.myfirstapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class pitPreGameInfo extends AppCompatActivity {
    RadioButton shuttleBot, basketBot, chamberBot, highTask, lowTask, autoYes, autoNo, shuttleAuto, basketAuto, chamberAuto, liftNO;
    TextView pitTeamNumber;
    private String launchstring;
    private TextView launchTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_pre_game_info);
        this.setRequestedOrientation(ActivityInfo. SCREEN_ORIENTATION_LANDSCAPE);
        //pitTeamNumber =findViewById(R.id.pitTeamNumber);
        //highTask= findViewById(R.id.highTask);
        //lowTask= findViewById(R.id.lowTask);
        //autoYes= findViewById(R.id.autoYes);
        //autoNo= findViewById(R.id.autoNo);
        //shuttleAuto= findViewById(R.id.liftNO);
        //basketAuto= findViewById(R.id.basketAuto);
        
        launchTextView =findViewById(R.id.launchTextView);
        
        
        liftNO= findViewById(R.id.liftNO);
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
    //public void shuttleBotclick(View view){
    //    chamberBot.setChecked(false);
    //    basketBot.setChecked(false);
    //    shuttleBot.setChecked(true);
    //    RecordsActivity.Info.pitBotTipe="Shuttle Bot";
    //}
    //public void basketBotclick(View view){
    //    chamberBot.setChecked(false);
    //    shuttleBot.setChecked(false);
    //    basketBot.setChecked(true);
    //    RecordsActivity.Info.pitBotTipe="Basket Bot";
    //}
    //public void chamberBotclick(View view){
    //    basketBot.setChecked(false);
    //    shuttleBot.setChecked(false);
    //    chamberBot.setChecked(true);
    //    RecordsActivity.Info.pitBotTipe="Chamber Bot";
    //}
    //public void lowTaskclick(View view){
    //    highTask.setChecked(false);
    //    lowTask.setChecked(true);
    //    RecordsActivity.Info.pitTask="Low Task";
    //}
    //public void highTaskclick(View view){
    //    lowTask.setChecked(false);
    //    highTask.setChecked(true);
    //    RecordsActivity.Info.pitTask= "High Task";
    //}
    //public void pitYesClick(View view){
    //    autoNo.setChecked(false);
    //    autoYes.setChecked(true);
    //    RecordsActivity.Info.pitAuto="Yes";
    //}
    //public void pitNoClick(View view){
    //    autoYes.setChecked(false);
    //    autoNo.setChecked(true);
    //    RecordsActivity.Info.pitAuto="No";
    //}
    //public void shuttleAutoClick(View view){
   //    chamberAuto.setChecked(false);
   //    basketAuto.setChecked(false);
   //    shuttleAuto.setChecked(true);
   //    RecordsActivity.Info.pitAutoTipe= "Shuttle Auto";
   //}
   //public void basketAutoClick(View view){
   //    chamberAuto.setChecked(false);
   //    shuttleAuto.setChecked(false);
   //    basketAuto.setChecked(true);
   //    RecordsActivity.Info.pitAutoTipe="Basket Auto";
   //}
   //public void chamberAutoClick (View view){
   //    basketAuto.setChecked(false);
   //    shuttleAuto.setChecked(false);
   //    chamberAuto.setChecked(true);
   //    RecordsActivity.Info.pitAutoTipe="Chamber Auto";
   //}
    
    
    public void autoliftNO (View view){

    }
    
    
    
    
    
    
    
    
    
    //calian's work
    public void PITredtopleft (View view){
        updatelaunchTextView("PIT red top left");
    }
    public void PITtopmid(View view){
        updatelaunchTextView("PIT top mid");
    }
    public void PITbluetopright(View view){
     updatelaunchTextView("PIT blue top right");
    }
    public void PITbottomleft (View view){
        updatelaunchTextView("PIT bottom left");
    }
    public void PITbottommid(View view){
        updatelaunchTextView("PIT bottom mid");
    }
    public void PITbottomright(View view){
        updatelaunchTextView("PIT bottom right");
    }
    
    
    
    private void updatelaunchTextView(String position) {
        launchstring = position;
        launchTextView.setText(position);
        Log.d("YELLOWBUTTONS", "launchstring set to " + position);
    }
//calian's work end





















}
