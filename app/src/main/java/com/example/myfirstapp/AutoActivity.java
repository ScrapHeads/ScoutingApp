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

public class AutoActivity<pri> extends AppCompatActivity {
    RadioButton park, noPark, LevleOne;
    TextView autoNetZoneText, autoLowBasketText, autoHighBasketText,AutoHiChamberText,AutoloChamberText;
    byte autoNetZone = 0, autoLowBasket = 0, autoHighbasket = 0, AutoHiChamber=0,AutoloChamber=0, autoTeamPer=0;
    String autoBotAscent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        this.setRequestedOrientation(ActivityInfo. SCREEN_ORIENTATION_LANDSCAPE);
        autoNetZoneText = findViewById(R.id.sampleNetZoneCount);
        autoLowBasketText = findViewById(R.id.sampleLowBasketCount);
        autoHighBasketText = findViewById(R.id.sampleHighBasketCount);
        AutoHiChamberText = findViewById(R.id.specimenHCZeroText);
        AutoloChamberText = findViewById(R.id.specimenLCZeroText);
        park =findViewById(R.id.AutoPark);
        noPark = findViewById(R.id.endNoPark);
        LevleOne = findViewById(R.id.endLevel1);
        RecordsActivity.Info.noAuto=false;
        setPrevious();
}


    public void toSpecimen(View view) {
        Intent next = new Intent(this, Tele.class);
        saveData();
        startActivity(next);
    }

    public void No_Auto(View view){
        Intent no_Auto = new Intent(this, Tele.class);
        noPark.setChecked(false);
        LevleOne.setChecked(false);
        park.setChecked(false);
        autoNetZoneText.setText("0");
        autoLowBasketText.setText("0");
        autoHighBasketText.setText("0");
        autoBotAscent= String.valueOf(0);
        AutoHiChamberText.setText("0");
        AutoloChamberText.setText("0");
        RecordsActivity.Info.noAuto=true;
        saveData();
        startActivity(no_Auto);
    }

    public void setPrevious() {                                                                         Log.d("AASet Previous", "run Set Previous");
        Intent previous=getIntent();                                                                    Log.d("AASet Previous", "Start unpacking Suitcase");
        autoNetZoneText.setText(previous.getStringExtra("netZoneText"));                          Log.d("AASet Previous","netZoneText = "+autoNetZoneText.getText().toString()); Log.d("AASet Previous", "autoNetZoneText"+String.valueOf(RecordsActivity.Info.autoNetZoneText));
        autoNetZoneText.setText(String.valueOf(RecordsActivity.Info.autoNetZoneText));
        autoLowBasketText.setText(previous.getStringExtra("lowBasketText"));                      Log.d("AASet Previous","lowBasketText = "+autoLowBasketText.getText().toString()); Log.d("AASet Previous", "autoLowBasketText"+String.valueOf(RecordsActivity.Info.autoLowBasketText));
        autoLowBasketText.setText(String.valueOf(RecordsActivity.Info.autoLowBasketText));
        autoHighBasketText.setText(previous.getStringExtra("highBasketText"));                    Log.d("AASet Previous","highBasketText = "+autoHighBasketText.getText().toString()); Log.d("AASet Previous", "autoHighBasketText"+String.valueOf(RecordsActivity.Info.autoHighBasketText));
        autoHighBasketText.setText(String.valueOf(RecordsActivity.Info.autoHighBasketText));
        AutoHiChamberText.setText(previous.getStringExtra("AutoHiChamberText"));                  Log.d("AASet Previous","AutoHiChamberText = "+AutoHiChamberText.getText().toString()); Log.d("AASet Previous", "autoHighChamberText"+String.valueOf(RecordsActivity.Info.autoHighChamberText));
        AutoHiChamberText.setText(String.valueOf(RecordsActivity.Info.autoHighChamberText));
        AutoloChamberText.setText(previous.getStringExtra("AutoloChamberText"));                  Log.d("AASet Previous","AutoloChamberText = "+AutoloChamberText.getText().toString()); Log.d("AASet Previous", "autoLowChamberText"+String.valueOf(RecordsActivity.Info.autoLowChamberText));
        AutoloChamberText.setText(String.valueOf(RecordsActivity.Info.autoLowChamberText));
        autoBotAscent=previous.getStringExtra("autoBotAscent");                                   Log.d("AASet Previous","autoBotAscent = "+autoBotAscent); Log.d("AASet Previous", "AutoAscent"+String.valueOf(RecordsActivity.Info.AutoAscent));
        autoBotAscent=RecordsActivity.Info.AutoAscent;
        if (autoBotAscent=="noPark") {
            park.setChecked(false);
            LevleOne.setChecked(false);
            noPark.setChecked(true);
        }
        if (autoBotAscent=="park") {
            noPark.setChecked(false);
            LevleOne.setChecked(false);
            park.setChecked(true);
        }
        if (autoBotAscent=="LevleOne") {
            noPark.setChecked(false);
            park.setChecked(false);
            LevleOne.setChecked(true);
        }
        autoNetZone = Byte.parseByte(autoNetZoneText.getText().toString());
        if (autoNetZone == 0){                                                                           Log.d("AASet Previous", String.valueOf(autoNetZone));
            findViewById(R.id.sampleNetSubtract).setVisibility(INVISIBLE);                              Log.d("AASet Previous", "INVISIBLE");
        }
        autoNetZone = Byte.parseByte(autoNetZoneText.getText().toString());
        if (autoNetZone > 0) {                                                                          Log.d("AASet Previous", String.valueOf(autoNetZone));
            findViewById(R.id.sampleNetSubtract).setVisibility(VISIBLE);                                Log.d("AASet Previous", "VISIBLE");
        }
        AutoloChamber = Byte.parseByte(AutoloChamberText.getText().toString());
        if (AutoloChamber ==0){
            findViewById(R.id.specimenLCSubtractionButton).setVisibility(GONE);
        }
        if (AutoloChamber > 0) {                                                                          Log.d("AASet Previous", String.valueOf(autoNetZone));
            findViewById(R.id.specimenLCSubtractionButton).setVisibility(VISIBLE);                                Log.d("AASet Previous", "VISIBLE");
        }
        AutoHiChamber = Byte.parseByte(AutoHiChamberText.getText().toString());
        if (AutoHiChamber ==0) {
            findViewById(R.id.specimenHCSubtractionButton4).setVisibility(GONE);
        }
        if (AutoHiChamber > 0) {                                                                          Log.d("AASet Previous", String.valueOf(autoNetZone));
            findViewById(R.id.specimenHCSubtractionButton4).setVisibility(VISIBLE);                                Log.d("AASet Previous", "VISIBLE");
        }
        autoLowBasket = Byte.parseByte(autoLowBasketText.getText().toString());
        if (autoLowBasket ==0){
            findViewById(R.id.sampleLowBasketSubtract).setVisibility(GONE);
        }
        if (autoLowBasket > 0) {                                                                          Log.d("AASet Previous", String.valueOf(autoNetZone));
            findViewById(R.id.sampleLowBasketSubtract).setVisibility(VISIBLE);                                Log.d("AASet Previous", "VISIBLE");
        }
        autoHighbasket = Byte.parseByte(autoHighBasketText.getText().toString());
        if (autoHighbasket ==0){
            findViewById(R.id.sampleHighBasketSubtract).setVisibility(GONE);
        }
        if (autoHighbasket > 0) {                                                                          Log.d("AASet Previous", String.valueOf(autoNetZone));
            findViewById(R.id.sampleHighBasketSubtract).setVisibility(VISIBLE);                                Log.d("AASet Previous", "VISIBLE");
        }
                                                                                                        Log.d("AASet Previous", "Exit Set Previous");
    }

    public final class Math extends Object {
        byte autoTeamPer;


    }


    public void saveData() {                                                                                Log.d("BackClick","Start Save Data");
        Intent AUTOsave= new Intent(this, RecordsActivity.class);                               Log.d("BackClick","RecordsActivity");
        RecordsActivity.Info.autoNetZoneText = Byte.parseByte(autoNetZoneText.getText().toString());        Log.d("AAput","autoNetZoneText"+autoNetZoneText.getText().toString()); Log.d("AAput", String.valueOf(RecordsActivity.Info.autoNetZoneText));
        AUTOsave.putExtra("netZoneText",  autoNetZoneText.getText().toString());
        RecordsActivity.Info.autoLowBasketText = Byte.parseByte(autoLowBasketText.getText().toString());    Log.d("AAput","autoLowBasketText"+autoLowBasketText.getText().toString()); Log.d("AAput", String.valueOf(RecordsActivity.Info.autoLowBasketText));
        AUTOsave.putExtra("lowBasketText",  autoLowBasketText.getText().toString());
        RecordsActivity.Info.autoHighBasketText = Byte.parseByte(autoHighBasketText.getText().toString());  Log.d("AAput","autoHighBasketText"+autoHighBasketText.getText().toString()); Log.d("AAput", String.valueOf(RecordsActivity.Info.autoHighBasketText));
        AUTOsave.putExtra("highBasketText",  autoHighBasketText.getText().toString());
        RecordsActivity.Info.AutoAscent = autoBotAscent;                                                    Log.d("AAput","autoBotAscent"+autoBotAscent); Log.d("AAput", String.valueOf(RecordsActivity.Info.AutoAscent));
        AUTOsave.putExtra("autoBotAscent", String.valueOf(autoBotAscent));
        RecordsActivity.Info.autoHighChamberText = Byte.parseByte(AutoHiChamberText.getText().toString());  Log.d("AAput","AutoHiChamberText"+AutoHiChamberText.getText().toString()); Log.d("AAput", String.valueOf(RecordsActivity.Info.autoHighChamberText));
        AUTOsave.putExtra("AutoHiChamberText",AutoHiChamberText.getText().toString());
        RecordsActivity.Info.autoLowChamberText = Byte.parseByte(AutoloChamberText.getText().toString());   Log.d("AAput","AutoloChamberText" + AutoloChamberText.getText().toString()); Log.d("AAput", String.valueOf(RecordsActivity.Info.autoLowChamberText));
        AUTOsave.putExtra("AutoloChamberText",AutoloChamberText.getText().toString());                Log.d("BackClick","End Save Data");

    }

    public void backMain(View view) {
        Intent news = new Intent(this, preGameInfo.class);                                     Log.d("BackClick","load main activity");
        saveData();                                                                                          Log.d("BackClick","Start Save Data");
        startActivity(news);                                                                                 Log.d("BackClick","Start Main Acitivity");
    }

    public void netZoneIncrease(View view) {
        //findViewById(R.id.sampleNetSubtract).setVisibility(VISIBLE);
                RecordsActivity.Info.noAuto=false;
                autoNetZone++;
                autoNetZoneText.setText(String.valueOf(autoNetZone));

                if (autoNetZone > 0){
                    findViewById(R.id.sampleNetSubtract).setVisibility(VISIBLE);
                }
    }
    public void netZoneDecrease(View view) {;
        if (autoNetZone > 0) {
            RecordsActivity.Info.noAuto = false;
            autoNetZone--;
            autoNetZoneText.setText(String.valueOf(autoNetZone));

        }
        if (autoNetZone <= 0){
            findViewById(R.id.sampleNetSubtract).setVisibility(GONE);
        }
    }
    public void lowChamberIncrease(View view){
        //findViewById(R.id.specimenLCSubtractionButton).setVisibility(VISIBLE);
        RecordsActivity.Info.noAuto=false;
        AutoloChamber++;
        AutoloChamberText.setText(String.valueOf(AutoloChamber));
        if (AutoloChamber > 0){
            findViewById(R.id.specimenLCSubtractionButton).setVisibility(VISIBLE);
        }
        }
    public void lowChamberDecrease(View view){
        if (AutoloChamber > 0) {
            RecordsActivity.Info.noAuto = false;
            AutoloChamber--;
            AutoloChamberText.setText(String.valueOf(AutoloChamber));

        }
        if (AutoloChamber <=0){
            findViewById(R.id.specimenLCSubtractionButton).setVisibility(GONE);
        }
    }
    public void lowBasketIncrease(View view) {
        findViewById(R.id.sampleLowBasketSubtract).setVisibility(VISIBLE);
            RecordsActivity.Info.noAuto = false;
            autoLowBasket++;
            autoLowBasketText.setText(String.valueOf(autoLowBasket));
    }
    public void highChamberIncrease(View view) {
        //findViewById(R.id.specimenHCSubtractionButton4).setVisibility(VISIBLE);
        RecordsActivity.Info.noAuto=false;
        AutoHiChamber++;
        AutoHiChamberText.setText(String.valueOf(AutoHiChamber));
        if (AutoHiChamber > 0){
            findViewById(R.id.specimenHCSubtractionButton4).setVisibility(VISIBLE);
        }
    }
    public void highChamberDecrease(View view) {
        if (AutoHiChamber > 0) {
            RecordsActivity.Info.noAuto = false;
            AutoHiChamber--;
            AutoHiChamberText.setText(String.valueOf(AutoHiChamber));
            if (AutoHiChamber <=0) {
                findViewById(R.id.specimenHCSubtractionButton4).setVisibility(GONE);
            }
        }
    }

     public void lowBasketDecrease(View view) {
         if (autoLowBasket > 0) {
             RecordsActivity.Info.noAuto = false;
             autoLowBasket--;
             autoLowBasketText.setText(String.valueOf(autoLowBasket));
         }
         if (autoLowBasket <=0){
             findViewById(R.id.sampleLowBasketSubtract).setVisibility(GONE);
         }
    }
     public void highBasketIncrease(View view) {
         findViewById(R.id.sampleHighBasketSubtract).setVisibility(VISIBLE);
         RecordsActivity.Info.noAuto=false;
        autoHighbasket++;
            autoHighBasketText.setText(String.valueOf(autoHighbasket));
        }
     public void highBasketDecrease(View view) {
         if (autoHighbasket > 0) {
            RecordsActivity.Info.noAuto=false;
            autoHighbasket--;
            autoHighBasketText.setText(String.valueOf(autoHighbasket));
            }
         if (autoHighbasket <=0){
             findViewById(R.id.sampleHighBasketSubtract).setVisibility(GONE);
         }

    }
    public void ClickPark(View view){
        RecordsActivity.Info.noAuto=false;
        noPark.setChecked(false);
        LevleOne.setChecked(false);
        park.setChecked(true);
        autoBotAscent ="park";
    }

    public void ClickNoPark(View view) {
        RecordsActivity.Info.noAuto=false;
                                            Log.d("NoParkClick", "starting method");
        park.setChecked(false);             Log.d("NoParkClick", "set Park false");
        LevleOne.setChecked(false);         Log.d("NoParkClick", "set levleOne true");
        noPark.setChecked(true);            Log.d("NoParkClick", "set NoPark true");
        autoBotAscent="noPark";
    }
    public void ClickLevleOne(View view){
        RecordsActivity.Info.noAuto=false;
        park.setChecked(false);         Log.d("LevleOne", "set park false");
        noPark.setChecked(false);       Log.d("LevleOne", "set noPark false");
        LevleOne.setChecked(true);      Log.d("LevleOne", "set LevleOne true");

        autoBotAscent="LevleOne";  Log.d("LevleOne", String.valueOf(autoBotAscent));
        Log.d("LevleOne", String.valueOf(autoBotAscent));
    }


}