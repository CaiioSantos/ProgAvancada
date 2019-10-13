package com.example.unifood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.unifood.R;

public class HistoricoPedido extends AppCompatActivity {

    public ListView vListaPedido;

    int [] images = {R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4};

    String [] names = {"Salgados do Caio",
            "Salgados SW",
            "Doces do Mourcout",
            "Doces do Mourcout"};


    String [] numeropedido = {"#2834",
            "#2834",
            "#2834",
            "#2834"};

    String [] data = {"10/12/2020",
            "10/08/2020",
            "13/11/2019",
            "02/05/2018"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_pedido);
        setTitle("Histórico de Pedido");
        vListaPedido = findViewById(R.id.historico_list_view);

        customAdaptor1 customAdapter = new customAdaptor1();
        vListaPedido.setAdapter(customAdapter);

        vListaPedido.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent Detalhe = new Intent(getApplicationContext(), DetalhePedido.class);
                Detalhe.putExtra("nomeLoja",names[position]);
                Detalhe.putExtra("numeropedido",numeropedido[position]);
                Detalhe.putExtra("data",data[position]);
                startActivity(Detalhe);

            }
        });
    }

    class customAdaptor1 extends BaseAdapter {


        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.custom_historico_pedido, null);

            ImageView vImageView = view.findViewById(R.id.imageView);
            TextView vTextView = view.findViewById(R.id.textView);
            TextView vNumeroPedido= view.findViewById(R.id.txNumeroPedido1);
            TextView vDataPedido = view.findViewById(R.id.txDataPedido1);


            vImageView.setImageResource(images[position]);
            vTextView.setText(names[position]);
            vNumeroPedido.setText(numeropedido[position]);
            vDataPedido.setText(data[position]);
            return view;
        }
    }
}

