package com.gayuh.cariguru.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gayuh.cariguru.MainActivity;
import com.gayuh.cariguru.R;
import com.gayuh.cariguru.model.RegisterSiswaForm;
import com.gayuh.cariguru.model.ResponsesLogin;
import com.gayuh.cariguru.model.ResponsesPostRegisterSiswa;
import com.gayuh.cariguru.rest.ApiClient;
//import com.google.android.safetynet.SafetyNet;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class Registrasi extends AppCompatActivity {
    Spinner ddDaftar,ddGender,ddProvinsi,ddKabupaten;
    EditText etNama, etEmail, etNoTelp, etAlamatLengkap, etPassword, etPasswordd;

    String SITE_KEY = "6LeekFIdAAAAAP4SoLFVEn-W4UIkc7luyepCZrmD";
    String SECRET_KEY = "6LeekFIdAAAAANQ8feu8tWnDubvqTMgYSYbTcCGn";
    RequestQueue queue;

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

        etNama = findViewById(R.id.etNama);
        etEmail = findViewById(R.id.etEmail);
        etNoTelp = findViewById(R.id.etNoTelp);
        etAlamatLengkap = findViewById(R.id.etAlamatLengkap);
        etPassword = findViewById(R.id.etPassword);

        queue = Volley.newRequestQueue(getApplicationContext());
//        btnverifyCaptcha = findViewById(R.id.button);
//        btnverifyCaptcha.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                verifyGoogleReCAPTCHA();
//            }
//        });

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

        Button btnDaftar = findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
//                String nama = etNama.getText().toString();
//                String noTelp = etNoTelp.getText().toString();
//                String alamatLengkap = etAlamatLengkap.getText().toString();
//                String password = etPasswordd.getText().toString();

                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(Registrasi.this, "email benar", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Registrasi.this, login.class);
                    Registrasi.this.startActivity(i);
                    return;
                }else{
                    Toast.makeText(Registrasi.this, "email salah", Toast.LENGTH_SHORT).show();
                }

//                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//                    Toast.makeText(Registrasi.this, "email benar", Toast.LENGTH_SHORT).show();
//                    return;
//                }else{
//                    Toast.makeText(Registrasi.this, "email salah", Toast.LENGTH_SHORT).show();
//                }

//                Log.d("test", "ok");
//                String email = etEmail.getText().toString();
//                String nama = etNama.getText().toString();
//                String noTelp = etNoTelp.getText().toString();
//                String alamatLengkap = etAlamatLengkap.getText().toString();
//                String password = etPasswordd.getText().toString();
//                RegisterSiswaForm registerSiswaForm = new RegisterSiswaForm(email,password, nama,"Jawa Timur", "Sidoarjo", alamatLengkap,"01-04-03", noTelp, "Laki Laki",2);
//
//                Call<ResponsesPostRegisterSiswa> call = ApiClient.getClient().registerSiswa(registerSiswaForm);
//                call.enqueue(new Callback<ResponsesPostRegisterSiswa>() {
//
//                    @Override
//                    public void onResponse(Call<ResponsesPostRegisterSiswa> call, Response<ResponsesPostRegisterSiswa> response) {
////                        Intent i = new Intent(Registrasi.this, login.class);
////                        Registrasi.this.startActivity(i);
//                        Log.d("test", response.message());
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponsesPostRegisterSiswa> call, Throwable t) {
//                        Log.d("test", t.getMessage());
//                    }
//                });
            }

//            RegisterSiswaForm registerSiswaForm =
//
//            @Override
//            public void onClick(View v) {
//                Call<ResponsesPostRegisterSiswa> call = ApiClient.getClient().registerSiswa(registerSiswaForm);
//                Log.d("url",call.request().url().toString());
//                call.enqueue(new Callback<ResponsesPostRegisterSiswa>() {
//                    @Override
//                    public void onResponse(Call<ResponsesPostRegisterSiswa> call, Response<ResponsesPostRegisterSiswa> response) {
//                        if(response.body() != null) {
//                            ResponsesPostRegisterSiswa responsesPostRegisterSiswa = response.body();
//
//                            Intent i = new Intent(Registrasi.this, MainActivity.class);
//                            Registrasi.this.startActivity(i);
//                        }
//                    }
//                    @Override
//                    public void onFailure(Call<ResponsesPostRegisterSiswa> call, Throwable t) {
//
//                    }

        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), login.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public void onClickCaptha(View view) {
        verifyGoogleReCAPTCHA();
    }

    private void verifyGoogleReCAPTCHA() {

        // below line is use for getting our safety
        // net client and verify with reCAPTCHA
        SafetyNet.getClient(this).verifyWithRecaptcha(SITE_KEY)
                // after getting our client we have
                // to add on success listener.
                .addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                    @Override
                    public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                        // in below line we are checking the response token.
                        if (!response.getTokenResult().isEmpty()) {
                            // if the response token is not empty then we
                            // are calling our verification method.
                            handleVerification(response.getTokenResult());
                        }
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // this method is called when we get any error.
                        if (e instanceof ApiException) {
                            ApiException apiException = (ApiException) e;
                            // below line is use to display an error message which we get.
                            Log.d("TAG", "Error message: " +
                                    CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()));
                        } else {
                            // below line is use to display a toast message for any error.
                            Toast.makeText(Registrasi.this, "Error found is : " + e, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    protected void handleVerification(final String responseToken) {
        // inside handle verification method we are
        // verifying our user with response token.
        // url to sen our site key and secret key
        // to below url using POST method.
        String url = "https://www.google.com/recaptcha/api/siteverify";

        // in this we are making a string request and
        // using a post method to pass the data.
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // inside on response method we are checking if the
                        // response is successful or not.
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getBoolean("success")) {
                                // if the response is successful then we are
                                // showing below toast message.
                                Toast.makeText(Registrasi.this, "User verified with reCAPTCHA", Toast.LENGTH_SHORT).show();
                            } else {
                                // if the response if failure we are displaying
                                // a below toast message.
                                Toast.makeText(getApplicationContext(), String.valueOf(jsonObject.getString("error-codes")), Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception ex) {
                            // if we get any exception then we are
                            // displaying an error message in logcat.
                            Log.d("TAG", "JSON exception: " + ex.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // inside error response we are displaying
                        // a log message in our logcat.
                        Log.d("TAG", "Error message: " + error.getMessage());
                    }
                }) {
            // below is the getParamns method in which we will
            // be passing our response token and secret key to the above url.
            @Override
            protected Map<String, String> getParams() {
                // we are passing data using hashmap
                // key and value pair.
                Map<String, String> params = new HashMap<>();
                params.put("secret", SECRET_KEY);
                params.put("response", responseToken);
                return params;
            }
        };
        // below line of code is use to set retry
        // policy if the api fails in one try.
        request.setRetryPolicy(new DefaultRetryPolicy(
                // we are setting time for retry is 5 seconds.
                50000,

                // below line is to perform maximum retries.
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // at last we are adding our request to queue.
        queue.add(request);
    }

    public void onClickDaftarBtn(View view) {
        Log.d("test", "ok");
    }
}