package com.example.unifood.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unifood.R;

import static android.Manifest.permission.CALL_PHONE;

public class DescricaoVendedor extends AppCompatActivity {
    private Button botaoLigar;
    private ImageView descricao;
    private TextView tituloDetalhe;
    private TextView PrecoDetalhe;
    private TextView EstadoDetalhe;
    private TextView DescricaoDetalhe;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_vendedor);
        Intent intent = getIntent();


        botaoLigar = findViewById(R.id.BtnLigar);
        botaoLigar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FazerChamada();
            }
        });

        inicializarComponentes();

        String nomeDaLoja = intent.getStringExtra("nomeLoja");
        tituloDetalhe.setText(nomeDaLoja);

        int imagemDaLoja = intent.getIntExtra("imagemLoja",0);
        descricao.setImageResource(imagemDaLoja);


    }





    private void inicializarComponentes() {
        descricao = findViewById(R.id.imageDescricao);
        tituloDetalhe = findViewById(R.id.textTituloDetalhe);
        PrecoDetalhe = findViewById(R.id.textPrecoDetalhe);
        EstadoDetalhe = findViewById(R.id.textEstadoDetalhe);
        DescricaoDetalhe = findViewById(R.id.textDescricaoDetalhe);

    }

    protected void FazerChamada() {
        Intent Intent = new Intent(android.content.Intent.ACTION_CALL);
        Intent.setData(Uri.parse("tel:123456789"));

        if (ActivityCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(DescricaoVendedor.this, new String[] {CALL_PHONE},1);

            return;
        }
        startActivity(Intent);


    }
}
