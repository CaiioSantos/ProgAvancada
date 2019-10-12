package com.example.unifood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.Manifest.permission.CALL_PHONE;

public class DescricaoVendedor extends AppCompatActivity {
    private Button botaoLigar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_vendedor);

        botaoLigar = findViewById(R.id.BtnLigar);
        botaoLigar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FazerChamada();
            }
        });

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
