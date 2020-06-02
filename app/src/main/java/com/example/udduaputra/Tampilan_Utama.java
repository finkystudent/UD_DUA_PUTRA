package com.example.udduaputra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tampilan_Utama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan__utama);
    }

    public void Lap_Aktivitas(View view) {
        Intent intent = new Intent(Tampilan_Utama.this, Lap_aktivitas.class);
        startActivity(intent);
    }
}
