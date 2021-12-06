package com.gayuh.cariguru.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gayuh.cariguru.MainActivity;
import com.gayuh.cariguru.R;

public class RegistrasiGuruActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi_guru);

        Button btnDaftarGuru2 = findViewById(R.id.btnDaftarGuru2);
        btnDaftarGuru2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistrasiGuruActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}