package com.gayuh.cariguru.siswa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gayuh.cariguru.R;

public class DetailLesActivitySiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Les");
        setContentView(R.layout.activity_detail_les);
    }
}