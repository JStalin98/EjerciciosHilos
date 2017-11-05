package com.example.jstalin.ejercicioshilos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void itenBt1(View v){

        Intent i = new Intent(this, Hilos1.class);
        startActivity(i);
    }
}
