package com.example.coronavirusassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    TextView tName, tJMBG, tVac, tVacp,tDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        tName = findViewById(R.id.NameAndSurname);
        tJMBG = findViewById(R.id.jmbg);
        tVac = findViewById(R.id.vac);
        tVacp = findViewById(R.id.vacp);
        tDate = findViewById(R.id.date);




        String name=getIntent().getStringExtra("NameAndSurname");
        tName.setText(name);
        String jmbg=getIntent().getStringExtra("jmbg");
        tJMBG.setText(jmbg);
        String vac=getIntent().getStringExtra("vac");
        tVac.setText(vac);
        String vacp=getIntent().getStringExtra("vacp");
        tVacp.setText(vacp);
        String date=getIntent().getStringExtra("date");
        tDate.setText(date);
    }
}