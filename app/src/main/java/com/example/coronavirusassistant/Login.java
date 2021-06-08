package com.example.coronavirusassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button login, lrn,lrnmr;
    Button register;
    ImageView image, image2, image3, image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        image=findViewById(R.id.zzjz);
        image2=findViewById(R.id.mzks);
        image3=findViewById(R.id.mzfbih);
        image4=findViewById(R.id.mzbih);
        lrn=findViewById(R.id.learn);
        lrnmr=findViewById(R.id.nadjilokaciju);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameText=username.getText().toString();
                String passwordText=password.getText().toString();
                if (usernameText.isEmpty()||passwordText.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ispuni sva polja!", Toast.LENGTH_SHORT).show();
                } else{

                    UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao=userDatabase.userDao();
                    new Thread(new Runnable(){

                        @Override
                        public void run(){

                            User user= userDao.login(usernameText, passwordText);
                            if (user == null){
                                runOnUiThread(new Runnable(){

                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Uneseni podaci nisu tačni, pokušajte ponovo", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else{

                                String name=user.getNameAndSurname();
                                String jmbg=user.getJMBG();
                                String vac=user.getVaccine();
                                String vacp=user.getVaccinationPlace();
                                String date=user.getVaccinationDate();

                                Intent intent=new Intent (Login.this,HomeScreen.class);
                                Bundle extras = new Bundle();
                                extras.putString("NameAndSurname", name);
                                extras.putString("jmbg", jmbg);
                                extras.putString("vac", vac);
                                extras.putString("vacp", vacp);
                                extras.putString("date", date);

                                intent.putExtras(extras);
                                startActivity(intent);




                            }


                        }
                    }).start();
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, MainActivity.class));
            }
        });

        image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, covid19ba.class));
            }
        });
        image2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, mzks.class));
            }
        });
        image3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, mzfbih.class));
            }
        });
        image4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, mcpbih.class));
            }
        });

        lrn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, vaccines.class));
            }
        });
        lrnmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, zetra.class));
                finish();
            }

        });













    }
}