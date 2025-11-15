package com.example.myfirstapp;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.CheckBox;
import android.view.View;
import android.content.SharedPreferences;

=======

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

<<<<<<< HEAD
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)
=======
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)
public class Tele extends AppCompatActivity {
<<<<<<< HEAD

    CheckBox telechoice1, telechoice2, telechoice3, telechoice4, telechoice5, telechoice6,
            telechoice7, telechoice8, telechoice9, telechoice10, telechoice11, telechoice12,
            telechoice13, telechoice14, telechoice15, telechoice16, telechoice17, telechoice18;

    // Tele Groups
    String telegroup1, telegroup2, telegroup3, telegroup4, telegroup5,
            telegroup6, telegroup7, telegroup8, telegroup9;

    // Auto Groups (loaded from AutoActivity)
    String autogroup1, autogroup2, autogroup3, autogroup4, autogroup5,
            autogroup6, autogroup7, autogroup8, autogroup9;
=======
    RadioButton park, noPark, LevleOne, LevleTwo,LevleThree, noparked, barlyparked, fullparked, parkedwithothers;
    TextView teleNetZoneText, teleLowBasketText, teleHighBasketText,teleHiChamberText,teleloChamberText, overflowtxt, OverallpointS,text1,text2,text3,text4,text5,text6,text7,text8,text9;
    byte teleNetZone = 0, teleLowBasket = 0, teleHighBasket = 0,teleHiChamber=0, teleloChamber=0, Overflow=0, Overallpoints=0;
    CheckBox telechoice1, telechoice2, telechoice3, telechoice4, telechoice5, telechoice6, telechoice7, telechoice8, telechoice9, telechoice10, telechoice11, telechoice12, telechoice13, telechoice14, telechoice15, telechoice16;
    String teleBotAscent, parked, autogrup1, autogrup2, autogrup3,autogrup4,autogrup5,autogrup6, autogrup7, autogrup8, autogrup9, autogrup10, autogrup11, autogrup12, autogrup13, autogrup14, autogrup15, autogrup16, autogrup17, autogrup18;
>>>>>>> parent of 768c9ab (Replace RadioGroups with CheckBoxes in tele UI)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_tele); // Your XML name

<<<<<<< HEAD
        // Assign checkboxes
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
=======
        park =findViewById(R.id.telePark);
        noPark = findViewById(R.id.teleNoPark);
        LevleOne = findViewById(R.id.telelevel1);
        LevleTwo = findViewById(R.id.endlevel2);
        LevleThree = findViewById(R.id.endLevel3);
        noparked =findViewById(R.id.telypark1);
        barlyparked=findViewById(R.id.telybparled);
        fullparked=findViewById(R.id.telyfullpared);
        parkedwithothers=findViewById(R.id.telyparkedwithothers);
        telechoice1 = findViewById(R.id.telechoice19);
        telechoice2 = findViewById(R.id.telechoice20);
        telechoice3 = findViewById(R.id.telechoice21);
        telechoice4 = findViewById(R.id.telechoice22);
        telechoice5 = findViewById(R.id.telechoice23);
        telechoice6 = findViewById(R.id.telechoice24);
        telechoice7 = findViewById(R.id.telechoice25);
        telechoice8 = findViewById(R.id.telechoice26);
        telechoice9 = findViewById(R.id.telechoice27);
        telechoice10 = findViewById(R.id.telechoice28);
        telechoice11 = findViewById(R.id.telechoice29);
        telechoice12 = findViewById(R.id.telechoice30);
        telechoice13 = findViewById(R.id.telechoice31);
        telechoice14 = findViewById(R.id.telechoice32);
        telechoice15 = findViewById(R.id.telechoice33);
        telechoice16 = findViewById(R.id.telechoice34);
        text1=findViewById(R.id.textView14);
        text2=findViewById(R.id.textView8);
        text3=findViewById(R.id.textView9);
        text4=findViewById(R.id.textView7);
        text5=findViewById(R.id.textView12);
        text6=findViewById(R.id.textView16);
        text7=findViewById(R.id.textView15);
        text8=findViewById(R.id.textView19);
        text9=findViewById(R.id.textView17);
>>>>>>> parent of 768c9ab (Replace RadioGroups with CheckBoxes in tele UI)

        // Load tele data
        loadDataTele();

        // Load auto values (for initialization)
        loadAutoData();

        // Initialize tele from auto IF tele has not been changed yet
        if (allTeleNull()) {
            initializeFromAuto();
            saveDataTele();
        }

        setPreviousTele();
    }

    // ----------------------------------------------------------
    // AUTO DATA LOADER
    // ----------------------------------------------------------
    private void loadAutoData() {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        autogroup1 = prefs.getString("autogroup1", null);
        autogroup2 = prefs.getString("autogroup2", null);
        autogroup3 = prefs.getString("autogroup3", null);
        autogroup4 = prefs.getString("autogroup4", null);
        autogroup5 = prefs.getString("autogroup5", null);
        autogroup6 = prefs.getString("autogroup6", null);
        autogroup7 = prefs.getString("autogroup7", null);
        autogroup8 = prefs.getString("autogroup8", null);
        autogroup9 = prefs.getString("autogroup9", null);
    }

    private boolean allTeleNull() {
        return telegroup1 == null && telegroup2 == null && telegroup3 == null &&
                telegroup4 == null && telegroup5 == null && telegroup6 == null &&
                telegroup7 == null && telegroup8 == null && telegroup9 == null;
    }

    private void initializeFromAuto() {
        telegroup1 = autogroup1;
        telegroup2 = autogroup2;
        telegroup3 = autogroup3;
        telegroup4 = autogroup4;
        telegroup5 = autogroup5;
        telegroup6 = autogroup6;
        telegroup7 = autogroup7;
        telegroup8 = autogroup8;
        telegroup9 = autogroup9;
    }

    // ----------------------------------------------------------
    // LOAD TELE DATA
    // ----------------------------------------------------------
    private void loadDataTele() {
        SharedPreferences prefs = getSharedPreferences("MyPrefsTele", MODE_PRIVATE);

        telegroup1 = prefs.getString("telegroup1", null);
        telegroup2 = prefs.getString("telegroup2", null);
        telegroup3 = prefs.getString("telegroup3", null);
        telegroup4 = prefs.getString("telegroup4", null);
        telegroup5 = prefs.getString("telegroup5", null);
        telegroup6 = prefs.getString("telegroup6", null);
        telegroup7 = prefs.getString("telegroup7", null);
        telegroup8 = prefs.getString("telegroup8", null);
        telegroup9 = prefs.getString("telegroup9", null);
    }

    // ----------------------------------------------------------
    // SAVE TELE DATA
    // ----------------------------------------------------------
    private void saveDataTele() {
        SharedPreferences prefs = getSharedPreferences("MyPrefsTele", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

<<<<<<< HEAD
<<<<<<< HEAD
        editor.putString("telegroup1", telegroup1);
        editor.putString("telegroup2", telegroup2);
        editor.putString("telegroup3", telegroup3);
        editor.putString("telegroup4", telegroup4);
        editor.putString("telegroup5", telegroup5);
        editor.putString("telegroup6", telegroup6);
        editor.putString("telegroup7", telegroup7);
        editor.putString("telegroup8", telegroup8);
        editor.putString("telegroup9", telegroup9);
=======
=======
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)
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
<<<<<<< HEAD
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)
=======
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)

        editor.apply();
    }

<<<<<<< HEAD
<<<<<<< HEAD
    // ----------------------------------------------------------
    // SET PREVIOUS TELE (REFLECT UI)
    // ----------------------------------------------------------
    private void setPreviousTele() {

        // Group 1
        updateCheckboxes(telechoice1, telechoice2, telegroup1);

        // Group 2
        updateCheckboxes(telechoice3, telechoice4, telegroup2);

        // Group 3
        updateCheckboxes(telechoice5, telechoice6, telegroup3);

        // Group 4
        updateCheckboxes(telechoice7, telechoice8, telegroup4);

        // Group 5
        updateCheckboxes(telechoice9, telechoice10, telegroup5);

        // Group 6
        updateCheckboxes(telechoice11, telechoice12, telegroup6);

        // Group 7
        updateCheckboxes(telechoice13, telechoice14, telegroup7);

        // Group 8
        updateCheckboxes(telechoice15, telechoice16, telegroup8);

        // Group 9
        updateCheckboxes(telechoice17, telechoice18, telegroup9);
    }

    private void updateCheckboxes(CheckBox green, CheckBox purple, String value) {
        green.setChecked(false);
        purple.setChecked(false);

        if ("Green".equals(value)) {
            green.setChecked(true);
        } else if ("purple".equals(value)) {
            purple.setChecked(true);
        }
    }

    // ----------------------------------------------------------
    // TELE CHOICE HANDLERS (ALL 18)
    // ----------------------------------------------------------

<<<<<<< HEAD
    public void telechoice1(View view) {
        if (telechoice1.isChecked()) {
=======
=======
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)
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
<<<<<<< HEAD
            telechoice1.setChecked(true);
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)
            telechoice2.setChecked(false);
            telegroup1 = "Green";
        } else {
            telegroup1 = null;
=======
            telychoice1.setChecked(true);
            telychoice2.setChecked(false);
>>>>>>> parent of 768c9ab (Replace RadioGroups with CheckBoxes in tele UI)
        }
<<<<<<< HEAD
<<<<<<< HEAD
        saveDataTele();
    }
=======
=======
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)
        if (autogrup1 == "telychoice2") {
            telychoice1.setChecked(false);
            telychoice2.setChecked(true);
        }
<<<<<<< HEAD
        if (autogrup2 == "telychoice3") {
            telechoice3.setChecked(true);
            telechoice4.setChecked(false);
        }
        if (autogrup2 == "telychoice4") {
            telechoice4.setChecked(true);
            telechoice3.setChecked(false);
        }
        if (autogrup3 == "telychoice5") {
            telechoice5.setChecked(true);
            telechoice6.setChecked(false);
        }
        if (autogrup3 == "telychoice6") {
            telechoice6.setChecked(true);
            telechoice5.setChecked(false);
        }
        if (autogrup4 == "telychoice7") {
            telechoice7.setChecked(true);
            telechoice8.setChecked(false);
        }
        if (autogrup4 == "telychoice8") {
            telechoice8.setChecked(true);
            telechoice7.setChecked(false);
        }
        if (autogrup5 == "telychoice9") {
            telechoice9.setChecked(true);
            telechoice10.setChecked(false);
        }
        if (autogrup5 == "telychoice10") {
            telechoice10.setChecked(true);
            telechoice9.setChecked(false);
        }
        if (autogrup6 == "telychoice11") {
            telechoice11.setChecked(true);
            telechoice12.setChecked(false);
        }
        if (autogrup6 == "telychoice12") {
            telechoice12.setChecked(true);
            telechoice11.setChecked(false);
        }
        if (autogrup7 == "telychoice13") {
            telechoice13.setChecked(true);
            telechoice14.setChecked(false);
        }
        if (autogrup7 == "telychoice14") {
            telechoice14.setChecked(true);
            telechoice13.setChecked(false);
        }
        if (autogrup8 == "telychoice15") {
            telechoice15.setChecked(true);
            telechoice16.setChecked(false);
        }
        if (autogrup8 == "telychoice16") {
            telechoice16.setChecked(true);
            telechoice15.setChecked(false);
        }
        if (autogrup9 == "telychoice17") {
            telechoice17.setChecked(true);
            telechoice18.setChecked(false);
        }
        if (autogrup9 == "telychoice18") {
            telechoice18.setChecked(true);
            telechoice17.setChecked(false);
=======
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
>>>>>>> parent of 768c9ab (Replace RadioGroups with CheckBoxes in tele UI)
        }
        }
<<<<<<< HEAD
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)

    public void telechoice2(View view) {
        if (telechoice2.isChecked()) {
            telechoice1.setChecked(false);
            telegroup1 = "purple";
        } else {
            telegroup1 = null;
        }
        saveDataTele();
    }
=======
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)

    public void telechoice3(View view) {
        if (telechoice3.isChecked()) {
            telechoice4.setChecked(false);
            telegroup2 = "Green";
        } else {
            telegroup2 = null;
        }
        saveDataTele();
    }

    public void telechoice4(View view) {
        if (telechoice4.isChecked()) {
            telechoice3.setChecked(false);
            telegroup2 = "purple";
        } else {
            telegroup2 = null;
        }
        saveDataTele();
    }

    public void telechoice5(View view) {
        if (telechoice5.isChecked()) {
            telechoice6.setChecked(false);
            telegroup3 = "Green";
        } else {
            telegroup3 = null;
        }
        saveDataTele();
    }

    public void telechoice6(View view) {
        if (telechoice6.isChecked()) {
            telechoice5.setChecked(false);
            telegroup3 = "purple";
        } else {
            telegroup3 = null;
        }
        saveDataTele();
    }

    public void telechoice7(View view) {
        if (telechoice7.isChecked()) {
            telechoice8.setChecked(false);
            telegroup4 = "Green";
        } else {
            telegroup4 = null;
        }
        saveDataTele();
    }

    public void telechoice8(View view) {
        if (telechoice8.isChecked()) {
            telechoice7.setChecked(false);
            telegroup4 = "purple";
        } else {
            telegroup4 = null;
        }
        saveDataTele();
    }

    public void telechoice9(View view) {
        if (telechoice9.isChecked()) {
            telechoice10.setChecked(false);
            telegroup5 = "Green";
        } else {
            telegroup5 = null;
        }
        saveDataTele();
    }

    public void telechoice10(View view) {
        if (telechoice10.isChecked()) {
            telechoice9.setChecked(false);
            telegroup5 = "purple";
        } else {
            telegroup5 = null;
        }
        saveDataTele();
    }

    public void telechoice11(View view) {
        if (telechoice11.isChecked()) {
            telechoice12.setChecked(false);
            telegroup6 = "Green";
        } else {
            telegroup6 = null;
        }
        saveDataTele();
    }

    public void telechoice12(View view) {
        if (telechoice12.isChecked()) {
            telechoice11.setChecked(false);
            telegroup6 = "purple";
        } else {
            telegroup6 = null;
        }
        saveDataTele();
    }

    public void telechoice13(View view) {
        if (telechoice13.isChecked()) {
            telechoice14.setChecked(false);
            telegroup7 = "Green";
        } else {
            telegroup7 = null;
        }
        saveDataTele();
    }

    public void telechoice14(View view) {
        if (telechoice14.isChecked()) {
            telechoice13.setChecked(false);
            telegroup7 = "purple";
        } else {
            telegroup7 = null;
        }
        saveDataTele();
    }

    public void telechoice15(View view) {
        if (telechoice15.isChecked()) {
            telechoice16.setChecked(false);
            telegroup8 = "Green";
        } else {
            telegroup8 = null;
        }
        saveDataTele();
    }

    public void telechoice16(View view) {
        if (telechoice16.isChecked()) {
            telechoice15.setChecked(false);
            telegroup8 = "purple";
        } else {
            telegroup8 = null;
        }
        saveDataTele();
    }

    public void telechoice17(View view) {
        if (telechoice17.isChecked()) {
            telechoice18.setChecked(false);
            telegroup9 = "Green";
        } else {
            telegroup9 = null;
        }
        saveDataTele();
    }

    public void telechoice18(View view) {
        if (telechoice18.isChecked()) {
            telechoice17.setChecked(false);
            telegroup9 = "purple";
        } else {
            telegroup9 = null;
        }
        saveDataTele();
=======
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
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)
        AUTOsave.putExtra("autogrup9", String.valueOf(autogrup9));
        //RecordsActivity.Info.telegrup10 = autogrup10;
        //AUTOsave.putExtra("autogrup10", String.valueOf(autogrup10));
        //RecordsActivity.Info.telegrup11 = autogrup11;
        //AUTOsave.putExtra("autogrup11", String.valueOf(autogrup11));
        //RecordsActivity.Info.telegrup12 = autogrup12;
        //AUTOsave.putExtra("autogrup12", String.valueOf(autogrup12));
        //RecordsActivity.Info.telegrup13 = autogrup13;
        //AUTOsave.putExtra("autogrup13", String.valueOf(autogrup13));
        //RecordsActivity.Info.telegrup14 = autogrup14;
        //AUTOsave.putExtra("autogrup14", String.valueOf(autogrup14));
        //RecordsActivity.Info.telegrup15 = autogrup15;
        //AUTOsave.putExtra("autogrup15", String.valueOf(autogrup15));
        //RecordsActivity.Info.telegrup16 = autogrup16;
        //AUTOsave.putExtra("autogrup16", String.valueOf(autogrup16));
        //RecordsActivity.Info.telegrup17 = autogrup17;
        //AUTOsave.putExtra("autogrup17", String.valueOf(autogrup17));
        //RecordsActivity.Info.telegrup18 = autogrup18;
        //AUTOsave.putExtra("autogrup18", String.valueOf(autogrup18));
<<<<<<< HEAD
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)
=======
>>>>>>> parent of 0b9fbe1 (Refactor string comparisons and update UI elements)

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
<<<<<<< HEAD
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
>>>>>>> parent of f010446 (Expand auto group choices and update variable names)
    }
=======
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

>>>>>>> parent of 768c9ab (Replace RadioGroups with CheckBoxes in tele UI)
}