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

public class MainActivity extends AppCompatActivity implements ApiService {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        irAProductos();

    }

    public void irAProductos(){
        Intent i = new Intent(this, Productos.class);
        startActivity(i);
    }

    public void bajarInformacion(){
        getTokens("ZV^M4Y*Wb#%j9tpgZ%Rlvy2TjiyZ","%kpjbI4c3@jTu!U3QB$dKWKa5w9$1zd%R7lg@CvKTLaV%vV1Vi");
    }


    @Override
    public Call<WebService> getTokens(String username, String password) {

        Log.d("token", "Recibi algo :v ");
        return null;
    }
}
