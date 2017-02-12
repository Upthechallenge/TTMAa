package com.example.ramiboukadida.ttma;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by MEHDI on 09/11/2015.
 */
public class ListEventActivity extends ListActivity {
    private static String url = "http://10.0.2.2:18080/PidevService-web/rest/events/lister";
    private String data = "";
    private static final String TAG_ID = "id_event";
    private static final String TAG_NAME = "name_event";
    Button valider;
    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        valider = (Button) findViewById(R.id.valider);
        /*valider.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                Intent myIntent = new Intent(view.getContext(), HotelActivity.class);

                startActivity(myIntent);

            }

        });*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listevent);
        contactList = new ArrayList<HashMap<String, String>>();

        ListView lv = getListView();

        new A().execute();
    }






    class A extends AsyncTask<Void, Void, Void> {
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
                for(int i=0; i < jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    String id = jsonObject.getString(TAG_ID);
                    String name = jsonObject.getString(TAG_NAME);

                    //  data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";

                    // tmp hashmap for single contact
                    HashMap<String, String> contact = new HashMap<String, String>();

                    // adding each child node to HashMap key => value
                    contact.put(TAG_ID, id);
                    contact.put(TAG_NAME,"name: "+ name);


                    // adding contact to contact list
                    contactList.add(contact);
                }



            } catch (JSONException e) {e.printStackTrace();}
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            ListAdapter adapter = new SimpleAdapter(ListEventActivity.this, contactList,R.layout.list_item, new String[] { TAG_NAME, }, new int[] { R.id.name});
            setListAdapter(adapter);

        }

    }


}



