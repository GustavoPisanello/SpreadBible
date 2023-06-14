package com.example.spreadbible_v3;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsumirJSON {

    public static DadosAPI Dados(String jsonString){
        Log.i("EU", "Resposta do servidor:" + jsonString);
        try{

            JSONObject retorno = new JSONObject(jsonString);
            JSONObject livro = retorno.getJSONObject("book");

            String abbrev = livro.getString("abbrev");
            String name = livro.getString("name");
            String autor = livro.getString("author");
            String grupo = livro.getString("group");
            String versao = livro.getString("version");

            JSONObject cap = retorno.getJSONObject("chapter");
            int chapter = cap.getInt("number");
            int verses = cap.getInt("verses");

            String versi = null;

            int i;
            for(i = 0; i < verses; i++){
                JSONArray v = retorno.getJSONArray("verses");
                String texto = v.getJSONObject(i).getString("text");

                versi = String.join("." , texto);
            }

            DadosAPI dadosAPI = new DadosAPI(abbrev, name, autor, grupo, versao, chapter, versi);

            return dadosAPI;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
