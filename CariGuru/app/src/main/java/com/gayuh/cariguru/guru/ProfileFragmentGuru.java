package com.gayuh.cariguru.guru;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.gayuh.cariguru.MainActivity;
import com.gayuh.cariguru.R;
import com.gayuh.cariguru.TambahPenawaranActivity;
import com.gayuh.cariguru.auth.login;
import com.gayuh.cariguru.model.GuruModel;
import com.gayuh.cariguru.model.ResponsesGetPenawaranGuru;
import com.gayuh.cariguru.model.ResponsesLogin;
import com.gayuh.cariguru.model.SiswaModel;
import com.gayuh.cariguru.rest.ApiClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragmentGuru#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragmentGuru extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    GuruModel guruModel;
    SharedPreferences sharedPreferences;
    EditText etNama, etEmail, etNoTelp, etAlamatLengkap, etDeskripsi;
    Spinner ddGender,ddProvinsi,ddKabupaten;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragmentGuru() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragmentGuru newInstance(String param1, String param2) {
        ProfileFragmentGuru fragment = new ProfileFragmentGuru();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = sharedPreferences.getString("user", "");
        guruModel = gson.fromJson(json, GuruModel.class);

        etNama = getActivity().findViewById(R.id.etNama);
        etEmail = getActivity().findViewById(R.id.etEmail);
        etNoTelp = getActivity().findViewById(R.id.etNoTelp);
        etAlamatLengkap = getActivity().findViewById(R.id.etAlamatLengkap);
//        etDeskripsi = getActivity().findViewById(R.id.etDeskripsi);
        ddGender = getActivity().findViewById(R.id.ddGender);
        ddProvinsi = getActivity().findViewById(R.id.ddProvinsi);
        ddKabupaten = getActivity().findViewById(R.id.ddKabupaten);

        etNama.setText(guruModel.getNama());
        etEmail.setText(guruModel.getEmail());
        etNoTelp.setText(guruModel.getWhatsapp());
        etAlamatLengkap.setText(guruModel.getAlamat_lengkap());
//        etDeskripsi.setText(guruModel.get());

        Call<ResponsesGetPenawaranGuru> call = ApiClient.getClient().getPenawaranGuru(guruModel.getUser_id());
        Log.d("url",call.request().url().toString());
        call.enqueue(new Callback<ResponsesGetPenawaranGuru>() {
            @Override
            public void onResponse(Call<ResponsesGetPenawaranGuru> call, Response<ResponsesGetPenawaranGuru> response) {
                if(response.body() != null) {
//                    ResponsesLogin responsesLogin = response.body();
//                    Log.d("testtt", respons);
                }
            }

            @Override
            public void onFailure(Call<ResponsesGetPenawaranGuru> call, Throwable t) {
                Log.d("test",t.getMessage());
            }
        });

        String[] itemsGender = new String[]{"Laki Laki", "Perempuan"};
        ArrayAdapter<String> adapterGender = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, itemsGender);
        ddGender.setAdapter(adapterGender);

        String[] itemsProvinsi = new String[]{"Jawa Timur", "Jawa Barat"};
        ArrayAdapter<String> adapterProvinsi = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, itemsProvinsi);
        ddProvinsi.setAdapter(adapterProvinsi);

        String[] itemsKabupaten = new String[]{"Sidoarjo", "Surabaya"};
        ArrayAdapter<String> adapterKabupaten = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, itemsKabupaten);
        ddKabupaten.setAdapter(adapterKabupaten);


        Button btnLogout = getActivity().findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("user");
                editor.commit();

                Intent i = new Intent(getActivity(), login.class);
                startActivity(i);
            }
        });

        Button btnTambahPenawaran = getActivity().findViewById(R.id.btnTambahPenawaran);
        btnTambahPenawaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TambahPenawaranActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_guru, container, false);
    }
}