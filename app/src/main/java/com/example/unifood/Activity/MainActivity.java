package com.example.unifood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.unifood.Controller.UsuarioController;
import com.example.unifood.Fachada.Fachada;
import com.example.unifood.Model.Usuario;
import com.example.unifood.R;

public class MainActivity extends AppCompatActivity {

    EditText edtlogin;
    EditText edtpassword;
    Button BtnLogin;
    UsuarioController usuarioController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        edtlogin = findViewById(R.id.EtLogin);
        edtpassword = findViewById(R.id.EtPassword);
        BtnLogin = findViewById(R.id.BtnRegister);


        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String login = edtlogin.getText().toString();
                String password = edtpassword.getText().toString();

                if (!login.isEmpty()) {
                    if (!password.isEmpty()) {

                        Usuario usuario = new Usuario();
                        Fachada fachada = Fachada.getInstance();

                        usuario.setNome(edtlogin.getText().toString());
                        usuario.setSenha(edtpassword.getText().toString());


                        if(fachada.acharUsuario(usuario).equals(true)){

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

            Intent login = new Intent(getApplicationContext(), ListaVendedor.class);
            startActivity(login);
        }

}