package com.example.unifood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {

    EditText edtNome = findViewById(R.layout.activity_cadastro);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Cadastrar();

    }

    Cadastrar(){

    }
}
