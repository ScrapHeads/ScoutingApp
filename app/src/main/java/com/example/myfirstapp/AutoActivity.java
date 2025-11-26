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

import java.util.ArrayList;

public class AutoActivity<pri> extends AppCompatActivity {
    RadioButton park, noPark, LevleOne, noparked, barlyparked, fullparked, parkedwithothers, ppg, gpp, pgp;
    TextView autoNetZoneText, autoLowBasketText, autoHighBasketText, AutoHiChamberText, AutoloChamberText, overflowtxt,OverallpointS, text1,text2,text3,text4,text5,text6,text7,text8,text9;
    byte autoNetZone = 0, autoLowBasket = 0, autoHighbasket = 0, AutoHiChamber = 0, AutoloChamber = 0, autoTeamPer = 0, overflow = 0, Overallpoints=0;
    String autoBotAscent, parked, pgpppggpp, autogrup1, autogrup2, autogrup3, autogrup4, autogrup5, autogrup6, autogrup7, autogrup8, autogrup9, autogrup10, autogrup11, autogrup12, autogrup13, autogrup14, autogrup15, autogrup16, autogrup17, autogrup18;
    CheckBox autochoice1, autochoice2, autochoice3, autochoice4, autochoice5, autochoice6, autochoice7, autochoice8, autochoice9, autochoice10, autochoice11, autochoice12, autochoice13, autochoice14, autochoice15, autochoice16, autochoice17, autochoice18;
    private Switch hasAuto;
    private CheckBox[] upperCheckBox = new CheckBox[9];
    private CheckBox[] lowerCheckBox = new CheckBox[9];
    private String[] currentSelection = new String[9];
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
        
        
        
        upperCheckBox[0] = findViewById(R.id.autocheckbox1);
        lowerCheckBox[0] = findViewById(R.id.autocheckbox2);
        
        upperCheckBox[1] = findViewById(R.id.autocheckbox3);
        lowerCheckBox[1] = findViewById(R.id.autocheckbox4);
        
        upperCheckBox[2] = findViewById(R.id.autocheckbox5);
        lowerCheckBox[2] = findViewById(R.id.autocheckbox6);
        
        upperCheckBox[3] = findViewById(R.id.autocheckbox7);
        lowerCheckBox[3] = findViewById(R.id.autocheckbox8);
        
        upperCheckBox[4] = findViewById(R.id.autocheckbox9);
        lowerCheckBox[4] = findViewById(R.id.autocheckbox10);
        
        upperCheckBox[5] = findViewById(R.id.autocheckbox11);
        lowerCheckBox[5] = findViewById(R.id.autocheckbox12);
        
        upperCheckBox[6] = findViewById(R.id.autocheckbox13);
        lowerCheckBox[6] = findViewById(R.id.autocheckbox14);
        
        upperCheckBox[7] = findViewById(R.id.autocheckbox15);
        lowerCheckBox[7] = findViewById(R.id.autocheckbox16);
        
        upperCheckBox[8] = findViewById(R.id.autocheckbox17);
        lowerCheckBox[8] = findViewById(R.id.autocheckbox18);
        

        RecordsActivity.Info.doWeHaveAuto = false;
        hasAuto = findViewById(R.id.switch1);
        setPrevious();
    }
    
    private final ArrayList<String[]> allRuns = new ArrayList<>();
    
    
    
    private void setGreen(int index) {
        currentSelection[index] = "G";
        lowerCheckBox[index].setChecked(false);
    }
    
    private void setPurple(int index) {
        currentSelection[index] = "P";
        upperCheckBox[index].setChecked(false);
    }
    
    
    
    
    
    

    public void toSpecimen(View view) {
        Intent next = new Intent(this, Tele.class);
        // Save currentSelection into the global store
        RecordsActivity.Info.autoGrids = currentSelection.clone();

// Save all runs too
        RecordsActivity.Info.autoRuns = new ArrayList<>(allRuns);
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
        if (parked == "no parked") {
            //barlyparked.setChecked(false);
            fullparked.setChecked(false);
            //parkedwithothers.setChecked(false);
            noparked.setChecked(true);
        }
        if (parked == "barly parked") {
            fullparked.setChecked(false);
            //parkedwithothers.setChecked(false);
            noparked.setChecked(false);
            //barlyparked.setChecked(true);
        }
        if (parked == "full parked") {
            //barlyparked.setChecked(false);
           // parkedwithothers.setChecked(false);
            noparked.setChecked(false);
            fullparked.setChecked(true);
        }
        if (parked == "parkedwithothers") {
            //barlyparked.setChecked(false);
            fullparked.setChecked(false);
            noparked.setChecked(false);
            //parkedwithothers.setChecked(true);
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


        if (pgpppggpp == "PGP") {
            pgp.setChecked(true);
            gpp.setChecked(false);
            ppg.setChecked(false);
            text1.setText("P");
            text2.setText("G");
            text3.setText("P");
            text4.setText("P");
            text5.setText("G");
            text6.setText("P");
            text7.setText("P");
            text8.setText("G");
            text9.setText("P");
        }
        if (pgpppggpp == "PPG") {
            ppg.setChecked(true);
            gpp.setChecked(false);
            pgp.setChecked(false);
            text1.setText("P");
            text2.setText("P");
            text3.setText("G");
            text4.setText("P");
            text5.setText("P");
            text6.setText("G");
            text7.setText("P");
            text8.setText("P");
            text9.setText("G");
        }
        if (pgpppggpp == "GPP") {
            gpp.setChecked(true);
            pgp.setChecked(false);
            ppg.setChecked(false);
            text1.setText("G");
            text2.setText("P");
            text3.setText("P");
            text4.setText("G");
            text5.setText("P");
            text6.setText("P");
            text7.setText("G");
            text8.setText("P");
            text9.setText("P");
        }
        if (autogrup1 == "Green") {
            autochoice1.setChecked(true);
            autochoice2.setChecked(false);
        }
        if (autogrup1 == "Purple") {
            autochoice1.setChecked(false);
            autochoice2.setChecked(true);
        }
        if (autogrup2 == "Green") {
            autochoice3.setChecked(true);
            autochoice4.setChecked(false);
        }
        if (autogrup2 == "Purple") {
            autochoice4.setChecked(true);
            autochoice3.setChecked(false);
        }
        if (autogrup3 == "Green") {
            autochoice5.setChecked(true);
            autochoice6.setChecked(false);
        }
        if (autogrup3 == "Purple") {
            autochoice6.setChecked(true);
            autochoice5.setChecked(false);
        }
        if (autogrup4 == "Green") {
            autochoice7.setChecked(true);
            autochoice8.setChecked(false);
        }
        if (autogrup4 == "Purple") {
            autochoice8.setChecked(true);
            autochoice7.setChecked(false);
        }
        if (autogrup5 == "Green") {
            autochoice9.setChecked(true);
            autochoice10.setChecked(false);
        }
        if (autogrup5 == "Purple") {
            autochoice10.setChecked(true);
            autochoice9.setChecked(false);
        }
        if (autogrup6 == "Green") {
            autochoice11.setChecked(true);
            autochoice12.setChecked(false);
        }
        if (autogrup6 == "Purple") {
            autochoice12.setChecked(true);
            autochoice11.setChecked(false);
        }
        if (autogrup7 == "Green") {
            autochoice13.setChecked(true);
            autochoice14.setChecked(false);
        }
        if (autogrup7 == "Purple") {
            autochoice14.setChecked(true);
            autochoice13.setChecked(false);
        }
        if (autogrup8 == "Green") {
            autochoice15.setChecked(true);
            autochoice16.setChecked(false);
        }
        if (autogrup8 == "Purple") {
            autochoice16.setChecked(true);
            autochoice15.setChecked(false);
        }
        if (autogrup9 == "Green") {
            autochoice17.setChecked(true);
            autochoice18.setChecked(false);
        }
        if (autogrup9 == "Purple") {
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
//        AutoloChamber = Byte.parseByte(AutoloChamberText.getText().toString());
//        if (AutoloChamber == 0) {
//            findViewById(R.id.specimenLCSubtractionButton).setVisibility(GONE);
//        }
//        if (AutoloChamber > 0) {
//            Log.d("AASet Previous", String.valueOf(autoNetZone));
//            findViewById(R.id.specimenLCSubtractionButton).setVisibility(VISIBLE);
//            Log.d("AASet Previous", "VISIBLE");
//        }
//        AutoHiChamber = Byte.parseByte(AutoHiChamberText.getText().toString());
//        if (AutoHiChamber == 0) {
//            findViewById(R.id.specimenHCSubtractionButton4).setVisibility(GONE);
//        }
//        if (AutoHiChamber > 0) {
//            Log.d("AASet Previous", String.valueOf(autoNetZone));
//            findViewById(R.id.specimenHCSubtractionButton4).setVisibility(VISIBLE);
//            Log.d("AASet Previous", "VISIBLE");
//        }
//        autoLowBasket = Byte.parseByte(autoLowBasketText.getText().toString());
//        if (autoLowBasket == 0) {
//            findViewById(R.id.sampleLowBasketSubtract).setVisibility(GONE);
//        }
//        if (autoLowBasket > 0) {
//            Log.d("AASet Previous", String.valueOf(autoNetZone));
//            findViewById(R.id.sampleLowBasketSubtract).setVisibility(VISIBLE);
//            Log.d("AASet Previous", "VISIBLE");
//        }
//        autoHighbasket = Byte.parseByte(autoHighBasketText.getText().toString());
//        if (autoHighbasket == 0) {
//            findViewById(R.id.sampleHighBasketSubtract).setVisibility(GONE);
//        }
////        if (autoHighbasket > 0) {
////            Log.d("AASet Previous", String.valueOf(autoNetZone));
//            findViewById(R.id.sampleHighBasketSubtract).setVisibility(VISIBLE);
//            Log.d("AASet Previous", "VISIBLE");
//        }
//        Log.d("AASet Previous", "Exit Set Previous");
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
        AUTOsave.putExtra("autogrup1", String.valueOf(autogrup1));
        RecordsActivity.Info.autogrup2 = autogrup2;
        AUTOsave.putExtra("autogrup2", String.valueOf(autogrup2));
        RecordsActivity.Info.autogrup3 = autogrup3;
        AUTOsave.putExtra("autogrup3", String.valueOf(autogrup3));
        RecordsActivity.Info.autogrup4 = autogrup4;
        AUTOsave.putExtra("autogrup4", String.valueOf(autogrup4));
        RecordsActivity.Info.autogrup5 = autogrup5;
        AUTOsave.putExtra("autogrup5", String.valueOf(autogrup5));
        RecordsActivity.Info.autogrup6 = autogrup6;
        AUTOsave.putExtra("autogrup6", String.valueOf(autogrup6));
        RecordsActivity.Info.autogrup7 = autogrup7;
        AUTOsave.putExtra("autogrup7", String.valueOf(autogrup7));
        RecordsActivity.Info.autogrup8 = autogrup8;
        AUTOsave.putExtra("autogrup8", String.valueOf(autogrup8));
        RecordsActivity.Info.autogrup9 = autogrup9;
        AUTOsave.putExtra("autogrup9", String.valueOf(autogrup9));
        RecordsActivity.Info.autogrup10 = autogrup10;
        AUTOsave.putExtra("autogrup10", String.valueOf(autogrup10));
        RecordsActivity.Info.autogrup11 = autogrup11;
        AUTOsave.putExtra("autogrup11", String.valueOf(autogrup11));
        RecordsActivity.Info.autogrup12 = autogrup12;
        AUTOsave.putExtra("autogrup12", String.valueOf(autogrup12));
        RecordsActivity.Info.autogrup13 = autogrup13;
        AUTOsave.putExtra("autogrup13", String.valueOf(autogrup13));
        RecordsActivity.Info.autogrup14 = autogrup14;
        AUTOsave.putExtra("autogrup14", String.valueOf(autogrup14));
        RecordsActivity.Info.autogrup15 = autogrup15;
        AUTOsave.putExtra("autogrup15", String.valueOf(autogrup15));
        RecordsActivity.Info.autogrup16 = autogrup16;
        AUTOsave.putExtra("autogrup16", String.valueOf(autogrup16));
        RecordsActivity.Info.autogrup17 = autogrup17;
        AUTOsave.putExtra("autogrup17", String.valueOf(autogrup17));
        RecordsActivity.Info.autogrup18 = autogrup18;
        AUTOsave.putExtra("autogrup18", String.valueOf(autogrup18));
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
        autoBotAscent = "no Park";
    }

    public void ClickLevleOne(View view) {
        RecordsActivity.Info.doWeHaveAuto = false;
        park.setChecked(false);
        Log.d("LevleOne", "set park false");
        noPark.setChecked(false);
        Log.d("LevleOne", "set noPark false");
        LevleOne.setChecked(true);
        Log.d("LevleOne", "set LevleOne true");

        autoBotAscent = "Levle One";
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

    public void autoclickdidnotparked(View view) {
        //barlyparked.setChecked(false);
        fullparked.setChecked(false);
        //parkedwithothers.setChecked(false);
        noparked.setChecked(true);
        parked = "no parked";
    }

    //public void clickbarlyparked(View view) {
      //  fullparked.setChecked(false);
      //  parkedwithothers.setChecked(false);
      //  noparked.setChecked(false);
      //  barlyparked.setChecked(true);
      //  parked = "barly parked";
    //}

    public void clickfullparked(View view) {
        //barlyparked.setChecked(false);
        //parkedwithothers.setChecked(false);
        noparked.setChecked(false);
        fullparked.setChecked(true);
        parked = "full parked";
    }

    //public void clickparkedwithothers(View view) {
    //    barlyparked.setChecked(false);
    //    fullparked.setChecked(false);
    //    noparked.setChecked(false);
    //    parkedwithothers.setChecked(true);
    //    parked = "parkedwithothers";
    //}

    public void ppg(View view) {
        ppg.setChecked(true);
        gpp.setChecked(false);
        pgp.setChecked(false);
        text1.setText("P");
        text2.setText("P");
        text3.setText("G");
        text4.setText("P");
        text5.setText("P");
        text6.setText("G");
        text7.setText("P");
        text8.setText("P");
        text9.setText("G");
        pgpppggpp = "PPG";
    }

    public void pgp(View view) {
        pgp.setChecked(true);
        ppg.setChecked(false);
        gpp.setChecked(false);
        text1.setText("P");
        text2.setText("G");
        text3.setText("P");
        text4.setText("P");
        text5.setText("G");
        text6.setText("P");
        text7.setText("P");
        text8.setText("G");
        text9.setText("P");
        pgpppggpp = "PGP";
    }

    public void gpp(View view) {
        gpp.setChecked(true);
        ppg.setChecked(false);
        pgp.setChecked(false);
        text1.setText("G");
        text2.setText("P");
        text3.setText("P");
        text4.setText("G");
        text5.setText("P");
        text6.setText("P");
        text7.setText("G");
        text8.setText("P");
        text9.setText("P");
        pgpppggpp = "GPP";
    }
    
    
    
    
    
    public void autochoice1(View view){
        int index=0;
        if (((CheckBox)view).isChecked()){
            setGreen(index);
        } else {
            currentSelection[index]=null;
        }
        if (autochoice1.isChecked()) {
            autochoice2.setChecked(false);
            autogrup1 = "Green";
        }else {
            autogrup13 = null;
        }
    }
    public void autochoice2(View view){
        int index=0;
        if (((CheckBox)view).isChecked()){
            setPurple(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice2.isChecked()) {
            autochoice1.setChecked(false);
            autogrup1 = "Purple";
        }else {
            autogrup1 = null;
        }
    }
    public void autochoice3(View view){
        int index=1;
        if (((CheckBox)view).isChecked()){
            setGreen(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice3.isChecked()) {
            autochoice4.setChecked(false);
            autogrup2 = "Green";
        }else {
            autogrup2 = null;
        }
    }
    public void autochoice4(View view){
        int index=1;
        if (((CheckBox)view).isChecked()){
            setPurple(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice4.isChecked()) {
            autochoice3.setChecked(false);
            autogrup2 = "Purple";
        }else {
            autogrup2 = null;
        }
    }
    public void autochoice5(View view) {
        int index = 2;
        
        if (((CheckBox)view).isChecked()) {
            setGreen(index);
        } else {
            currentSelection[index] = null;
        }
        if (autochoice5.isChecked()) {
            autochoice6.setChecked(false);
            autogrup3 = "Green";
        }else {
            autogrup3 = null;
        }
    }
    public void autochoice6(View view) {
        int index = 2;
        
        if (((CheckBox)view).isChecked()) {
            setPurple(index);
        } else {
            currentSelection[index] = null;
        }
        if (autochoice6.isChecked()) {
            autochoice5.setChecked(false);
            autogrup3 = "Purple";
        }else {
            autogrup3 = null;
        }
    }
    public void autochoice7(View view){
        int index =3;
        if (((CheckBox)view).isChecked()){
            setGreen(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice7.isChecked()) {
            autochoice8.setChecked(false);
            autogrup4 = "Green";
        }else {
            autogrup4 = null;
        }
    }
    public void autochoice8(View view){
        int index =3;
        if (((CheckBox)view).isChecked()){
            setPurple(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice8.isChecked()) {
            autochoice7.setChecked(false);
            autogrup4 = "Purple";
        }else {
            autogrup4 = null;
        }
    }
    public void autochoice9(View view){
        int index =4;
        if (((CheckBox)view).isChecked()){
            setGreen(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice9.isChecked()) {
            autochoice10.setChecked(false);
            autogrup5 = "Green";
        }else {
            autogrup5 = null;
        }
    }
    public void autochoice10(View view){
        int index =4;
        if (((CheckBox)view).isChecked()){
            setPurple(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice10.isChecked()) {
            autochoice9.setChecked(false);
            autogrup5 = "Purple";
        }else {
            autogrup5 = null;
        }
    }
    public void autochoice11(View view){
        int index =5;
        if (((CheckBox)view).isChecked()){
            setGreen(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice11.isChecked()) {
            autochoice12.setChecked(false);
            autogrup6 = "Green";
        }else {
            autogrup6 = null;
        }
    }
    public void autochoice12(View view){
        int index =5;
        if (((CheckBox)view).isChecked()){
            setPurple(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice12.isChecked()) {
            autochoice11.setChecked(false);
            autogrup6 = "Purple";
        }else {
            autogrup6 = null;
        }
    }
    public void autochoice13(View view){
        int index =6;
        if (((CheckBox)view).isChecked()){
            setGreen(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice13.isChecked()) {
            autochoice14.setChecked(false);
            autogrup7 = "Green";
        }else {
            autogrup7 = null;
        }
    }
    public void autochoice14(View view){
        int index =6;
        if (((CheckBox)view).isChecked()){
            setPurple(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice14.isChecked()) {
            autochoice13.setChecked(false);
            autogrup7 = "Purple";
        }else {
            autogrup7 = null;
        }
    }
    public void autochoice15(View view){
        int index =7;
        if (((CheckBox)view).isChecked()){
            setGreen(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice15.isChecked()) {
            autochoice16.setChecked(false);
            autogrup8 = "Green";
        }else {
            autogrup8 = null;
        }
    }
    public void autochoice16(View view){
        int index =7;
        if (((CheckBox)view).isChecked()){
            setPurple(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice16.isChecked()) {
            autochoice15.setChecked(false);
            autogrup8 = "Purple";
        }else {
            autogrup8 = null;
        }
    }
    public void autochoice17(View view){
        int index =8;
        if (((CheckBox)view).isChecked()){
            setGreen(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice17.isChecked()) {
            autochoice18.setChecked(false);
            autogrup9 = "Green";
        }else {
            autogrup9 = null;
        }
    }
    public void autochoice18(View view){
        int index =8;
        if (((CheckBox)view).isChecked()){
            setPurple(index);
        }else {
            currentSelection[index]=null;
        }
        if (autochoice18.isChecked()) {
            autochoice17.setChecked(false);
            autogrup9 = "Purple";
        }else {
            autogrup9 = null;
        }
    }
    
    
    
    
    
    
    
   // public void autochoice1(View view) {
     //   //autochoice1.setChecked(true);
       // //autochoice2.setChecked(false);
        //autogrup1 = "Green";
    //    if (autochoice1.isChecked()) {
     //       autochoice2.setChecked(false);
     //       autogrup1 = "Green";
     //   } else {
      //      autogrup1 = null;
        //}
    //}

//    public void autochoice2(View view) {
        //autochoice2.setChecked(true);
        //autochoice1.setChecked(false);
        //autogrup1 = "Purple";
//        if (autochoice2.isChecked()) {
//            autochoice1.setChecked(false);
//            autogrup1 = "Purple";
//        } else {
//            autogrup1 = null;
//        }
//    }

//    public void autochoice3(View view) {
//        //autochoice3.setChecked(true);
//        //autochoice4.setChecked(false);
//        //autogrup2 = "Green";
//        if (autochoice3.isChecked()) {
//            autochoice4.setChecked(false);
//            autogrup2 = "Green";
//        } else {
//            autogrup2 = null;
//        }
//    }

//    public void autochoice4(View view) {
//        //autochoice4.setChecked(true);
//        //autochoice3.setChecked(false);
//        //autogrup2 = "Purple";
//        if (autochoice4.isChecked()) {
//            autochoice3.setChecked(false);
//            autogrup2 = "Purple";
//        } else {
//            autogrup2 = null;
//        }
//    }

//    public void autochoice5(View view) {
//        //autochoice5.setChecked(true);
//        //autochoice6.setChecked(false);
//        //autogrup3 = "Green";
//        if (autochoice5.isChecked()) {
//            autochoice6.setChecked(false);
//            autogrup3 = "Green";
//        } else {
//            autogrup3 = null;
//        }
//    }

//    public void autochoice6(View view) {
//       // autochoice6.setChecked(true);
//        //autochoice5.setChecked(false);
//       // autogrup3 = "Purple";
//        if (autochoice6.isChecked()) {
//            autochoice5.setChecked(false);
//            autogrup3 = "Purple";
//        } else {
//            autogrup3 = null;
//        }
//    }

//    public void autochoice7(View view) {
//       // autochoice7.setChecked(true);
//       // autochoice8.setChecked(false);
//       // autogrup4 = "Green";
//        if (autochoice7.isChecked()) {
//            autochoice8.setChecked(false);
//            autogrup4 = "Green";
//        } else {
//            autogrup4 = null;
//        }
//    }

//    public void autochoice8(View view) {
//       // autochoice8.setChecked(true);
//        //autochoice7.setChecked(false);
//       // autogrup4 = "Purple";
//        if (autochoice8.isChecked()) {
//                autochoice7.setChecked(false);
//            autogrup4 = "Purple";
//        } else {
//            autogrup4 = null;
//        }
//    }

//    public void autochoice9(View view) {
//       // autochoice9.setChecked(true);
//        //autochoice10.setChecked(false);
//        //autogrup5 = "Green";
//        if (autochoice9.isChecked()) {
//            autochoice10.setChecked(false);
//            autogrup5 = "Green";
//        } else {
//            autogrup5 = null;
//        }
//    }
//
//    public void autochoice10(View view) {
//       // autochoice10.setChecked(true);
//        //autochoice9.setChecked(false);
//        //autogrup5 = "Purple";
//        if (autochoice10.isChecked()) {
//            autochoice9.setChecked(false);
//            autogrup5 = "Purple";
//        } else {
//            autogrup5 = null;
//        }
//    }

//    public void autochoice11(View view) {
//       // autochoice11.setChecked(true);
//       // autochoice12.setChecked(false);
//       //autogrup6 = "Green";
//        if (autochoice11.isChecked()) {
//            autochoice12.setChecked(false);
//            autogrup6 = "Green";
//        } else {
//            autogrup6 = null;
//        }
//    }

//    public void autochoice12(View view) {
//       // autochoice12.setChecked(true);
//       // autochoice11.setChecked(false);
//       // autogrup6 = "Purple";
//        if (autochoice12.isChecked()) {
//            autochoice11.setChecked(false);
//            autogrup6 = "Purple";
//        } else {
//            autogrup6 = null;
//        }
//    }

//    public void autochoice13(View view) {
//       // autochoice13.setChecked(true);
//       // autochoice14.setChecked(false);
//       // autogrup7 = "Green";
//        if (autochoice13.isChecked()) {
//            autochoice14.setChecked(false);
//            autogrup7 = "Green";
//        } else {
//            autogrup7 = null;
//        }
//    }

//    public void autochoice14(View view) {
//       // autochoice14.setChecked(true);
//       // autochoice13.setChecked(false);
//       // autogrup7 = "Purple";
//        if (autochoice14.isChecked()) {
//            autochoice13.setChecked(false);
//            autogrup7 = "Purple";
//        } else {
//            autogrup7 = null;
//        }
//    }

//    public void autochoice15(View view) {
//       // autochoice15.setChecked(true);
//       //autochoice16.setChecked(false);
//       //autogrup8 = "Green";
//        if (autochoice15.isChecked()) {
//            autochoice16.setChecked(false);
//            autogrup8 = "Green";
//        } else {
//            autogrup8 = null;
//        }
//    }

//    public void autochoice16(View view) {
//       // autochoice16.setChecked(true);
//       // autochoice15.setChecked(false);
//       // autogrup8 = "Purple";
//        if (autochoice16.isChecked()) {
//            autochoice15.setChecked(false);
//            autogrup8 = "Purple";
//        } else {
//            autogrup8 = null;
//        }
//    }

//    public void autochoice17(View view) {
//       // autochoice17.setChecked(true);
//       // autochoice18.setChecked(false);
//       // autogrup9 = "Green";
//        if (autochoice17.isChecked()) {
//            autochoice18.setChecked(false);
//            autogrup9 = "Green";
//        } else {
//            autogrup9 = null;
//        }
//    }

//    public void autochoice18(View view) {
//        //autochoice18.setChecked(true);
        //autochoice17.setChecked(false);
        //autogrup9 = "Purple";
//        if (autochoice18.isChecked()) {
//            autochoice17.setChecked(false);
//            autogrup9 = "Purple";
//        } else {
//            autogrup9 = null;
//        }
//    }
    public void Autoclear(View view){
        // save the finished 18-variable selection
        allRuns.add(currentSelection.clone());
        
        // wipe the temporary selection
        currentSelection = new String[9];
        
        // uncheck all checkboxes
        for (int i = 0; i < 9; i++) {
            upperCheckBox[i].setChecked(false);
            lowerCheckBox[i].setChecked(false);
        }
    }
//        if (autochoice1 != null) autochoice1.setChecked(false);
//        if (autochoice2 != null) autochoice2.setChecked(false);
//        if (autochoice3 != null) autochoice3.setChecked(false);
//        if (autochoice4 != null) autochoice4.setChecked(false);
//        if (autochoice5 != null) autochoice5.setChecked(false);
//        if (autochoice6 != null) autochoice6.setChecked(false);
//        if (autochoice7 != null) autochoice7.setChecked(false);
//        if (autochoice8 != null) autochoice8.setChecked(false);
//        if (autochoice9 != null) autochoice9.setChecked(false);
//        if (autochoice10 != null) autochoice10.setChecked(false);
//        if (autochoice11 != null) autochoice11.setChecked(false);
//        if (autochoice12 != null) autochoice12.setChecked(false);
//        if (autochoice13 != null) autochoice13.setChecked(false);
//        if (autochoice14 != null) autochoice14.setChecked(false);
//        if (autochoice15 != null) autochoice15.setChecked(false);
//        if (autochoice16 != null) autochoice16.setChecked(false);
//        if (autochoice17 != null) autochoice17.setChecked(false);
//        if (autochoice18 != null) autochoice18.setChecked(false);
//        RecordsActivity.Info.autogrup1="";
//        RecordsActivity.Info.autogrup2="";
//        RecordsActivity.Info.autogrup3="";
//        RecordsActivity.Info.autogrup4="";
//        RecordsActivity.Info.autogrup5="";
//        RecordsActivity.Info.autogrup6="";
//        RecordsActivity.Info.autogrup7="";
//        RecordsActivity.Info.autogrup8="";
//        RecordsActivity.Info.autogrup9="";
//        RecordsActivity.Info.autogrup10="";
//        RecordsActivity.Info.autogrup11="";
//        RecordsActivity.Info.autogrup12="";
//        RecordsActivity.Info.autogrup13="";
//        RecordsActivity.Info.autogrup14="";
//        RecordsActivity.Info.autogrup15="";
//        RecordsActivity.Info.autogrup16="";
//        RecordsActivity.Info.autogrup17="";
//        RecordsActivity.Info.autogrup18="";
//        autochoice18.setChecked(false);
//        autochoice17.setChecked(false);
//        autochoice16.setChecked(false);
//        autochoice15.setChecked(false);
//        autochoice14.setChecked(false);
//        autochoice13.setChecked(false);
//        autochoice12.setChecked(false);
//        autochoice11.setChecked(false);
//        autochoice10.setChecked(false);
//        autochoice9.setChecked(false);
//        autochoice8.setChecked(false);
//        autochoice7.setChecked(false);
//        autochoice6.setChecked(false);
//        autochoice5.setChecked(false);
//        autochoice4.setChecked(false);
//        autochoice3.setChecked(false);
//        autochoice1.setChecked(false);
//        autochoice2.setChecked(false);
//        RecordsActivity.Info.autogrup1="";
//        RecordsActivity.Info.autogrup2="";
//        RecordsActivity.Info.autogrup3="";
//        RecordsActivity.Info.autogrup5="";
//        RecordsActivity.Info.autogrup6="";
//        RecordsActivity.Info.autogrup7="";
//        RecordsActivity.Info.autogrup8="";
//        RecordsActivity.Info.autogrup9="";
    }







