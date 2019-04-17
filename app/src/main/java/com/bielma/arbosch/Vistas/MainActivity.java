package com.bielma.arbosch.Vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bielma.arbosch.Modelos.Producto;
import com.bielma.arbosch.R;
import com.bielma.arbosch.WebService.ApiService;
import com.bielma.arbosch.WebService.WebService;
import com.bielma.arbosch.db.ProductosDBHelper;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCenter.start(getApplication(), "6886331a-0f40-4ae2-95c0-414c78da27ec", Analytics.class, Crashes.class);
        insertarRegistro();
        irAProductos();


    }

    /**
     * Inserta el registro del item "F0132050AA"
     */
    private void insertarRegistro(){
        ProductosDBHelper helper = new ProductosDBHelper(this);
        Producto dremel = new Producto();
        dremel.setUniqueID("F0132050AA");
        dremel.setPriceINMXN("980");
        dremel.setLongDescription("    Esta es la herramienta más pequeña de la familia Dremel, ligera, silenciosa, cómoda y fácil de usar\n" +
                "    Multifuncional (lijar, pulir, limpiar, esmerilar, afilar, fresar, tallar, grabar)\n" +
                "    Control de velocidad variable para brindar mayor versatilidad\n" +
                "    Con botón de bloqueo para intercambiar accesorios");
        dremel.setShortDescription("Kit herramienta con 15 accesorios");
        dremel.setFullImage(String.valueOf(R.drawable.f0132050aa));
        dremel.setThumbnail(String.valueOf(R.drawable.f0132050aa));
        dremel.setName("Dremel Stylo +");
        helper.insertarProducto(dremel);

    }
    /**
     * Abre el activity con la lista de productos.
     */
    public void irAProductos(){
        Intent i = new Intent(this, Productos.class);
        startActivity(i);
    }
}
