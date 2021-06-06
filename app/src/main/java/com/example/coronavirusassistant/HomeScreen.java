package com.example.coronavirusassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Random;

public class HomeScreen extends AppCompatActivity {

    TextView tName, tJMBG, tVac, tVacp,tDate;
    Button button, button2;
    Bitmap bmp,bmp2;
    Bitmap scaledbmp,scaledbmp2;
    int pageWidth=1200;
    int rand_int=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        tName = findViewById(R.id.NameAndSurname);
        tJMBG = findViewById(R.id.jmbg);
        tVac = findViewById(R.id.vac);
        tVacp = findViewById(R.id.vacp);
        tDate = findViewById(R.id.date);
        bmp=BitmapFactory.decodeResource(getResources(), R.drawable.grbovi);
        scaledbmp=Bitmap.createScaledBitmap(bmp, 400, 200, false);
        Random rand = new Random();
        bmp2=BitmapFactory.decodeResource(getResources(), R.drawable.qrcode);
        scaledbmp2=Bitmap.createScaledBitmap(bmp2, 400, 400, false);
        button2=findViewById(R.id.logout);


        rand_int = rand.nextInt(10000000);






        String name = getIntent().getStringExtra("NameAndSurname");
        tName.setText(name);
        String jmbg = getIntent().getStringExtra("jmbg");
        tJMBG.setText(jmbg);
        String vac = getIntent().getStringExtra("vac");
        tVac.setText(vac);
        String vacp = getIntent().getStringExtra("vacp");
        tVacp.setText(vacp);
        String date = getIntent().getStringExtra("date");
        tDate.setText(date);

        button = findViewById(R.id.generatePDF);







            button.setOnClickListener(new View.OnClickListener(){


                public void askForPermission(){
                    ActivityCompat.requestPermissions(HomeScreen.this, new String[]{


                            Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
                }
                @Override
                public void onClick(View view){
                    askForPermission();
                    PdfDocument myPdfDocument = new PdfDocument();
                    Paint myPaint=new Paint();
                    Paint titlePaint=new Paint();


                    PdfDocument.PageInfo myPageInfo1=new PdfDocument.PageInfo.Builder(1200, 2010, 1).create();
                    PdfDocument.Page myPage1=myPdfDocument.startPage(myPageInfo1);

                    Canvas canvas=myPage1.getCanvas();
                    canvas.drawBitmap(scaledbmp, 40, 50, myPaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(32);
                    canvas.drawText("BOSNA I HERCEGOVINA", 800, 100, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(32);
                    canvas.drawText("FEDERACIJA BOSNE I HERCEGOVINE", 800, 150, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(32);
                    canvas.drawText("KANTON SARAJEVO", 800, 200, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(32);
                    canvas.drawText("POTVRDA O REGISTROVANOJ VAKCINACIJI", 600, 350, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(32);
                    canvas.drawText("CONFIRMATION ABOUT SCHEDULED VACCINATION", 600, 400, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(25);
                    canvas.drawText("Ime i prezime / Name and surname", 600, 500, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                    titlePaint.setTextSize(25);
                    canvas.drawText(tName.getText().toString(), 600, 550, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(25);
                    canvas.drawText("JMBG / Unique Master Citizen Number", 600, 600, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                    titlePaint.setTextSize(25);
                    canvas.drawText(tJMBG.getText().toString(), 600, 650, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(25);
                    canvas.drawText("Vakcina / Selected vaccine", 600, 700, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                    titlePaint.setTextSize(25);
                    canvas.drawText(tVac.getText().toString(), 600, 750, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(25);
                    canvas.drawText("Odabrana ustanova za vakcinaciju / Vaccination place", 600, 800, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                    titlePaint.setTextSize(25);
                    canvas.drawText(tVacp.getText().toString(), 600, 850, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(25);
                    canvas.drawText("Datum vakcinacije / Vaccination date", 600, 900, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                    titlePaint.setTextSize(25);
                    canvas.drawText(tDate.getText().toString(), 600, 950, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(25);

                    canvas.drawBitmap(scaledbmp2, 400, 1000, myPaint);

                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                    titlePaint.setTextSize(21);
                    canvas.drawText("QR kod možete iskoristiti na punktu za vakcinaciju kao sredstvo identifikacije", 600, 1450, titlePaint);
                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                    titlePaint.setTextSize(21);
                    canvas.drawText("You can use the QR code to identify yourself on chosen vaccination place", 600, 1650, titlePaint);


                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(25);
                    canvas.drawText("ID potvrde / Certificate ID:" + rand_int, 600, 1850, titlePaint);


                    titlePaint.setTextAlign(Paint.Align.CENTER);
                    titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                    titlePaint.setTextSize(12);
                    canvas.drawText("© 2021 Nedim Bandžović & Ademir Ahmetović",600, 1900, titlePaint);




















                    myPdfDocument.finishPage(myPage1);

                    File file=new File (Environment.getExternalStorageDirectory(),"/COVID-19Potvrda.pdf");
                    Toast.makeText(getApplicationContext(), "Potvrda napravljena, istu možete naći u internoj memoriji uređaja", Toast.LENGTH_SHORT).show();

                    try {
                        myPdfDocument.writeTo(new FileOutputStream(file));


                    }catch (IOException e){
                        e.printStackTrace();
                    }

                    myPdfDocument.close();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, Login.class));
            }
        });



    }

    }
