package com.iespino.pets.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iespino.pets.DataBase.DBManager;
import com.iespino.pets.pojo.Pets;
import com.iespino.pets.R;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.PetsViewHolder>
{
    private List<Pets> items;
    private int acum;
    DBManager db;

    public static class PetsViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView mascota;
        public TextView nombre;
        public TextView tvlikes;
        public ImageView ivhuesito_like;


        public PetsViewHolder(View v)
        {
            super(v);
            mascota = (ImageView) v.findViewById(R.id.imgmascota);
            nombre = (TextView) v.findViewById(R.id.nombre);
            tvlikes = (TextView) v.findViewById(R.id.tvlikes);
            ivhuesito_like = (ImageView) v.findViewById(R.id.ivhuesito_like);

        }
    }

    public Adapter(List<Pets> items)
    {
        this.items = items;
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    @Override
    public PetsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_cardview_pets, viewGroup, false);
        return new PetsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PetsViewHolder viewHolder, final int i)
    {
        viewHolder.mascota.setImageResource(items.get(i).getMascota());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.tvlikes.setText(String.valueOf(items.get(i).getLikes()));

        viewHolder.ivhuesito_like.setTag(viewHolder);

        viewHolder.ivhuesito_like.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {   db = new DBManager(v.getContext());
                PetsViewHolder acum = (PetsViewHolder) v.getTag();
                acum.tvlikes.setText(String.valueOf(1 + Integer.parseInt(acum.tvlikes.getText().toString())));
                items.get(i).setLikes(Integer.parseInt(acum.tvlikes.getText().toString()));
                db.updateLike(items.get(i));

            }
        });
    }
}