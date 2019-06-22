package com.uas.buahapaapp;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BuahDetail extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buah_detail);
        TextView namaBuah = findViewById(R.id.tv_namabuah);
        ImageView gambarBuah = findViewById(R.id.img_gambarbuah);
        TextView detail = findViewById(R.id.tvdetail);
        Button backMenu = findViewById(R.id.back_menu);

        int position = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        String[] Buah = resources.getStringArray(R.array.fruits);
        namaBuah.setText(Buah[position % Buah.length]);

        TypedArray Buahpic = resources.obtainTypedArray(R.array.place_avator);
        gambarBuah.setImageDrawable(Buahpic.getDrawable(position % Buahpic.length()));
        Buahpic.recycle();

        final String[] BuahDetail = resources.getStringArray(R.array.fruits_desc);
        detail.setText(BuahDetail[position % BuahDetail.length]);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuahDetail.this, DaftarBuahActivity.class));
                finish();
            }
        });


    }
}
