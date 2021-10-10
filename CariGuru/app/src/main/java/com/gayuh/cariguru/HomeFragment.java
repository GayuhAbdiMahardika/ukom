package com.gayuh.cariguru;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.gayuh.cariguru.adapter.PromoHomeAdapter;
import com.gayuh.cariguru.model.Promo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    PromoHomeAdapter promoHomeAdapter;
    List<Promo> listPromo;

    public HomeFragment() {
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
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

//        EditText etSearch = getActivity().findViewById(R.id.search);
//        etSearch.bringToFront();

//        listPromo = new ArrayList<Promo>();
//        listPromo.add(new Promo("Promo UN","Matematika","4","2","100.000","20"));
//        listPromo.add(new Promo("Promo UN","Matematika","4","2","100.000","20"));
//        listPromo.add(new Promo("Promo UN","Matematika","4","2","100.000","20"));
//        listPromo.add(new Promo("Promo UN","Matematika","4","2","100.000","20"));
//
//        promoHomeAdapter = new PromoHomeAdapter(getContext(), listPromo);
//        recyclerView.setAdapter(promoHomeAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView recyclerView = getActivity().findViewById(R.id.rcvPromoHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        listPromo = new ArrayList<Promo>();
        listPromo.add(new Promo("Promo UN","Matematika","4","2","100.000","20"));
        listPromo.add(new Promo("Promo UN","Matematika","4","2","100.000","20"));
        listPromo.add(new Promo("Promo UN","Matematika","4","2","100.000","20"));
        listPromo.add(new Promo("Promo UN","Matematika","4","2","100.000","20"));

        promoHomeAdapter = new PromoHomeAdapter(getContext(), listPromo);
        recyclerView.setAdapter(promoHomeAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home, container, false);
    }
}