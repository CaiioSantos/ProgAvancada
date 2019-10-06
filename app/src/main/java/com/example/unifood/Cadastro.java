package com.example.unifood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.unifood.Controller.UsuarioController;
import com.example.unifood.Model.Usuario;

import java.util.ArrayList;

public class Cadastro extends AppCompatActivity {

    EditText edtNome;
    EditText edtEmail;
    EditText edtSenha;
    private ArrayList<Usuario> usuarioArrayList;
    UsuarioController usuarioController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();

        edtNome = findViewById(R.id.EtUsername);
        edtEmail = findViewById(R.id.EtEmail);
        edtSenha = findViewById(R.id.EtPassword);

    }

    public void tRegister(View view) {
        Usuario usuario = new Usuario();
        usuario.setNome(edtNome.getText().toString());
        usuario.setEmail(edtEmail.getText().toString());
        usuario.setSenha(edtSenha.getText().toString());

        usuarioController.adicionarUsuario(usuario);

    }
}
