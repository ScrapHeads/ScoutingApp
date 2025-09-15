package com.example.myfirstapp;

import android.util.Log;
import android.view.View;

public class RecordsActivity {
    public static class Info {

        public static String qrString = "";
        //Main activity
        static String scoutName = "";
        static String matchNumber = "1";
        static String teamNumber = "";
        static String preload = "";
        static String alliance = "";
        public static byte fieldPosition = 0;

        //Auto activity
        public static byte autoLowChamberText = 0;
        public static byte autoHighChamberText = 0;
        public static byte autoNetZoneText = 0;
        public static byte autoLowBasketText = 0;
        public static byte autoHighBasketText = 0;
        static String AutoAscent = "";
        public static boolean noAuto= false;

        //Tele activty
        public static byte teleSpecimenLowChamber = 0;
        static byte teleHighChamber = 0;
        public static byte teleNetZoneText = 0;
        public static byte teleLowBasketText = 0;
        public static byte teleHighBasketText = 0;
        static String teleAscent = "";

        //Match notes
        public static byte skillLvl = 0;
        public static boolean tipped = false;
        public static boolean droppedPieces = false;
        public static boolean BotDied = false;
        public static boolean ArmWorksSlowly = false;
        public static boolean BotMovesSlow = false;
        public static boolean MakesAGoodAlliancePartener = false;
        public static byte MinorFoul = 0;
        public static byte MajorFoul = 0;
        static String endCommitBox = "";
        //pit
        static String pitTeamNumber="";
        static String pitBotTipe="";
        static String pitTask="";
        static String pitAuto="";
        static String pitAutoTipe="";


        /*
        {

            String json = String.format("{\"Name\": \"%s\",", scoutName);
            json += String.format("\"Match\": \"%s\",", matchNumber);
            json += String.format("\"Team\": \"%s\",", teamNumber);
            json += String.format("\"preload\": \"%s\",", preload);
            json += String.format("\"alliance\": \"%s\",", alliance);
            json += String.format("\"Pos\": \"%s\",", fieldPosition);                               Log.d("rAjson",json);

            //auto activity
            json += String.format("\"auto LowChamber\": \"%s\",", autoLowChamberText);
            json += String.format("\"auto HighChamber\": \"%s\",", autoHighChamberText);
            json += String.format("\"auto NetZone\": \"%s\",", autoNetZoneText);
            json += String.format("\"auto LowBasket\": \"%s\",", autoLowBasketText);
            json += String.format("\"auto HighBasket\": \"%s\",", autoHighBasketText);
            json += String.format("\"auto Ascent\": \"%s\",", AutoAscent);                          Log.d("rAjson",json);

            //tele activity
            json += String.format("\"tele LowChamber\": \"%s\",", teleSpecimenLowChamber);
            json += String.format("\"tele HighChamber\": \"%s\",", teleHighChamber);
            json += String.format("\"tele NetZone\": \"%s\",", teleNetZoneText);
            json += String.format("\"tele LowBasket\": \"%s\",", teleLowBasketText);
            json += String.format("\"tele HighBasket\": \"%s\",", teleHighBasketText);
            json += String.format("\"tele Ascent\": \"%s\",", teleAscent);                          Log.d("rAjson",json);

            //Match Notes activity
            json += String.format("\"skill Lvl\": \"%s\",", skillLvl);
            json += String.format("\"bot Tipped\": \"%s\",", tipped);
            json += String.format("\"bot Dropped Pieces\": \"%s\",", droppedPieces);
            json += String.format("\"bot Died\": \"%s\",", BotDied);
            json += String.format("\"bot Arm Works Slowly\": \"%s\",", ArmWorksSlowly);
            json += String.format("\"Bot Moves Slow\": \"%s\",", BotMovesSlow);
            json += String.format("\"Makes A Good Alliance Partener\": \"%s\",", MakesAGoodAlliancePartener);
            json += String.format("\"had Minor Fouls\": \"%s\",", MinorFoul);
            json += String.format("\"had Major Fouls\": \"%s\",", MajorFoul);
            json += String.format("\"had Yellow Card\": \"%s\",", YellowCard);
            json += String.format("\"had Red Card\": \"%s\",", RedCard);
            json += String.format("{\"Name\": \"%s\",", endCommitBox);                              Log.d("rAjson",json);
            qrString = json;

        }

        public static void clear(View view) {

            //main activity
            matchNumber = Integer.toString(Integer.decode(matchNumber) + 1);
            teamNumber = "";
            preload = "";
            fieldPosition = 0;

            //auto activity
            autoLowChamberText = 0;
            autoHighChamberText = 0;
            autoNetZoneText = 0;
            autoLowBasketText = 0;
            autoHighBasketText = 0;
            AutoAscent = "";

            //tele activity
            teleSpecimenLowChamber = 0;
            teleHighChamber = 0;
            teleNetZoneText = 0;
            teleLowBasketText = 0;
            teleHighBasketText = 0;
            teleAscent = "";

            //Match notes
            skillLvl = 0;
            tipped = false;
            droppedPieces = false;
            BotDied = false;
            ArmWorksSlowly = false;
            BotMovesSlow = false;
            MakesAGoodAlliancePartener = false;
            MinorFoul = false;
            MajorFoul = false;
            YellowCard = false;
            RedCard = false;
            endCommitBox = "";

        }*/
    }
}

