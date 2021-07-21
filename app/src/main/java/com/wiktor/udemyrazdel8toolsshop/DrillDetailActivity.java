package com.wiktor.udemyrazdel8toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    private TextView textViewtitle;
    private TextView textViewtinfo;
    private ImageView imageViewDrill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        textViewtitle = findViewById(R.id.textView_title);
        textViewtinfo = findViewById(R.id.textViewInfo);
        imageViewDrill = findViewById(R.id.imageViewDrill);

        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1);

            textViewtitle.setText(title);
            textViewtinfo.setText(info);
            imageViewDrill.setImageResource(resId);
        } else {
            Intent backToCategory = new Intent(this, DrillCategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}