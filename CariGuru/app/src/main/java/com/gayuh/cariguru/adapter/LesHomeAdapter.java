package com.gayuh.cariguru.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gayuh.cariguru.DetailGuruActivity;
import com.gayuh.cariguru.DetailLesActivity;
import com.gayuh.cariguru.R;
import com.gayuh.cariguru.model.Jadwal;

import java.util.List;

public class LesHomeAdapter extends RecyclerView.Adapter<LesHomeAdapter.ViewHolder> {

    private Context context;
    private List<Jadwal> jadwals;

    public LesHomeAdapter(Context context, List<Jadwal> jadwals) {
        this.context = context;
        this.jadwals = jadwals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jadwal_home, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Jadwal jadwal = jadwals.get(position);
        holder.tvJudul.setText(jadwal.getJudul());
        holder.tvNamaGuru.setText(jadwal.getNamaGuru());
        holder.tvDate.setText(jadwal.getHari()+", "+jadwal.getDate());
        holder.tvJam.setText(jadwal.getJamMulai() + " - "+jadwal.getJamSelesai()+" ");


        holder.item_les.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailLesActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jadwals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvJudul;
        private TextView tvNamaGuru;
        private TextView tvDate;
        private TextView tvJam;
        private LinearLayout item_les;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvNamaGuru = itemView.findViewById(R.id.tvGuru);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvJam = itemView.findViewById(R.id.tvJam);
            item_les = itemView.findViewById(R.id.item_les);
        }
    }
}
