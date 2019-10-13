package com.example.unifood.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unifood.Activity.DescricaoVendedor;
import com.example.unifood.R;

public class ListaVendedor extends AppCompatActivity {

    ListView vListView;

    int [] images = {R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4};

    String [] names = {"Salgados do Caio",
            "Salgados SW",
            "Doces do Mourcout",
            "Doces do Mourcout"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vendedor);
        setTitle("Lista de Vendedores");
        vListView = findViewById(R.id.vendedores_list_view);

        customAdaptor customAdapter = new customAdaptor();
        vListView.setAdapter(customAdapter);

        vListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent Descricao = new Intent(getApplicationContext(), DescricaoVendedor.class);
                Descricao.putExtra("nomeLoja",names[position]);
                Descricao.putExtra("imagemLoja",images[position]);
              startActivity(Descricao);


            }
        });
    }



    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            Intent Historico = new Intent(getApplicationContext(), HistoricoPedido.class);
            startActivity(Historico);
        }
        return super.onOptionsItemSelected(item);
    }


    class customAdaptor extends BaseAdapter {


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

            View view = getLayoutInflater().inflate(R.layout.customlayout, null);

            ImageView vImageView = view.findViewById(R.id.imageView);
            TextView vTextView = view.findViewById(R.id.textView);

            vImageView.setImageResource(images[position]);
            vTextView.setText(names[position]);
            return view;
        }
    }
}
