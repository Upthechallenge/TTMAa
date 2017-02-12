package com.example.ramiboukadida.ttma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ramiboukadida.ttma.entities.AddProblem;
import com.example.ramiboukadida.ttma.entities.Problem;

/**
 * Created by MEHDI on 10/11/2015.
 */
public class AddProblemActivity extends AppCompatActivity {


    EditText txttitle , txtdesc;

     Button valider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproblem);

        valider = (Button) findViewById(R.id.valider);
        valider.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                txttitle= (EditText) findViewById(R.id.txttitle);
                txtdesc= (EditText) findViewById(R.id.txtdesc);

               Problem p=new Problem();
                p.setTitle(txttitle.getText().toString());
                p.setDescription(txtdesc.getText().toString());
                AddProblem ap=new AddProblem();
                ap.execute(p);


               /* Intent myIntent = new Intent(view.getContext(), HomeActivity.class);

                startActivity(myIntent);*/

            }

        });

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }
}
