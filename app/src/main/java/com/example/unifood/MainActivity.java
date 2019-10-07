package com.example.unifood;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import com.example.unifood.Controller.UsuarioController;
import com.example.unifood.Model.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtlogin;
    EditText edtpassword;
    Button BtnLogin;
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
        BtnLogin = findViewById(R.id.BtnRegister);
        usuarioController = new UsuarioController();


        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String login = edtlogin.getText().toString();
                String password = edtpassword.getText().toString();

                if (!login.isEmpty()) {
                    if (!password.isEmpty()) {

                        Usuario usuario = new Usuario();
                        usuario.setNome(edtlogin.getText().toString());
                        usuario.setSenha(edtpassword.getText().toString());


                        if(usuarioController.acharUsuario(usuario).equals(true)){

                            Toast.makeText(MainActivity.this, "Logado com sucesso",
                                    Toast.LENGTH_SHORT).show();
                            Intent Login = new Intent(getApplicationContext(), ListaVendedor.class);
                            startActivity(Login);

                        }else{
                            Toast.makeText(MainActivity.this, "Usuario não encontrado",
                                    Toast.LENGTH_SHORT).show();
                        }


                    }else{
                        Toast.makeText(MainActivity.this, "Preencha o Password",
                            Toast.LENGTH_SHORT).show();

                    }

                }else{
                    Toast.makeText(MainActivity.this, "Preencha o Login",
                            Toast.LENGTH_SHORT).show();

                }


            }
        });

    }


    public void tRegister(View view) {
        Intent t = new Intent(getApplicationContext(), Cadastro.class);
        startActivity(t);
    }

    public void BtnLogin(View view) {
        if (usuarioController.loginUsuario(usuario)) {
            Intent login = new Intent(getApplicationContext(), ListaVendedor.class);
            startActivity(login);
        }
    }
}