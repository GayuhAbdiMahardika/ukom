package com.gayuh.cariguru.siswa;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gayuh.cariguru.CariGuruActivity;
import com.gayuh.cariguru.MainActivity;
import com.gayuh.cariguru.R;
import com.gayuh.cariguru.SearchActivity;
import com.gayuh.cariguru.adapter.LesHomeAdapter;
import com.gayuh.cariguru.adapter.PromoHomeAdapter;
import com.gayuh.cariguru.model.Jadwal;
import com.gayuh.cariguru.model.Promo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragmentSiswa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragmentSiswa extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    PromoHomeAdapter promoHomeAdapter;
    LesHomeAdapter lesHomeAdapter;

    List<Promo> listPromo;
    List<Jadwal> listJadwal;

    public HomeFragmentSiswa() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragmentSiswa newInstance(String param1, String param2) {
        HomeFragmentSiswa fragment = new HomeFragmentSiswa();
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

        TextView tvJudulPromoHome = getActivity().findViewById(R.id.tvJudulPromo);
        RecyclerView rcvPromoHome = getActivity().findViewById(R.id.rcvPromoHome);
        rcvPromoHome.setLayoutManager(new LinearLayoutManager(getContext()));
        listPromo = new ArrayList<Promo>();
        listPromo.add(new Promo("Promo UN","Matematika","4","2","100.000","20"));
        listPromo.add(new Promo("Promo UN","Matematika","4","2","100.000","20"));
        listPromo.add(new Promo("Promo UN","Matematika","4","2","100.000","20"));
        listPromo.add(new Promo("Promo UN","Matematika","4","2","100.000","20"));
        promoHomeAdapter = new PromoHomeAdapter(getContext(), listPromo);
        rcvPromoHome.setAdapter(promoHomeAdapter);

        RecyclerView rcvJadwalHome = getActivity().findViewById(R.id.rcvJadwalHome);
        rcvJadwalHome.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        listJadwal = new ArrayList<Jadwal>();
        listJadwal.add(new Jadwal("Matematika","Mas Kevin", "01-10-2021","Senin","10.00","12.00"));
        listJadwal.add(new Jadwal("Matematika","Mas Kevin", "01-10-2021","Senin","10.00","12.00"));
        listJadwal.add(new Jadwal("Matematika","Mas Kevin", "01-10-2021","Senin","10.00","12.00"));
        listJadwal.add(new Jadwal("Matematika","Mas Kevin", "01-10-2021","Senin","10.00","12.00"));
        listJadwal.add(new Jadwal("Matematika","Mas Kevin", "01-10-2021","Senin","10.00","12.00"));
        lesHomeAdapter = new LesHomeAdapter(getContext(),listJadwal);
        rcvJadwalHome.setAdapter(lesHomeAdapter);

        LinearLayout etSearch = getActivity().findViewById(R.id.etSearch);
        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SearchActivity.class);
                startActivity(i);
            }
        });

        Button btnBelumLogin = getActivity().findViewById(R.id.btnBelumLogin);
        btnBelumLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                i.putExtra("frgToLoad",R.id.fr_home);
                startActivity(i);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_siswa, container, false);
    }
}