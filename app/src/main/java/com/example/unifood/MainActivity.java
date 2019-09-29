package com.example.unifood;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtnome;
    EditText editpassword;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnome = findViewById(R.layout.activity_main);



    }

    public void btnLongin(View view) {
        Intent login =  new Intent(getApplicationContext(),Cadastro.class);
        startActivity(login);
    }
}
