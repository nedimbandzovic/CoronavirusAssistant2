package com.example.coronavirusassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.IOException;

public class MainActivity extends AppCompatActivity  {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        EditText username, password, NameAndSurname, JMBG, Email;
        Spinner VaccinationPlace, Vaccine;
        Button register;
        Button login;
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        NameAndSurname=findViewById(R.id.NameAndSurname);
        JMBG=findViewById(R.id.JMBG);
        Email=findViewById(R.id.Email);



        Spinner dropdown = findViewById(R.id.spinner1);

//create a list of items for the spinner.
        String[] items = new String[]{"Sputnik V", "AstraZeneca-CoviShield", "Sinopharm BBIpV", "Sinovac", "Moderna", "Johnson & Johnson", "Pfizer-BioNTech"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        Spinner seconddropdown=findViewById(R.id.spinner2);
        String [] items2=new String []{"Dom zdravlja Hadžići","Dom zdravlja Ilijaš","Dom zdravlja Ilidža","Olimpijska dvorana Juan Antonio Samaran - Zetra", "Dvorana Goran Čengić - Novo Sarajevo"};
        ArrayAdapter <String> adapter2=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        seconddropdown.setAdapter(adapter2);

        register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        long offset = Timestamp.valueOf("2021-01-01 09:00:00").getTime();
        long end = Timestamp.valueOf("2022-01-01 21:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
        String vac=rand.toString();

        register.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                User user=new User();
                user.setUsername(username.getText().toString());
                user.setPassword(password.getText().toString());
                user.setNameAndSurname(NameAndSurname.getText().toString());
                user.setJMBG(JMBG.getText().toString());
                user.setVaccine(dropdown.getItemAtPosition(dropdown.getSelectedItemPosition()).toString());
                user.setVaccinationPlace(seconddropdown.getItemAtPosition(seconddropdown.getSelectedItemPosition()).toString());
                user.setVaccinationDate(vac);
                user.setEmail(Email.getText().toString());

                if (validateInput(user)){

                    UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao=userDatabase.userDao();
                    new Thread (new Runnable(){

                        @Override
                        public void run(){
                            userDao.registerUser(user);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Uspješno ste se prijavili za vakcinaciju", Toast.LENGTH_SHORT).show();
                                    sendEmail(user);
                                }
                            });
                        }


                    }).start();


                }else{
                    Toast.makeText(getApplicationContext(), "Morate ispuniti sva polja!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,Login.class));

            }
        });








    }
    private void sendEmail(User user){
        String mEmail = user.getEmail().toString();
        String mSubject = "Potvrda za uspješnu registraciju za vakcinaciju protiv COVID-19";
        String mMessage = "Ime i prezime:" + user.getNameAndSurname().toString() + "\n Datum vakcinacije: " + user.getVaccinationDate().toString() + "\n Odabrana vakcina: " + user.getVaccine().toString() + "\n Vakcinalni punkt: " + user.getVaccinationPlace().toString()+ "\n \n EMAIL POTVRDA POTPISANA OD STRANE MZKS I CS";
        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject, mMessage);
        javaMailAPI.execute();
    }









    private Boolean validateInput (User user){




        if (user.getUsername().isEmpty()||user.getPassword().isEmpty()||user.getNameAndSurname().isEmpty()){
            return false;
        }
        return true;
    }


    }












