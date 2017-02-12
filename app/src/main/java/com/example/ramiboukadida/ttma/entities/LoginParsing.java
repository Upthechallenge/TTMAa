package com.example.ramiboukadida.ttma.entities;

/**
 * Created by AminePC on 10/11/2015.
 */

import android.os.AsyncTask;
import android.util.Log;

import com.example.ramiboukadida.ttma.ServiceHandler;

/**
 * Created by lenovo on 09/11/2015.
 */
public class LoginParsing extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... params) {

        ServiceHandler sh = new ServiceHandler();
        String resultatlogin="";
        if (params != null) {


            resultatlogin = sh.makeServiceCall(params[0], Integer.parseInt(params[1]));


        } else {
            Log.e("ServiceHandler", "Couldn't get any data from the url");
        }
        return resultatlogin;
    }
}
