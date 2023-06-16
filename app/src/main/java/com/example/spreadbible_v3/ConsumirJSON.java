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
            JSONArray versosArray = jsonObject.getJSONArray("verses");

            int i;
            for(i = 0; i < versosArray.length(); i++ ){
                JSONObject versi = versosArray.getJSONObject(i);
                DadosAPI dadosAPI = new DadosAPI();
                dadosAPI.setText(versi.getString("text"));
                dadosList.add(dadosAPI);
            }

            Log.i("EU", "Resposta do servidor 4:" + dadosList);
            return dadosList;
        }

        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
