package com.example.unifood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unifood.Controller.UsuarioController;
import com.example.unifood.Model.Usuario;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Cadastro extends AppCompatActivity  {

    EditText edtNome;
    EditText edtEmail;
    EditText edtSenha;
    TextView TvBack;
    Button  BtnRegister;
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
        BtnRegister = findViewById(R.id.BtnRegister);
        TvBack = findViewById(R.id.TvBack);

        usuarioController = new UsuarioController();

        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Usuario usuario = new Usuario();
                usuario.setNome(edtNome.getText().toString());
                usuario.setEmail(edtEmail.getText().toString());
                usuario.setSenha(edtSenha.getText().toString());


                try {
                    if(!usuario.getNome().isEmpty()&& !usuario.getEmail().isEmpty()&& !usuario.getEmail().isEmpty()) {

                        if(usuarioController.acharUsuario(usuario).equals(false)){
                            usuarioController.adicionarUsuario(usuario);
                            Toast.makeText(getApplicationContext(), "Usuario cadastrado",
                                    Toast.LENGTH_SHORT).show();

                            Log.i("CU", "FUNCIOUNOUUASOUD CARAI");
                        }else{

                            Toast.makeText(getApplicationContext(), "Usuario já está cadastrado",
                                    Toast.LENGTH_SHORT).show();
                        }



                    }else{
                        Toast.makeText(getApplicationContext(), "Preencha o krai",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }




            }
        });

        TvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Back);
            }
        });

    }


}
