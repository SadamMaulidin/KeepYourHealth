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

import java.util.zip.Inflater;

public class Adapters extends RecyclerView.Adapter<Adapters.ViewHolder> {
    Context context;
    int[] foodImg;
    String[] footName, foodDet;

    public Adapters(Context context, int[] foodImg, String[] foodDet, String[] footName) {
        this.context = context;
        this.foodImg = foodImg;
        this.footName = footName;
        this.foodDet = foodDet;
    }

    @NonNull
    @Override
    public Adapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.healthy_food, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapters.ViewHolder viewHolder, final int i) {
        viewHolder.txtNamaFood.setText(footName[i]);
        Glide.with(context).load(foodImg[i]).into(viewHolder.imgLogoFood);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailActivity.class);
                pindah.putExtra("fn", footName[i]);
                pindah.putExtra("fd", foodDet[i]);
                pindah.putExtra("fi", foodImg[i]);
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodImg.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogoFood;
        TextView txtNamaFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogoFood = itemView.findViewById(R.id.imgListFood);
            txtNamaFood = itemView.findViewById(R.id.txtTitleFood);
        }
    }
}
