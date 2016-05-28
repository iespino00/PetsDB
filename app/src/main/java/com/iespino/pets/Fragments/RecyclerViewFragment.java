package com.iespino.pets.Fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.iespino.pets.Adapter.Adapter;
import com.iespino.pets.DataBase.AccionesDB;
import com.iespino.pets.DataBase.ConstantesDB;
import com.iespino.pets.DataBase.DBManager;
import com.iespino.pets.R;
import com.iespino.pets.pojo.Pets;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment
{
    private RecyclerView recycler;
    private ArrayList<Pets> items;
    DBManager db;
    SQLiteDatabase auxdb;
    AccionesDB acc;
    private Context c;
    public String statusPreferencia;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);


        acc= new AccionesDB(getActivity());
        statusPreferencia= acc.cargarPreferencias(getActivity());
        if (statusPreferencia == "no")
        {
            db = new DBManager(getActivity());
            auxdb = db.getWritableDatabase();
            acc = new AccionesDB(getActivity());
            acc.crearPreferencia(getActivity());
            acc = new AccionesDB(getActivity()).cargaIniciarlPets(db);

        }else{

        }

        inicializarMascotas();
        if (!items.isEmpty())
        {
            //Obtener el Recycler
            recycler = (RecyclerView) v.findViewById(R.id.reciclador);
            //  recycler.setHasFixedSize(true)
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);

            recycler.setLayoutManager(llm);

            inicializarAdaptador();

        }

           return  v;

    }

    public void  inicializarAdaptador()
    {
        // Crear un nuevo adaptador
        Adapter adapter = new Adapter(items);
        recycler.setAdapter(adapter);
    }
    public  void inicializarMascotas()
    {
      /*  // Inicializar
        items = new ArrayList<>();

        items.add(new Pets(R.drawable.pet1, "Speedy", 0));
        items.add(new Pets(R.drawable.pet2, "Pluto", 0));
        items.add(new Pets(R.drawable.pet3, "Doggy", 0));
        items.add(new Pets(R.drawable.pet4, "Hamsty", 0));
        items.add(new Pets(R.drawable.pet5, "Leoni", 0));
        items.add(new Pets(R.drawable.pet6, "TumTum", 0));
        items.add(new Pets(R.drawable.pet7, "Doberto", 0));*/

        db = new DBManager(getActivity());
        items = new ArrayList<Pets>();
        items = db.getAllPets();
    }






}
