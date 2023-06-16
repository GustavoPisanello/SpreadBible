package com.example.spreadbible_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Doacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doacao);

        ImageButton btnBiblia = findViewById(R.id.btnBiblia);
        ImageButton btnDoar = findViewById(R.id.btnDoar);
        ImageButton btnDiario = findViewById(R.id.btnDiario);
        ImageButton btnPerfil = findViewById(R.id.btnPerfil);
        ImageButton btnHome = findViewById(R.id.btnHome);

        Button btnDoacao = findViewById(R.id.btnDoacao);

        btnBiblia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Doacao.this, EncontreAPalavra.class);
                startActivity(intent);
            }
        });

        btnDoar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Doacao.this, Doacao.class);
                startActivity(intent);
            }
        });

        btnDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Doacao.this, Diario.class);
                startActivity(intent);
            }
        });

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Doacao.this, Login.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Doacao.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnDoacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregaLink("https://www.abrale.org.br/informacoes/doacao-de-recursos/");
            }
        });
    }

    private void CarregaLink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}