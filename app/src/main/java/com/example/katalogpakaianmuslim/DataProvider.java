package com.example.katalogpakaianmuslim;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.example.katalogpakaianmuslim.Pria;
import com.example.katalogpakaianmuslim.Pakaian;
import com.example.katalogpakaianmuslim.Wanita;

public class DataProvider {
    private static List<Pakaian> pakaians = new ArrayList<>();

    private static List<Pria> initDataPria(Context ctx) {
        List<Pria> prias = new ArrayList<>();
        prias.add(new Pria("Gerai Hawa Yassar Hoodie Kurta", "Rp 380.000,00",
                "size : M, L, XL, XXL", R.drawable.aa));
        prias.add(new Pria("Aldebaran Amr Black", "Rp 125.000,00",
                "size : M, L, XL, XXL", R.drawable.aaa));
        prias.add(new Pria("Bunayya Gamis Krakatoa", "Rp 250.000,00",
                "size : M, L, XL, XXL", R.drawable.aaaa));
        prias.add(new Pria("Gerai Hawa Khalil Koko", "Rp 330.000,00",
                "size : M, L, XL, XXL", R.drawable.aaaaa));
        return prias;
    }

    private static List<Wanita> initDataWanita(Context ctx) {
        List<Wanita> wanitas = new ArrayList<>();
        wanitas.add(new Wanita("Havva Farani Kaftan White", "Rp 450.000,00",
                "size : M, L, XL, XXL", R.drawable.bb));
        wanitas.add(new Wanita("ALEZA Hevana Top", "Rp 350.000,00 ",
                "size : M, L, XL, XXL", R.drawable.bbb));
        wanitas.add(new Wanita("Kanaka Bia Stripped Blouse ", "Rp 500.000,00",
                "size : M, L, XL, XXL ", R.drawable.bbbb));
        wanitas.add(new Wanita("Mannequina Mirsya Jumpsuit di", "Rp 330.000,00",
                "size : M, L, XL, XXL", R.drawable.bbbbb));
        return wanitas;
    }

    private static void initAllPakaian(Context ctx) {
        pakaians.addAll(initDataPria(ctx));
        pakaians.addAll(initDataWanita(ctx));
    }

    public static List<Pakaian> getAllPakaian(Context ctx) {
        if (pakaians.size() == 0) {
            initAllPakaian(ctx);
        }
        return  pakaians;
    }

    public static List<Pakaian> getPakaiansByTipe(Context ctx, String jenis) {
        List<Pakaian> pakaiansByType = new ArrayList<>();
        if (pakaians.size() == 0) {
            initAllPakaian(ctx);
        }
        for (Pakaian h : pakaians) {
            if (h.getJenis().equals(jenis)) {
                pakaiansByType.add(h);
            }
        }
        return pakaiansByType;
    }

}
