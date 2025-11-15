package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.CheckBox;
import android.view.View;
import android.content.SharedPreferences;

public class Tele extends AppCompatActivity {

    CheckBox telechoice1, telechoice2, telechoice3, telechoice4, telechoice5, telechoice6,
            telechoice7, telechoice8, telechoice9, telechoice10, telechoice11, telechoice12,
            telechoice13, telechoice14, telechoice15, telechoice16, telechoice17, telechoice18;

    // Tele Groups
    String telegroup1, telegroup2, telegroup3, telegroup4, telegroup5,
            telegroup6, telegroup7, telegroup8, telegroup9;

    // Auto Groups (loaded from AutoActivity)
    String autogroup1, autogroup2, autogroup3, autogroup4, autogroup5,
            autogroup6, autogroup7, autogroup8, autogroup9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_tele); // Your XML name

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

        editor.putString("telegroup1", telegroup1);
        editor.putString("telegroup2", telegroup2);
        editor.putString("telegroup3", telegroup3);
        editor.putString("telegroup4", telegroup4);
        editor.putString("telegroup5", telegroup5);
        editor.putString("telegroup6", telegroup6);
        editor.putString("telegroup7", telegroup7);
        editor.putString("telegroup8", telegroup8);
        editor.putString("telegroup9", telegroup9);

        editor.apply();
    }

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

    public void telechoice1(View view) {
        if (telechoice1.isChecked()) {
            telechoice2.setChecked(false);
            telegroup1 = "Green";
        } else {
            telegroup1 = null;
        }
        saveDataTele();
    }

    public void telechoice2(View view) {
        if (telechoice2.isChecked()) {
            telechoice1.setChecked(false);
            telegroup1 = "purple";
        } else {
            telegroup1 = null;
        }
        saveDataTele();
    }

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
    }
}