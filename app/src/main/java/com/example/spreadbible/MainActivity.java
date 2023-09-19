package com.example.spreadbible;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.spreadbible_v3.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void ActivityEncontre(){
        Intent encontre = new Intent(MainActivity.this, EncontreAPalavra.class);
        startActivity(encontre);
    }
}