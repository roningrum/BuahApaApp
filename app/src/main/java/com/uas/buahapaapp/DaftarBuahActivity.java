package com.uas.buahapaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DaftarBuahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_buah);
        RecyclerView rvDaftarBuah = findViewById(R.id.rv_daftar_buah);
        BuahAdapter adapter = new BuahAdapter(this);
        rvDaftarBuah.setAdapter(adapter);
        rvDaftarBuah.setHasFixedSize(true);
        rvDaftarBuah.setLayoutManager(new LinearLayoutManager(this ));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.logout){
            startActivity(new Intent(this, UserLogin.class));
            Preferences.clearLoginUser(getBaseContext());
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
