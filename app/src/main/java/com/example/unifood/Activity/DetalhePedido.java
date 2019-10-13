package com.example.unifood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.unifood.R;

public class DetalhePedido extends AppCompatActivity {

    private TextView vNomeLoja;
    private TextView vDataPedido;
    private TextView vNumeroPedido;
    private TextView vValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pedido);
        setTitle("Detalhe do Pedido");
        Intent intent = getIntent();
        inicializarComponentes();

        String nomeDaLoja = intent.getStringExtra("nomeLoja");
        vNomeLoja.setText(nomeDaLoja);

        String numeroPedido = intent.getStringExtra("numeropedido");
        vNumeroPedido.setText(numeroPedido);

        String dataPedido = intent.getStringExtra("data");
        vDataPedido.setText(dataPedido);



    }

    private void inicializarComponentes() {
        vNomeLoja = findViewById(R.id.txNome);
        vDataPedido = findViewById(R.id.txData);
        vNumeroPedido = findViewById(R.id.txNumero);
        vValor = findViewById(R.id.txValor);


    }

}
