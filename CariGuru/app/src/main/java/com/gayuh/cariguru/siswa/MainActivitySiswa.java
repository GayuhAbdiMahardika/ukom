package com.gayuh.cariguru.siswa;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.gayuh.cariguru.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivitySiswa extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener{

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragmentSiswa());

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.fr_home:
                fragment = new HomeFragmentSiswa();
                break;
            case R.id.fr_les:
                fragment = new LesFragmentSiswa();
                break;
            case R.id.fr_profile:
                fragment = new ProfileFragmentSiswa();
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