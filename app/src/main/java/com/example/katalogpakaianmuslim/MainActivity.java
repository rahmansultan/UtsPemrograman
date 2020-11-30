package com.example.katalogpakaianmuslim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnKucing,btnAnjing;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnKucing = findViewById(R.id.btn_buka_pria);
        btnAnjing = findViewById(R.id.btn_buka_wanita);
        btnKucing.setOnClickListener(view -> bukaGaleri("Pria"));
        btnAnjing.setOnClickListener(view -> bukaGaleri("Wanita"));
    }

    private void bukaGaleri(String jenisPakaina) {
        Log.d("MAIN","Buka activity pria");
        Intent intent = new Intent(this, GaleryActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisPakaina);
        startActivity(intent);
    }

}