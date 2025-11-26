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

import org.json.JSONArray;

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
    
    // Prevent loops
    private boolean qrGeneratedOnce = false;
    private boolean qrSavedOnce = false;
    
    
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
        
        // Build QR JSON payload
        String json = RecordsActivity.Info.scoutName;
        json += ("\t " + RecordsActivity.Info.teamNumber);
        json += ("\t " + RecordsActivity.Info.matchNumber);
        json += ("\t " + RecordsActivity.Info.alliance);
        json += ("\t " + RecordsActivity.Info.fieldPositionNuw);
        
        // Auto basic
        json += ("\t " + RecordsActivity.Info.overflowtxtauto);
        json += ("\t " + RecordsActivity.Info.AutoOverallpoint);
        json += ("\t " + RecordsActivity.Info.parkedAuto);
        json += ("\t " + RecordsActivity.Info.ppggpppgp);
        
        // Auto grids
        json += "\t ";
        for (int i = 0; i < RecordsActivity.Info.autoGrids.length; i++) {
            String v = RecordsActivity.Info.autoGrids[i];
            json += (v == null ? "-" : v);
            if (i < RecordsActivity.Info.autoGrids.length - 1) json += ",";
        }
        
        json += "\t ";
        for (int r = 0; r < RecordsActivity.Info.autoRuns.size(); r++) {
            String[] run = RecordsActivity.Info.autoRuns.get(r);
            json += "[";
            for (int i = 0; i < run.length; i++) {
                json += (run[i] == null ? "-" : run[i]);
                if (i < run.length - 1) json += ",";
            }
            json += "]";
            if (r < RecordsActivity.Info.autoRuns.size() - 1) json += ",";
        }
        json += "]";
        
        // Tele-op
        json += ("\t " + RecordsActivity.Info.overflowtxtTely);
        json += ("\t " + RecordsActivity.Info.teleOverallpoint);
        json += ("\t " + RecordsActivity.Info.telyparked);
        
        json += "\t TELE_CURRENT_variables:";
        for (int i = 0; i < RecordsActivity.Info.teleGrids.length; i++) {
            String v = RecordsActivity.Info.teleGrids[i];
            json += (v == null ? "-" : v);
            if (i < RecordsActivity.Info.teleGrids.length - 1) json += ",";
        }
        
        json += "\t TELE_PAST:[";
        for (int r = 0; r < RecordsActivity.Info.teleRuns.size(); r++) {
            String[] run = RecordsActivity.Info.teleRuns.get(r);
            json += "[";
            for (int i = 0; i < run.length; i++) {
                json += (run[i] == null ? "-" : run[i]);
                if (i < run.length - 1) json += ",";
            }
            json += "]";
            if (r < RecordsActivity.Info.teleRuns.size() - 1) json += ",";
        }
        json += "]";
        
        // Match notes
        json += ("\t " + RecordsActivity.Info.tipped);
        //json += ("\t " + RecordsActivity.Info.droppedPieces);
        json += ("\t " + RecordsActivity.Info.BotDied);
        //json += ("\t " + RecordsActivity.Info.ArmWorksSlowly);
        json += ("\t " + RecordsActivity.Info.BotMovesSlow);
        json += ("\t " + RecordsActivity.Info.MinorFoul);
        json += ("\t " + RecordsActivity.Info.MajorFoul);
        json += ("\t"+RecordsActivity.Info.MakesAGoodAlliancePartener);
        json += ("\t " + RecordsActivity.Info.endCommitBox);
        
        qrString = json;
        Log.d("rAjson", json);
        
        if (!qrGeneratedOnce) {
            qrGeneratedOnce = true;
            generateQRCode(qrString);
        }
    }
    
    
    // --------------------------
    // Permissions
    // --------------------------
    private void checkStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    STORAGE_PERMISSION_CODE);
        }
    }
    
    
    // --------------------------
    // QR CODE GENERATOR
    // --------------------------
    private void generateQRCode(String text) {
        Log.d("qAgen", "Start Code Generation");
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(text, BarcodeFormat.QR_CODE, 400, 400);
            
            qrCodeIV.setImageBitmap(bitmap);
            Qrbmp = bitmap;
            
            // Save ONLY once
            if (!qrSavedOnce) {
                qrSavedOnce = true;
                saveQrOnce(bitmap);
            }
            
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
    
    
    // --------------------------
    // AUTO-SAVE ONE TIME
    // --------------------------
    private void saveQrOnce(Bitmap b) {
        new Thread(() -> {
            try {
                saveImage(b);
                runOnUiThread(() ->
                        Toast.makeText(this, "QR saved!", Toast.LENGTH_SHORT).show()
                );
            } catch (Exception e) {
                Log.e("QR_SAVE", "Error saving QR", e);
            }
        }).start();
    }
    
    
    // --------------------------
    // MANUAL SAVE BUTTON
    // --------------------------
    public void setGenerateQrBtn(View view) {
        Log.d("qAgen", "Manual save button pushed");
        if (Qrbmp != null) {
            new Thread(() -> {
                try {
                    saveImage(Qrbmp);
                    runOnUiThread(() ->
                            Toast.makeText(this, "QR saved manually!", Toast.LENGTH_SHORT).show()
                    );
                } catch (IOException e) {
                    Log.e("QR_SAVE", "Manual save error", e);
                }
            }).start();
        } else {
            Toast.makeText(this, "QR not generated yet!", Toast.LENGTH_SHORT).show();
        }
    }
    
    
    // --------------------------
    // SAVE TO STORAGE
    // --------------------------
    public boolean saveImage(Bitmap bitmap) throws IOException {
        
        if (bitmap == null) return false;
        
        OutputStream fos;
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContentValues cv = new ContentValues();
            cv.put(MediaStore.MediaColumns.DISPLAY_NAME, System.currentTimeMillis() + ".png");
            cv.put(MediaStore.MediaColumns.MIME_TYPE, "image/png");
            cv.put(MediaStore.MediaColumns.RELATIVE_PATH, "DCIM/QR");
            
            Uri imageUri = getContentResolver()
                    .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cv);
            
            if (imageUri == null) return false;
            
            fos = getContentResolver().openOutputStream(imageUri);
        } else {
            File dir = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DCIM), "QR");
            if (!dir.exists()) dir.mkdirs();
            
            File image = new File(dir, System.currentTimeMillis() + ".png");
            fos = new FileOutputStream(image);
        }
        
        boolean saved = bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
        fos.flush();
        fos.close();
        return saved;
    }
    
    
    public void TheLastBack(View view) {
        startActivity(new Intent(this, match_notes_Activity.class));
    }
    
    
    // --------------------------
    // RESET ALL DATA
    // --------------------------
    public void resetAllData() {
        
        RecordsActivity.Info.autoGrids = new String[9];
        if (RecordsActivity.Info.autoRuns != null)
            RecordsActivity.Info.autoRuns.clear();
        
        RecordsActivity.Info.teleGrids = new String[18];
        if (RecordsActivity.Info.teleRuns != null)
            RecordsActivity.Info.teleRuns.clear();
        
        Toast.makeText(this, "All scouting data cleared.", Toast.LENGTH_SHORT).show();
    }
    
    
    public void clear(View view) {
        Log.d("qAClr", "Clear Called");
        
        resetAllData();
        
        Intent news = new Intent(this, preGameInfo.class);
        
        // Increment match #
        try {
            RecordsActivity.Info.matchNumber =
                    Integer.toString(Integer.parseInt(RecordsActivity.Info.matchNumber) + 1);
        } catch (Exception e) {
            RecordsActivity.Info.matchNumber = "1";
        }
        
        // Clear all fields
        RecordsActivity.Info.teamNumber = "";
        RecordsActivity.Info.fieldPositionNuw = "";
        RecordsActivity.Info.overflowtxtauto = 0;
        RecordsActivity.Info.parkedAuto = "";
        RecordsActivity.Info.ppggpppgp = "";
        RecordsActivity.Info.overflowtxtTely = 0;
        RecordsActivity.Info.telyparked = "";
        
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
        
        startActivity(news);
    }
}