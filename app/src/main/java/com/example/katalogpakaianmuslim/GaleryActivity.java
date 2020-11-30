package com.example.katalogpakaianmuslim;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.example.katalogpakaianmuslim.Pakaian;

public class GaleryActivity extends AppCompatActivity {

    List<Pakaian> pakaians;
    int indeksTampil = 0;
    String jenisPakaian;
    Button btnPertama, btnTerakhir, btnSebelumnya, btnBerikutnya;
    TextView txJenis, txBaju, txHarga, txDeskripsi, txJudul;
    ImageView ivFotoPakaian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_muslim);
        Intent intent = getIntent();
        jenisPakaian = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        pakaians = DataProvider.getPakaiansByTipe(this, jenisPakaian);
        inisialisasiView();
        tampilkanProfil();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> pakaianPertama());
        btnTerakhir.setOnClickListener(view -> pakaianTerakhir());
        btnSebelumnya.setOnClickListener(view -> pakaianSebelumnya());
        btnBerikutnya.setOnClickListener(view -> pakaianBerikutnya());

        txJenis = findViewById(R.id.txJenis);
        txBaju = findViewById(R.id.txBaju);
        txHarga = findViewById(R.id.txHarga);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoPakaian = findViewById(R.id.gambarPakaian);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Berbagai Macam Pakaian Muslim " + jenisPakaian);
    }


    private void tampilkanProfil() {
        Pakaian k = pakaians.get(indeksTampil);
        Log.d("WANITA", "Menampilkan wanita " + k.getJenis());
        txJenis.setText(k.getJenis());
        txBaju.setText(k.getBaju());
        txHarga.setText(k.getHarga());
        txDeskripsi.setText(k.getDeskripsi());
        ivFotoPakaian.setImageDrawable(this.getDrawable(k.getDrawableRes()));
    }

    private void pakaianPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this, "Sudah di posisi pertama", Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void pakaianTerakhir() {
        int posAkhir = pakaians.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this, "Sudah di posisi terakhir", Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void pakaianBerikutnya() {
        if (indeksTampil == pakaians.size() - 1) {
            Toast.makeText(this, "Sudah di posisi terakhir", Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void pakaianSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this, "Sudah di posisi pertama", Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }
    }
}