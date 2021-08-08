package com.example.toast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQliteHelper extends SQLiteOpenHelper {
    private static final String database_NAME = "FitnessArea";
    private static final int database_VERSİON = 1;
    private static final String table_GYMCENTER = "GymCenter";
    private static final String gymCenter_ID = "id";
    private static final String gymCenter_ADRESS = "gymCenterAdress";
    private static final String gymCenter_NAME = "gymCenterName";
    private static final String CREATE_GYMCENTER_TABLE = "CREATE TABLE "
            + table_GYMCENTER+ " ("
            + gymCenter_ID+ " INTEGER PRİMARY KEY AUTOINCREMENT, "
            + gymCenter_ADRESS+ " TEXT, "
            + gymCenter_NAME+ " TEXT )";



    public SQliteHelper(@Nullable Context context) {
        super(context, database_NAME, null, database_VERSİON);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_GYMCENTER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_GYMCENTER);
        this.onCreate(db);
    }
    public void GymCenterEkle(FitnessArea gymCenterr) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues degerler = new ContentValues();
        degerler.put(gymCenter_ADRESS,gymCenterr.getGymCenterAdress());
        degerler.put(gymCenter_NAME,gymCenterr.getGymCenterName());
        db.insert(table_GYMCENTER,null,degerler);
        db.close();
    }
    public List<FitnessArea> gymCenterGetir(){
        List<FitnessArea> fitnessAreaa = new ArrayList<>();
        String query = " SELECT * FROM "+ table_GYMCENTER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query , null);
        FitnessArea fitnessArea = null ;
        if (cursor.moveToFirst()) {
            do {
                fitnessArea = new FitnessArea();
                fitnessArea.setId(Integer.parseInt(cursor.getString(0)));
                fitnessArea.setGymCenterAdress(cursor.getString(1));
                fitnessArea.setGymCenterName(cursor.getString(2));
                fitnessAreaa.add(fitnessArea);
            } while (cursor.moveToNext());
        }
        return fitnessAreaa;

    }
}
