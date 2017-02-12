package com.example.ramiboukadida.ttma;

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


import com.example.ramiboukadida.ttma.entities.OnlineConsultations;

/**
 * Created by FOUED BRAHIM on 10/11/2015.
 */
public class ADDOnlineCon extends AsyncTask<OnlineConsultations, Void,Void> {
    @Override
    protected Void doInBackground(OnlineConsultations... params) {
        JSONObject json = new JSONObject();
        try {
            // json.put("idappointement", params[0].getIDappointement());
            json.put("patientNAmeApp", params[0].getPatientNAmeApp());
            json.put("doctorNAmeapp", params[0].getDoctorNAmeapp());
            json.put("dateApp", params[0].getDateApp());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpEntity httpEntity = null;
        HttpResponse httpResponse = null;
        HttpPost httpPost = new HttpPost("http://10.0.2.2:18080/PidevService-web/rest/consultations/ajout1");

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
