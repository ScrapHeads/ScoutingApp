package com.example.myfirstapp;


import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Tele extends AppCompatActivity {
    RadioButton park, noPark, LevleOne, LevleTwo,LevleThree, noparked, barlyparked, fullparked, parkedwithothers;
    TextView teleNetZoneText, teleLowBasketText, teleHighBasketText,teleHiChamberText,teleloChamberText, overflowtxt, OverallpointS,text1,text2,text3,text4,text5,text6,text7,text8,text9;
    byte teleNetZone = 0, teleLowBasket = 0, teleHighBasket = 0,teleHiChamber=0, teleloChamber=0, Overflow=0, Overallpoints=0;
    CheckBox telechoice1, telechoice2, telechoice3, telechoice4, telechoice5, telechoice6, telechoice7, telechoice8, telechoice9, telechoice10, telechoice11, telechoice12, telechoice13, telechoice14, telechoice15, telechoice16, telechoice17, telechoice18;
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
        telechoice1 = findViewById(R.id.telecheckbox1);
        telechoice2 = findViewById(R.id.telecheckbox2);
        telechoice3 = findViewById(R.id.telecheckbox3);
        telechoice4 = findViewById(R.id.telecheckbox4);
        telechoice5 = findViewById(R.id.telecheckbox5);
        telechoice6 = findViewById(R.id.telecheckbox6);
        telechoice7 = findViewById(R.id.telecheckbox7);
        telechoice8 = findViewById(R.id.telecheckbox8);
        telechoice9 = findViewById(R.id.telecheckbox9);
        telechoice10 = findViewById(R.id.telecheckbox10);
        telechoice11 = findViewById(R.id.telecheckbox11);
        telechoice12 = findViewById(R.id.telecheckbox12);
        telechoice13 = findViewById(R.id.telecheckbox13);
        telechoice14 = findViewById(R.id.telecheckbox14);
        telechoice15 = findViewById(R.id.telecheckbox15);
        telechoice16 = findViewById(R.id.telecheckbox16);
        telechoice17 = findViewById(R.id.telecheckbox17);
        telechoice18 = findViewById(R.id.telecheckbox18);
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
        autogrup1 = RecordsActivity.Info.autogrup1;
        autogrup2 = RecordsActivity.Info.autogrup2;
        autogrup3 = RecordsActivity.Info.autogrup3;
        autogrup4 = RecordsActivity.Info.autogrup4;
        autogrup5 = RecordsActivity.Info.autogrup5;
        autogrup6 = RecordsActivity.Info.autogrup6;

        OverallpointS.setText(String.valueOf((RecordsActivity.Info.teleOverallpoint)));



        autogrup7 = RecordsActivity.Info.autogrup7;
        autogrup8 = RecordsActivity.Info.autogrup8;
        autogrup9 = RecordsActivity.Info.autogrup9;
        autogrup10 = RecordsActivity.Info.autogrup10;
        autogrup11 = RecordsActivity.Info.autogrup11;
        autogrup12 = RecordsActivity.Info.autogrup12;
        autogrup13 = RecordsActivity.Info.autogrup13;
        autogrup14 = RecordsActivity.Info.autogrup14;
        autogrup15 = RecordsActivity.Info.autogrup15;
        autogrup16 = RecordsActivity.Info.autogrup16;
        autogrup17 = RecordsActivity.Info.autogrup17;
        autogrup18 = RecordsActivity.Info.autogrup18;

        if (Objects.equals(teleBotAscent, "park")){
            noPark.setChecked(false);
            LevleOne.setChecked(false);
            LevleTwo.setChecked(false);
            LevleThree.setChecked(false);
            park.setChecked(true);
        }
        if (Objects.equals(teleBotAscent, "noPark")){
            park.setChecked(false);
            LevleOne.setChecked(false);
            LevleTwo.setChecked(false);
            LevleThree.setChecked(false);
            noPark.setChecked(true);
        }
        if (Objects.equals(teleBotAscent, "lvlOne")){
            park.setChecked(false);
            noPark.setChecked(false);
            LevleTwo.setChecked(false);
            LevleThree.setChecked(false);
            LevleOne.setChecked(true);
        }
        if (Objects.equals(teleBotAscent, "LvlTwo")){
            park.setChecked(false);
            LevleOne.setChecked(false);
            LevleThree.setChecked(false);
            noPark.setChecked(false);
            LevleTwo.setChecked(true);
        }
        if (Objects.equals(teleBotAscent, "LvlThree")) {
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
        if (Objects.equals(parked, "noparked")){
            barlyparked.setChecked(false);
            fullparked.setChecked(false);
            parkedwithothers.setChecked(false);
            noparked.setChecked(true);
        }
        if (Objects.equals(parked, "barlyparked")){
            fullparked.setChecked(false);
            parkedwithothers.setChecked(false);
            noparked.setChecked(false);
            barlyparked.setChecked(true);
        }
        if (Objects.equals(parked, "fullparked")){
            barlyparked.setChecked(false);
            parkedwithothers.setChecked(false);
            noparked.setChecked(false);
            fullparked.setChecked(true);
        }
        if (Objects.equals(parked, "parkedwithothers")){
            barlyparked.setChecked(false);
            fullparked.setChecked(false);
            noparked.setChecked(false);
            parkedwithothers.setChecked(true);
        }
        if (Objects.equals(autogrup1, "Green")) {
            telechoice1.setChecked(true);
            telechoice2.setChecked(false);
        }
        if (Objects.equals(autogrup1, "purple")) {
            telechoice1.setChecked(false);
            telechoice2.setChecked(true);
        }
        if (Objects.equals(autogrup2, "Green")) {
            telechoice3.setChecked(true);
            telechoice4.setChecked(false);
        }
        if (Objects.equals(autogrup2, "purple")) {
            telechoice4.setChecked(true);
            telechoice3.setChecked(false);
        }
        if (Objects.equals(autogrup3, "Green")) {
            telechoice5.setChecked(true);
            telechoice6.setChecked(false);
        }
        if (Objects.equals(autogrup3, "purple")) {
            telechoice6.setChecked(true);
            telechoice5.setChecked(false);
        }
        if (Objects.equals(autogrup4, "Green")) {
            telechoice7.setChecked(true);
            telechoice8.setChecked(false);
        }
        if (Objects.equals(autogrup4, "purple")) {
            telechoice8.setChecked(true);
            telechoice7.setChecked(false);
        }
        if (Objects.equals(autogrup5, "Green")) {
            telechoice9.setChecked(true);
            telechoice10.setChecked(false);
        }
        if (Objects.equals(autogrup5, "purple")) {
            telechoice10.setChecked(true);
            telechoice9.setChecked(false);
        }
        if (Objects.equals(autogrup6, "Green")) {
            telechoice11.setChecked(true);
            telechoice12.setChecked(false);
        }
        if (Objects.equals(autogrup6, "purple")) {
            telechoice12.setChecked(true);
            telechoice11.setChecked(false);
        }
        if (Objects.equals(autogrup7, "Green")) {
            telechoice13.setChecked(true);
            telechoice14.setChecked(false);
        }
        if (Objects.equals(autogrup7, "purple")) {
            telechoice14.setChecked(true);
            telechoice13.setChecked(false);
        }
        if (Objects.equals(autogrup8, "Green")) {
            telechoice15.setChecked(true);
            telechoice16.setChecked(false);
        }
        if (Objects.equals(autogrup8, "purple")) {
            telechoice16.setChecked(true);
            telechoice15.setChecked(false);
        }
        if (Objects.equals(autogrup9, "Green")) {
            telechoice17.setChecked(true);
            telechoice18.setChecked(false);
        }
        if (Objects.equals(autogrup9, "purple")) {
            telechoice18.setChecked(true);
            telechoice17.setChecked(false);
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
        AUTOsave.putExtra("Green", String.valueOf(autogrup1));
        RecordsActivity.Info.telegrup2 = autogrup2;
        AUTOsave.putExtra("purple", String.valueOf(autogrup2));
        RecordsActivity.Info.telegrup3 = autogrup3;
        AUTOsave.putExtra("Green", String.valueOf(autogrup3));
        RecordsActivity.Info.telegrup4 = autogrup4;
        AUTOsave.putExtra("purple", String.valueOf(autogrup4));
        RecordsActivity.Info.telegrup5 = autogrup5;
        AUTOsave.putExtra("Green", String.valueOf(autogrup5));
        RecordsActivity.Info.telegrup6 = autogrup6;
        AUTOsave.putExtra("purple", String.valueOf(autogrup6));
        RecordsActivity.Info.telegrup7 = autogrup7;
        AUTOsave.putExtra("Green", String.valueOf(autogrup7));
        RecordsActivity.Info.telegrup8 = autogrup8;
        AUTOsave.putExtra("purple", String.valueOf(autogrup8));
        RecordsActivity.Info.telegrup9 = autogrup9;
        AUTOsave.putExtra("Green", String.valueOf(autogrup9));
        RecordsActivity.Info.telegrup10 = autogrup10;
        AUTOsave.putExtra("purple", String.valueOf(autogrup10));
        RecordsActivity.Info.telegrup11 = autogrup11;
        AUTOsave.putExtra("Green", String.valueOf(autogrup11));
        RecordsActivity.Info.telegrup12 = autogrup12;
        AUTOsave.putExtra("purple", String.valueOf(autogrup12));
        RecordsActivity.Info.telegrup13 = autogrup13;
        AUTOsave.putExtra("Green", String.valueOf(autogrup13));
        RecordsActivity.Info.telegrup14 = autogrup14;
        AUTOsave.putExtra("purple", String.valueOf(autogrup14));
        RecordsActivity.Info.telegrup15 = autogrup15;
        AUTOsave.putExtra("Green", String.valueOf(autogrup15));
        RecordsActivity.Info.telegrup16 = autogrup16;
        AUTOsave.putExtra("purple", String.valueOf(autogrup16));
        RecordsActivity.Info.telegrup17 = autogrup17;
        AUTOsave.putExtra("Green", String.valueOf(autogrup17));
        RecordsActivity.Info.telegrup18 = autogrup18;
        AUTOsave.putExtra("purple", String.valueOf(autogrup18));

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

        teleBotAscent="lvlOne";  Log.d("levleOne", teleBotAscent);
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
        //telechoice1.setChecked(true);
        telechoice2.setChecked(false);
        autogrup1 = "Green";
    }

    public void telechoice2(View view) {
        //telechoice2.setChecked(true);
        telechoice1.setChecked(false);
        autogrup1 = "purple";
    }

    public void telechoice3(View view) {
        //telechoice3.setChecked(true);
        telechoice4.setChecked(false);
        autogrup2 = "Green";
    }

    public void telechoice4(View view) {
        //telechoice4.setChecked(true);
        telechoice3.setChecked(false);
        autogrup2 = "purple";
    }

    public void telechoice5(View view) {
        //telechoice5.setChecked(true);
        telechoice6.setChecked(false);
        autogrup3 = "Green";
    }

    public void telechoice6(View view) {
        //telechoice6.setChecked(true);
        telechoice5.setChecked(false);
        autogrup3 = "purple";
    }

    public void telechoice7(View view) {
        //telechoice7.setChecked(true);
        telechoice8.setChecked(false);
        autogrup4 = "Green";
    }

    public void telechoice8(View view) {
        //telechoice8.setChecked(true);
        telechoice7.setChecked(false);
        autogrup4 = "purple";
    }

    public void telechoice9(View view) {
        //telechoice9.setChecked(true);
        telechoice10.setChecked(false);
        autogrup5 = "Green";
    }

    public void telechoice10(View view) {
        //telechoice10.setChecked(true);
        telechoice9.setChecked(false);
        autogrup5 = "purple";
    }

    public void telechoice11(View view) {
        //telechoice11.setChecked(true);
        telechoice12.setChecked(false);
        autogrup6 = "Green";
    }

    public void telechoice12(View view) {
        //telechoice12.setChecked(true);
        telechoice11.setChecked(false);
        autogrup6 = "purple";
    }

    public void telechoice13(View view) {
        //telechoice13.setChecked(true);
        telechoice14.setChecked(false);
        autogrup7 = "Green";
    }

    public void telechoice14(View view) {
        //telechoice14.setChecked(true);
        telechoice13.setChecked(false);
        autogrup7 = "purple";
    }

    public void telechoice15(View view) {
        //telechoice15.setChecked(true);
        telechoice16.setChecked(false);
        autogrup8 = "Green";
    }

    public void telechoice16(View view) {
        // telechoice16.setChecked(true);
        telechoice15.setChecked(false);
        autogrup8 = "purple";
    }

    public void telechoice17(View view) {
        //telechoice17.setChecked(true);
        telechoice18.setChecked(false);
        autogrup9 = "Green";
    }

    public void telechoice18(View view) {
        //telechoice18.setChecked(true);
        telechoice17.setChecked(false);
        autogrup9 = "purple";
    }
    public void teleclear(View view){
        if (telechoice1 != null) telechoice1.setChecked(false);
        if (telechoice2 != null) telechoice2.setChecked(false);
        if (telechoice3 != null) telechoice3.setChecked(false);
        if (telechoice4 != null) telechoice4.setChecked(false);
        if (telechoice5 != null) telechoice5.setChecked(false);
        if (telechoice6 != null) telechoice6.setChecked(false);
        if (telechoice7 != null) telechoice7.setChecked(false);
        if (telechoice8 != null) telechoice8.setChecked(false);
        if (telechoice9 != null) telechoice9.setChecked(false);
        if (telechoice10 != null) telechoice10.setChecked(false);
        if (telechoice11 != null) telechoice11.setChecked(false);
        if (telechoice12 != null) telechoice12.setChecked(false);
        if (telechoice13 != null) telechoice13.setChecked(false);
        if (telechoice14 != null) telechoice14.setChecked(false);
        if (telechoice15 != null) telechoice15.setChecked(false);
        if (telechoice16 != null) telechoice16.setChecked(false);
        if (telechoice17 != null) telechoice17.setChecked(false);
        if (telechoice18 != null) telechoice18.setChecked(false);
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