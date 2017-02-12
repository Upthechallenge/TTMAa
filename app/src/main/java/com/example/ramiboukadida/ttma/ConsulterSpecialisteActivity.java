package com.example.ramiboukadida.ttma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ramiboukadida.ttma.entities.OnlineConsultations;


/**
 * Created by FOUED BRAHIM on 08/11/2015.
 */
public class ConsulterSpecialisteActivity extends ActionBarActivity {



   TextView dt,doctor,pat;
  Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulterspecialiste);
        dt=(TextView)findViewById(R.id.dt);
        doctor=(TextView)findViewById(R.id.doctor);
        pat=(TextView)findViewById(R.id.pat);
        valider = (Button) findViewById(R.id.valider);
        valider.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                ADDOnlineCon addOnlineCon = new ADDOnlineCon();
                OnlineConsultations o =new OnlineConsultations();
                o.setDateApp(dt.getText().toString());
                o.setDoctorNAmeapp(doctor.getText().toString());
                o.setPatientNAmeApp(pat.getText().toString());

                addOnlineCon.execute(o);

                Intent myIntent = new Intent(view.getContext(), MyappointementsActivity.class);

                startActivity(myIntent);

            }

        });
    }
}


