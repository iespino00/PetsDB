package com.iespino.pets.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.iespino.pets.Fragments.RecyclerViewFragment;
import com.iespino.pets.R;
import com.iespino.pets.pojo.Pets;

import java.util.ArrayList;

public class AccionesDB extends  AppCompatActivity
{
    private Context context;
    DBManager db;
    private ContentValues contentValues;
    private Boolean statusPreferencia;

    public AccionesDB(Context context)
    {
        this.context= context;

    }

    public AccionesDB cargaIniciarlPets(DBManager db)
    {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TPETS_NOMBRE, "Speedy");
        contentValues.put(ConstantesDB.TPETS_LIKES, 0);
        contentValues.put(ConstantesDB.TPETS_FOTO, R.drawable.pet1);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TPETS_NOMBRE, "Pluto");
        contentValues.put(ConstantesDB.TPETS_LIKES, 0);
        contentValues.put(ConstantesDB.TPETS_FOTO, R.drawable.pet2);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TPETS_NOMBRE, "Doggy");
        contentValues.put(ConstantesDB.TPETS_LIKES, 0);
        contentValues.put(ConstantesDB.TPETS_FOTO, R.drawable.pet3);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TPETS_NOMBRE, "Hamsty");
        contentValues.put(ConstantesDB.TPETS_LIKES, 0);
        contentValues.put(ConstantesDB.TPETS_FOTO, R.drawable.pet4);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TPETS_NOMBRE, "Leoni");
        contentValues.put(ConstantesDB.TPETS_LIKES, 0);
        contentValues.put(ConstantesDB.TPETS_FOTO, R.drawable.pet5);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TPETS_NOMBRE, "TumTum");
        contentValues.put(ConstantesDB.TPETS_LIKES, 0);
        contentValues.put(ConstantesDB.TPETS_FOTO, R.drawable.pet6);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TPETS_NOMBRE, "Doberto");
        contentValues.put(ConstantesDB.TPETS_LIKES, 0);
        contentValues.put(ConstantesDB.TPETS_FOTO, R.drawable.pet7);
        db.insertarPet(contentValues);
        return null;

    }


    public ArrayList<Pets> obtenerDatos()
    {
        DBManager db = new DBManager(context);
        return db.getAllPets();
    }

    public void crearPreferencia(Context c)
    {
        SharedPreferences PreferenciaPets= c.getSharedPreferences("PreferenciasDBPets", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= PreferenciaPets.edit();
        String valor= "si";
        editor.putString("DB", valor);
        editor.commit();
    }

    public String cargarPreferencias(Context c)
    {
        RecyclerViewFragment rvf = new RecyclerViewFragment();

        SharedPreferences PreferenciaPets= c.getSharedPreferences("PreferenciasDBPets", Context.MODE_PRIVATE);
        rvf.statusPreferencia=PreferenciaPets.getString("DB", "no");

        String var = rvf.statusPreferencia;

      return var;

    }

}
