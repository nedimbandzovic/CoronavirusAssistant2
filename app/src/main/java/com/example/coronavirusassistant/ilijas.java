package com.example.coronavirusassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ilijas extends AppCompatActivity {

    ImageView img22, img23, img8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilijas);

        img22 = findViewById(R.id.nazad3);
        img23 = findViewById(R.id.naprijed3);
        Button b1;
        b1=findViewById(R.id.ilijasCall);
        Button b2;
        b2=findViewById(R.id.ilijasMap);
        img8=findViewById(R.id.ugasime3);


        img22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ilijas.this, novosarajevo.class));
                finish();
            }

        });
        img23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ilijas.this, ilidza.class));
                finish();
            }

        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+387616202020"));
                startActivity(intent);
                finish();
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ilijas.this, ilijaslocation.class));
            }

        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ilijas.this, Login.class));
            }

        });
    }
    public void onBackPressed(){
        return;
    }
}