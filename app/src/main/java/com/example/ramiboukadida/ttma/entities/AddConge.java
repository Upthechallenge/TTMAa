package com.example.ramiboukadida.ttma.entities;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by AminePC on 10/11/2015.
 */
public class AddConge  extends AsyncTask<Conge, Void,Void> {
    @Override
    protected Void doInBackground(Conge... params) {
        JSONObject json = new JSONObject();
        try {
            json.put("cin", params[0].getCIN());
            json.put("dateDeb", params[0].getDateDeb());
            json.put("dateFin", params[0].getDateFin());
          //  json.put("titre", params[0].getTitre());
            json.put("verif", params[0].getVerif());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpEntity httpEntity = null;
        HttpResponse httpResponse = null;
        HttpPost httpPost = new HttpPost("http://10.0.2.2:18080/PidevService-web/rest/conges/ajouterconge");

        StringEntity a = null;
        try {
            a = new StringEntity(json.toString());
            httpPost.setEntity(a);
            httpPost.addHeader("content-type","application/json");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            httpResponse = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
