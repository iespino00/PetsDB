package com.iespino.pets;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iespino.pets.Adapter.Adapter;
import com.iespino.pets.DataBase.DBManager;
import com.iespino.pets.pojo.Pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Detalle extends AppCompatActivity
{
    private TextView txtbar;
    private ImageView imgTop;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private ArrayList<Pets> items;
    private DBManager db;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Toolbar ActionBar= (Toolbar)findViewById(R.id.ActionBar);
        setSupportActionBar(ActionBar);

        txtbar = (TextView) findViewById(R.id.txtbar);
        txtbar.setText("TOP MASCOTAS");

        imgTop = (ImageView) findViewById(R.id.imgtop);
        imgTop.setVisibility(View.INVISIBLE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setLogo(R.drawable.cat_footprint_48);

        inicializarMascotas();

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.rvDetalle);
        recycler.setHasFixedSize(true);
        recycler.setClickable(false);
        recycler.setEnabled(false);


        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

       inicializarAdaptador();
    }
    public void  inicializarAdaptador()
    {
        // Crear un nuevo adaptador
        adapter = new Adapter(items);
        recycler.setAdapter(adapter);
    }
    public  void inicializarMascotas()
    {
        db = new DBManager(Detalle.this);
        items = new ArrayList<Pets>();
        items = db.getTop();

    }
}
