package com.gayuh.cariguru.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.gayuh.cariguru.DetailGuruActivity;
import com.gayuh.cariguru.MainActivity;
import com.gayuh.cariguru.R;
import com.gayuh.cariguru.model.Promo;

import java.util.List;

public class PromoHomeAdapter extends RecyclerView.Adapter<PromoHomeAdapter.ViewHolder> {
    private Context context;
    private List<Promo> promos;


    public PromoHomeAdapter(Context context, List<Promo> promos) {
        this.context = context;
        this.promos = promos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promo_home, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Promo promo = promos.get(position);
        holder.btnDiskon.setText("Diskon "+promo.getDiskon()+"%");
        holder.tvJudul.setText(promo.getJudul());
        holder.tvPertemuan.setText(promo.getJumlahPertemuan()+"x pertemuan");
        holder.tvMapel.setText(promo.getMapel());
        holder.tvHargaAsli.setText(promo.getHargaAsli()); holder.tvHargaAsli.setPaintFlags(holder.tvHargaAsli.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.tvHargaDiskon.setText(promo.getHargaAsli());

        holder.itemPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailGuruActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return promos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgGuru;
        private TextView tvJudul;
        private TextView tvPertemuan;
        private TextView tvMapel;
        private TextView tvHargaAsli;
        private TextView tvHargaDiskon;
        private Button btnDiskon;
        private LinearLayout itemPromo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemPromo = itemView.findViewById(R.id.item_promo);
            imgGuru = (ImageView)  itemView.findViewById(R.id.imgGuru);
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvPertemuan = (TextView) itemView.findViewById(R.id.tvDate);
            tvMapel = (TextView) itemView.findViewById(R.id.tvGuru);
            tvHargaAsli = (TextView) itemView.findViewById(R.id.tvJam);
            tvHargaDiskon = (TextView) itemView.findViewById(R.id.tvHargaDiskon);
            btnDiskon = (Button) itemView.findViewById(R.id.btnDiskon);

        }
    }
}
