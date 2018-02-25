package com.example.android.RantiDwitaPutri_1202154298_Modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username); //membuat referensi EditText dari layout activity_login.xml
        password = (EditText) findViewById(R.id.password); //membuat referensi EditText dari layout activity_login.xml
        login = (Button) findViewById(R.id.login); //membuat referensi button dari layout activity_login.xml
    }
    public void login(View view) { //method onClick untuk membuat action jika button di klik
        if (username.getText().toString().equals("EAD")&& password.getText().toString().equals("MOBILE") ) {
            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show(); //jika password dan username sesuai maka muncul toast
            Intent intentlogin = new Intent(this, MainActivity.class); // agar pindah ke halaman mainactivity
            startActivity(intentlogin);
        } else {
            Toast.makeText(this,"Login Gagal", Toast.LENGTH_SHORT).show(); //jika gagal login akan muncul toast
        }
    }
}

