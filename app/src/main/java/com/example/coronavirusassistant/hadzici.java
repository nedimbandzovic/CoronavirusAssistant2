package com.example.coronavirusassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class hadzici extends AppCompatActivity {

    ImageView img22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadzici);

        img22 = findViewById(R.id.nazad5);
        Button b1;
        Button b2;
        b1=findViewById(R.id.hadziciCall);
        b2=findViewById(R.id.hadziciMap);


        img22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(hadzici.this, ilidza.class));
                finish();
            }

        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+387911919911"));
                startActivity(intent);
                finish();
            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(hadzici.this, hadzicilocation.class));
            }

        });

    }
    public void onBackPressed(){
        return;
    }
}