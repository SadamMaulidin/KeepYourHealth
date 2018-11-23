package com.tapperware.keepyourhealth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_start)
    Button btnStart;
    @BindView(R.id.btn_report)
    Button btnReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent pindah;
        switch (item.getItemId()){
            case R.id.action_about:
                pindah = new Intent(this, About.class);
                startActivity(pindah);
                break;
            case R.id.action_profile:
                pindah = new Intent(this, Profile.class);
                startActivity(pindah);
        }
        return super.onOptionsItemSelected(item);
    }


    @OnClick({R.id.btn_start, R.id.btn_report})
    public void onViewClicked(View view) {
        Intent pindah;
        switch (view.getId()) {
            case R.id.btn_start:
                pindah = new Intent(this, home.class);
                startActivity(pindah);
                break;
            case R.id.btn_report:
                String phoneNum = "089607707821";
                pindah = new Intent(Intent.ACTION_DIAL);
                pindah.setData(Uri.parse("tel"+phoneNum));
                startActivity(pindah);
                break;
        }


    }
}
