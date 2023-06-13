package com.example.spreadbible_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class EncontreAPalavra extends AppCompatActivity {
    private List<DadosAPI> dadosAPI = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encontre_apalavra);

        // Menu Inferior
        ImageButton btnBiblia = findViewById(R.id.btnBiblia);
        ImageButton btnDoar = findViewById(R.id.btnDoar);
        ImageButton btnDiario = findViewById(R.id.btnDiario);
        ImageButton btnPerfil = findViewById(R.id.btnPerfil);
        ImageButton btnHome = findViewById(R.id.btnHome);


        // Botão de pesquisa e EditText com pesquisa
        Button btnPesquisar = findViewById(R.id.btnPesquisar);
        EditText edtPesquisa = findViewById(R.id.editTextPesquisa);

        btnBiblia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EncontreAPalavra.this, EncontreAPalavra.class);
                startActivity(intent);
            }
        });

        btnDoar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EncontreAPalavra.this, Doacao.class);
                startActivity(intent);
            }
        });

        btnDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EncontreAPalavra.this, Diario.class);
                startActivity(intent);
            }
        });

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EncontreAPalavra.this, Login.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EncontreAPalavra.this, MainActivity.class);
                startActivity(intent);
            }
        });

      btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesquisa = edtPesquisa.getText().toString();
                Tarefa tarefa = new Tarefa();
                tarefa.execute("https://www.abibliadigital.com.br/api/"+ pesquisa);
                // verses/nvi/sl/23/1
            }
        });
    }
 private class Tarefa extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            String retorno = Conexao.getDados(strings[0]);
            return retorno;
        }

        @Override
        protected void onPostExecute(String s){
           dadosAPI = ConsumirJSON.jsonDados(s);
           exibirDados();
        }
    }
    private void exibirDados() {
        TextView txtVersiculo = findViewById(R.id.txtVersiculo);

        if(dadosAPI != null){
            for(DadosAPI dadosAPI : dadosAPI) {
                txtVersiculo.append(dadosAPI.getText() + "\n");
            }
            }
        else{
            txtVersiculo.setText("Oi");
        }
    }
}