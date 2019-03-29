package com.bielma.arbosch.Vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bielma.arbosch.ArticulosAdapter;
import com.bielma.arbosch.Modelos.Producto;
import com.bielma.arbosch.R;

import java.util.ArrayList;

public class Productos extends AppCompatActivity implements ArticulosAdapter.ItemClickListener{
    ArrayList<Producto> productos;      //Lista
    ArticulosAdapter adapter;           //Adaptador para el recyclerview
    RecyclerView lista_productos;       //Recycler view que mostrara cada item
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        lista_productos = (RecyclerView)findViewById(R.id.lista_articulos);
        lista_productos.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false ));
        productos = new ArrayList<>();
        productos.add(new Producto());
        adapter = new ArticulosAdapter(productos);

        adapter.setClickClickListener(this);
        lista_productos.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int Position) {
        mostrarDetalles();
    }
    public void mostrarDetalles(){
        Intent detalles = new Intent(this, DetallesArticulo.class);
        startActivity(detalles);
    }
}
