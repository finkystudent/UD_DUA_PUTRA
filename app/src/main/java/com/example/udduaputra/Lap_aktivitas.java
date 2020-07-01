package com.example.udduaputra;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Lap_aktivitas extends AppCompatActivity {
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    EditText bt_datepicker;
    TextView namanya;
    Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap_aktivitas);

        bt_datepicker = (EditText) findViewById(R.id.bt_datepicker);
        namanya = findViewById(R.id.add_nama);
        simpan = findViewById(R.id.add_simpan);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMounth) {

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMounth);
                updateLabel();
            }

            private void updateLabel() {
                String myFormat = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                bt_datepicker.setText(sdf.format(myCalendar.getTime()));
            }

        };

        bt_datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Lap_aktivitas.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tgl = bt_datepicker.getText().toString();
                String nm = namanya.getText().toString();

                if (tgl.isEmpty()) {

                    bt_datepicker.setError("Masukkan Tanggal");

                } else if (nm.isEmpty()) {
                    namanya.setError("Masukkan Nama");


                } else {
                    sendData(tgl, nm);


                }


            }
        });
    }

    public void sendData(final String tanggal, final String nama) {
        String url = "https://a944b6274200.ngrok.io/tambah-panen";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                bt_datepicker.setText("");
                namanya.setText("");
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                Intent menu1 = new Intent(Lap_aktivitas.this, LapAktivitas.class);
                startActivity(menu1);
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("tanggal", tanggal);
                params.put("nama", nama);
                return params;

            }
        };
        queue.add(request);
    }
}