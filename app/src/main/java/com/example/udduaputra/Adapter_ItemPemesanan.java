package com.example.udduaputra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter_ItemPemesanan extends RecyclerView.Adapter<Adapter_ItemPemesanan.ListViewHolder> {
    private ArrayList<Model_ItemPemesanan> listPemesanannya;
    private Context mContext;

    public Adapter_ItemPemesanan(ArrayList<Model_ItemPemesanan> listPemesanan) {
        //  this.mContext = mContext;
        this.listPemesanannya = listPemesanan;
        notifyDataSetChanged();
    }


//    @NonNull
//    @Override
//    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        View view;
////        LayoutInflater inflater = LayoutInflater.from(mContext);
////        view = inflater.inflate(R.layout.item_hasil_panen, parent, false);
////        return new myViewHolder(view);
//
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Adapter_HasilPanen.myViewHolder holder, int position) {
//        Model_HasilPanen model_hasilPanen = listPanen.get(position);
//        holder.Tanggal.setText(model_hasilPanen.getTanggal());
//        holder.Berat.setText(model_hasilPanen.getBerat());
//
//    }

    @NonNull
    @Override
    public Adapter_ItemPemesanan.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item__pemesanan, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_ItemPemesanan.ListViewHolder holder, int position) {
        Model_ItemPemesanan hasilPemesanan = listPemesanannya.get(position);
        String url = "https://5fa9c18beb2d.ngrok.io/images/";
        holder.Nama_Produk.setText(hasilPemesanan.getNama_produk());
        holder.Jumlah.setText( hasilPemesanan.getJumlah());
        holder.Harga.setText( hasilPemesanan.getHarga());
        Glide
                .with(holder.itemView.getContext())
                .load(url+hasilPemesanan.getFoto())

                .into(holder.Foto);

    }

    @Override
    public int getItemCount() {
        return listPemesanannya.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView Foto;
        TextView Nama_Produk;
        TextView Harga;
        EditText Jumlah;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            Foto = itemView.findViewById(R.id.imageView6);
            Nama_Produk = itemView.findViewById(R.id.namaproduk);
            Harga = itemView.findViewById(R.id.harga_produk);
            Jumlah = itemView.findViewById(R.id.jumlah_pemesanan);
        }
    }
}


