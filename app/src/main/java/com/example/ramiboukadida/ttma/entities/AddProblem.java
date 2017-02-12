package com.example.ramiboukadida.ttma.entities;

import android.os.AsyncTask;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MEHDI on 10/11/2015.
 */
public class AddProblem extends AsyncTask<Problem, Void,Void> {
@Override
protected Void doInBackground(Problem... params) {
        JSONObject json = new JSONObject();
        try {
        json.put("title", params[0].getTitle());
        json.put("description", params[0].getDescription());

        } catch (JSONException e) {
        e.printStackTrace();
        }

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpEntity httpEntity = null;
        HttpResponse httpResponse = null;
        HttpPost httpPost = new HttpPost("http://10.0.2.2:18080/PidevService-web/rest/problems/create");

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
