package com.example.ramiboukadida.ttma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ramiboukadida.ttma.entities.AddConge;
import com.example.ramiboukadida.ttma.entities.Conge;

/**
 * Created by Amine Chalouati on 04/11/2015.
 */
public class AddCongeActivity extends ActionBarActivity {

    Button valider;
    TextView txttitre,txtcin,txtDteDeb,txtverif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_conge);

        txttitre = (TextView) findViewById(R.id.txttitre);
        txtcin = (TextView) findViewById(R.id.txtcin);
        txtDteDeb = (TextView) findViewById(R.id.txtdateDeb);
        txtverif = (TextView) findViewById(R.id.txtverif);
        valider = (Button) findViewById(R.id.valider);
        valider.setOnClickListener(new View.OnClickListener() {




            public void onClick(View view) {



                AddConge addConge = new AddConge();
                Conge c =new Conge();

              // c.setTitre(titre.getText().toString());
                c.setCIN(txtcin.getText().toString());
                c.setDateDeb(txtDteDeb.getText().toString());
                c.setVerif(txtverif.getText().toString());
                addConge.execute(c);

                Intent myIntent = new Intent(view.getContext(), AddCongeActivity.class);
                startActivity(myIntent);





                        }

                    });
                }
            }

