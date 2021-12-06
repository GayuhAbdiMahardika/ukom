package com.gayuh.cariguru;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TambahPenawaranActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Penawaran");
        setContentView(R.layout.activity_tambah_penawaran);
    }
}