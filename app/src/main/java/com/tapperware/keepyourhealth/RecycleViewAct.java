package com.tapperware.keepyourhealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewAct extends AppCompatActivity {

    @BindView(R.id.my_recyler_view)
    RecyclerView myRecylerView;

    String[] namaMakanan, detailMakanan;
    int[] gambarMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        ButterKnife.bind(this);

        namaMakanan = getResources().getStringArray(R.array.healthyfood);
        detailMakanan = getResources().getStringArray(R.array.healthyfood_det);
        gambarMakanan = new int[]{R.drawable.vegetables, R.drawable.fruit, R.drawable.meat, R.drawable.egg, R.drawable.fish, R.drawable.peas, R.drawable.milk};

        Adapters adapter = new Adapters(RecycleViewAct.this, gambarMakanan, detailMakanan, namaMakanan);

        myRecylerView.setHasFixedSize(true);
        myRecylerView.setLayoutManager(new LinearLayoutManager(this));
        myRecylerView.setAdapter(adapter);

    }
}
