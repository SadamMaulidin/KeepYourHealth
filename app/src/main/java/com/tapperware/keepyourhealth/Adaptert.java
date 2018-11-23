package com.tapperware.keepyourhealth;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adaptert extends RecyclerView.Adapter<Adaptert.ViewHolder> {
    Context context;
    int[] sportImg;
    String[] sportName, sportDet;

    public Adaptert(Context context, int[] sportImg, String[] sportDet, String[] sportName) {
        this.context = context;
        this.sportImg = sportImg;
        this.sportName = sportName;
        this.sportDet = sportDet;
    }

    @NonNull
    @Override
    public Adaptert.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sport, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptert.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(sportName[i]);
        Glide.with(context).load(sportImg[i]).into(viewHolder.imgLogo);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailActivity.class);
                pindah.putExtra("sn", sportName[i]);
                pindah.putExtra("sd", sportDet[i]);
                pindah.putExtra("si", sportImg[i]);
                context.startActivity(pindah);
            }
        });
    }
    @Override
    public int getItemCount() {
        return sportImg.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView txtNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgListSport);
            txtNama = itemView.findViewById(R.id.txtTitleSport);
        }
    }
}
