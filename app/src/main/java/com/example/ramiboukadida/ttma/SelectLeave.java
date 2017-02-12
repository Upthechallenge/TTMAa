package com.example.ramiboukadida.ttma;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class SelectLeave extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_leave);

        TextView output = (TextView) findViewById(R.id.textView1);
        Bundle b = getIntent().getExtras();


        String name = b.getString("name");
        String cin = b.getString("cin");
        String db = b.getString("date debut");
        String df = b.getString("date fin");
        String stat = b.getString("Statut");



        String data = "";
        data +=  " \n name: "+ name +" \n cin: "+ cin +" \n date debut= "+db  +" \n date fin="+df+"\n ";
        output.setText(data);
    }
    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }
}
