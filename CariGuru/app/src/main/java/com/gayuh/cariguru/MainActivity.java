package com.gayuh.cariguru;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;

import com.gayuh.cariguru.auth.login;
import com.gayuh.cariguru.guru.HomeFragmentGuru;
import com.gayuh.cariguru.guru.ProfileFragmentGuru;
import com.gayuh.cariguru.model.GuruModel;
import com.gayuh.cariguru.model.SiswaModel;
import com.gayuh.cariguru.siswa.HomeFragmentSiswa;
import com.gayuh.cariguru.siswa.ProfileFragmentSiswa;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener{

    SharedPreferences sharedPreferences;
    SiswaModel siswaModel;
    GuruModel guruModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Gson gson = new Gson();
        String json = sharedPreferences.getString("user", "");
        if(json != ""){
            guruModel = gson.fromJson(json, GuruModel.class);
            if(guruModel.getRole() == 2){
                loadFragment(new HomeFragmentSiswa());
            }else {
                loadFragment(new HomeFragmentGuru());
            }
        }else{
            loadFragment(new HomeFragment());
        }

//        Log.d("lol", guruModel.getRole().toString());




        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        switch (item.getItemId()){
            case R.id.fr_home:
                if(sharedPreferences.getString("user", "") != ""){
                    if(guruModel.getRole() == 2){
                        fragment = new HomeFragmentSiswa();
                    }else if(guruModel.getRole() ==1){
                        fragment = new HomeFragmentGuru();
                    }
                }else {
                    fragment = new HomeFragment();
                }
                break;
            case R.id.fr_les:
                if(sharedPreferences.getString("user", "") != ""){
                    fragment = new LesFragment();
                }else{
                    Intent i = new Intent(this, login.class);
                    startActivity(i);
                }

                break;
            case R.id.fr_profile:
                if(sharedPreferences.getString("user", "") != ""){
                    if(guruModel.getRole() == 2){
                        fragment = new ProfileFragmentSiswa();
                    } else {
                        fragment = new ProfileFragmentGuru();
                    }
                }else{
                    Intent i = new Intent(this, login.class);
                    startActivity(i);
                }

                break;
        }
        return loadFragment(fragment);
    }
    private boolean loadFragment(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,fragment).commit();
            return true;
        }
        return false;
    }
}