package com.example.udduaputra;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Produk extends AppCompatActivity {

    final private ArrayList<Model_ItemProduk> listproduk = new ArrayList<>();
    private RecyclerView myrv;

//    private BottomNavigationView navigasi2;
static String url =  " http://85c8168762ff.ngrok.io/produk";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);


        myrv = findViewById(R.id.produk_recycleview);
        myrv.setHasFixedSize(true);
        getData();
    }



    private void getData() {

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object1 = new JSONObject(response);
                    JSONArray data = object1.getJSONArray("data");
                    Log.d("array", "" + data);
                    for (int i = 0; i < data.length(); i++) {
                        Model_ItemProduk produk = new Model_ItemProduk();
                        JSONObject object2 = data.getJSONObject(i);
                        String foto = object2.getString("foto");
                        String nama_produk = object2.getString("nama_produk");
                        String harga = object2.getString("harga");
                        String doto = object2.getString("foto");
                        Toast.makeText(Produk.this, "Foto" + foto  + nama_produk+ harga, Toast.LENGTH_SHORT).show();
                    produk.setFoto(doto);
                        produk.setNama_produk(nama_produk);
                        produk.setHarga(harga);
                        listproduk.add(produk);
                    }

                    showRecycleList();
                    Log.d("listnya", "" + listproduk);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(request);
    }

    private void showRecycleList() {
        myrv.setLayoutManager(new LinearLayoutManager(this));
        Adapter_ItemProduk adapter_itemProduk = new Adapter_ItemProduk(listproduk);
        myrv.setAdapter(adapter_itemProduk);
    }
//        navigasi2 = (BottomNavigationView) findViewById(R.id.navigasi2);
//        navigasi2.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                switch (id) {
//                    case R.id.navigation_toko:
//                        Toast.makeText(Produk.this," Anda sedang berada di toko", Toast.LENGTH_SHORT).show();
//                        Intent intent1 = new Intent(Produk.this, Toko.class);
//                        startActivity(intent1);
//                        break;
//                    case R.id.navigation_produk:
//                        Toast.makeText(Produk.this," Anda sedang berada di produk", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.navigation_pemesanan:
//                        Toast.makeText(Produk.this," Anda sedang berada di pemesanan", Toast.LENGTH_SHORT).show();
//                        Intent intent2 = new Intent(Produk.this, Pemesanan.class);
//                        startActivity(intent2);
//                        break;
//                }
//                return true;
//            }
//        });



            }
