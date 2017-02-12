package com.example.ramiboukadida.ttma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ramiboukadida.ttma.entities.ADDStaff;
import com.example.ramiboukadida.ttma.entities.Staff;


/**
 * Created by Rami Boukadida on 04/11/2015.
 */
public class InscriptionActivity extends Activity {

    Button valider;
    TextView nom,prenom,cin,emai,login,pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        nom = (TextView) findViewById(R.id.txtnom);
        prenom = (TextView) findViewById(R.id.txtprenom);
        cin = (TextView) findViewById(R.id.txtcin);
        emai = (TextView) findViewById(R.id.txemail);
        login = (TextView) findViewById(R.id.txtlogin);
        pw = (TextView) findViewById(R.id.txtpwd);
        valider = (Button) findViewById(R.id.valider);
        valider.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                ADDStaff addStaff = new ADDStaff();
                Staff o =new Staff();

                o.setName(nom.getText().toString());
                o.setSurname(prenom.getText().toString());
                o.setCin(cin.getText().toString());
                o.setEmail(emai.getText().toString());
                o.setLogin(login.getText().toString());
                o.setMdp(pw.getText().toString());

                addStaff.execute(o);

                Intent myIntent = new Intent(view.getContext(), MainActivity.class);

                startActivity(myIntent);

            }

        });
    }
}
