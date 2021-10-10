package com.gayuh.cariguru.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gayuh.cariguru.MainActivity;
import com.gayuh.cariguru.R;

public class login extends AppCompatActivity {

    Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login);

        btnDaftar = findViewById(R.id.btnDaftar);
    }

    public void onClickDaftarBtn(View view) {
        Intent i = new Intent(this,Registrasi.class);
        this.startActivity(i);
    }

    public void onClickLogin(View view) {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
    }
}