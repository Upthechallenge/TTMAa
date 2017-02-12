package com.example.ramiboukadida.ttma;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ramiboukadida.ttma.entities.LoginParsing;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    final Context context = this;

    Button valider;
    Button valider2;
    Button sinscrire;
    EditText txtlogin,txtpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtlogin= (EditText) findViewById(R.id.txtlogin);
        txtpwd= (EditText) findViewById(R.id.txtpwd);

        valider = (Button) findViewById(R.id.valider);


          valider.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.valider: {
                        LoginParsing loginParsing = new LoginParsing();
                        String x = "";
                        try {
                            x =loginParsing.execute("http://10.0.2.2:18080/PidevService-web/"+"rest/authentif/login/"+txtlogin.getText().toString(),"1").get();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }

                        if(x.equals("exist")) {

                                // Creating service handler class instance


                            Intent myIntent = new Intent(v.getContext(), ActivityAdmin.class);



                            startActivity(myIntent);
                            break;
                        }
                        else Log.e("does not", x);
                    }

                }





            }




        });

      /*  valider.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                Intent myIntent = new Intent(view.getContext(), HomeActivity.class);



                startActivity(myIntent);

            }




        });*/

        sinscrire = (Button) findViewById(R.id.sinscrire);
        sinscrire.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                Intent myIntent = new Intent(view.getContext(), InscriptionActivity.class);

                startActivity(myIntent);

            }

        });

        valider2 = (Button) findViewById(R.id.valider2);
        valider2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                Intent myIntent = new Intent(view.getContext(), HomeActivity.class);

                startActivity(myIntent);

            }

        });
    }

    @Override
    public void onBackPressed() {
        // your code.
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle(R.string.quitter);

        // set dialog message
        alertDialogBuilder

                .setCancelable(true)
                .setPositiveButton(R.string.oui, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(startMain);
                        finish();
                    }
                })
                .setNegativeButton(R.string.non, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();

                    }
                });


        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

   @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.valider: {
                LoginParsing loginParsing = new LoginParsing();
                String x = "";
                try {
                    x =loginParsing.execute("http://localhost:18080/PidevService-web/rest/authentif/login/"+txtlogin.getText().toString(),"1").get();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                if(x.equals("exist")) {
                    startActivity(new Intent(this, MainActivity.class));
                    break;
                }
                else Log.e("does not", x);
            }

        }
    }
}
