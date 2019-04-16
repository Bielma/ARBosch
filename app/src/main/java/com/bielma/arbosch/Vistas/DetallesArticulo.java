package com.bielma.arbosch.Vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bielma.arbosch.R;

public class DetallesArticulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_articulo);
    }

    public void showAR(View view){
        Intent ar = new Intent(this, SceneFormActivity.class);
        startActivity(ar);
    }
}
