package com.anggit.android.anggitnurf_1202154362_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class splash_screen extends AppCompatActivity {
    //waktu ketika splash muncul 2000 = 2 detik
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //membuat intent untuk masuk ke screen selanjutnya
                Intent homeIntent = new Intent(splash_screen.this, LoginActivity.class);

                //memulai intent
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}