package com.bielma.arbosch.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bielma.arbosch.Modelos.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Con esta clase se hacen las operaciones sobre la base de datos.
 */
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

    /**
     * Inserta un Producto en la base de datos.
     * @param producto
     */
    public void insertarProducto(Producto producto){
        ContentValues values = new ContentValues();
        values.put("id",producto.getUniqueID());
        values.put("full_image",producto.getFullImage());
        values.put("thumbnail",producto.getThumbnail());
        values.put("short_Descripcion",producto.getShortDescription());
        values.put("precio",producto.getPriceINMXN());
        values.put("nombre",producto.getName());
        values.put("long_description", producto.getLongDescription());
        db.insert("PRODUCTOS", null, values);

    }
    /*
        Devuelve todos los items guardados en la base de datos
     */
    public List<Producto> getProductos(){
        List<Producto> productos = new ArrayList<>();
        Producto producto = new Producto();
        Cursor cursor = db.rawQuery("SELECT  * FROM PRODUCTOS ",null );
        if (cursor.moveToFirst()){
            do{
                producto.setUniqueID(cursor.getString(0));
                producto.setFullImage(cursor.getString(1));
                producto.setThumbnail(cursor.getString(2));
                producto.setShortDescription(cursor.getString(3));
                producto.setPriceINMXN(cursor.getString(4));
                producto.setName(cursor.getString(5));
                producto.setLongDescription(cursor.getString(6));
                productos.add(producto);
            }while (cursor.moveToNext());

        }
        if (cursor != null && !cursor.isClosed())
            cursor.close();


        return productos;
    }

    /**
     * Busca un registro con un id dado.
     * @param id
     * @return Producto
     */
    public Producto getProducto(String id) {
        Producto producto = new Producto();
        Cursor cursor = db.rawQuery("SELECT * FROM PRODUCTOS WHERE id ='"+id+"'",null );
        if (cursor.moveToFirst()){
            do{
                producto.setUniqueID(cursor.getString(0));
                producto.setFullImage(cursor.getString(1));
                producto.setThumbnail(cursor.getString(2));
                producto.setShortDescription(cursor.getString(3));
                producto.setPriceINMXN(cursor.getString(4));
                producto.setName(cursor.getString(5));
                producto.setLongDescription(cursor.getString(6));
            }while (cursor.moveToNext());

        }
        if (cursor != null && !cursor.isClosed())
            cursor.close();


        return producto;
    }
}
