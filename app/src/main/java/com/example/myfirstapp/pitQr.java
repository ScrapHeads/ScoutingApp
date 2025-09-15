package com.example.myfirstapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class pitQr extends AppCompatActivity {

    // variables for imageview, edittext,
    // button, bitmap and qrencoder.
    private ImageView qrCodeIV;
    private EditText dataEdt;
    String pitqrString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pit_qr);
        qrCodeIV = findViewById(R.id.pitQrImage);
        this.setRequestedOrientation(ActivityInfo. SCREEN_ORIENTATION_LANDSCAPE);

        {
            String json = (RecordsActivity.Info.pitTeamNumber);
            json += ("\t " + RecordsActivity.Info.pitBotTipe);
            json += ("\t " + RecordsActivity.Info.pitTask);
            json += ("\t " + RecordsActivity.Info.pitAuto);
            json += ("\t " + RecordsActivity.Info.pitAutoTipe);
            json += ("\r"+"\b"+"\b"+"\b"+"\b"+"\b");
           /* json+=("\t"+RecordsActivity.Info.matchNumber );
            json += ("\t "+ RecordsActivity.Info.alliance);
            json+=("\t"+ RecordsActivity.Info.preload);
            json += ("\t "+ RecordsActivity.Info.fieldPosition);              Log.d("rAjson", json);

            json += ("\t "+ RecordsActivity.Info.MakesAGoodAlliancePartener);
            json += ("\t "+ RecordsActivity.Info.skillLvl);
            //auto activity
            json += ("\t "+ RecordsActivity.Info.autoLowChamberText);
            json += ("\t "+ RecordsActivity.Info.autoHighChamberText);
            json += ("\t "+ RecordsActivity.Info.autoNetZoneText);
            json += ("\t "+ RecordsActivity.Info.autoLowBasketText);
            json += ("\t "+ RecordsActivity.Info.autoHighBasketText);
            json += ("\t "+ RecordsActivity.Info.AutoAscent);
            json += ("\t "+ RecordsActivity.Info.noAuto);                     Log.d("rAjson",json);

            //tele activity
            json += ("\t "+ RecordsActivity.Info.teleSpecimenLowChamber);
            json += ("\t "+ RecordsActivity.Info.teleHighChamber);
            json += ("\t "+ RecordsActivity.Info.teleNetZoneText);
            json += ("\t "+ RecordsActivity.Info.teleLowBasketText);
            json += ("\t "+ RecordsActivity.Info.teleHighBasketText);
            json += ("\t "+ RecordsActivity.Info.teleAscent);            Log.d("rAjson", json);

            //Match Notes activity
            json += ("\t "+ RecordsActivity.Info.tipped);
            json += ("\t "+ RecordsActivity.Info.droppedPieces);
            json += ("\t "+ RecordsActivity.Info.BotDied);
            json += ("\t "+ RecordsActivity.Info.ArmWorksSlowly);
            json += ("\t "+ RecordsActivity.Info.BotMovesSlow);
            json += ("\t "+ RecordsActivity.Info.MinorFoul);
            json += ("\t "+ RecordsActivity.Info.MajorFoul);
            json += ("\t "+ RecordsActivity.Info.endCommitBox+"\n"+"\b");
            json+=("\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b");
            */pitqrString = json;
            generateQRCode(pitqrString);

        }
    }
    public void back(View view){
        Intent back = new Intent(this, pitPreGameInfo.class);
        startActivity(back);
    }
    private void generateQRCode(String text){               Log.d("qAgen","Start Code Generation");
        BarcodeEncoder barcodeEncoder
                = new BarcodeEncoder();
        try {
            // This method returns a Bitmap image of the
            // encoded text with a height and width of 400
            // pixels.
            Bitmap bitmap = barcodeEncoder.encodeBitmap(text, BarcodeFormat.QR_CODE, 400, 400);
            qrCodeIV.setImageBitmap(bitmap); // Sets the Bitmap to ImageView
        }
        catch (WriterException e) {
            e.printStackTrace();
        }
    }
    public void clear(View view) {                                                               Log.d("qAClr","Clear Called");
        Intent news = new Intent(this, pitPreGameInfo.class);                        Log.d("qAClr","inish main activity");

        //main activity
        Log.d("qAClr","Old match" + RecordsActivity.Info.matchNumber);
        RecordsActivity.Info.matchNumber = "1";
        RecordsActivity.Info.teamNumber = "";                                                   Log.d("qAClr",RecordsActivity.Info.teamNumber);
        RecordsActivity.Info.preload = "";                                                      Log.d("qAClr",RecordsActivity.Info.preload);
        RecordsActivity.Info.fieldPosition = 0;                                                 Log.d("qAClr", String.valueOf(RecordsActivity.Info.fieldPosition));
        Log.d("qAClr","Done Reseting Main Vars");

        //auto activity
        RecordsActivity.Info.autoLowChamberText = 0;
        RecordsActivity.Info.autoHighChamberText = 0;
        RecordsActivity.Info.autoNetZoneText = 0;
        RecordsActivity.Info.autoLowBasketText = 0;
        RecordsActivity.Info.autoHighBasketText = 0;
        RecordsActivity.Info.AutoAscent = "";                                                   Log.d("qAClr","Done Reseting Auto Vars");

        //tele activity
        RecordsActivity.Info.teleSpecimenLowChamber = 0;
        RecordsActivity.Info.teleHighChamber = 0;
        RecordsActivity.Info.teleNetZoneText = 0;
        RecordsActivity.Info.teleLowBasketText = 0;
        RecordsActivity.Info.teleHighBasketText = 0;
        RecordsActivity.Info.teleAscent = "";                                                   Log.d("qAClr","Done Reseting Tele Vars");

        //Match notes
        RecordsActivity.Info.skillLvl = 0;
        RecordsActivity.Info.tipped = false;
        RecordsActivity.Info.droppedPieces = false;
        RecordsActivity.Info.BotDied = false;
        RecordsActivity.Info.ArmWorksSlowly = false;
        RecordsActivity.Info.BotMovesSlow = false;
        RecordsActivity.Info.MakesAGoodAlliancePartener = false;
        RecordsActivity.Info.MinorFoul = 0;
        RecordsActivity.Info.MajorFoul = 0;
        RecordsActivity.Info.endCommitBox = "";
        RecordsActivity.Info.pitTeamNumber="";
        RecordsActivity.Info.pitBotTipe="";
        RecordsActivity.Info.pitTask="";
        RecordsActivity.Info.pitAuto="";
        RecordsActivity.Info.pitAutoTipe="";

        Log.d("qAClr","Done Reseting Notes Vars");
        startActivity(news);                                                                    Log.d("qAClr","Load Main Activity");


    }
}