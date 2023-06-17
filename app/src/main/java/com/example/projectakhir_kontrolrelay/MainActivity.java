package com.example.projectakhir_kontrolrelay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button tombolLogin;
    EditText idBar;
    EditText pwBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idBar = (EditText) findViewById(R.id.idBar);
        pwBar = (EditText) findViewById(R.id.pwBar);

        tombolLogin = (Button) findViewById(R.id.tombolLogin);
        tombolLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                klikMasuk();
            }
        });
    }
    public void klikMasuk() {
        String user , pw ;
        user = idBar.getText().toString();
        pw = pwBar.getText().toString();

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String newuser= "admin";
        String newpass0= "admin";

        if (user.equals(newuser) && pw.equals(newpass0)){

            Intent halamanKontrol=new Intent(this, halKontrol.class);
            startActivity(halamanKontrol);
            Toast.makeText(this.getBaseContext(), "Berhasil masuk",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this.getBaseContext(), "Maaf, User atau Password yang kamu masukan salah.",Toast.LENGTH_LONG).show();
        }
    }
}