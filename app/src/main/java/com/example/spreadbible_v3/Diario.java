package com.example.spreadbible_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Diario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario);

        ImageButton btnBiblia = findViewById(R.id.btnBiblia);
        ImageButton btnDoar = findViewById(R.id.btnDoar);
        ImageButton btnDiario = findViewById(R.id.btnDiario);
        ImageButton btnPerfil = findViewById(R.id.btnPerfil);
        ImageButton btnHome = findViewById(R.id.btnHome);

        btnBiblia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diario.this, EncontreAPalavra.class);
                startActivity(intent);
            }
        });

        btnDoar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diario.this, Doacao.class);
                startActivity(intent);
            }
        });

        btnDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diario.this, Diario.class);
                startActivity(intent);
            }
        });

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diario.this, Login.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diario.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}