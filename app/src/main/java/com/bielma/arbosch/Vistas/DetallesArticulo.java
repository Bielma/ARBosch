package com.bielma.arbosch.Vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bielma.arbosch.Modelos.Producto;
import com.bielma.arbosch.R;
import com.bielma.arbosch.db.ProductosDBHelper;

public class DetallesArticulo extends AppCompatActivity {

    private TextView nombre;
    private TextView precio;
    private TextView descripcion;
    private ImageView imagen;
    private String id;
    private ProductosDBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_articulo);
        initViews();
        getId();
        setData();
    }

    /**
     * Coloca los datos en los textViews
     */
    private void setData() {
        Producto producto;
        producto = helper.getProducto(id);
        nombre.setText(producto.getName());
        precio.setText("$"+producto.getPriceINMXN());
        descripcion.setText(producto.getLongDescription());
        imagen.setImageResource(Integer.valueOf(producto.getFullImage()));
        //imagen.setImageURI();

    }
    /**
     * Obtiene el id pasado por la actividad Productos.
     */
    private void getId() {
        Intent extras = getIntent();
        id = extras.getStringExtra("id");
    }

    /**
     * Este metodo castea los textViews en xml con el codigo en java.
     */
    private void initViews() {
        nombre = (TextView)findViewById(R.id.lbl_nombre);
        descripcion = (TextView)findViewById(R.id.lbl_description);
        precio = (TextView)findViewById(R.id.lbl_precio);
        imagen = (ImageView)findViewById(R.id.imagen);
        helper = new ProductosDBHelper(this);
    }

    /**
     *Abre SceneFormActivity el cual muestra el producto en Realidad Aumentada.
     * @param view
     */
    public void showAR(View view){
        Intent ar = new Intent(this, SceneFormActivity.class);
        startActivity(ar);
    }
    public void showToast(View view){
        Toast.makeText(this, "En desarollo...", Toast.LENGTH_LONG).show();
    }
}
