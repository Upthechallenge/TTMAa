package com.example.ramiboukadida.ttma;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class SelectAPP extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_app);

        TextView output = (TextView) findViewById(R.id.textView1);
        Bundle b = getIntent().getExtras();


        String value = b.getString("Patient Name");
        String star = b.getString("Date appointement");
        String description = b.getString("Doctor name");


        String data = "";
        data +=  " \n Patient Name: "+ value +" \n Date appointement: "+ star +" \n Doctor name= "+ description +" \n ";
        output.setText(data);
    }
    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }}
