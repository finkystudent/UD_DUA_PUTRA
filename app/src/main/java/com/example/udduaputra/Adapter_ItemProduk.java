package com.example.udduaputra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class Adapter_ItemProduk extends RecyclerView.Adapter<Adapter_ItemProduk.ListViewHolder> {

    private ArrayList<Model_ItemProduk> listProduknya;
    private Context mContext;

    public Adapter_ItemProduk(ArrayList<Model_ItemProduk> listProduk) {
        //  this.mContext = mContext;
        this.listProduknya = listProduk;
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
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item__produk, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Model_ItemProduk hasilProduk = listProduknya.get(position);
String url = "https://85c8168762ff.ngrok.io/images/";
        holder.Nama_Produk.setText(hasilProduk.getNama_produk());
        holder.Harga.setText( hasilProduk.getHarga());
        Glide
                .with(mContext)
                .load(url+hasilProduk.getFoto())
       . apply(new RequestOptions().override(500, 500))
                .into(holder.Foto);

    }

    @Override
    public int getItemCount() {
        return listProduknya.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView Foto;
        TextView Nama_Produk;
        TextView Harga;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            Foto = itemView.findViewById(R.id.imageView6);
            Nama_Produk = itemView.findViewById(R.id.namaproduk);
            Harga = itemView.findViewById(R.id.harga_produk);
        }
    }
}


