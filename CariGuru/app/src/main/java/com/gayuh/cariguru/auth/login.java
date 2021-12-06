package com.gayuh.cariguru.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gayuh.cariguru.MainActivity;
import com.gayuh.cariguru.R;
import com.gayuh.cariguru.model.GuruModel;
import com.gayuh.cariguru.model.LoginForm;
//import com.gayuh.cariguru.model.Responses;
import com.gayuh.cariguru.model.ResponsesLogin;
import com.gayuh.cariguru.model.SiswaModel;
//import com.gayuh.cariguru.responses.Responses;
import com.gayuh.cariguru.rest.ApiClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    Button btnDaftar;
    EditText etEmail, etPassword;
    String password, email;
    SharedPreferences sharedPreferences;
    SiswaModel siswaModel;
    GuruModel guruModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login);

        btnDaftar = findViewById(R.id.btnDaftar);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(sharedPreferences.getString("user","") != ""){
            Intent i = new Intent(login.this, MainActivity.class);
            login.this.startActivity(i);
        }

        Button btnDaftarGuru = findViewById(R.id.btnDaftarGuru);
        btnDaftarGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this,Registrasi2.class);
                startActivity(i);
            }
        });
    }

    public void onClickDaftarBtn(View view) {
        Intent i = new Intent(this,Registrasi.class);
        this.startActivity(i);
    }

    public void onClickLogin(View view) {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        LoginForm loginForm = new LoginForm(email, password);

        Call<ResponsesLogin> call = ApiClient.getClient().login(loginForm);
        Log.d("url",call.request().url().toString());
        call.enqueue(new Callback<ResponsesLogin>() {
            @Override
            public void onResponse(Call<ResponsesLogin> call, Response<ResponsesLogin> response) {
                if(response.body() != null) {
                    ResponsesLogin responsesLogin = response.body();
                    if(responsesLogin.getRole() == 1){
                        guruModel = responsesLogin.getGuru();
                        guruModel.setEmail(email);
                        guruModel.setRole(1);
                        Gson gson = new Gson();
                        String json = gson.toJson(guruModel);
                        editor.putString("user", json);
                        editor.commit();
                    } else if(responsesLogin.getRole() == 2){
                        siswaModel = responsesLogin.getSiswa();
                        siswaModel.setEmail(email);
                        siswaModel.setRole(2);
                        Gson gson = new Gson();
                        String json = gson.toJson(siswaModel);
                        editor.putString("user", json);
                        editor.commit();
                    }

                    Intent i = new Intent(login.this, MainActivity.class);
                    login.this.startActivity(i);
                }
            }

            @Override
            public void onFailure(Call<ResponsesLogin> call, Throwable t) {
                Log.d("test",t.getMessage());
            }
        });


    }
}