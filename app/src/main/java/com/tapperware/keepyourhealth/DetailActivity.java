package com.tapperware.keepyourhealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.imgList)
    ImageView imgList;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtDetail)
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        txtDetail.setText(getIntent().getStringExtra("fd"));
        txtTitle.setText(getIntent().getStringExtra("fn"));
        Glide.with(this).load(getIntent().getIntExtra("fi", 0)).into(imgList);

        txtDetail.setText(getIntent().getStringExtra("sd"));
        txtTitle.setText(getIntent().getStringExtra("sn"));
        Glide.with(this).load(getIntent().getIntExtra("si", 0)).into(imgList);
    }
}
