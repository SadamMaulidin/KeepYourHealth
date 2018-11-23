package com.tapperware.keepyourhealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class home extends AppCompatActivity {

    @BindView(R.id.food)
    Button food;
    @BindView(R.id.sport)
    Button sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.food, R.id.sport})
    public void onViewClicked(View view) {
        Intent pindah;
        switch (view.getId()) {
            case R.id.food:
                pindah = new Intent(this, RecycleViewAct.class);
                startActivity(pindah);
                break;
            case R.id.sport:
                pindah = new Intent(this,RecycleSport.class);
                startActivity(pindah);
                break;
        }
    }
}
