package com.gayuh.cariguru.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.gayuh.cariguru.R;

public class Registrasi extends AppCompatActivity {
    Spinner ddDaftar,ddGender,ddProvinsi,ddKabupaten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Daftar");
        setContentView(R.layout.form_registrasi);

        ddDaftar = findViewById(R.id.ddDaftarsebagai);
        ddGender = findViewById(R.id.ddGender);
        ddProvinsi = findViewById(R.id.ddProvinsi);
        ddKabupaten = findViewById(R.id.ddKabupaten);

        String[] itemsDaftar = new String[]{"Siswa", "Guru"};
        ArrayAdapter<String> adapterDaftar = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsDaftar);
        ddDaftar.setAdapter(adapterDaftar);

        String[] itemsGender = new String[]{"Laki Laki", "Perempuan"};
        ArrayAdapter<String> adapterGender = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsGender);
        ddGender.setAdapter(adapterGender);

        String[] itemsProvinsi = new String[]{"Jawa Timur", "Jawa Barat"};
        ArrayAdapter<String> adapterProvinsi = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsProvinsi);
        ddProvinsi.setAdapter(adapterProvinsi);

        String[] itemsKabupaten = new String[]{"Sidoarjo", "Surabaya"};
        ArrayAdapter<String> adapterKabupaten = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsKabupaten);
        ddKabupaten.setAdapter(adapterKabupaten);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), login.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}