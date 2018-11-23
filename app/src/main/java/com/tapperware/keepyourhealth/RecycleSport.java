package com.tapperware.keepyourhealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleSport extends AppCompatActivity {

    @BindView(R.id.my_recyler_view)
    RecyclerView myRecylerView;

    String[] namaSport, detailSport;
    int[] gambarSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_sport);
        ButterKnife.bind(this);

        namaSport = getResources().getStringArray(R.array.sport);
        detailSport = getResources().getStringArray(R.array.sport_detail);
        gambarSport = new int[]{R.drawable.bicycle,R.drawable.meditation,R.drawable.running,R.drawable.swim};

        Adaptert adapter = new Adaptert(RecycleSport.this, gambarSport, detailSport, namaSport);

        myRecylerView.setHasFixedSize(true);
        myRecylerView.setLayoutManager(new LinearLayoutManager(this));
        myRecylerView.setAdapter(adapter);
    }
}
