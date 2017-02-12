package com.example.ramiboukadida.ttma;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class selectpatient extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectpatient);

        TextView output = (TextView) findViewById(R.id.textView1);
        Bundle b = getIntent().getExtras();


        String name = b.getString("name");
        String cin = b.getString("cin");
        String email = b.getString("email");
        String dns = b.getString("dns");
        String function = b.getString("function");



        String data = "";
        data +=  " \n name: "+ name +" \n cin: "+ cin +" \n dns= "+dns  +" \n email="+email+" \n function="+function+"\n ";
        output.setText(data);
    }
    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }
}
