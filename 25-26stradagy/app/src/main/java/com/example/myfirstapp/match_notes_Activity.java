package com.example.myfirstapp;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class match_notes_Activity extends AppCompatActivity {
    byte skillLvl;
    RadioButton skillLvlOne, skillLvlTwo, skillLvlThree, skillLvlFour;
    TextView endCommitBox, MajorFoulText, MinorFoulText;
    byte MajorFoul = 0, MinorFoul2 = 0;
    CheckBox matchNotesOne, matchNotesTwo, matchNotesThree, matchNotesFour, matchNotesfive, matchNotesSix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_notes);
        this.setRequestedOrientation(ActivityInfo. SCREEN_ORIENTATION_LANDSCAPE);
        if (MinorFoul2 <=0){
            findViewById(R.id.sampleNetSubtract3).setVisibility(GONE);
        }
        if (MajorFoul <=0){
            findViewById(R.id.sampleNetSubtract2).setVisibility(GONE);
        }
        skillLvlOne=findViewById(R.id.radioButton);
        skillLvlTwo=findViewById(R.id.radioButton2);
        skillLvlThree=findViewById(R.id.radioButton3);
        skillLvlFour=findViewById(R.id.radioButton4);
        endCommitBox=findViewById(R.id.endCommitBox);
        matchNotesOne = findViewById(R.id.matchNotesOne);
        matchNotesTwo = findViewById(R.id.matchNotesTwo);
        matchNotesThree = findViewById(R.id.matchNotesThree);
        matchNotesFour = findViewById(R.id.matchNotesFour);
        matchNotesfive = findViewById(R.id.matchNotesfive);
        matchNotesSix = findViewById(R.id.matchNotesSix);
        MajorFoulText = findViewById(R.id.sampleNetZoneCount2);
        MinorFoulText = findViewById(R.id.sampleNetZoneCount4);
        setPrevious();

    }
    public void setPrevious() {
        Intent previous = getIntent();
        MajorFoulText.setText(previous.getStringExtra("MajorFoul"));
        MajorFoulText.setText(String.valueOf(RecordsActivity.Info.MajorFoul));
        MinorFoulText.setText(previous.getStringExtra("MinorFoul"));
        MinorFoulText.setText(String.valueOf(RecordsActivity.Info.MinorFoul));
        skillLvl = (RecordsActivity.Info.skillLvl);
        endCommitBox.setText(previous.getStringExtra("endCommitBox"));
        endCommitBox.setText(String.valueOf(RecordsActivity.Info.endCommitBox));

        if (skillLvl == 1) {
            skillLvlTwo.setChecked(false);
            skillLvlThree.setChecked(false);
            skillLvlFour.setChecked(false);
            skillLvlOne.setChecked(true);
        }
        if (skillLvl == 2) {
            skillLvlOne.setChecked(false);
            skillLvlThree.setChecked(false);
            skillLvlFour.setChecked(false);
            skillLvlTwo.setChecked(true);
        }
        if (skillLvl == 3) {
            skillLvlOne.setChecked(false);
            skillLvlTwo.setChecked(false);
            skillLvlFour.setChecked(false);
            skillLvlThree.setChecked(true);
        }
        if (skillLvl == 4) {
            skillLvlOne.setChecked(false);
            skillLvlTwo.setChecked(false);
            skillLvlThree.setChecked(false);
            skillLvlFour.setChecked(true);
        }
        if ((RecordsActivity.Info.tipped)==true) {
            matchNotesOne.setChecked(true);
        }
        if (RecordsActivity.Info.droppedPieces==true) {
            matchNotesTwo.setChecked(true);
        }
        if (RecordsActivity.Info.BotDied==true) {
            matchNotesThree.setChecked(true);
        }
        if (RecordsActivity.Info.ArmWorksSlowly==true) {
            matchNotesFour.setChecked(true);
        }
        if (RecordsActivity.Info.BotMovesSlow==true) {
            matchNotesfive.setChecked(true);
        }
        if (RecordsActivity.Info.MakesAGoodAlliancePartener==true) {
            matchNotesSix.setChecked(true);
        }
        MajorFoul = Byte.parseByte(MajorFoulText.getText().toString());
        if (MajorFoul == 0){
            findViewById(R.id.sampleNetSubtract2).setVisibility(INVISIBLE);
        }
        if (MajorFoul > 0) {
            findViewById(R.id.sampleNetSubtract2).setVisibility(VISIBLE);
        }
        MinorFoul2 = Byte.parseByte(MinorFoulText.getText().toString());
        if (MinorFoul2 == 0){
            findViewById(R.id.sampleNetSubtract3).setVisibility(INVISIBLE);
        }
        if (MinorFoul2 > 0) {
            findViewById(R.id.sampleNetSubtract3).setVisibility(VISIBLE);
        }

    }
        public void saveData () {
            Intent save = new Intent(this, RecordsActivity.class);
            RecordsActivity.Info.endCommitBox = endCommitBox.getText().toString();
            save.putExtra("endCommitBox", endCommitBox.getText().toString());         Log.d("Vput",endCommitBox.getText().toString()); Log.d("Vput",RecordsActivity.Info.endCommitBox);
            RecordsActivity.Info.MajorFoul= Byte.parseByte(MajorFoulText.getText().toString());
            save.putExtra("MajorFoul",  MajorFoulText.getText().toString());
            RecordsActivity.Info.MinorFoul= Byte.parseByte(MinorFoulText.getText().toString());
            save.putExtra("MinorFoul",  MinorFoulText.getText().toString());
            RecordsActivity.Info.skillLvl = skillLvl;
            save.putExtra("skillLvl", skillLvl);
            Log.d("Vput", String.valueOf(skillLvl));
            Log.d("Vput", String.valueOf(RecordsActivity.Info.skillLvl));
        }

    public void backSpecimen (View view){
            Intent back = new Intent(this, Tele.class);
            startActivity(back);
            saveData();
        }
        public void skillLvlOne (View view){
            skillLvlTwo.setChecked(false);
            skillLvlThree.setChecked(false);
            skillLvlFour.setChecked(false);
            skillLvlOne.setChecked(true);
            skillLvl = 1;
        }
    public void skillLvlTwo (View view){
        skillLvlOne.setChecked(false);
        skillLvlThree.setChecked(false);
        skillLvlFour.setChecked(false);
        skillLvlTwo.setChecked(true);
        skillLvl = 2;
    }
    public void skillLvlThree (View view){
            skillLvlOne.setChecked(false);
            skillLvlTwo.setChecked(false);
            skillLvlFour.setChecked(false);
            skillLvlThree.setChecked(true);
            skillLvl = 3;
        }
    public void skillLvlFour (View view){
            skillLvlOne.setChecked(false);
            skillLvlTwo.setChecked(false);
            skillLvlThree.setChecked(false);
            skillLvlFour.setChecked(true);
            skillLvl = 4;
        }
        public void tipped(View view){
            boolean checked = ((CheckBox) view).isChecked();

            switch (view.getId()) {
                case R.id.matchNotesOne:
                    if (checked)
                        (RecordsActivity.Info.tipped) = true;
                    else
                        (RecordsActivity.Info.tipped) = false;

                    break;
            }
        }


        public void BotDroppedPieces(View view){
            boolean checked = ((CheckBox) view).isChecked();

            switch (view.getId()) {
                case R.id.matchNotesTwo:
                    if (checked)
                        (RecordsActivity.Info.droppedPieces) = true;
                    else
                        (RecordsActivity.Info.droppedPieces) = false;

                    break;
            }

        }
        public void BotDied(View view) {
            boolean checked = ((CheckBox) view).isChecked();

            switch (view.getId()) {
                case R.id.matchNotesThree:
                    if (checked)
                        (RecordsActivity.Info.BotDied) = true;
                    else
                        (RecordsActivity.Info.BotDied) = false;

                    break;
            }
        }
        public void ArmWorksSlowly (View view){
            boolean checked = ((CheckBox) view).isChecked();

            switch (view.getId()) {
                case R.id.matchNotesFour:
                    if (checked)
                        (RecordsActivity.Info.ArmWorksSlowly) = true;
                    else
                        (RecordsActivity.Info.ArmWorksSlowly) = false;

                    break;
            }
        }
        public void BotMovesSlow(View view){
            boolean checked = ((CheckBox) view).isChecked();

            switch (view.getId()) {
                case R.id.matchNotesfive:
                    if (checked)
                        (RecordsActivity.Info.BotMovesSlow) = true;
                    else
                        (RecordsActivity.Info.BotMovesSlow) = false;

                    break;
            }

        }
        public void MakesAGoodAlliancePartener(View view){
            boolean checked = ((CheckBox) view).isChecked();

            switch (view.getId()) {
                case R.id.matchNotesSix:
                    if (checked)
                        (RecordsActivity.Info.MakesAGoodAlliancePartener) = true;
                    else
                        (RecordsActivity.Info.MakesAGoodAlliancePartener) = false;

                    break;
            }
        }
        public void ToQr(View view){
            Intent next = new Intent(this, QrActivity.class);             Log.d("logNextClick", "Make a Page");
            saveData();                                                                 Log.d("logNextClick", "Save Data");
            startActivity(next);                                                        Log.d("logNextClick", "open Page");
        }
    public void netZoneIncrease2(View view) {
        findViewById(R.id.sampleNetSubtract2).setVisibility(VISIBLE);
        MajorFoul++;
        MajorFoulText.setText(String.valueOf(MajorFoul));
    }
    public void netZoneDecrease2(View view) {
        if (MajorFoul > 0) {
        MajorFoul--;
        MajorFoulText.setText(String.valueOf(MajorFoul));
        }
        if (MajorFoul <=0){
            findViewById(R.id.sampleNetSubtract2).setVisibility(GONE);
        }
    }
    public void netZoneIncrease3(View view) {
        findViewById(R.id.sampleNetSubtract3).setVisibility(VISIBLE);
        MinorFoul2++;
        MinorFoulText.setText(String.valueOf(MinorFoul2));
    }
    public void netZoneDecrease3(View view) {
        if (MinorFoul2 > 0) {
        MinorFoul2--;
        MinorFoulText.setText(String.valueOf(MinorFoul2));
        }
        if (MinorFoul2 <=0){
            findViewById(R.id.sampleNetSubtract3).setVisibility(GONE);
        }
    }

}

