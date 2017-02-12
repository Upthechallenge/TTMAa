package com.example.ramiboukadida.ttma;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class ListLeave extends ListActivity {

    private static String url = "http://10.0.2.2:18080/PidevService-web/rest/conges/list";


    private String data = "";
    private static final String TAG_ID = "id";
    private static final String TAG_DF = "dateFin";
    private static final String TAG_DB = "dateDeb";
    private static final String TAG_Verif = "verif";
    private static final String TAG_NAME = "titre";
    private static final String TAG_CIN = "cin";

    Button valider;
    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;
   TextView f,v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        valider = (Button) findViewById(R.id.valider);
       /* valider.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                Intent myIntent = new Intent(view.getContext(), HotelActivity.class);

                startActivity(myIntent);

            }

        });*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_leave);
        contactList = new ArrayList<HashMap<String, String>>();
        ServiceHandler a = new ServiceHandler();

        ListView lv = getListView();

        new GetContacts().execute();
    }


    class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();
            String strJson = sh.makeServiceCall(url, ServiceHandler.GET);


            //  String strJson="{ \"Employee\" :[{\"id\":\"101\",\"name\":\"Sonoo Jaiswal\",\"salary\":\"50000\"},{\"id\":\"102\",\"name\":\"Vimal Jaiswal\",\"salary\":\"60000\"}] }";
            //String strJson= " [{"id":1,"nom":"hhhhh","adresse":null,"description":null,"star":5,"roomNumber":null,"longitude":null,"latitude":null,"reservations"}]"
            Log.e("success get url", strJson);
            try {


                // Making a request to url and getting response

                // Create the root JSONObject from the JSON string.
                // JSONObject  jsonRootObject = new JSONObject(strJson);

                //Get the instance of JSONArray that contains JSONObjects
                // JSONArray jsonArray = jsonRootObject.optJSONArray("");
                JSONArray jsonArray = new JSONArray(strJson);
                //Iterate the jsonArray and print the info of JSONObjects
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    String id = jsonObject.getString(TAG_ID);
                    String name = jsonObject.getString(TAG_NAME);
                    String verif = jsonObject.getString(TAG_Verif);
                    String cin = jsonObject.getString(TAG_CIN);
                    String db = jsonObject.getString(TAG_DB);
                    String df = jsonObject.getString(TAG_DF);

                    //  data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";

                    // tmp hashmap for single contact
                    HashMap<String, String> contact = new HashMap<String, String>();

                    // adding each child node to HashMap key => value
                    contact.put(TAG_ID, id);
                    contact.put(TAG_NAME, name);
                    contact.put(TAG_Verif, verif);
                    contact.put(TAG_CIN, cin);
                    contact.put(TAG_DF, df);
                    contact.put(TAG_DB, db);




                    // adding contact to contact list
                    contactList.add(contact);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            ListAdapter adapter = new SimpleAdapter(ListLeave.this, contactList, R.layout.list_item, new String[]{TAG_NAME,}, new int[]{R.id.name});


            setListAdapter(adapter);

        }

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }

    @Override

    protected void onListItemClick(ListView list, View view, int position, long id) {

        super.onListItemClick(list, view, position, id);


        //  String selectedItem = (String) getListView().getItemAtPosition(position);

        //String selectedItem = (String) getListAdapter().getItem(position);


        Intent myIntent = new Intent(view.getContext(), SelectLeave.class);
        HashMap<String, String> contact = new HashMap<String, String>();
        contact = contactList.get(position);
        String name = (String) contact.get(TAG_NAME);
        String cin = (String) contact.get(TAG_CIN);
        String df = (String) contact.get(TAG_DF);
        String db = (String) contact.get(TAG_DB);
        String verif = (String) contact.get(TAG_Verif);
        Bundle b = new Bundle();
        b.putString("name", name);
        b.putString("cin", cin);
        b.putString("date debut", db);
        b.putString("date fin", df);
        b.putString("Statut", verif);




        // String value="hhhhh";
        // Bundle b = new Bundle();
        //  b.putString("name", value);
        myIntent.putExtras(b);
        startActivity(myIntent);

        //  text.setText("You clicked " + selectedItem + " at position " + position);

    }

}