package com.example.spreadbible_v3;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsumirJSON {

    public static List<DadosAPI> jsonDados(String jsonString){
        Log.i("EU", "Resposta do servidor:" + jsonString);
        List<DadosAPI> dadosList = new ArrayList<DadosAPI>();
        try{

            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("book");

            for(int i = 0; i < jsonArray.length(); i++){
                jsonObject = jsonArray.getJSONObject(i);

                DadosAPI dadosAPI = new DadosAPI();

                dadosAPI.setBook(jsonObject.getString("book"));
                dadosAPI.setAbbrev(jsonObject.getString("abbrev"));
                dadosAPI.setName(jsonObject.getString("name"));
                dadosAPI.setChapter(jsonObject.getString("chapter"));
                dadosAPI.setAuthor(jsonObject.getString("author"));
                dadosAPI.setGroup(jsonObject.getString("group"));
                dadosAPI.setVersion(jsonObject.getString("version"));
                dadosAPI.setChapter(jsonObject.getString("chapter"));
                dadosAPI.setNumber(jsonObject.getString("number"));
                dadosAPI.setText(jsonObject.getString("text"));

                dadosList.add(dadosAPI);
            }
            return dadosList;
        }

        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
