package com.bielma.arbosch.Vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bielma.arbosch.Modelos.Producto;
import com.bielma.arbosch.R;
import com.bielma.arbosch.WebService.ApiService;
import com.bielma.arbosch.WebService.WebService;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       irAProductos();
        WebService webService = new WebService();
        webService.getTokens();
       // Log.d("String", aber);
    }

    public void irAProductos(){
        Intent i = new Intent(this, Productos.class);
        startActivity(i);
    }
}
