package com.example.modulo8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "mascotas";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "last_pets";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_IMAGEN = "imagen";
    private static final String COLUMN_HAS_LIKE = "has_like";
    private static final String COLUMN_NUM_LIKES = "num_likes";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NOMBRE+ " TEXT NOT NULL,"
                + COLUMN_IMAGEN + " INTEGER,"
                + COLUMN_HAS_LIKE + " BOOLEAN,"
                + COLUMN_NUM_LIKES + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertarMascota(Mascota mascota){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, mascota.getPet());
        values.put(COLUMN_IMAGEN, mascota.getImage());
        values.put(COLUMN_HAS_LIKE, mascota.isHasLike());
        values.put(COLUMN_NUM_LIKES, mascota.getLikes());

        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    public List<Mascota> obtenerMascotas() {
        List<Mascota> mascotas = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME
                +" ORDER BY "+ COLUMN_ID+" DESC LIMIT 5", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE));
                int image = cursor.getInt(cursor.getColumnIndex(COLUMN_IMAGEN));
                boolean hasLike = cursor.getInt(cursor.getColumnIndex(COLUMN_HAS_LIKE))== 1;
                int likes = cursor.getInt(cursor.getColumnIndex(COLUMN_NUM_LIKES));

                Mascota mascota = new Mascota(id, nombre, image, hasLike, likes);
                mascotas.add(mascota);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mascotas;
    }

}

