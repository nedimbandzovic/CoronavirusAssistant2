package com.example.coronavirusassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class novosarajevo extends AppCompatActivity {

    ImageView img22, img23;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novosarajevo);

        img22 = findViewById(R.id.nazad2);
        img23 = findViewById(R.id.naprijed2);
        b1=findViewById(R.id.novoSarajevoCall);
        b2=findViewById(R.id.novoSarajevoMap);


        img22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(novosarajevo.this, zetra.class));
                finish();
            }

        });
        img23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(novosarajevo.this, ilijas.class));
                finish();
            }

        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+38760101010101"));
                startActivity(intent);
                finish();
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(novosarajevo.this, novosarajevolocation.class));
            }

        });
    }
    public void onBackPressed(){
        return;
    }
}