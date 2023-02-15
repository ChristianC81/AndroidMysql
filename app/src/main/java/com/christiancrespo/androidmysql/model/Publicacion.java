package com.christiancrespo.androidmysql.model;

public class Publicacion {
    private int userid;
    private int id;
    private String titulo;
    private String cuerpo;

    public Publicacion() {
    }

    public Publicacion(int userid, int id, String titulo, String cuerpo) {
        this.userid = userid;
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public int getUserid() {
        return userid;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
}
