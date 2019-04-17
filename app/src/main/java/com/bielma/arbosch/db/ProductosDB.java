package com.bielma.arbosch.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.ContentHandler;


/*

 */
public class ProductosDB extends SQLiteOpenHelper {

    /**
     * El constructor de la clase se limita a llamar al constructor heredado con el perfil.
     * @param context  // Contexto usado para abrir o crear la base de datos.
     * @param name      //Nombre de la base de datos que se creará.
     * @param factory   //Se utiliza para crear un objeto de tipo cursor. En nuestro caso no lo necesitamos.
     * @param version   //Número de versión de la base de datos empezando desde 1.
     */
    public ProductosDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    /***
     * Se llama cuando sea necesario crear la base de datos.
     * Como parámetro se nos pasa una instancia de la base de datos que se acaba de crear.
     * Aqui crearemos la tabla Productos.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String  id = "id VARCHAR NOT NULL,";
        String fullImage = "full_image VARCHAR NOT NULL,";
        String thumbnail = "thumbnail VARCHAR NOT NULL,";
        String shortDescripcion = "short_descripcion VARCHAR NOT NULL,";
        String precio = "precio VARCHAR NOT NULL,";
        String nombre = "nombre VARCHAR NOT NULL,";
        String longDescripcion = "long_description VARCHAR NOT NULL,";

        db.execSQL("CREATE TABLE PRODUCTOS(" +
                id+
                fullImage+
                thumbnail+
                shortDescripcion+
                precio+
                nombre+
                longDescripcion+
                "primary key(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
