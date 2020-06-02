package com.example.udduaputra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void Login(View view) {
        Intent intent = new Intent(login.this, Tampilan_Utama.class);
        startActivity(intent);
    }

    public void ResetPassword(View view) {
        Intent intent = new Intent(login.this, reset_password.class);
        startActivity(intent);
    }
}