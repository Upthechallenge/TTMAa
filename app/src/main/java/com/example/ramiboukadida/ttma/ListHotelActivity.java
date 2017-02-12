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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by MEHDI on 09/11/2015.
 */
public class ListHotelActivity extends ListActivity {
    private static String url = "http://10.0.2.2:18080/PidevService-web/rest/hotels/list";
    private String data = "";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "nom";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_STAR = "star";
    private static final String TAG_LONG = "longitude";
    private static final String TAG_LAT = "latitude";
    Button valider;
    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;
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
        setContentView(R.layout.activity_listhotel);
        contactList = new ArrayList<HashMap<String, String>>();

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
                for(int i=0; i < jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    String id = jsonObject.getString(TAG_ID);
                    String name = jsonObject.getString(TAG_NAME);
                    String description = jsonObject.getString(TAG_DESCRIPTION);
                    String star = jsonObject.getString(TAG_STAR);
                    String longitude = jsonObject.getString(TAG_LONG);
                    String latitude = jsonObject.getString(TAG_LAT);

                    //  data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";

                    // tmp hashmap for single contact
                    HashMap<String, String> contact = new HashMap<String, String>();

                    // adding each child node to HashMap key => value
                    contact.put(TAG_ID, id);
                    contact.put(TAG_NAME,"name: "+ name);
                    contact.put(TAG_DESCRIPTION,description);
                    contact.put(TAG_STAR,star);
                    contact.put(TAG_LONG,longitude);
                    contact.put(TAG_LAT,latitude);



                    // adding contact to contact list
                    contactList.add(contact);
                }



            } catch (JSONException e) {e.printStackTrace();}
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            ListAdapter adapter = new SimpleAdapter(ListHotelActivity.this, contactList,R.layout.list_item, new String[] { TAG_NAME, }, new int[] { R.id.name});



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


        Intent myIntent = new Intent(view.getContext(), SelectHotelActivity.class);
        HashMap<String, String> contact = new HashMap<String, String>();
        contact=contactList.get(position);
        String name = (String) contact.get(TAG_NAME);
        String star = (String) contact.get(TAG_STAR);
        String description = (String) contact.get(TAG_DESCRIPTION);
        String longitude = (String) contact.get(TAG_LONG);
        String latitude = (String) contact.get(TAG_LAT);
        Bundle b = new Bundle();
        b.putString("name", name);
        b.putString("star", star);
        b.putString("description", description);
        b.putString("longitude", longitude);
        b.putString("latitude", latitude);
       // Log.e("lat1",latitude );
       // Log.e("long1",longitude);
        // String value="hhhhh";
       // Bundle b = new Bundle();
       //  b.putString("name", value);
        myIntent.putExtras(b);
        startActivity(myIntent);

      //  text.setText("You clicked " + selectedItem + " at position " + position);

    }



}

