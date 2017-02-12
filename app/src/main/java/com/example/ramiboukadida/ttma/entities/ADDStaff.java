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
 * Created by FOUED BRAHIM on 10/11/2015.
 */
public class ADDStaff extends AsyncTask<Staff, Void,Void> {
    @Override
    protected Void doInBackground(Staff... params) {
        JSONObject json = new JSONObject();
        try {
            // json.put("idappointement", params[0].getIDappointement());
            json.put("name", params[0].getName());
            json.put("cin", params[0].getCin());
            json.put("salaire", params[0].getSalaire());
            json.put("login", params[0].getLogin());

            json.put("function", params[0].getFunction());
            json.put("surname", params[0].getSurname());
            json.put("dns", params[0].getDns());
            json.put("email", params[0].getEmail());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpEntity httpEntity = null;
        HttpResponse httpResponse = null;
        HttpPost httpPost = new HttpPost("http://10.0.2.2:18080/PidevService-web/rest/authentif/ajout");

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
