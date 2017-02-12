package com.example.ramiboukadida.ttma;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by MEHDI on 09/11/2015.
 */
public class SelectDoctorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectdoctor);

        TextView output = (TextView) findViewById(R.id.textView1);
        Bundle b = getIntent().getExtras();


        String value = b.getString("Name");
        String star = b.getString("Speciality");
        String description = b.getString("Email");


        String data = "";
        data +=  " \n Name: "+ value +" \n Speciality: "+ star +" \n Email= "+ description +" \n ";
        output.setText(data);
    }
    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }
}
