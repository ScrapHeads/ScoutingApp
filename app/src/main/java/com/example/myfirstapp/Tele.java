package com.example.myfirstapp;


import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class Tele<pri> extends AppCompatActivity {
    RadioButton park, noPark, LevleOne, LevleTwo,LevleThree;
    TextView teleNetZoneText, teleLowBasketText, teleHighBasketText,teleHiChamberText,teleloChamberText, overflowtxt;
    byte teleNetZone = 0, teleLowBasket = 0, teleHighBasket = 0,teleHiChamber=0, teleloChamber=0, Overflow=0;
    String teleBotAscent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tele);
        this.setRequestedOrientation(ActivityInfo. SCREEN_ORIENTATION_LANDSCAPE);
        overflowtxt = findViewById(R.id.overflowText);
        teleNetZoneText = findViewById(R.id.sampleNetZoneCount3);
        teleLowBasketText = findViewById(R.id.spesamenLowBasketCount);
        teleHighBasketText = findViewById(R.id.teleHighBasketCount);
        teleHiChamberText=findViewById(R.id.spesamenHCZeroText);
        teleloChamberText=findViewById(R.id.spesamenLCZeroText);
        park =findViewById(R.id.telePark);
        noPark = findViewById(R.id.teleNoPark);
        LevleOne = findViewById(R.id.telelevel1);
        LevleTwo = findViewById(R.id.endlevel2);
        LevleThree = findViewById(R.id.endLevel3);
        setPrevious();                                      Log.d("tApre","get I");
    }


    public void toend(View view) {
        Intent next = new Intent(this, match_notes_Activity.class);
        saveData();
        startActivity(next);
    }

    public void setPrevious() {
        Intent previous=getIntent();                                                                    Log.d("tApre","got Intent");
        teleNetZoneText.setText(previous.getStringExtra("netZoneText"));                          Log.d("tApre","got String Extra netZoneText");
        teleNetZoneText.setText(String.valueOf(RecordsActivity.Info.teleNetZoneText));                  Log.d("tApre"," .setText(RecordsActivity.Info.autoNetZoneText is good");
        teleLowBasketText.setText(String.valueOf(RecordsActivity.Info.teleLowBasketText));              Log.d("tApre","seted teleLowBasketText to autoHighBasketText ");
        teleHighBasketText.setText(previous.getStringExtra("highBasketText"));                    Log.d("tApre","got highBasketText from previous.getStringExtra");
        teleHighBasketText.setText(String.valueOf(RecordsActivity.Info.teleHighBasketText));            Log.d("tApre","teleHighBasketText set to autoHighBasketText ");
        teleBotAscent=previous.getStringExtra("teleBotAscent");                                   Log.d("tApre","got autoBotAscent from the getStringExtra");
        teleBotAscent=RecordsActivity.Info.teleAscent;                                                  Log.d("tApre","teleBotAscent = AutoAscent");
        teleHiChamberText.setText(previous.getStringExtra("teleHiChamberText"));                  Log.d("tApre","AutoHiChamberText from getStringExtra");
        teleHiChamberText.setText(String.valueOf(RecordsActivity.Info.teleHighChamber));                Log.d("tApre","teleHiChamberText setText teleHighChamber");
        teleloChamberText.setText(previous.getStringExtra("teleloChamberText"));                  Log.d("tApre","got teleloChamberText from getStringExtra");
        teleloChamberText.setText(String.valueOf(RecordsActivity.Info.teleSpecimenLowChamber));Log.d("tAloChamber","set pre teleloChamberText = "+teleloChamberText.getText().toString()); Log.d("tAloChamber", "set pre records teleLowChamberText"+String.valueOf(RecordsActivity.Info.teleSpecimenLowChamber));
        overflowtxt.setText(String.valueOf(RecordsActivity.Info.overflowtxtTely));

        if (teleBotAscent == "park"){
            noPark.setChecked(false);
            LevleOne.setChecked(false);
            LevleTwo.setChecked(false);
            LevleThree.setChecked(false);
            park.setChecked(true);
        }
        if (teleBotAscent=="noPark"){
            park.setChecked(false);
            LevleOne.setChecked(false);
            LevleTwo.setChecked(false);
            LevleThree.setChecked(false);
            noPark.setChecked(true);
        }
        if (teleBotAscent == "lvlOne"){
            park.setChecked(false);
            noPark.setChecked(false);
            LevleTwo.setChecked(false);
            LevleThree.setChecked(false);
            LevleOne.setChecked(true);
        }
        if (teleBotAscent== "LvlTwo"){
            park.setChecked(false);
            LevleOne.setChecked(false);
            LevleThree.setChecked(false);
            noPark.setChecked(false);
            LevleTwo.setChecked(true);
        }
        if (teleBotAscent== "LvlThree") {
            park.setChecked(false);
            LevleOne.setChecked(false);
            noPark.setChecked(false);
            LevleTwo.setChecked(false);
            LevleThree.setChecked(true);
        }
            teleNetZone = Byte.parseByte(teleNetZoneText.getText().toString());
            if (teleNetZone == 0){
                findViewById(R.id.spesamenNetSubtract).setVisibility(INVISIBLE);
            }
            teleNetZone = Byte.parseByte(teleNetZoneText.getText().toString());
            if (teleNetZone > 0) {
                findViewById(R.id.spesamenNetSubtract).setVisibility(VISIBLE);
            }
            Overflow= Byte.parseByte(overflowtxt.getText().toString());
            if (Overflow==0){
                findViewById(R.id.overflowMin).setVisibility(GONE);
            }
            Overflow=Byte.parseByte(overflowtxt.getText().toString());
            if (Overflow > 0){
                findViewById(R.id.overflowMin).setVisibility(VISIBLE);
            }


            teleloChamber = Byte.parseByte(teleloChamberText.getText().toString());
            if (teleloChamber == 0){
                findViewById(R.id.spesamenLCSubtractionButton).setVisibility(INVISIBLE);
            }
            if (teleloChamber > 0) {
                findViewById(R.id.spesamenLCSubtractionButton).setVisibility(VISIBLE);
            }
            teleHiChamber = Byte.parseByte(teleHiChamberText.getText().toString());
            if (teleHiChamber ==0) {
                findViewById(R.id.spesamenHCSubtractionButton).setVisibility(GONE);
            }
            if (teleHiChamber > 0) {
                findViewById(R.id.spesamenHCSubtractionButton).setVisibility(VISIBLE);
            }
            teleLowBasket = Byte.parseByte(teleLowBasketText.getText().toString());
            if (teleLowBasket ==0){
                findViewById(R.id.spesamenLowBasketSubtract).setVisibility(GONE);
            }
            if (teleLowBasket > 0) {
                findViewById(R.id.spesamenLowBasketSubtract).setVisibility(VISIBLE);
            }
            teleHighBasket = Byte.parseByte(teleHighBasketText.getText().toString());
            if (teleHighBasket ==0){
                findViewById(R.id.spesamenHighBasketSubtract).setVisibility(GONE);
            }
            if (teleHighBasket > 0) {
                findViewById(R.id.spesamenHighBasketSubtract).setVisibility(VISIBLE);                                Log.d("AASet Previous", "VISIBLE");
            }
        }


    public void saveData() {
        Intent AUTOsave= new Intent(this, RecordsActivity.class);
        RecordsActivity.Info.teleNetZoneText = Byte.parseByte(teleNetZoneText.getText().toString());            Log.d("tAput",teleNetZoneText.getText().toString()); Log.d("tAput", String.valueOf(RecordsActivity.Info.teleNetZoneText));
        AUTOsave.putExtra("telenetZoneText",  teleNetZoneText.getText().toString());
        RecordsActivity.Info.teleLowBasketText = Byte.parseByte(teleLowBasketText.getText().toString());        Log.d("tAput",teleLowBasketText.getText().toString()); Log.d("tAput", String.valueOf(RecordsActivity.Info.teleLowBasketText));
        AUTOsave.putExtra("telelowBasketText",  teleLowBasketText.getText().toString());
        RecordsActivity.Info.teleHighBasketText = Byte.parseByte(teleHighBasketText.getText().toString());      Log.d("tAput",teleHighBasketText.getText().toString()); Log.d("tAput", String.valueOf(RecordsActivity.Info.teleHighBasketText));
        AUTOsave.putExtra("telehighBasketText",  teleHighBasketText.getText().toString());
        RecordsActivity.Info.teleAscent = teleBotAscent;                                                        Log.d("tAput",teleBotAscent); Log.d("tAput", String.valueOf(RecordsActivity.Info.teleAscent));
        AUTOsave.putExtra("teleBotAscent", String.valueOf(teleBotAscent));
        RecordsActivity.Info.teleHighChamber = Byte.parseByte(teleHiChamberText.getText().toString());
        AUTOsave.putExtra("teleHiChamberText",teleHiChamberText.getText().toString());
        RecordsActivity.Info.teleSpecimenLowChamber = Byte.parseByte(teleloChamberText.getText().toString());   Log.d("tAloChamber", "save teleLoChamberText = "+(teleloChamberText.getText().toString())); Log.d("save tAloChamber", "teleLoChamberRecords = "+String.valueOf(RecordsActivity.Info.teleSpecimenLowChamber));
        AUTOsave.putExtra("teleloChamberText",teleloChamberText.getText().toString());
        RecordsActivity.Info.overflowtxtTely=Byte.parseByte(overflowtxt.getText().toString());
        AUTOsave.putExtra("Tellyoverflow", overflowtxt.getText().toString());
    }

    public void backAuto(View view) {
        Intent back = new Intent(this, AutoActivity.class);
        saveData();
        startActivity(back);
    }

    public void TeleNetZoneIncrease(View view) {
        //findViewById(R.id.spesamenNetSubtract).setVisibility(VISIBLE);

        teleNetZone++;
        teleNetZoneText.setText(String.valueOf(teleNetZone));
        if (teleNetZone > 0){
            findViewById(R.id.spesamenNetSubtract).setVisibility(VISIBLE);
        }
    }
    public void overflowIncreas(View view){
        Overflow++;
        overflowtxt.setText(String.valueOf(Overflow));
        if ( Overflow>0){
            findViewById(R.id.overflowMin).setVisibility(VISIBLE);
        }
    }
    public void overflowDecres(View view){
        if (Overflow >0){
            Overflow--;
            overflowtxt.setText(String.valueOf(Overflow));
        }
        if (Overflow<=0){
            findViewById(R.id.overflowMin).setVisibility(GONE);
        }

    }



    public void TeleNetZoneDecrease(View view) {
        if (teleNetZone > 0) {
            teleNetZone--;
            teleNetZoneText.setText(String.valueOf(teleNetZone));
        }
        if (teleNetZone <=0){
            findViewById(R.id.spesamenNetSubtract).setVisibility(GONE);
        }
    }
    public void TelelowChamberIncrease(View view){
        //findViewById(R.id.spesamenLCSubtractionButton).setVisibility(VISIBLE);
        teleloChamber++;                                                                            Log.d("tAloChamber", "push teleLoChamberByte = "+String.valueOf(teleloChamber)); Log.d("tAloChamber", "push teleLoChamberRecords = "+String.valueOf(RecordsActivity.Info.teleSpecimenLowChamber));
        teleloChamberText.setText(String.valueOf(teleloChamber));                                   Log.d("tAloChamber", "push teleLoChamberByte = "+String.valueOf(teleloChamber)); Log.d("tAloChamber", "push teleloChamberText = "+teleloChamberText.getText().toString());

        if (teleloChamber > 0){
            findViewById(R.id.spesamenLCSubtractionButton).setVisibility(VISIBLE);                  Log.d("tAloChamber", "VISIBLE");
        }
    }
    public void TelelowChamberDecrease(View view){
        if (teleloChamber > 0) {
        teleloChamber--;
        teleloChamberText.setText(String.valueOf(teleloChamber));
        }
        if (teleloChamber <=0){
            findViewById(R.id.spesamenLCSubtractionButton).setVisibility(GONE);                     Log.d("tAloChamber", "INVISIBLE");
        }
    }
    public void TelelowBasketIncrease(View view) {
        findViewById(R.id.spesamenLowBasketSubtract).setVisibility(VISIBLE);
        teleLowBasket++;
        teleLowBasketText.setText(String.valueOf(teleLowBasket));
        if (teleLowBasket > 0){
            findViewById(R.id.spesamenLowBasketSubtract).setVisibility(VISIBLE);
        }
    }
    public void TelehighChamberIncrease(View view) {
        findViewById(R.id.spesamenHCSubtractionButton).setVisibility(VISIBLE);
        teleHiChamber++;
        teleHiChamberText.setText(String.valueOf(teleHiChamber));
        if (teleHiChamber > 0){
            findViewById(R.id.spesamenHCSubtractionButton).setVisibility(VISIBLE);
        }
    }
    public void TelehighChamberDecrease(View view) {
        if (teleHiChamber > 0) {
        teleHiChamber--;
        teleHiChamberText.setText(String.valueOf(teleHiChamber));
        }
        if (teleHiChamber <=0){
            findViewById(R.id.spesamenHCSubtractionButton).setVisibility(GONE);
        }
    }

    public void TelelowBasketDecrease(View view) {
        if (teleLowBasket > 0) {
        teleLowBasket--;
        teleLowBasketText.setText(String.valueOf(teleLowBasket));
        }
        if (teleLowBasket <=0){
            findViewById(R.id.spesamenLowBasketSubtract).setVisibility(GONE);
        }
    }
    public void TelehighBasketIncrease(View view) {
        findViewById(R.id.spesamenHighBasketSubtract).setVisibility(VISIBLE);
        teleHighBasket++;
        teleHighBasketText.setText(String.valueOf(teleHighBasket));
        if (teleHighBasket > 0){
            findViewById(R.id.spesamenHighBasketSubtract).setVisibility(VISIBLE);
        }
    }
    public void TelehighBasketDecrease(View view) {
        if (teleHighBasket > 0) {
        teleHighBasket--;
        teleHighBasketText.setText(String.valueOf(teleHighBasket));
        }
        if (teleHighBasket <=0){
            findViewById(R.id.spesamenHighBasketSubtract).setVisibility(GONE);
        }
    }
    public void TeleClickPark(View view){
        noPark.setChecked(false);
        LevleOne.setChecked(false);
        LevleTwo.setChecked(false);
        LevleThree.setChecked(false);
        park.setChecked(true);
        teleBotAscent ="park";
    }

    public void TeleClickNoPark(View view) {
        Log.d("NoParkClick", "starting method");
        park.setChecked(false);             Log.d("NoParkClick", "set Park false");
        LevleOne.setChecked(false);         Log.d("NoParkClick", "set levleOne true");
        LevleTwo.setChecked(false);
        LevleThree.setChecked(false);
        noPark.setChecked(true);            Log.d("NoParkClick", "set NoPark true");
        teleBotAscent="noPark";
    }
    public void TeleClickLvlOne(View view){
        park.setChecked(false);         Log.d("LevleOne", "set park false");
        noPark.setChecked(false);Log.d("LevleOne", "set noPark false");
        LevleTwo.setChecked(false);
        LevleThree.setChecked(false);
        LevleOne.setChecked(true);      Log.d("LevleOne", "set LevleOne true");

        teleBotAscent="lvlOne";  Log.d("levleOne", String.valueOf(teleBotAscent));
        Log.d("levleOne", String.valueOf(teleBotAscent));
    }

    public void TeleClicklvl2(View view) {
        Log.d("NoParkClick", "starting method");
        park.setChecked(false);
        Log.d("NoParkClick", "set Park false");
        LevleOne.setChecked(false);
        Log.d("NoParkClick", "set levleOne true");
        LevleThree.setChecked(false);
        noPark.setChecked(false);
        Log.d("NoParkClick", "set NoPark true");
        LevleTwo.setChecked(true);
        teleBotAscent = "LvlTwo";
    }
    public void TeleClicklvl3(View view) {
        Log.d("NoParkClick", "starting method");
        park.setChecked(false);             Log.d("NoParkClick", "set Park false");
        LevleOne.setChecked(false);         Log.d("NoParkClick", "set levleOne true");
        noPark.setChecked(false);            Log.d("NoParkClick", "set NoPark true");
        LevleTwo.setChecked(false);
        LevleThree.setChecked(true);
        teleBotAscent="LvlThree";
    }
}