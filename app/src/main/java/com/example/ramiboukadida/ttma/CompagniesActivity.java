package com.example.ramiboukadida.ttma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Rami Boukadida on 10/11/2015.
 */
public class CompagniesActivity extends Activity {

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compagnies);

        mDrawerList = (ListView) findViewById(R.id.listCompagnies);



        addDrawerItems();
    }

    private void addDrawerItems(){
        String[] osArray = { "Evénements", "Gérer Profil", "Hôtels", "Cliniques / Centres médicaux", "Consulter Spécialiste", "Articles", "Compagnies", "À Propos","Déconnexion", "Evénements", "Gérer Profil", "Hôtels", "Cliniques / Centres médicaux", "Consulter Spécialiste", "Articles", "Compagnies", "À Propos","Déconnexion" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);


        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(EventsActivity.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0: {
                        Intent intent = new Intent(CompagniesActivity.this, EventsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent = new Intent(CompagniesActivity.this, ProfilActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 2: {
                        Intent intent = new Intent(CompagniesActivity.this, HotelActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 3: {
                        Intent intent = new Intent(CompagniesActivity.this, CliniqueActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 4: {
                        Intent intent = new Intent(CompagniesActivity.this, ConsulterSpecialisteActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 5: {
                        Intent intent = new Intent(CompagniesActivity.this, ArticlesActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 6: {
                        Intent intent = new Intent(CompagniesActivity.this, CompagniesActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 7: {
                        Intent intent = new Intent(CompagniesActivity.this, AproposActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 8: {
                        Intent intent = new Intent(CompagniesActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    }
                    default:
                        break;

                }
            }
        });
    }
}
