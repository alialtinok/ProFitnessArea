package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin,btnsignUp, btnVwist, btnCallmeNear;
    ListView listemiz;
    Context context = this;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        btnLogin.setOnClickListener(this);
        btnsignUp.setOnClickListener(this);
        btnVwist.setOnClickListener(this);
        btnCallmeNear.setOnClickListener(this);

    }
    public void tanimla(){
        btnLogin = findViewById(R.id.loginbtn);
        btnsignUp = findViewById(R.id.btnsignUp);
        btnVwist = findViewById(R.id.vwlistbtn);
        btnCallmeNear = findViewById(R.id.callMebtn);
        listemiz = findViewById(R.id.listemiz);
    }


    @Override
    public void onClick(View v) { // v tıklanan buton
        switch (v.getId()){


            case  R.id.loginbtn :
                Intent i = new Intent(context,login.class);
                startActivity(i);
                break;

             case  R.id.btnsignUp :
                Intent intent = new Intent(context,signUp.class);
                startActivity(intent);
                break;




            case  R.id.vwlistbtn :
                Intent c = new Intent(context,list.class);
                startActivity(c);

                break;

            case  R.id.callMebtn :
                Intent b = new Intent(context,callmeNear.class);
                startActivity(b);

                break;
        }
    }


}