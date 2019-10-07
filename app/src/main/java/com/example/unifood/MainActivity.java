package com.example.unifood;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.unifood.Controller.UsuarioController;
import com.example.unifood.Model.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtlogin;
    EditText edtpassword;
    private ArrayList<Usuario> usuarioArrayList;
    UsuarioController usuarioController;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        edtlogin = findViewById(R.id.EtLogin);
        edtpassword = findViewById(R.id.EtPassword);


    }


    public void tRegister(View view) {
        Intent t = new Intent(getApplicationContext(), Cadastro.class);
        startActivity(t);
    }

    public void BtnLogin(View view) {

            Intent login = new Intent(getApplicationContext(), ListaVendedor.class);
            startActivity(login);
        }

}