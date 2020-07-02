package com.example.udduaputra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Item_Pemesanan {
    private String Nama;
    private String Harga;
    private int Foto;
    private int Jumlah;

    public Item_Pemesanan() {
    }

    public Item_Pemesanan(String nama, int foto, String harga, int jumlah) {
        Nama = nama;
        Harga = harga;
        Foto = foto;
        Jumlah = jumlah;
    }

    public String getNama() {
        return Nama;
    }

    public String getHarga() {
        return Harga;
    }

    public int getFoto() {
        return Foto;
    }

    public int getJumlah() {
        return Jumlah;
    }

    public void setJumlah(int jumlah) {
        Jumlah = jumlah;
    }

    public void setNama_Produk(String nama_produk) {
        Nama = nama_produk;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }
}


