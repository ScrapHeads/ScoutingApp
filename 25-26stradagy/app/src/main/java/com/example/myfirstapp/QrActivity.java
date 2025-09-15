package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class QrActivity extends AppCompatActivity {
    // variables for imageview, edittext,
    TextView resetbut ;
    private ImageView qrCodeIV;
    String qrString;
    Bitmap Qrbmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        this.setRequestedOrientation(ActivityInfo. SCREEN_ORIENTATION_LANDSCAPE);
        resetbut= findViewById(R.id.generateQrBtn);
        // initializing all variables.
        qrCodeIV = findViewById(R.id.qrImage);
        //dataEdt.setText(RecordsActivity.Info.qrString);

        {
            String json = (RecordsActivity.Info.scoutName);
            json += ("\t " + RecordsActivity.Info.teamNumber);
            json+=("\t"+RecordsActivity.Info.matchNumber );
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
            json += ("\t "+ RecordsActivity.Info.endCommitBox); json += ("\r"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b"+"\b");
                                                                                                        Log.d("rAjson", json);
            qrString = json;
            generateQRCode(qrString);                                                                   Log.d("qAgen", "Call QR Generate code"); Log.d("qAgen",("qrString: "+qrString));

        }
    }
    public void TheLastBack(View view){
        Intent Back = new Intent(this, match_notes_Activity.class);
        startActivity(Back);

    }

    // initializing onclick listener for button.
    public void setGenerateQrBtn(View view){                                                            Log.d("qAgen","button pushed"); Log.d("qAgen",("qrString: "+qrString));

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


        public void clear(View view) throws IOException {                                                            Log.d("qAClr","Clear Called");
            Intent news = new Intent(this, preGameInfo.class);                        Log.d("qAClr","inish main activity");
            //Qrbmp = qrCodeIV.getDrawingCache();      Log.d("qAClr","Qrbmp = qrCodeIV.getDrawingCache();" );
            //saveImage(qrCodeIV.getDrawingCache());        Log.d("qAClr","Qrbmp = saveImage(Qrbmp)" );
            //main activity
                                                                                                    Log.d("qAClr","Old match" + RecordsActivity.Info.matchNumber);
            RecordsActivity.Info.matchNumber = Integer.toString(Integer.decode(RecordsActivity.Info.matchNumber) + 1); Log.d("qAClr","New match"+RecordsActivity.Info.matchNumber);
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
    public boolean saveImage(Bitmap bitmap) throws IOException {

        boolean saved;
        OutputStream fos=null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContentValues contentValues =new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, System.currentTimeMillis());
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/PNG");
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, "DCIM/" + "QR");
            Uri imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            try {
                fos = getContentResolver().openOutputStream(imageUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            String imagesDir = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DCIM).toString() + File.separator + "QR";

            File file =new File(imagesDir);

            if (!file.exists()) {
                file.mkdir();
            }

            File image =new File(imagesDir, "${System.currentTimeMillis()}.PNG");
            try {
                fos =new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        saved = bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
        assert fos != null;
        fos.flush();
        fos.close();
        return saved;

    }/*
    private String savePath = Environment.getExternalStorageDirectory().getPath() + "/QRCode/";

    resetbut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                try {
                    boolean save = new QRGSaver().save(savePath, edtValue.getText().toString().trim(), bitmap, QRGContents.ImageType.IMAGE_JPEG);
                    String result = save ? "Image Saved" : "Image Not Saved";
                    Toast.makeText(activity, result, Toast.LENGTH_LONG).show();
                    edtValue.setText(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
            }
        }
    };*/

}