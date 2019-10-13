package com.example.unifood.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
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



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        edtlogin = findViewById(R.id.EtLogin);
        edtpassword = findViewById(R.id.EtPassword);
        BtnLogin = findViewById(R.id.BtnRegister);


        if (AcessInternet()){
            BtnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    String login = edtlogin.getText().toString();
                    String password = edtpassword.getText().toString();

                    if (!login.isEmpty()) {
                        if (!password.isEmpty()) {

                            Usuario usuario = new Usuario();
                            Fachada fachada = Fachada.getInstance();
                            Intent Login;

                            usuario.setNome(edtlogin.getText().toString());
                            usuario.setSenha(edtpassword.getText().toString());


                            if(fachada.acharUsuario(usuario).equals(true)){

                                Toast.makeText(MainActivity.this, "Logado com sucesso",
                                        Toast.LENGTH_SHORT).show();
                                 Login = new Intent(getApplicationContext(), ListaVendedor.class);
                                startActivity(Login);
                                Login = null;

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


        }else if(!AcessInternet()){

            Toast.makeText(getApplicationContext(),"SEM INTERNET, CONNECTE E TENTE NOVAMENTE",Toast.LENGTH_SHORT).show();
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private boolean AcessInternet(){

        boolean acess_WIFI = false;
        boolean acess_MobileData = false;

        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo[] networks = connectivityManager.getAllNetworkInfo();

        for (NetworkInfo info:networks){
            if (info.getTypeName().equalsIgnoreCase("WIFI"))
                if (info.isConnected())
                acess_WIFI = true;
            if (info.getTypeName().equalsIgnoreCase("MOBILE"))
                if (info.isConnected())
                    acess_MobileData = true;
        }
        return acess_MobileData|| acess_WIFI;
    }


    public void tRegister(View view) {
        Intent t = new Intent(getApplicationContext(), Cadastro.class);
        startActivity(t);
    }

}