package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class list extends AppCompatActivity {
    Context context = this;
ListView listemiz;
List<FitnessArea> liste;
SQliteHelper db = new SQliteHelper(this);
ArrayAdapter<String> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        listemiz = findViewById(R.id.listemiz);
        db.onUpgrade(db.getWritableDatabase(),1,2);
        db.GymCenterEkle(new FitnessArea("Akdeniz,Defne/Hatay","Akademi Gym Center"));
        db.GymCenterEkle(new FitnessArea("Sümerler,Defne/Hatay","Matrix Gym Center"));
        db.GymCenterEkle(new FitnessArea("Cebrail,Antakya/Hatay","BigBoss Gym Center"));
        db.GymCenterEkle(new FitnessArea("Çay,İskenderun/Hatay","GoldenLife Gym Center"));
        db.GymCenterEkle(new FitnessArea("Çay,İskenderun/Hatay","EformGym Center"));
        db.GymCenterEkle(new FitnessArea("Kurtuluş,İskenderun/Hatay","Adonis Gym Center"));
        db.GymCenterEkle(new FitnessArea("Mustafa Kemal,İskenderun/Hatay","Fenix Gym Center"));
        db.GymCenterEkle(new FitnessArea("Numune Evler,Dörtyol/Hatay","BodyLine Gym Center"));
        db.GymCenterEkle(new FitnessArea("Cemal Gürsel,Samandağ/Hatay","Yonca Gym Center"));

        liste = db.gymCenterGetir();

        List<String> listGymCenterAdress = new ArrayList<>();
        for (int i=0; i<liste.size(); i++){
            listGymCenterAdress.add(i,liste.get(i).getGymCenterAdress());
            //listGymCenterAdress.add(i,liste.get(i+1).getGymCenterName());
        }
        mAdapter = new ArrayAdapter<String>(context,R.layout.list,R.id.listemiz,listGymCenterAdress);
        listemiz.setAdapter(mAdapter);
    }
}