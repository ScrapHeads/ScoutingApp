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
    RadioButton park, noPark, LevleOne, LevleTwo,LevleThree, noparked, barlyparked, fullparked, parkedwithothers, autochoice1, autochoice2, autochoice3, autochoice4, autochoice5, autochoice6, autochoice7, autochoice8, autochoice9, autochoice10, autochoice11, autochoice12, autochoice13, autochoice14, autochoice15, autochoice16, autochoice17, autochoice18;
    TextView teleNetZoneText, teleLowBasketText, teleHighBasketText,teleHiChamberText,teleloChamberText, overflowtxt;
    byte teleNetZone = 0, teleLowBasket = 0, teleHighBasket = 0,teleHiChamber=0, teleloChamber=0, Overflow=0;
    String teleBotAscent, parked, autogrup1, autogrup2, autogrup3,autogrup4,autogrup5,autogrup6, autogrup7, autogrup8, autogrup9, autogrup10, autogrup11, autogrup12, autogrup13, autogrup14, autogrup15, autogrup16, autogrup17, autogrup18;

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
        noparked =findViewById(R.id.telypark1);
        barlyparked=findViewById(R.id.telybparled);
        fullparked=findViewById(R.id.telyfullpared);
        parkedwithothers=findViewById(R.id.telyparkedwithothers);
        autochoice1 = findViewById(R.id.telechoice19);
        autochoice2 = findViewById(R.id.telechoice20);
        autochoice3 = findViewById(R.id.telychoice21);
        autochoice4 = findViewById(R.id.telechoice22);
        autochoice5 = findViewById(R.id.telechoice23);
        autochoice6 = findViewById(R.id.telechoice24);
        autochoice7 = findViewById(R.id.telechoice25);
        autochoice8 = findViewById(R.id.telechoice26);
        autochoice9 = findViewById(R.id.telechoice27);
        autochoice10 = findViewById(R.id.telechoice28);
        autochoice11 = findViewById(R.id.telechoice29);
        autochoice12 = findViewById(R.id.telechoice30);
        autochoice13 = findViewById(R.id.telechoice31);
        autochoice14 = findViewById(R.id.telechoice32);
        autochoice15 = findViewById(R.id.telechoice33);
        autochoice16 = findViewById(R.id.telechoice34);
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
        parked=RecordsActivity.Info.telyparked;
        autogrup1 = RecordsActivity.Info.telegrup1;
        autogrup2 = RecordsActivity.Info.telegrup2;
        autogrup3 = RecordsActivity.Info.telegrup3;
        autogrup4 = RecordsActivity.Info.telegrup4;
        autogrup5 = RecordsActivity.Info.telegrup5;
        autogrup6 = RecordsActivity.Info.telegrup6;
        autogrup7 = RecordsActivity.Info.telegrup7;
        autogrup8 = RecordsActivity.Info.telegrup8;
        autogrup9 = RecordsActivity.Info.telegrup9;
        autogrup10 = RecordsActivity.Info.telegrup10;
        autogrup11 = RecordsActivity.Info.telegrup11;
        autogrup12 = RecordsActivity.Info.telegrup12;
        autogrup13 = RecordsActivity.Info.telegrup13;
        autogrup14 = RecordsActivity.Info.telegrup14;
        autogrup15 = RecordsActivity.Info.telegrup15;
        autogrup16 = RecordsActivity.Info.telegrup16;
        autogrup17 = RecordsActivity.Info.telegrup17;
        autogrup18 = RecordsActivity.Info.telegrup18;

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
        if (parked=="noparked"){
            barlyparked.setChecked(false);
            fullparked.setChecked(false);
            parkedwithothers.setChecked(false);
            noparked.setChecked(true);
        }
        if (parked=="barlyparked"){
            fullparked.setChecked(false);
            parkedwithothers.setChecked(false);
            noparked.setChecked(false);
            barlyparked.setChecked(true);
        }
        if (parked=="fullparked"){
            barlyparked.setChecked(false);
            parkedwithothers.setChecked(false);
            noparked.setChecked(false);
            fullparked.setChecked(true);
        }
        if (parked=="parkedwithothers"){
            barlyparked.setChecked(false);
            fullparked.setChecked(false);
            noparked.setChecked(false);
            parkedwithothers.setChecked(true);
        }
        if (autogrup1 == "autochoice1") {
            autochoice1.setChecked(true);
            autochoice2.setChecked(false);
        }
        if (autogrup1 == "autochoice2") {
            autochoice1.setChecked(false);
            autochoice2.setChecked(true);
        }
        if (autogrup3 == "autochoice3") {
            autochoice3.setChecked(true);
            autochoice4.setChecked(false);
        }
        if (autogrup3 == "autochoice4") {
            autochoice4.setChecked(true);
            autochoice3.setChecked(false);
        }
        if (autogrup4 == "autochoice5") {
            autochoice5.setChecked(true);
            autochoice6.setChecked(false);
        }
        if (autogrup4 == "autochoice6") {
            autochoice6.setChecked(true);
            autochoice5.setChecked(false);
        }
        if (autogrup5 == "autochoice7") {
            autochoice7.setChecked(true);
            autochoice8.setChecked(false);
        }
        if (autogrup5 == "autochoice8") {
            autochoice8.setChecked(true);
            autochoice7.setChecked(false);
        }
        if (autogrup6 == "autochoice9") {
            autochoice9.setChecked(true);
            autochoice10.setChecked(false);
        }
        if (autogrup6 == "autochoice10") {
            autochoice10.setChecked(true);
            autochoice9.setChecked(false);
        }
        if (autogrup7 == "autochoice11") {
            autochoice11.setChecked(true);
            autochoice12.setChecked(false);
        }
        if (autogrup7 == "autochoice12") {
            autochoice12.setChecked(true);
            autochoice11.setChecked(false);
        }
        if (autogrup8 == "autochoice13") {
            autochoice13.setChecked(true);
            autochoice14.setChecked(false);
        }
        if (autogrup8 == "autochoice14") {
            autochoice14.setChecked(true);
            autochoice13.setChecked(false);
        }
        if (autogrup9 == "autochoice15") {
            autochoice15.setChecked(true);
            autochoice16.setChecked(false);
        }
        if (autogrup9 == "autochoice16") {
            autochoice16.setChecked(true);
            autochoice15.setChecked(false);
        }
        if (autogrup10 == "autochoice17") {
            autochoice17.setChecked(true);
            autochoice18.setChecked(false);
        }
        if (autogrup10 == "autochoice18") {
            autochoice18.setChecked(true);
            autochoice17.setChecked(false);
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
        RecordsActivity.Info.telyparked =parked;
        AUTOsave.putExtra("tellyparked",String.valueOf(parked));
        RecordsActivity.Info.telegrup1 = autogrup1;
        AUTOsave.putExtra("autogrup1", String.valueOf(autogrup1));
        RecordsActivity.Info.telegrup2 = autogrup2;
        AUTOsave.putExtra("autogrup2", String.valueOf(autogrup2));
        RecordsActivity.Info.telegrup3 = autogrup3;
        AUTOsave.putExtra("autogrup3", String.valueOf(autogrup3));
        RecordsActivity.Info.telegrup4 = autogrup4;
        AUTOsave.putExtra("autogrup4", String.valueOf(autogrup4));
        RecordsActivity.Info.telegrup5 = autogrup5;
        AUTOsave.putExtra("autogrup5", String.valueOf(autogrup5));
        RecordsActivity.Info.telegrup6 = autogrup6;
        AUTOsave.putExtra("autogrup6", String.valueOf(autogrup6));
        RecordsActivity.Info.telegrup7 = autogrup7;
        AUTOsave.putExtra("autogrup7", String.valueOf(autogrup7));
        RecordsActivity.Info.telegrup8 = autogrup8;
        AUTOsave.putExtra("autogrup8", String.valueOf(autogrup8));
        RecordsActivity.Info.telegrup9 = autogrup9;
        AUTOsave.putExtra("autogrup9", String.valueOf(autogrup9));
        RecordsActivity.Info.telegrup10 = autogrup10;
        AUTOsave.putExtra("autogrup10", String.valueOf(autogrup10));
        RecordsActivity.Info.telegrup11 = autogrup11;
        AUTOsave.putExtra("autogrup11", String.valueOf(autogrup11));
        RecordsActivity.Info.telegrup12 = autogrup12;
        AUTOsave.putExtra("autogrup12", String.valueOf(autogrup12));
        RecordsActivity.Info.telegrup13 = autogrup13;
        AUTOsave.putExtra("autogrup13", String.valueOf(autogrup13));
        RecordsActivity.Info.telegrup14 = autogrup14;
        AUTOsave.putExtra("autogrup14", String.valueOf(autogrup14));
        RecordsActivity.Info.telegrup15 = autogrup15;
        AUTOsave.putExtra("autogrup15", String.valueOf(autogrup15));
        RecordsActivity.Info.telegrup16 = autogrup16;
        AUTOsave.putExtra("autogrup16", String.valueOf(autogrup16));
        RecordsActivity.Info.telegrup17 = autogrup17;
        AUTOsave.putExtra("autogrup17", String.valueOf(autogrup17));
        RecordsActivity.Info.telegrup18 = autogrup18;
        AUTOsave.putExtra("autogrup18", String.valueOf(autogrup18));

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
    public void clickdidnotparked(View view){
        barlyparked.setChecked(false);
        fullparked.setChecked(false);
        parkedwithothers.setChecked(false);
        noparked.setChecked(true);
        parked="noparked";
    }
    public void clickbarlyparked(View view){
        fullparked.setChecked(false);
        parkedwithothers.setChecked(false);
        noparked.setChecked(false);
        barlyparked.setChecked(true);
        parked="barlyparked";
    }
    public void clickfullparked(View view){
        barlyparked.setChecked(false);
        parkedwithothers.setChecked(false);
        noparked.setChecked(false);
        fullparked.setChecked(true);
        parked="fullparked";
    }
    public void clickparkedwithothers(View view){
        barlyparked.setChecked(false);
        fullparked.setChecked(false);
        noparked.setChecked(false);
        parkedwithothers.setChecked(true);
        parked="parkedwithothers";
    }

    public void telechoice1(View view) {
        autochoice1.setChecked(true);
        autochoice2.setChecked(false);
        autogrup1 = "autochoice1";
    }

    public void telechoice2(View view) {
        autochoice2.setChecked(true);
        autochoice1.setChecked(false);
        autogrup1 = "autochoice2";
    }

    public void telechoice3(View view) {
        autochoice3.setChecked(true);
        autochoice4.setChecked(false);
        autogrup3 = "autochoice3";
    }

    public void telechoice4(View view) {
        autochoice4.setChecked(true);
        autochoice3.setChecked(false);
        autogrup3 = "autochoice4";
    }

    public void telechoice5(View view) {
        autochoice5.setChecked(true);
        autochoice6.setChecked(false);
        autogrup4 = "autochoice5";
    }

    public void telechoice6(View view) {
        autochoice6.setChecked(true);
        autochoice5.setChecked(false);
        autogrup4 = "autochoice6";
    }

    public void telechoice7(View view) {
        autochoice7.setChecked(true);
        autochoice8.setChecked(false);
        autogrup5 = "autochoice7";
    }

    public void telechoice8(View view) {
        autochoice8.setChecked(true);
        autochoice7.setChecked(false);
        autogrup5 = "autochoice8";
    }

    public void telechoice9(View view) {
        autochoice9.setChecked(true);
        autochoice10.setChecked(false);
        autogrup6 = "autochoice9";
    }

    public void telechoice10(View view) {
        autochoice10.setChecked(true);
        autochoice9.setChecked(false);
        autogrup6 = "autochoice10";
    }

    public void telechoice11(View view) {
        autochoice11.setChecked(true);
        autochoice12.setChecked(false);
        autogrup7 = "autochoice11";
    }

    public void telechoice12(View view) {
        autochoice12.setChecked(true);
        autochoice11.setChecked(false);
        autogrup7 = "autochoice12";
    }

    public void telechoice13(View view) {
        autochoice13.setChecked(true);
        autochoice14.setChecked(false);
        autogrup8 = "autochoice13";
    }

    public void telechoice14(View view) {
        autochoice14.setChecked(true);
        autochoice13.setChecked(false);
        autogrup8 = "autochoice14";
    }

    public void telechoice15(View view) {
        autochoice15.setChecked(true);
        autochoice16.setChecked(false);
        autogrup9 = "autochoice15";
    }

    public void telechoice16(View view) {
        autochoice16.setChecked(true);
        autochoice15.setChecked(false);
        autogrup9 = "autochoice16";
    }

    public void telechoice17(View view) {
        autochoice17.setChecked(true);
        autochoice18.setChecked(false);
        autogrup10 = "autochoice17";
    }

    public void telechoice18(View view) {
        autochoice18.setChecked(true);
        autochoice17.setChecked(false);
        autogrup10 = "autochoice18";
    }

}