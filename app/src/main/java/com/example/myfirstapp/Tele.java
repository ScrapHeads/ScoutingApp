package com.example.myfirstapp;


import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class Tele extends AppCompatActivity {
    RadioButton park, noPark, LevleOne, LevleTwo,LevleThree, noparked, barlyparked, fullparked, parkedwithothers, telychoice1, telychoice2, telychoice3, telychoice4, telychoice5, telychoice6, telychoice7, telychoice8, telychoice9, telychoice10, telychoice11, telychoice12, telychoice13, telychoice14, telychoice15, telychoice16, telychoice17, telychoice18;
    TextView teleNetZoneText, teleLowBasketText, teleHighBasketText,teleHiChamberText,teleloChamberText, overflowtxt, OverallpointS,text1,text2,text3,text4,text5,text6,text7,text8,text9;
    byte teleNetZone = 0, teleLowBasket = 0, teleHighBasket = 0,teleHiChamber=0, teleloChamber=0, Overflow=0, Overallpoints=0;

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
        OverallpointS = findViewById(R.id.textView27);

        park =findViewById(R.id.telePark);
        noPark = findViewById(R.id.teleNoPark);
        LevleOne = findViewById(R.id.telelevel1);
        LevleTwo = findViewById(R.id.endlevel2);
        LevleThree = findViewById(R.id.endLevel3);
        noparked =findViewById(R.id.telypark1);
        barlyparked=findViewById(R.id.telybparled);
        fullparked=findViewById(R.id.telyfullpared);
        parkedwithothers=findViewById(R.id.telyparkedwithothers);
        telychoice1 = findViewById(R.id.telechoice19);
        telychoice2 = findViewById(R.id.telechoice20);
        telychoice3 = findViewById(R.id.telechoice21);
        telychoice4 = findViewById(R.id.telechoice22);
        telychoice5 = findViewById(R.id.telechoice23);
        telychoice6 = findViewById(R.id.telechoice24);
        telychoice7 = findViewById(R.id.telechoice25);
        telychoice8 = findViewById(R.id.telechoice26);
        telychoice9 = findViewById(R.id.telechoice27);
        telychoice10 = findViewById(R.id.telechoice28);
        telychoice11 = findViewById(R.id.telechoice29);
        telychoice12 = findViewById(R.id.telechoice30);
        telychoice13 = findViewById(R.id.telechoice31);
        telychoice14 = findViewById(R.id.telechoice32);
        telychoice15 = findViewById(R.id.telechoice33);
        telychoice16 = findViewById(R.id.telechoice34);
        text1=findViewById(R.id.textView14);
        text2=findViewById(R.id.textView8);
        text3=findViewById(R.id.textView9);
        text4=findViewById(R.id.textView7);
        text5=findViewById(R.id.textView12);
        text6=findViewById(R.id.textView16);
        text7=findViewById(R.id.textView15);
        text8=findViewById(R.id.textView19);
        text9=findViewById(R.id.textView17);

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

        OverallpointS.setText(String.valueOf((RecordsActivity.Info.teleOverallpoint)));



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
        if (autogrup1 == "telychoice1") {
            telychoice1.setChecked(true);
            telychoice2.setChecked(false);
        }
        if (autogrup1 == "telychoice2") {
            telychoice1.setChecked(false);
            telychoice2.setChecked(true);
        }
        if (autogrup3 == "telychoice3") {
            telychoice3.setChecked(true);
            telychoice4.setChecked(false);
        }
        if (autogrup3 == "telychoice4") {
            telychoice4.setChecked(true);
            telychoice3.setChecked(false);
        }
        if (autogrup4 == "telychoice5") {
            telychoice5.setChecked(true);
            telychoice6.setChecked(false);
        }
        if (autogrup4 == "telychoice6") {
            telychoice6.setChecked(true);
            telychoice5.setChecked(false);
        }
        if (autogrup5 == "telychoice7") {
            telychoice7.setChecked(true);
            telychoice8.setChecked(false);
        }
        if (autogrup5 == "telychoice8") {
            telychoice8.setChecked(true);
            telychoice7.setChecked(false);
        }
        if (autogrup6 == "telychoice9") {
            telychoice9.setChecked(true);
            telychoice10.setChecked(false);
        }
        if (autogrup6 == "telychoice10") {
            telychoice10.setChecked(true);
            telychoice9.setChecked(false);
        }
        if (autogrup7 == "telychoice11") {
            telychoice11.setChecked(true);
            telychoice12.setChecked(false);
        }
        if (autogrup7 == "telychoice12") {
            telychoice12.setChecked(true);
            telychoice11.setChecked(false);
        }
        if (autogrup8 == "telychoice13") {
            telychoice13.setChecked(true);
            telychoice14.setChecked(false);
        }
        if (autogrup8 == "telychoice14") {
            telychoice14.setChecked(true);
            telychoice13.setChecked(false);
        }
        if (autogrup9 == "telychoice15") {
            telychoice15.setChecked(true);
            telychoice16.setChecked(false);
        }
        if (autogrup9 == "telychoice16") {
            telychoice16.setChecked(true);
            telychoice15.setChecked(false);
        }
        if (autogrup10 == "telychoice17") {
            telychoice17.setChecked(true);
            telychoice18.setChecked(false);
        }
        if (autogrup10 == "telychoice18") {
            telychoice18.setChecked(true);
            telychoice17.setChecked(false);
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
        telychoice1.setChecked(true);
        telychoice2.setChecked(false);
        autogrup1 = "telychoice1";
    }

    public void telechoice2(View view) {
        telychoice2.setChecked(true);
        telychoice1.setChecked(false);
        autogrup1 = "telychoice2";
    }

    public void telechoice3(View view) {
        telychoice3.setChecked(true);
        telychoice4.setChecked(false);
        autogrup3 = "telychoice3";
    }

    public void telechoice4(View view) {
        telychoice4.setChecked(true);
        telychoice3.setChecked(false);
        autogrup3 = "telychoice4";
    }

    public void telechoice5(View view) {
        telychoice5.setChecked(true);
        telychoice6.setChecked(false);
        autogrup4 = "telychoice5";
    }

    public void telechoice6(View view) {
        telychoice6.setChecked(true);
        telychoice5.setChecked(false);
        autogrup4 = "telychoice6";
    }

    public void telechoice7(View view) {
        telychoice7.setChecked(true);
        telychoice8.setChecked(false);
        autogrup5 = "telychoice7";
    }

    public void telechoice8(View view) {
        telychoice8.setChecked(true);
        telychoice7.setChecked(false);
        autogrup5 = "telychoice8";
    }

    public void telechoice9(View view) {
        telychoice9.setChecked(true);
        telychoice10.setChecked(false);
        autogrup6 = "telychoice9";
    }

    public void telechoice10(View view) {
        telychoice10.setChecked(true);
        telychoice9.setChecked(false);
        autogrup6 = "telychoice10";
    }

    public void telechoice11(View view) {
        telychoice11.setChecked(true);
        telychoice12.setChecked(false);
        autogrup7 = "telychoice11";
    }

    public void telechoice12(View view) {
        telychoice12.setChecked(true);
        telychoice11.setChecked(false);
        autogrup7 = "telychoice12";
    }

    public void telechoice13(View view) {
        telychoice13.setChecked(true);
        telychoice14.setChecked(false);
        autogrup8 = "telychoice13";
    }

    public void telechoice14(View view) {
        telychoice14.setChecked(true);
        telychoice13.setChecked(false);
        autogrup8 = "telychoice14";
    }

    public void telechoice15(View view) {
        telychoice15.setChecked(true);
        telychoice16.setChecked(false);
        autogrup9 = "telychoice15";
    }

    public void telechoice16(View view) {
        telychoice16.setChecked(true);
        telychoice15.setChecked(false);
        autogrup9 = "telychoice16";
    }

    public void telechoice17(View view) {
        telychoice17.setChecked(true);
        telychoice18.setChecked(false);
        autogrup10 = "telychoice17";
    }

    public void telechoice18(View view) {
        telychoice18.setChecked(true);
        telychoice17.setChecked(false);
        autogrup10 = "telychoice18";
    }
    public void teleclear(View view){
        if (telychoice1 != null) telychoice1.setChecked(false);
        if (telychoice2 != null) telychoice2.setChecked(false);
        if (telychoice3 != null) telychoice3.setChecked(false);
        if (telychoice4 != null) telychoice4.setChecked(false);
        if (telychoice5 != null) telychoice5.setChecked(false);
        if (telychoice6 != null) telychoice6.setChecked(false);
        if (telychoice7 != null) telychoice7.setChecked(false);
        if (telychoice8 != null) telychoice8.setChecked(false);
        if (telychoice9 != null) telychoice9.setChecked(false);
        if (telychoice10 != null) telychoice10.setChecked(false);
        if (telychoice11 != null) telychoice11.setChecked(false);
        if (telychoice12 != null) telychoice12.setChecked(false);
        if (telychoice13 != null) telychoice13.setChecked(false);
        if (telychoice14 != null) telychoice14.setChecked(false);
        if (telychoice15 != null) telychoice15.setChecked(false);
        if (telychoice16 != null) telychoice16.setChecked(false);
        if (telychoice17 != null) telychoice17.setChecked(false);
        if (telychoice18 != null) telychoice18.setChecked(false);
        RecordsActivity.Info.telegrup1="";
        RecordsActivity.Info.telegrup2="";
        RecordsActivity.Info.telegrup3="";
        RecordsActivity.Info.telegrup4="";
        RecordsActivity.Info.telegrup5="";
        RecordsActivity.Info.telegrup6="";
        RecordsActivity.Info.telegrup7="";
        RecordsActivity.Info.telegrup8="";
        RecordsActivity.Info.telegrup9="";
        RecordsActivity.Info.telegrup10="";
        RecordsActivity.Info.telegrup11="";
        RecordsActivity.Info.telegrup12="";
        RecordsActivity.Info.telegrup13="";
        RecordsActivity.Info.telegrup14="";
        RecordsActivity.Info.telegrup15="";
        RecordsActivity.Info.telegrup16="";
        RecordsActivity.Info.telegrup17="";
        RecordsActivity.Info.telegrup18="";
    }

    public void OverallpointsDecres(View view){
        if (Overallpoints>0){
            Overallpoints--;
            OverallpointS.setText(String.valueOf(Overallpoints));
        }
        if (Overallpoints<=0){
            findViewById(R.id.button10).setVisibility(GONE);
        }
    }

    public void OverallpointsIncreas (View view){
        Overallpoints++;
        OverallpointS.setText(String.valueOf(Overallpoints));
        if (Overallpoints >0){
            findViewById(R.id.button10).setVisibility(VISIBLE);
        }
    }

}