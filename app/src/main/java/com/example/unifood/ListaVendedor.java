package com.example.unifood;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

    }

    class customAdaptor extends BaseAdapter{


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
