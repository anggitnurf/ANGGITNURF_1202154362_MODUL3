package com.anggit.android.anggitnurf_1202154362_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    //variable
    EditText user;
    EditText pass;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize the views
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        signin = (Button) findViewById(R.id.buttonsign);
    }

    public void SingIn(View view) {
        //deklarasi untuk mengambil nilai user dan pass
        String username = user.getText().toString();
        String password = pass.getText().toString();

        //jika user dan pass sesuai maka muncul toast dan masuk ke activity selanjutnya
        if (username.equals("EAD") && password.equals("MOBILE")) {
            Toast.makeText(this, "You Signed In", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, DaftarMenu.class);
            startActivity(intent);
            //jika pass dan user salah
        } else {
            Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show();
        }
    }
}