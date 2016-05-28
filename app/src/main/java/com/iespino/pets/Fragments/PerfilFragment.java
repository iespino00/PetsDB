package com.iespino.pets.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iespino.pets.Adapter.Adapter;
import com.iespino.pets.R;
import com.iespino.pets.pojo.Pets;

import java.util.ArrayList;


public class PerfilFragment extends Fragment
{
    private RecyclerView recycler;
    private ArrayList<Pets> items;
    private TextView tvPerfil;

    public PerfilFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        //Obtener el Recycler
        recycler = (RecyclerView) v.findViewById(R.id.rvPerfil);
        //  recycler.setHasFixedSize(true)
        final GridLayoutManager glm= new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);

        recycler.setLayoutManager(glm);

        tvPerfil = (TextView) v.findViewById(R.id.tvPerfil);
        tvPerfil.setText("Pluto");
       /* LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recycler.setLayoutManager(llm);*/
        inicializarMascotas();
        inicializarAdaptador();

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
        int cont=1;

        items = new ArrayList<>();

        for (int i=0;i<=4;i++)
        {
            items.add(new Pets(R.drawable.pet2, "Pluto", cont));
             cont*=2;
        }


    }
}
