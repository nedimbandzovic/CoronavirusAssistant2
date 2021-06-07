package com.example.coronavirusassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class vaccines extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccines);

        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);

//create a list of items for the spinner.
        String[] items = new String[]{"Odaberite vakcinu", "Sputnik V", "AstraZeneca-CoviShield", "Sinopharm BBIpV", "Sinovac", "Moderna", "Johnson & Johnson", "Pfizer-BioNTech"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);


        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int position, long row_id)
            {
                final Intent intent;
                switch(position)
                {


                    case 1:
                        intent = new Intent(vaccines.this, SputnikV.class);
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(vaccines.this, astrazeneca.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(vaccines.this, sinopharm.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(vaccines.this, sinovac.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(vaccines.this, moderna.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(vaccines.this, jj.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(vaccines.this, pfizer.class);
                        startActivity(intent);
                        break;

// and so on // .....

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });


    }
        }


