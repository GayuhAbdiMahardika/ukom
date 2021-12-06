package com.gayuh.cariguru.siswa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gayuh.cariguru.R;

public class DetailGuruActivitySiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detail_guru);
    }
}