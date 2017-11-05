package com.example.jstalin.ejercicioshilos;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Hilos1 extends AppCompatActivity {

    static TextView txtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilos1);

        txtView = (TextView)findViewById(R.id.tvContador);

    }



    public void iniciarCuenta(View v){

        // runOnUiThread(Runnable) *************************************


/*
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 1000; i++) {


                    final int aux = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            txtView.setText(String.valueOf(aux));
                        }
                    });
                    // pausa para dar tiempo a que se muestre el valor antes de
                    // pasar al siguiente
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Log.d("Threading", e.getLocalizedMessage());
                    }
                }
            }
        }).start();*/


        //post(Runnaable);******************************************


        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    final int contador = i;

                    txtView.post(new Runnable() {
                        public void run() {

                            txtView.setText(String.valueOf(contador));
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Log.d("Threading", e.getLocalizedMessage());
                    }
                }
            }
        }).start();


        //Handler ************************************



/*
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    // actualizar actividad principal

                   Hilos1.UIactualiza.obtainMessage(0,String.valueOf(i).getBytes()).
                            sendToTarget();
                    // --- introducir un retraso
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Log.d("Threading" , e.getLocalizedMessage());
                    }
                }
            }
        }).start();*/


    }



    static Handler UIactualiza = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            byte[] buffer = (byte[]) msg.obj;
            //convierte el array de byte a string
            String strRecibido = new String(buffer);
            //uestra el texto recibido en el TextView
            txtView.setText(strRecibido);
            Log.d("Threading", "corriendo");
        }
    };



}

