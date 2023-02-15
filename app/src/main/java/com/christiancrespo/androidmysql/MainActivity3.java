package com.christiancrespo.androidmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.christiancrespo.androidmysql.model.Proyectos;
import com.christiancrespo.androidmysql.model.ProyectosService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity3 extends AppCompatActivity {
    ListView list;
    ArrayAdapter arrayAdapter;
    ArrayList<String> datos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        list = findViewById(R.id.listViewDatos);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,datos);
        list.setAdapter(arrayAdapter);
        obtenerProyectos();
    }
    private void obtenerProyectos(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://24pullrequests.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProyectosService proyectosService= retrofit.create(ProyectosService.class);
        Call<List<Proyectos>> call= proyectosService.getProyectos();
        call.enqueue(new Callback<List<Proyectos>>() {
            @Override
            public void onResponse(Call<List<Proyectos>> call, Response<List<Proyectos>> response) {
                for (Proyectos proyectos: response.body()){
                    datos.add(proyectos.getDescription());

                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Proyectos>> call, Throwable t) {

            }
        });
    }
}