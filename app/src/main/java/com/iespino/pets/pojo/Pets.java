package com.iespino.pets.pojo;


public class Pets
{
    private int mascota;
    private String nombre;
    private int tvlikes;
    private int id;


    public Pets()
    {

    }
    public Pets(int mascota, String nombre, int tvlikes)
    {
        this.mascota = mascota;
        this.nombre = nombre;
        this.tvlikes = tvlikes;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getLikes()
    {
        return tvlikes;
    }


    public int getMascota()
    {
        return mascota;
    }

    public void setLikes(int likes)
    {
        this.tvlikes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTvlikes(int tvlikes)
    {
        this.tvlikes = tvlikes;
    }

    public void setMascota(int mascota) {
        this.mascota = mascota;
    }
}
