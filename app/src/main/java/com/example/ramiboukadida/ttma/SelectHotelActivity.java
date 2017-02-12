package com.example.ramiboukadida.ttma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;

/**
 * Created by MEHDI on 09/11/2015.
 */
public class SelectHotelActivity extends ActionBarActivity {
    Button valider;
    String value;
    String star;
    String description;
    String longitude;
    String latitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecthotel);
        valider = (Button) findViewById(R.id.valider);










                TextView output = (TextView) findViewById(R.id.textView1);
                Bundle b = getIntent().getExtras();
                value = b.getString("name");
                star = b.getString("star");
                description = b.getString("description");
                longitude = b.getString("longitude");
                latitude = b.getString("latitude");
                Log.e("long2",longitude);
                Log.e("lat3",latitude);
        valider.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                Intent myIntent = new Intent(view.getContext(), MapsActivity.class);
                Bundle b = getIntent().getExtras();



            //    Log.e("long3",longitude);
                Bundle b1 = new Bundle();
                b1.putString("longitude", longitude);
                b1.putString("latitude", latitude);
                myIntent.putExtras(b1);
                startActivity(myIntent);

            }

        });


                String data = "";
                data += " \n Name: " + value + " \n Stars: " + star + " \n Description= " + description + " \n ";
                output.setText(data);
            }

            @Override
            public void onBackPressed() {

                super.onBackPressed();

            }
        }
