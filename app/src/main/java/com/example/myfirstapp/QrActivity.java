package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class QrActivity extends AppCompatActivity {

    private static final int STORAGE_PERMISSION_CODE = 1001;

    private ImageView qrCodeIV;
    private TextView resetbut;
    private String qrString;
    private Bitmap Qrbmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        qrCodeIV = findViewById(R.id.qrImage);
        resetbut = findViewById(R.id.generateQrBtn);

        // Request storage permission for Android 9 and below
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            checkStoragePermission();
        }

        // Build QR data string
        String json = (RecordsActivity.Info.scoutName);
        json += ("\t " + RecordsActivity.Info.teamNumber);
        json += ("\t" + RecordsActivity.Info.matchNumber);
        json += ("\t " + RecordsActivity.Info.alliance);
        json += (" \t " + RecordsActivity.Info.fieldPositionNuw);

        // Auto
        json += (" \t " + RecordsActivity.Info.overflowtxtauto);
        json += (" \t"+ RecordsActivity.Info.AutoOverallpoint);
        json += (" \t " + RecordsActivity.Info.parkedAuto);
        json += (" \t " + RecordsActivity.Info.ppggpppgp);
        json += (" \t " + RecordsActivity.Info.autogrup1);
        json += (" \t " + RecordsActivity.Info.autogrup2);
        json += (" \t " + RecordsActivity.Info.autogrup3);
        json += (" \t " + RecordsActivity.Info.autogrup5);
        json += (" \t " + RecordsActivity.Info.autogrup6);
        json += (" \t " + RecordsActivity.Info.autogrup7);
        json += (" \t " + RecordsActivity.Info.autogrup8);
        json += (" \t " + RecordsActivity.Info.autogrup9);

        // Tele
        json += (" \t " + RecordsActivity.Info.overflowtxtTely);
        json += (" \t "+ RecordsActivity.Info.teleOverallpoint);
        json += (" \t " + RecordsActivity.Info.telyparked);
        json += (" \t " + RecordsActivity.Info.telegrup1);
        json += (" \t " + RecordsActivity.Info.telegrup2);
        json += (" \t " + RecordsActivity.Info.telegrup3);
        json += (" \t " + RecordsActivity.Info.telegrup4);
        json += (" \t " + RecordsActivity.Info.telegrup5);
        json += (" \t " + RecordsActivity.Info.telegrup6);
        json += (" \t " + RecordsActivity.Info.telegrup7);
        json += (" \t " + RecordsActivity.Info.telegrup8);
        json += (" \t " + RecordsActivity.Info.telegrup9);
        json += (" \t " + RecordsActivity.Info.telegrup10);
        json += (" \t " + RecordsActivity.Info.telegrup11);
        json += (" \t " + RecordsActivity.Info.telegrup12);
        json += (" \t " + RecordsActivity.Info.telegrup13);
        json += (" \t " + RecordsActivity.Info.telegrup14);
        json += (" \t " + RecordsActivity.Info.telegrup15);
        json += (" \t " + RecordsActivity.Info.telegrup16);
        json += (" \t " + RecordsActivity.Info.telegrup17);
        json += (" \t " + RecordsActivity.Info.telegrup18);

        // Match notes
        json += (" \t " + RecordsActivity.Info.tipped);
        json += (" \t " + RecordsActivity.Info.droppedPieces);
        json += (" \t " + RecordsActivity.Info.BotDied);
        json += (" \t " + RecordsActivity.Info.ArmWorksSlowly);
        json += (" \t " + RecordsActivity.Info.BotMovesSlow);
        json += (" \t " + RecordsActivity.Info.MinorFoul);
        json += (" \t " + RecordsActivity.Info.MajorFoul);
        json += (" \t " + RecordsActivity.Info.endCommitBox);

        Log.d("rAjson", json);
        qrString = json;
        generateQRCode(qrString);
    }

    private void checkStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    STORAGE_PERMISSION_CODE);
        }
    }

    private void generateQRCode(String text) {
        Log.d("qAgen", "Start Code Generation");
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(text, BarcodeFormat.QR_CODE, 400, 400);
            qrCodeIV.setImageBitmap(bitmap);
            Qrbmp = bitmap;

            // Optionally auto-save on creation
            new Thread(() -> {
                try {
                    saveImage(bitmap);
                    runOnUiThread(() ->
                            Toast.makeText(this, "QR saved to DCIM/QR", Toast.LENGTH_SHORT).show());
                } catch (IOException e) {
                    Log.e("QR_SAVE", "Error saving QR", e);
                }
            }).start();

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public void TheLastBack(View view) {
        Intent Back = new Intent(this, match_notes_Activity.class);
        startActivity(Back);
    }

    public void setGenerateQrBtn(View view) {
        Log.d("qAgen", "button pushed");
        if (Qrbmp != null) {
            new Thread(() -> {
                try {
                    saveImage(Qrbmp);
                    runOnUiThread(() ->
                            Toast.makeText(this, "QR saved manually!", Toast.LENGTH_SHORT).show());
                } catch (IOException e) {
                    Log.e("QR_SAVE", "Error saving on button press", e);
                }
            }).start();
        } else {
            Toast.makeText(this, "QR not generated yet!", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean saveImage(Bitmap bitmap) throws IOException {
        if (bitmap == null) return false;
        OutputStream fos = null;
        boolean saved;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, System.currentTimeMillis() + ".png");
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/png");
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, "DCIM/QR");

            Uri imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (imageUri != null) {
                fos = getContentResolver().openOutputStream(imageUri);
            } else {
                Log.e("QR_SAVE", "Failed to create image URI");
                return false;
            }
        } else {
            File dir = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DCIM), "QR");
            if (!dir.exists()) dir.mkdirs();

            File image = new File(dir, System.currentTimeMillis() + ".png");
            fos = new FileOutputStream(image);
        }

        saved = bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
        if (fos != null) {
            fos.flush();
            fos.close();
        }

        return saved;
    }

    public void clear(View view) {
        Log.d("qAClr", "Clear Called");
        Intent news = new Intent(this, preGameInfo.class);

        try {
            RecordsActivity.Info.matchNumber = Integer.toString(Integer.parseInt(RecordsActivity.Info.matchNumber) + 1);
        } catch (Exception e) {
            RecordsActivity.Info.matchNumber = "1";
        }

        RecordsActivity.Info.teamNumber = "";
        //RecordsActivity.Info.preload = "";
        RecordsActivity.Info.fieldPositionNuw = "";

        RecordsActivity.Info.overflowtxtauto=0;
        RecordsActivity.Info.parkedAuto="";
        RecordsActivity.Info.ppggpppgp="";
        RecordsActivity.Info.autogrup1="";
        RecordsActivity.Info.autogrup2="";
        RecordsActivity.Info.autogrup3="";
        RecordsActivity.Info.autogrup5="";
        RecordsActivity.Info.autogrup6="";
        RecordsActivity.Info.autogrup7="";
        RecordsActivity.Info.autogrup8="";
        RecordsActivity.Info.autogrup9="";
        RecordsActivity.Info.overflowtxtTely=0;
        RecordsActivity.Info.telyparked="";
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


        //RecordsActivity.Info.autoLowChamberText = 0;
        //RecordsActivity.Info.autoHighChamberText = 0;
        //RecordsActivity.Info.autoNetZoneText = 0;
        //RecordsActivity.Info.autoLowBasketText = 0;
        //RecordsActivity.Info.autoHighBasketText = 0;
        //RecordsActivity.Info.AutoAscent = "";

        //RecordsActivity.Info.teleSpecimenLowChamber = 0;
        //RecordsActivity.Info.teleHighChamber = 0;
        //RecordsActivity.Info.teleNetZoneText = 0;
        //RecordsActivity.Info.teleLowBasketText = 0;
        //RecordsActivity.Info.teleHighBasketText = 0;
        //RecordsActivity.Info.teleAscent = "";

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

        RecordsActivity.Info.pitTeamNumber = "";
        RecordsActivity.Info.pitBotTipe = "";
        RecordsActivity.Info.pitTask = "";
        RecordsActivity.Info.pitAuto = "";
        RecordsActivity.Info.pitAutoTipe = "";

        startActivity(news);
    }
    //String json = (RecordsActivity.Info.scoutName);
    //json += ("\t " + RecordsActivity.Info.teamNumber);
    //json += ("\t" + RecordsActivity.Info.matchNumber);
    //json += ("\t " + RecordsActivity.Info.alliance);
    //json += (" \t " + RecordsActivity.Info.fieldPositionNuw);

    // Auto
    //json += (" \t " + RecordsActivity.Info.overflowtxtauto);
    //json += (" \t " + RecordsActivity.Info.parkedAuto);
    //json += (" \t " + RecordsActivity.Info.ppggpppgp);
    //json += (" \t " + RecordsActivity.Info.autogrup1);
    //json += (" \t " + RecordsActivity.Info.autogrup2);
    //json += (" \t " + RecordsActivity.Info.autogrup3);
    //json += (" \t " + RecordsActivity.Info.autogrup5);
    //json += (" \t " + RecordsActivity.Info.autogrup6);
    //json += (" \t " + RecordsActivity.Info.autogrup7);
    //json += (" \t " + RecordsActivity.Info.autogrup8);
    //json += (" \t " + RecordsActivity.Info.autogrup9);

    // Tele
    //json += (" \t " + RecordsActivity.Info.overflowtxtTely);
    //json += (" \t " + RecordsActivity.Info.telyparked);
    /*json += (" \t " + RecordsActivity.Info.telegrup1);
    json += (" \t " + RecordsActivity.Info.telegrup2);
    json += (" \t " + RecordsActivity.Info.telegrup3);
    json += (" \t " + RecordsActivity.Info.telegrup4);
    json += (" \t " + RecordsActivity.Info.telegrup5);
    json += (" \t " + RecordsActivity.Info.telegrup6);
    json += (" \t " + RecordsActivity.Info.telegrup7);
    json += (" \t " + RecordsActivity.Info.telegrup8);
    json += (" \t " + RecordsActivity.Info.telegrup9);
    json += (" \t " + RecordsActivity.Info.telegrup10);
    json += (" \t " + RecordsActivity.Info.telegrup11);
    json += (" \t " + RecordsActivity.Info.telegrup12);
    json += (" \t " + RecordsActivity.Info.telegrup13);
    json += (" \t " + RecordsActivity.Info.telegrup14);
    json += (" \t " + RecordsActivity.Info.telegrup15);
    json += (" \t " + RecordsActivity.Info.telegrup16);
    json += (" \t " + RecordsActivity.Info.telegrup17);
    json += (" \t " + RecordsActivity.Info.telegrup18);

    // Match notes
    json += (" \t " + RecordsActivity.Info.tipped);
    json += (" \t " + RecordsActivity.Info.droppedPieces);
    json += (" \t " + RecordsActivity.Info.BotDied);
    json += (" \t " + RecordsActivity.Info.ArmWorksSlowly);
    json += (" \t " + RecordsActivity.Info.BotMovesSlow);
    json += (" \t " + RecordsActivity.Info.MinorFoul);
    json += (" \t " + RecordsActivity.Info.MajorFoul);
    json += (" \t " + RecordsActivity.Info.endCommitBox);*/
}