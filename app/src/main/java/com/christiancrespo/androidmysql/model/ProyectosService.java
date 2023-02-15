package com.christiancrespo.androidmysql.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProyectosService{
    String API_ROUTE = "/projects.json";
    @GET(API_ROUTE)
    Call<List<Proyectos>> getProyectos();
}
