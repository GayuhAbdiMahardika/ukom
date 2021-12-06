package com.gayuh.cariguru.siswa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.gayuh.cariguru.DetailGuruActivity;
import com.gayuh.cariguru.DetailLesActivity;
import com.gayuh.cariguru.R;
import com.gayuh.cariguru.auth.login;
import com.google.gson.Gson;

import java.util.Calendar;

public class FormPesanActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_form_pesan);

        Button btnAturWaktu = findViewById(R.id.btnAturHari);
        btnAturWaktu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modalHari();
            }
        });

        Button btnAturWaktu2 = findViewById(R.id.btnAturJam);
        btnAturWaktu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modalWaktu();
            }
        });

        Button btnPesan = findViewById(R.id.btnPesan);
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(FormPesanActivity.this);
                Gson gson = new Gson();
                String json = sharedPreferences.getString("user", "");
                if(json == ""){
                    Intent i = new Intent(FormPesanActivity.this, login.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(FormPesanActivity.this, DetailLesActivity.class);
                    startActivity(i);
                }


            }
        });

//        Button setJam = findViewById(R.id.btnUbahJam);
//        setJam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Calendar mcurrentTime = Calendar.getInstance();
//                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
//                int minute = mcurrentTime.get(Calendar.MINUTE);
//                TimePickerDialog mTimePicker;
//                mTimePicker = new TimePickerDialog(FormPesanActivity.this, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//
//                    }
//                }, hour, minute, true);
//                mTimePicker.setTitle("Select Time");
//                mTimePicker.show();
//
//            }
//        });


    }

    public void modalWaktu(){
        Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
    }

    public void modalHari() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        alert.setView(inflater.inflate(R.layout.modal_pesan, null));

        alert.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });

        alert.setNegativeButton("Batal",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();

//        Button setJam = findViewById(R.id.btnUbahJam);
//        setJam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Calendar mcurrentTime = Calendar.getInstance();
//                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
//                int minute = mcurrentTime.get(Calendar.MINUTE);
//                TimePickerDialog mTimePicker;
//                mTimePicker = new TimePickerDialog(alert.getContext(), new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//
//                    }
//                }, hour, minute, true);
//                mTimePicker.setTitle("Select Time");
//                mTimePicker.show();
//
//            }
//        });

    }
}