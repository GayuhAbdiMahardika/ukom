package com.gayuh.cariguru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gayuh.cariguru.auth.Registrasi;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class CariGuruActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cari_guru);

        ImageView btnFilter = findViewById(R.id.btnFilter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFilter();
            }
        }) ;

        CardView cvGuru = findViewById(R.id.cvGuru);
        cvGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CariGuruActivity.this, DetailGuruActivity.class);
                startActivity(i);
            }
        });
    }

    private void showFilter(){
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_filter);
        bottomSheetDialog.show();
    }
}