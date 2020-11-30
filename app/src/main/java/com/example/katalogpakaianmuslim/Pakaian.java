package com.example.katalogpakaianmuslim;

public class Pakaian {
    private String jenis;
    private String baju;
    private String harga;
    private String deskripsi;
    private int drawableRes;

    public Pakaian(String jenis, String baju, String harga, String deskripsi, int drawableRes) {
        this.jenis = jenis;
        this.baju = baju;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.drawableRes = drawableRes;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getBaju() {
        return baju;
    }

    public void setBaju(String baju) {
        this.baju = baju;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }
}
