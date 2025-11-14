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
import android.widget.Switch;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.TreeSet;

public class AutoActivity<pri> extends AppCompatActivity {
    RadioButton park, noPark, LevleOne, noparked, barlyparked, fullparked, parkedwithothers, ppg, gpp, pgp;
    TextView autoNetZoneText, autoLowBasketText, autoHighBasketText, AutoHiChamberText, AutoloChamberText, overflowtxt,OverallpointS, text1,text2,text3,text4,text5,text6,text7,text8,text9;
    byte autoNetZone = 0, autoLowBasket = 0, autoHighbasket = 0, AutoHiChamber = 0, AutoloChamber = 0, autoTeamPer = 0, overflow = 0, Overallpoints=0;
    String autoBotAscent, parked, pgpppggpp, autogrup1, autogrup2, autogrup3, autogrup4, autogrup5, autogrup6, autogrup7, autogrup8, autogrup9, autogrup10, autogrup11, autogrup12, autogrup13, autogrup14, autogrup15, autogrup16, autogrup17, autogrup18;
    CheckBox autochoice1, autochoice2, autochoice3, autochoice4, autochoice5, autochoice6, autochoice7, autochoice8, autochoice9, autochoice10, autochoice11, autochoice12, autochoice13, autochoice14, autochoice15, autochoice16, autochoice17, autochoice18;
    private Switch hasAuto;
    private boolean doWeHaveAuto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        overflowtxt = findViewById(R.id.textView10);
        OverallpointS = findViewById(R.id.textView24);

        autoNetZoneText = findViewById(R.id.sampleNetZoneCount);
        autoLowBasketText = findViewById(R.id.sampleLowBasketCount);
        autoHighBasketText = findViewById(R.id.sampleHighBasketCount);
        AutoHiChamberText = findViewById(R.id.specimenHCZeroText);
        AutoloChamberText = findViewById(R.id.specimenLCZeroText);
        park = findViewById(R.id.AutoPark);
        noPark = findViewById(R.id.endNoPark);
        LevleOne = findViewById(R.id.endLevel1);
        noparked = findViewById(R.id.autopark1);
        barlyparked = findViewById(R.id.autobparled);
        fullparked = findViewById(R.id.autofullpared);
        ppg = findViewById(R.id.ppg);
        gpp = findViewById(R.id.gpp);
        pgp = findViewById(R.id.pgp);
        autochoice1 = findViewById(R.id.autocheckbox1);
        autochoice2 = findViewById(R.id.autocheckbox2);
        autochoice3 = findViewById(R.id.autocheckbox3);
        autochoice4 = findViewById(R.id.autocheckbox4);
        autochoice5 = findViewById(R.id.autocheckbox5);
        autochoice6 = findViewById(R.id.autocheckbox6);
        autochoice7 = findViewById(R.id.autocheckbox7);
        autochoice8 = findViewById(R.id.autocheckbox8);
        autochoice9 = findViewById(R.id.autocheckbox9);
        autochoice10 = findViewById(R.id.autocheckbox10);
        autochoice11 = findViewById(R.id.autocheckbox11);
        autochoice12 = findViewById(R.id.autocheckbox12);
        autochoice13 = findViewById(R.id.autocheckbox13);
        autochoice14 = findViewById(R.id.autocheckbox14);
        autochoice15 = findViewById(R.id.autocheckbox15);
        autochoice16 = findViewById(R.id.autocheckbox16);
        autochoice17 = findViewById(R.id.autocheckbox17);
        autochoice18 = findViewById(R.id.autocheckbox18);
        text1=findViewById(R.id.textView34);
        text2=findViewById(R.id.textView40);
        text3=findViewById(R.id.textView39);
        text4=findViewById(R.id.textView33);
        text5=findViewById(R.id.textView36);
        text6=findViewById(R.id.textView37);
        text7=findViewById(R.id.textView35);
        text8=findViewById(R.id.textView41);
        text9=findViewById(R.id.textView42);






        RecordsActivity.Info.doWeHaveAuto = false;
        hasAuto = findViewById(R.id.switch1);
        setPrevious();
    }


    public void toSpecimen(View view) {
        Intent next = new Intent(this, Tele.class);
        saveData();
        startActivity(next);
    }

    public void No_Auto(View view) {
        Intent no_Auto = new Intent(this, Tele.class);
        noPark.setChecked(false);
        LevleOne.setChecked(false);
        park.setChecked(false);
        autoNetZoneText.setText("0");
        autoLowBasketText.setText("0");
        autoHighBasketText.setText("0");
        autoBotAscent = String.valueOf(0);
        AutoHiChamberText.setText("0");
        AutoloChamberText.setText("0");
        RecordsActivity.Info.doWeHaveAuto = true;
        saveData();
        startActivity(no_Auto);
    }

    public void setPrevious() {
        Log.d("AASet Previous", "run Set Previous");
        Intent previous = getIntent();
        Log.d("AASet Previous", "Start unpacking Suitcase");
        autoNetZoneText.setText(previous.getStringExtra("netZoneText"));
        Log.d("AASet Previous", "netZoneText = " + autoNetZoneText.getText().toString());
        Log.d("AASet Previous", "autoNetZoneText" + String.valueOf(RecordsActivity.Info.autoNetZoneText));
        autoNetZoneText.setText(String.valueOf(RecordsActivity.Info.autoNetZoneText));
        autoLowBasketText.setText(previous.getStringExtra("lowBasketText"));
        Log.d("AASet Previous", "lowBasketText = " + autoLowBasketText.getText().toString());
        Log.d("AASet Previous", "autoLowBasketText" + String.valueOf(RecordsActivity.Info.autoLowBasketText));
        autoLowBasketText.setText(String.valueOf(RecordsActivity.Info.autoLowBasketText));
        autoHighBasketText.setText(previous.getStringExtra("highBasketText"));
        Log.d("AASet Previous", "highBasketText = " + autoHighBasketText.getText().toString());
        Log.d("AASet Previous", "autoHighBasketText" + String.valueOf(RecordsActivity.Info.autoHighBasketText));
        autoHighBasketText.setText(String.valueOf(RecordsActivity.Info.autoHighBasketText));
        AutoHiChamberText.setText(previous.getStringExtra("AutoHiChamberText"));
        Log.d("AASet Previous", "AutoHiChamberText = " + AutoHiChamberText.getText().toString());
        Log.d("AASet Previous", "autoHighChamberText" + String.valueOf(RecordsActivity.Info.autoHighChamberText));
        AutoHiChamberText.setText(String.valueOf(RecordsActivity.Info.autoHighChamberText));
        AutoloChamberText.setText(previous.getStringExtra("AutoloChamberText"));
        Log.d("AASet Previous", "AutoloChamberText = " + AutoloChamberText.getText().toString());
        Log.d("AASet Previous", "autoLowChamberText" + String.valueOf(RecordsActivity.Info.autoLowChamberText));
        AutoloChamberText.setText(String.valueOf(RecordsActivity.Info.autoLowChamberText));
        autoBotAscent = previous.getStringExtra("autoBotAscent");
        Log.d("AASet Previous", "autoBotAscent = " + autoBotAscent);
        Log.d("AASet Previous", "AutoAscent" + String.valueOf(RecordsActivity.Info.AutoAscent));
        autoBotAscent = RecordsActivity.Info.AutoAscent;
        overflowtxt.setText(String.valueOf(RecordsActivity.Info.overflowtxtauto));

        OverallpointS.setText(String.valueOf((RecordsActivity.Info.AutoOverallpoint)));

        parked = RecordsActivity.Info.parkedAuto;
        pgpppggpp = RecordsActivity.Info.ppggpppgp;
        autogrup1 = RecordsActivity.Info.autogrup1;
        autogrup2 = RecordsActivity.Info.autogrup2;
        autogrup3 = RecordsActivity.Info.autogrup3;
        autogrup4 = RecordsActivity.Info.autogrup4;
        autogrup5 = RecordsActivity.Info.autogrup5;
        autogrup6 = RecordsActivity.Info.autogrup6;
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


        if (autoBotAscent == "noPark") {
            park.setChecked(false);
            LevleOne.setChecked(false);
            noPark.setChecked(true);
        }
        if (autoBotAscent == "park") {
            noPark.setChecked(false);
            LevleOne.setChecked(false);
            park.setChecked(true);
        }
        if (autoBotAscent == "LevleOne") {
            noPark.setChecked(false);
            park.setChecked(false);
            LevleOne.setChecked(true);
        }
        if (parked == "noparked") {
            barlyparked.setChecked(false);
            fullparked.setChecked(false);
            parkedwithothers.setChecked(false);
            noparked.setChecked(true);
        }
        if (parked == "barlyparked") {
            fullparked.setChecked(false);
            parkedwithothers.setChecked(false);
            noparked.setChecked(false);
            barlyparked.setChecked(true);
        }
        if (parked == "fullparked") {
            barlyparked.setChecked(false);
            parkedwithothers.setChecked(false);
            noparked.setChecked(false);
            fullparked.setChecked(true);
        }
        if (parked == "parkedwithothers") {
            barlyparked.setChecked(false);
            fullparked.setChecked(false);
            noparked.setChecked(false);
            parkedwithothers.setChecked(true);
        }

        overflow = Byte.parseByte(overflowtxt.getText().toString());
        if (overflow == 0) {
            findViewById(R.id.button5).setVisibility(GONE);
        }
        overflow = Byte.parseByte(overflowtxt.getText().toString());
        if (overflow > 0) {
            findViewById(R.id.button5).setVisibility(VISIBLE);
        }

        Overallpoints = Byte.parseByte(OverallpointS.getText().toString());
        if (Overallpoints == 0) {
            findViewById(R.id.button3).setVisibility(GONE);
        }
        Overallpoints = Byte.parseByte(OverallpointS.getText().toString());
        if (Overallpoints > 0) {
            findViewById(R.id.button3).setVisibility(VISIBLE);
        }


        if (pgpppggpp == "pgp") {
            pgp.setChecked(true);
            gpp.setChecked(false);
            ppg.setChecked(false);
            text1.setText("p");
            text2.setText("g");
            text3.setText("p");
            text4.setText("p");
            text5.setText("g");
            text6.setText("p");
            text7.setText("p");
        }
        if (pgpppggpp == "ppg") {
            ppg.setChecked(true);
            gpp.setChecked(false);
            pgp.setChecked(false);
        }
        if (pgpppggpp == "gpp") {
            gpp.setChecked(true);
            pgp.setChecked(false);
            ppg.setChecked(false);
        }
        if (autogrup1 == "Green") {
            autochoice1.setChecked(true);
            autochoice2.setChecked(false);
        }
        if (autogrup1 == "purple") {
            autochoice1.setChecked(false);
            autochoice2.setChecked(true);
        }
        if (autogrup2 == "Green") {
            autochoice3.setChecked(true);
            autochoice4.setChecked(false);
        }
        if (autogrup2 == "purple") {
            autochoice4.setChecked(true);
            autochoice3.setChecked(false);
        }
        if (autogrup3 == "Green") {
            autochoice5.setChecked(true);
            autochoice6.setChecked(false);
        }
        if (autogrup3 == "purple") {
            autochoice6.setChecked(true);
            autochoice5.setChecked(false);
        }
        if (autogrup4 == "Green") {
            autochoice7.setChecked(true);
            autochoice8.setChecked(false);
        }
        if (autogrup4 == "purple") {
            autochoice8.setChecked(true);
            autochoice7.setChecked(false);
        }
        if (autogrup5 == "Green") {
            autochoice9.setChecked(true);
            autochoice10.setChecked(false);
        }
        if (autogrup5 == "purple") {
            autochoice10.setChecked(true);
            autochoice9.setChecked(false);
        }
        if (autogrup6 == "Green") {
            autochoice11.setChecked(true);
            autochoice12.setChecked(false);
        }
        if (autogrup6 == "purple") {
            autochoice12.setChecked(true);
            autochoice11.setChecked(false);
        }
        if (autogrup7 == "Green") {
            autochoice13.setChecked(true);
            autochoice14.setChecked(false);
        }
        if (autogrup7 == "purple") {
            autochoice14.setChecked(true);
            autochoice13.setChecked(false);
        }
        if (autogrup8 == "Green") {
            autochoice15.setChecked(true);
            autochoice16.setChecked(false);
        }
        if (autogrup8 == "purple") {
            autochoice16.setChecked(true);
            autochoice15.setChecked(false);
        }
        if (autogrup9 == "Green") {
            autochoice17.setChecked(true);
            autochoice18.setChecked(false);
        }
        if (autogrup9 == "purple") {
            autochoice18.setChecked(true);
            autochoice17.setChecked(false);
        }


        if (RecordsActivity.Info.doWeHaveAuto = true) {
            hasAuto.setChecked(false);
        }
        if (RecordsActivity.Info.doWeHaveAuto = false) {

            hasAuto.setChecked(true);
        }


        autoNetZone = Byte.parseByte(autoNetZoneText.getText().toString());
        if (autoNetZone == 0) {
            Log.d("AASet Previous", String.valueOf(autoNetZone));
            findViewById(R.id.sampleNetSubtract).setVisibility(INVISIBLE);
            Log.d("AASet Previous", "INVISIBLE");
        }
        autoNetZone = Byte.parseByte(autoNetZoneText.getText().toString());
        if (autoNetZone > 0) {
            Log.d("AASet Previous", String.valueOf(autoNetZone));
            findViewById(R.id.sampleNetSubtract).setVisibility(VISIBLE);
            Log.d("AASet Previous", "VISIBLE");
        }
        AutoloChamber = Byte.parseByte(AutoloChamberText.getText().toString());
        if (AutoloChamber == 0) {
            findViewById(R.id.specimenLCSubtractionButton).setVisibility(GONE);
        }
        if (AutoloChamber > 0) {
            Log.d("AASet Previous", String.valueOf(autoNetZone));
            findViewById(R.id.specimenLCSubtractionButton).setVisibility(VISIBLE);
            Log.d("AASet Previous", "VISIBLE");
        }
        AutoHiChamber = Byte.parseByte(AutoHiChamberText.getText().toString());
        if (AutoHiChamber == 0) {
            findViewById(R.id.specimenHCSubtractionButton4).setVisibility(GONE);
        }
        if (AutoHiChamber > 0) {
            Log.d("AASet Previous", String.valueOf(autoNetZone));
            findViewById(R.id.specimenHCSubtractionButton4).setVisibility(VISIBLE);
            Log.d("AASet Previous", "VISIBLE");
        }
        autoLowBasket = Byte.parseByte(autoLowBasketText.getText().toString());
        if (autoLowBasket == 0) {
            findViewById(R.id.sampleLowBasketSubtract).setVisibility(GONE);
        }
        if (autoLowBasket > 0) {
            Log.d("AASet Previous", String.valueOf(autoNetZone));
            findViewById(R.id.sampleLowBasketSubtract).setVisibility(VISIBLE);
            Log.d("AASet Previous", "VISIBLE");
        }
        autoHighbasket = Byte.parseByte(autoHighBasketText.getText().toString());
        if (autoHighbasket == 0) {
            findViewById(R.id.sampleHighBasketSubtract).setVisibility(GONE);
        }
        if (autoHighbasket > 0) {
            Log.d("AASet Previous", String.valueOf(autoNetZone));
            findViewById(R.id.sampleHighBasketSubtract).setVisibility(VISIBLE);
            Log.d("AASet Previous", "VISIBLE");
        }
        Log.d("AASet Previous", "Exit Set Previous");
    }

    public final class Math extends Object {
        byte autoTeamPer;


    }


    public void saveData() {
        Log.d("BackClick", "Start Save Data");
        Intent AUTOsave = new Intent(this, RecordsActivity.class);
        Log.d("BackClick", "RecordsActivity");
        RecordsActivity.Info.autoNetZoneText = Byte.parseByte(autoNetZoneText.getText().toString());
        Log.d("AAput", "autoNetZoneText" + autoNetZoneText.getText().toString());
        Log.d("AAput", String.valueOf(RecordsActivity.Info.autoNetZoneText));
        AUTOsave.putExtra("netZoneText", autoNetZoneText.getText().toString());
        RecordsActivity.Info.autoLowBasketText = Byte.parseByte(autoLowBasketText.getText().toString());
        Log.d("AAput", "autoLowBasketText" + autoLowBasketText.getText().toString());
        Log.d("AAput", String.valueOf(RecordsActivity.Info.autoLowBasketText));
        AUTOsave.putExtra("lowBasketText", autoLowBasketText.getText().toString());
        RecordsActivity.Info.autoHighBasketText = Byte.parseByte(autoHighBasketText.getText().toString());
        Log.d("AAput", "autoHighBasketText" + autoHighBasketText.getText().toString());
        Log.d("AAput", String.valueOf(RecordsActivity.Info.autoHighBasketText));
        AUTOsave.putExtra("highBasketText", autoHighBasketText.getText().toString());
        RecordsActivity.Info.AutoAscent = autoBotAscent;
        Log.d("AAput", "autoBotAscent" + autoBotAscent);
        Log.d("AAput", String.valueOf(RecordsActivity.Info.AutoAscent));
        AUTOsave.putExtra("autoBotAscent", String.valueOf(autoBotAscent));
        RecordsActivity.Info.autoHighChamberText = Byte.parseByte(AutoHiChamberText.getText().toString());
        Log.d("AAput", "AutoHiChamberText" + AutoHiChamberText.getText().toString());
        Log.d("AAput", String.valueOf(RecordsActivity.Info.autoHighChamberText));
        AUTOsave.putExtra("AutoHiChamberText", AutoHiChamberText.getText().toString());
        RecordsActivity.Info.autoLowChamberText = Byte.parseByte(AutoloChamberText.getText().toString());
        Log.d("AAput", "AutoloChamberText" + AutoloChamberText.getText().toString());
        Log.d("AAput", String.valueOf(RecordsActivity.Info.autoLowChamberText));
        AUTOsave.putExtra("AutoloChamberText", AutoloChamberText.getText().toString());
        Log.d("BackClick", "End Save Data");
        RecordsActivity.Info.overflowtxtauto = Byte.parseByte(overflowtxt.getText().toString());
        AUTOsave.putExtra("autooverflow", overflowtxt.getText().toString());
        AUTOsave.putExtra("AutoOverallpoint", OverallpointS.getText().toString());
        RecordsActivity.Info.AutoOverallpoint = Byte.parseByte(OverallpointS.getText().toString());


        RecordsActivity.Info.parkedAuto = parked;
        AUTOsave.putExtra("parkedAuto", String.valueOf(parked));
        RecordsActivity.Info.ppggpppgp = pgpppggpp;
        AUTOsave.putExtra("ppgpgpgpp", String.valueOf(pgpppggpp));
        RecordsActivity.Info.autogrup1 = autogrup1;
        AUTOsave.putExtra("Green", String.valueOf(autogrup1));
        RecordsActivity.Info.autogrup2 = autogrup2;
        AUTOsave.putExtra("purple", String.valueOf(autogrup2));
        RecordsActivity.Info.autogrup3 = autogrup3;
        AUTOsave.putExtra("Green", String.valueOf(autogrup3));
        RecordsActivity.Info.autogrup4 = autogrup4;
        AUTOsave.putExtra("purple", String.valueOf(autogrup4));
        RecordsActivity.Info.autogrup5 = autogrup5;
        AUTOsave.putExtra("Green", String.valueOf(autogrup5));
        RecordsActivity.Info.autogrup6 = autogrup6;
        AUTOsave.putExtra("purple", String.valueOf(autogrup6));
        RecordsActivity.Info.autogrup7 = autogrup7;
        AUTOsave.putExtra("Green", String.valueOf(autogrup7));
        RecordsActivity.Info.autogrup8 = autogrup8;
        AUTOsave.putExtra("purple", String.valueOf(autogrup8));
        RecordsActivity.Info.autogrup9 = autogrup9;
        AUTOsave.putExtra("Green", String.valueOf(autogrup9));
        RecordsActivity.Info.autogrup10 = autogrup10;
        AUTOsave.putExtra("purple", String.valueOf(autogrup10));
        RecordsActivity.Info.autogrup11 = autogrup11;
        AUTOsave.putExtra("Green", String.valueOf(autogrup11));
        RecordsActivity.Info.autogrup12 = autogrup12;
        AUTOsave.putExtra("purple", String.valueOf(autogrup12));
        RecordsActivity.Info.autogrup13 = autogrup13;
        AUTOsave.putExtra("Green", String.valueOf(autogrup13));
        RecordsActivity.Info.autogrup14 = autogrup14;
        AUTOsave.putExtra("purple", String.valueOf(autogrup14));
        RecordsActivity.Info.autogrup15 = autogrup15;
        AUTOsave.putExtra("Green", String.valueOf(autogrup15));
        RecordsActivity.Info.autogrup16 = autogrup16;
        AUTOsave.putExtra("purple", String.valueOf(autogrup16));
        RecordsActivity.Info.autogrup17 = autogrup17;
        AUTOsave.putExtra("Green", String.valueOf(autogrup17));
        RecordsActivity.Info.autogrup18 = autogrup18;
        AUTOsave.putExtra("purple", String.valueOf(autogrup18));
        if (hasAuto.equals(true)){
            RecordsActivity.Info.doWeHaveAuto=false;
        }
        if (hasAuto.equals(false)){
            RecordsActivity.Info.doWeHaveAuto=true;
        }
        RecordsActivity.Info.doWeHaveAuto= Boolean.parseBoolean(String.valueOf(doWeHaveAuto));
        AUTOsave.putExtra("doWeHaveAuto", doWeHaveAuto);


    }

    public void backMain(View view) {
        Intent news = new Intent(this, preGameInfo.class);
        Log.d("BackClick", "load main activity");
        saveData();
        Log.d("BackClick", "Start Save Data");
        startActivity(news);
        Log.d("BackClick", "Start Main Acitivity");
    }

    public void netZoneIncrease(View view) {
        //findViewById(R.id.sampleNetSubtract).setVisibility(VISIBLE);
        RecordsActivity.Info.doWeHaveAuto = false;
        autoNetZone++;
        autoNetZoneText.setText(String.valueOf(autoNetZone));

        if (autoNetZone > 0) {
            findViewById(R.id.sampleNetSubtract).setVisibility(VISIBLE);
        }
    }

    public void netZoneDecrease(View view) {
        ;
        if (autoNetZone > 0) {
            RecordsActivity.Info.doWeHaveAuto = false;
            autoNetZone--;
            autoNetZoneText.setText(String.valueOf(autoNetZone));

        }
        if (autoNetZone <= 0) {
            findViewById(R.id.sampleNetSubtract).setVisibility(GONE);
        }
    }

    public void lowChamberIncrease(View view) {
        //findViewById(R.id.specimenLCSubtractionButton).setVisibility(VISIBLE);
        RecordsActivity.Info.doWeHaveAuto = false;
        AutoloChamber++;
        AutoloChamberText.setText(String.valueOf(AutoloChamber));
        if (AutoloChamber > 0) {
            findViewById(R.id.specimenLCSubtractionButton).setVisibility(VISIBLE);
        }
    }

    public void lowChamberDecrease(View view) {
        if (AutoloChamber > 0) {
            RecordsActivity.Info.doWeHaveAuto = false;
            AutoloChamber--;
            AutoloChamberText.setText(String.valueOf(AutoloChamber));

        }
        if (AutoloChamber <= 0) {
            findViewById(R.id.specimenLCSubtractionButton).setVisibility(GONE);
        }
    }

    public void lowBasketIncrease(View view) {
        findViewById(R.id.sampleLowBasketSubtract).setVisibility(VISIBLE);
        RecordsActivity.Info.doWeHaveAuto = false;
        autoLowBasket++;
        autoLowBasketText.setText(String.valueOf(autoLowBasket));
    }

    public void highChamberIncrease(View view) {
        //findViewById(R.id.specimenHCSubtractionButton4).setVisibility(VISIBLE);
        RecordsActivity.Info.doWeHaveAuto = false;
        AutoHiChamber++;
        AutoHiChamberText.setText(String.valueOf(AutoHiChamber));
        if (AutoHiChamber > 0) {
            findViewById(R.id.specimenHCSubtractionButton4).setVisibility(VISIBLE);
        }
    }

    public void highChamberDecrease(View view) {
        if (AutoHiChamber > 0) {
            RecordsActivity.Info.doWeHaveAuto = false;
            AutoHiChamber--;
            AutoHiChamberText.setText(String.valueOf(AutoHiChamber));
            if (AutoHiChamber <= 0) {
                findViewById(R.id.specimenHCSubtractionButton4).setVisibility(GONE);
            }
        }
    }

    public void lowBasketDecrease(View view) {
        if (autoLowBasket > 0) {
            RecordsActivity.Info.doWeHaveAuto = false;
            autoLowBasket--;
            autoLowBasketText.setText(String.valueOf(autoLowBasket));
        }
        if (autoLowBasket <= 0) {
            findViewById(R.id.sampleLowBasketSubtract).setVisibility(GONE);
        }
    }

    public void highBasketIncrease(View view) {
        findViewById(R.id.sampleHighBasketSubtract).setVisibility(VISIBLE);
        RecordsActivity.Info.doWeHaveAuto = false;
        autoHighbasket++;
        autoHighBasketText.setText(String.valueOf(autoHighbasket));
    }

    public void highBasketDecrease(View view) {
        if (autoHighbasket > 0) {
            RecordsActivity.Info.doWeHaveAuto = false;
            autoHighbasket--;
            autoHighBasketText.setText(String.valueOf(autoHighbasket));
        }
        if (autoHighbasket <= 0) {
            findViewById(R.id.sampleHighBasketSubtract).setVisibility(GONE);
        }

    }

    public void ClickPark(View view) {
        RecordsActivity.Info.doWeHaveAuto = false;
        noPark.setChecked(false);
        LevleOne.setChecked(false);
        park.setChecked(true);
        autoBotAscent = "park";
    }

    public void ClickNoPark(View view) {
        RecordsActivity.Info.doWeHaveAuto = false;
        Log.d("NoParkClick", "starting method");
        park.setChecked(false);
        Log.d("NoParkClick", "set Park false");
        LevleOne.setChecked(false);
        Log.d("NoParkClick", "set levleOne true");
        noPark.setChecked(true);
        Log.d("NoParkClick", "set NoPark true");
        autoBotAscent = "noPark";
    }

    public void ClickLevleOne(View view) {
        RecordsActivity.Info.doWeHaveAuto = false;
        park.setChecked(false);
        Log.d("LevleOne", "set park false");
        noPark.setChecked(false);
        Log.d("LevleOne", "set noPark false");
        LevleOne.setChecked(true);
        Log.d("LevleOne", "set LevleOne true");

        autoBotAscent = "LevleOne";
        Log.d("LevleOne", String.valueOf(autoBotAscent));
        Log.d("LevleOne", String.valueOf(autoBotAscent));
    }

    public void overflowIncreas(View view) {
        overflow++;
        overflowtxt.setText(String.valueOf(overflow));
        if (overflow > 0) {
            findViewById(R.id.button5).setVisibility(VISIBLE);
        }
    }
    public void overflowDecres(View view) {
        if (overflow > 0) {
            overflow--;
            overflowtxt.setText(String.valueOf(overflow));
        }
        if (overflow <= 0) {
            findViewById(R.id.button5).setVisibility(GONE);
        }
    }

    public void OverallpointsDecres(View view){
        if (Overallpoints>0){
            Overallpoints--;
            OverallpointS.setText(String.valueOf(Overallpoints));
        }
        if (Overallpoints<=0){
            findViewById(R.id.button3).setVisibility(GONE);
        }
    }

    public void OverallpointsIncreas (View view){
        Overallpoints++;
        OverallpointS.setText(String.valueOf(Overallpoints));
        if (Overallpoints >0){
            findViewById(R.id.button3).setVisibility(VISIBLE);
        }
    }

    public void clickdidnotparked(View view) {
        barlyparked.setChecked(false);
        fullparked.setChecked(false);
        parkedwithothers.setChecked(false);
        noparked.setChecked(true);
        parked = "noparked";
    }

    public void clickbarlyparked(View view) {
        fullparked.setChecked(false);
        parkedwithothers.setChecked(false);
        noparked.setChecked(false);
        barlyparked.setChecked(true);
        parked = "barlyparked";
    }

    public void clickfullparked(View view) {
        barlyparked.setChecked(false);
        parkedwithothers.setChecked(false);
        noparked.setChecked(false);
        fullparked.setChecked(true);
        parked = "fullparked";
    }

    public void clickparkedwithothers(View view) {
        barlyparked.setChecked(false);
        fullparked.setChecked(false);
        noparked.setChecked(false);
        parkedwithothers.setChecked(true);
        parked = "parkedwithothers";
    }

    public void ppg(View view) {
        ppg.setChecked(true);
        gpp.setChecked(false);
        pgp.setChecked(false);
        pgpppggpp = "ppg";
    }

    public void pgp(View view) {
        pgp.setChecked(true);
        ppg.setChecked(false);
        gpp.setChecked(false);
        pgpppggpp = "pgp";
    }

    public void gpp(View view) {
        gpp.setChecked(true);
        ppg.setChecked(false);
        pgp.setChecked(false);
        pgpppggpp = "gpp";
    }


    private void uncheck(CheckBox a, CheckBox b) {
        if (a != null) a.setChecked(false);
        if (b != null) b.setChecked(false);
    }
    public void autochoice1(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice2.setChecked(false);
            autogrup1 = "Green";
        } else {
            autogrup1 = null;
        }
    }

    public void autochoice2(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice1.setChecked(false);
            autogrup1 = "purple";
        } else {
            autogrup1 = null;
        }
    }

    public void autochoice3(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice4.setChecked(false);
            autogrup2 = "Green";
        } else {
            autogrup2 = null;
        }
    }

    public void autochoice4(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice3.setChecked(false);
            autogrup2 = "purple";
        } else {
            autogrup2 = null;
        }
    }

    public void autochoice5(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice6.setChecked(false);
            autogrup3 = "Green";
        } else {
            autogrup3 = null;
        }
    }

    public void autochoice6(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice5.setChecked(false);
            autogrup3 = "purple";
        } else {
            autogrup3 = null;
        }
    }

    public void autochoice7(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice8.setChecked(false);
            autogrup4 = "Green";
        } else {
            autogrup4 = null;
        }
    }

    public void autochoice8(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice7.setChecked(false);
            autogrup4 = "purple";
        } else {
            autogrup4 = null;
        }
    }

    public void autochoice9(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice10.setChecked(false);
            autogrup5 = "Green";
        } else {
            autogrup5 = null;
        }
    }

    public void autochoice10(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice9.setChecked(false);
            autogrup5 = "purple";
        } else {
            autogrup5 = null;
        }
    }

    public void autochoice11(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice12.setChecked(false);
            autogrup6 = "Green";
        } else {
            autogrup6 = null;
        }
    }

    public void autochoice12(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice11.setChecked(false);
            autogrup6 = "purple";
        } else {
            autogrup6 = null;
        }
    }

    public void autochoice13(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice14.setChecked(false);
            autogrup7 = "Green";
        } else {
            autogrup7 = null;
        }
    }

    public void autochoice14(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice13.setChecked(false);
            autogrup7 = "purple";
        } else {
            autogrup7 = null;
        }
    }

    public void autochoice15(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice16.setChecked(false);
            autogrup8 = "Green";
        } else {
            autogrup8 = null;
        }
    }

    public void autochoice16(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice15.setChecked(false);
            autogrup8 = "purple";
        } else {
            autogrup8 = null;
        }
    }

    public void autochoice17(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice18.setChecked(false);
            autogrup9 = "Green";
        } else {
            autogrup9 = null;
        }
    }

    public void autochoice18(View view) {
        CheckBox cb = (CheckBox) view;
        if (cb.isChecked()) {
            autochoice17.setChecked(false);
            autogrup9 = "purple";
        } else {
            autogrup9 = null;
        }
    }














            //public void Autoclear(View view){
    //    autochoice18.setChecked(false);
    //    autochoice17.setChecked(false);
    //    autochoice16.setChecked(false);
    //    autochoice15.setChecked(false);
    //    autochoice14.setChecked(false);
    //    autochoice13.setChecked(false);
    //    autochoice12.setChecked(false);
    //    autochoice11.setChecked(false);
    //    autochoice10.setChecked(false);
    //    autochoice9.setChecked(false);
    //    autochoice8.setChecked(false);
    //    autochoice7.setChecked(false);
    //    autochoice6.setChecked(false);
    //    autochoice5.setChecked(false);
    //    autochoice4.setChecked(false);
    //    autochoice3.setChecked(false);
    //    autochoice1.setChecked(false);
    //    autochoice2.setChecked(false);
    //    RecordsActivity.Info.autogrup1="";
    //    RecordsActivity.Info.autogrup2="";
    //    RecordsActivity.Info.autogrup3="";
    //    RecordsActivity.Info.autogrup5="";
    //    RecordsActivity.Info.autogrup6="";
    //    RecordsActivity.Info.autogrup7="";
    //    RecordsActivity.Info.autogrup8="";
    //    RecordsActivity.Info.autogrup9="";
    //}
//




}

