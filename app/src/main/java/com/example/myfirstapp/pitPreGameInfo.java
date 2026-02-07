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
    RadioButton shuttleBot, basketBot, chamberBot, highTask, lowTask, autoYes, autoNo, shuttleAuto, basketAuto, chamberAuto, liftNO, liftYES, autoYES, autoNO, shortRange, farRange;
    TextView pitTeamNumber, TeleopCyclesAverage, AutoCyclesAverage;
    private String launchstring,atostring ;
    private TextView launchTextView, atotextvew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_pre_game_info);
        this.setRequestedOrientation(ActivityInfo. SCREEN_ORIENTATION_LANDSCAPE);
        pitTeamNumber =findViewById(R.id.pitTeamNumber);
        //highTask= findViewById(R.id.highTask);
        //lowTask= findViewById(R.id.lowTask);
        //autoYes= findViewById(R.id.autoYes);
        //autoNo= findViewById(R.id.autoNo);
        //shuttleAuto= findViewById(R.id.liftNO);
        //basketAuto= findViewById(R.id.basketAuto);
        
        launchTextView =findViewById(R.id.launchTextView);
        atotextvew=findViewById(R.id.textView29);
        TeleopCyclesAverage=findViewById(R.id.TeleopCyclesAverage);
        AutoCyclesAverage=findViewById(R.id.AutoCyclesAverage);
        
        liftNO =findViewById(R.id.liftNO);
        liftYES =findViewById(R.id.liftYES);
        autoNO =findViewById(R.id.autoNO);
        autoYES =findViewById(R.id.autoYES);
        shortRange =findViewById(R.id.shortRange);
        farRange =findViewById(R.id.farRange);
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
        RecordsActivity.Info.TeleopCyclesAverage =TeleopCyclesAverage.getText().toString();
        RecordsActivity.Info.AutoCyclesAverage =AutoCyclesAverage.getText().toString();
        
        RecordsActivity.Info.launchstring = launchTextView.getText().toString();
        RecordsActivity.Info.atostring = atotextvew.getText().toString();
        
    }
    public void setPrevious() {
        Intent previous = getIntent();
        pitTeamNumber.setText(previous.getStringExtra("pitTeamNumber"));
        pitTeamNumber.setText(String.valueOf(RecordsActivity.Info.pitTeamNumber));
        
        launchTextView.setText(String.valueOf(RecordsActivity.Info.launchstring));
        atotextvew.setText(String.valueOf(RecordsActivity.Info.atostring));
        
        TeleopCyclesAverage.setText(previous.getStringExtra("TeleopCyclesAverage"));
        TeleopCyclesAverage.setText(String.valueOf(RecordsActivity.Info.TeleopCyclesAverage));
        AutoCyclesAverage.setText(previous.getStringExtra("AutoCyclesAverage"));
        AutoCyclesAverage.setText(String.valueOf(RecordsActivity.Info.AutoCyclesAverage));
        
        if (RecordsActivity.Info.autolift == "auto lift no"){
            liftNO.setChecked(true);
            liftYES.setChecked(false);
            RecordsActivity.Info.autolift ="auto lift no";
        }
        if (RecordsActivity.Info.autolift == "auto lift yes"){
            liftNO.setChecked(false);
            liftYES.setChecked(true);
            RecordsActivity.Info.autolift ="auto lift yes";
        }
        if(RecordsActivity.Info.DoHaveAuto =="no auto"){
            autoNO.setChecked(true);
            autoYES.setChecked(false);
            RecordsActivity.Info.DoHaveAuto ="no auto";
        }
        if(RecordsActivity.Info.DoHaveAuto == "yes auto"){
            autoNO.setChecked(false);
            autoYES.setChecked(true);
            RecordsActivity.Info.DoHaveAuto= "yes auto";
        }
        if (RecordsActivity.Info.range == "short Range"){
            shortRange.setChecked(true);
            farRange.setChecked(false);
            RecordsActivity.Info.range = "short Range";
        }
        if(RecordsActivity.Info.range =="far Range"){
            shortRange.setChecked(false);
            farRange.setChecked(true);
            RecordsActivity.Info.range ="far Range";
        }
        /*
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
        }*/

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
        liftNO.setChecked(true);
        liftYES.setChecked(false);
        RecordsActivity.Info.autolift ="auto lift no";
    }
    public void autoliftYES (View view){
        liftNO.setChecked(false);
        liftYES.setChecked(true);
        RecordsActivity.Info.autolift ="auto lift yes";
    }
    public void autosetNO (View view){
        autoNO.setChecked(true);
        autoYES.setChecked(false);
        RecordsActivity.Info.DoHaveAuto ="no auto";
    }
    public void autosetYES (View view){
        autoNO.setChecked(false);
        autoYES.setChecked(true);
        RecordsActivity.Info.DoHaveAuto= "yes auto";
    }
    public void autoshortRange (View view){
        shortRange.setChecked(true);
        farRange.setChecked(false);
        RecordsActivity.Info.range = "short Range";
    }
    public void autofarRange (View view){
        shortRange.setChecked(false);
        farRange.setChecked(true);
        RecordsActivity.Info.range ="far Range";
    }


    //calian's work
    public void PITbluetopleft(View view){
        
        updatelaunchTextView("launch blue top left");
    }
    public void PITtopmid(View view){
        
        updatelaunchTextView("launch top mid");
    }
    public void PITredtopright(View view){
     
        updatelaunchTextView("launch red top right");
    }
    public void PITbottomleft (View view){
        
        updatelaunchTextView("launch bottom left");
    }
    public void PITbottommid(View view){
        
        updatelaunchTextView("launch bottom mid");
    }
    public void PITbottomright(View view){
        
        updatelaunchTextView("launch bottom right");
    }

    
    private void updatelaunchTextView(String position) {
        launchstring = position;
        launchTextView.setText(position);
        Log.d("YELLOWBUTTONS", "launchstring set to " + position);
    }
    private void updateAtoTextView(String position) {
        atostring = position;
        atotextvew.setText(position);
        Log.d("YELLOWBUTTONS", "launchstring set to " + position);
    }
    public void PITbluetopleft1(View view){
        
        updateAtoTextView("auto blue top left");
    }
    public void PITtopmid1(View view){
        
        updateAtoTextView("auto top mid");
    }
    public void PITredtopright1(View view){
        
        updateAtoTextView("auto red top right");
    }
    public void PITbottomleft1 (View view){
        
        updateAtoTextView("auto bottom left");
    }
    public void PITbottommid1(View view){
        
        updateAtoTextView("auto bottom mid");
    }
    public void PITbottomright1 (View view){
        
        updateAtoTextView("auto bottom right");
    }
    
    
    
    
    
    
    
    
    
    
//calian's work end

}
