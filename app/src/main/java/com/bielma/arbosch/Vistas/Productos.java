package com.bielma.arbosch.Vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bielma.arbosch.Modelos.Producto;
import com.bielma.arbosch.R;
import com.bielma.arbosch.db.ProductosDBHelper;

import java.util.List;

/**
 * Vista con una lista de productos, sacados de la base de datos.
 * Primero se obtienen los productos, despues se instancia un adaptador
 * pasandole una lista de productos.
 */

public class Productos extends AppCompatActivity implements ArticulosAdapter.ItemClickListener{
    private List<Producto> productos;      //Lista de Producto
    private ArticulosAdapter adapter;           //Adaptador para el recyclerview
    private RecyclerView lista_productos;       //Recycler view que mostrará todos los items
    private ProductosDBHelper helper;           //Instancia de ProductosDBHelper para acceder a la
                                                //base de datos.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        lista_productos = (RecyclerView)findViewById(R.id.lista_articulos);
        lista_productos.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false ));
        helper = new ProductosDBHelper(this);
        productos = helper.getProductos();
       // productos = new ArrayList<>();
        //productos.add(new Producto());
        adapter = new ArticulosAdapter(productos);
        adapter.setClickClickListener(this);
        lista_productos.setAdapter(adapter);

    }

    /**
     * Se llama cuando se hace click sobre un item del recyclerView
     * @param view
     * @param Position
     */
    @Override
    public void onItemClick(View view, int Position) {
        mostrarDetalles(Position);
    }

    /**
     * Abre un activity donde se muestran los datos del producto.
     * @param p
     */
    public void mostrarDetalles(int p){
        Intent detalles = new Intent(this, DetallesArticulo.class);
        detalles.putExtra("id", productos.get(p).getUniqueID());
        startActivity(detalles);
    }
}
