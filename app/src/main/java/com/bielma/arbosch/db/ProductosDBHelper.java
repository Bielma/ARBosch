package com.bielma.arbosch.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bielma.arbosch.Modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductosDBHelper {
    private ProductosDB productosDB;

    private SQLiteDatabase db;
    //Nombre de la base de datos
    private  static final String DB_NAME = "Productos.db";
    //Versión de la base de datos
    private  static final int VERSION = 1;
    public ProductosDBHelper(Context context){
        productosDB = new ProductosDB(context, DB_NAME, null, VERSION);
        db = productosDB.getWritableDatabase();

    }
    public void insertarProducto(Producto producto){
        ContentValues values = new ContentValues();
        //values.put("id",producto.getUniqueID());
        db.insert("PRODUCTOS", null, values);

    }
    /*
        Devuelve todos los items guardados en la base de datos
     */
    public List<Producto> getProductos(){
        List<Producto> productos = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT  * FROM PRODUCTOS ",null );
        if (cursor.moveToFirst()){
            do{
                productos.add(new Producto());
            }while (cursor.moveToNext());

        }
        if (cursor != null && !cursor.isClosed())
            cursor.close();


        return productos;
    }
}
