package com.example.ramiboukadida.ttma;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class SelectOfferActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_offer);

        TextView output = (TextView) findViewById(R.id.textView1);
        Bundle b = getIntent().getExtras();
        String value = b.getString("Type Operation");
        String star = b.getString("Price");
        String description = b.getString("Clinic");


        String data = "";
        data +=  " \n Type Operation: "+ value +" \n Price: "+ star +" \n Clinic= "+ description +" \n ";
        output.setText(data);
    }
    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }
}
