package com.example.udduaputra;

public class Item_Produk {

    private String Nama;
    private String Harga;
    private int Foto;

    public Item_Produk() {
    }

    public Item_Produk(String nama, int foto, String harga) {
        Nama = nama;
        Harga = harga;
        Foto = foto;
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

