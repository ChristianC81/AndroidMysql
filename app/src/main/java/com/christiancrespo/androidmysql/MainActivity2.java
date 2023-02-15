package com.christiancrespo.androidmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.christiancrespo.androidmysql.model.Car;
import com.christiancrespo.androidmysql.model.Comentarios;
import com.christiancrespo.androidmysql.model.Marcadores;
import com.christiancrespo.androidmysql.model.Publicacion;
import com.christiancrespo.androidmysql.model.User;
import com.christiancrespo.androidmysql.model.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdpater;
    ArrayList<String> datos= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.listViewNoticias);
        arrayAdpater= new ArrayAdapter(this, android.R.layout.simple_spinner_item, datos);
        listView.setAdapter(arrayAdpater);
        obtenerDatosMarcadores();
    }

    private void obtenerDatos(){
        String url = "http://jsonplaceholder.typicode.com/posts";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Obtenemos la respuesta del json
                        //Manejamos el json
                        manejarJson(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }

    private void obtenerDatosUser(){
        String url = "https://24pullrequests.com/users/andrew.json";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Obtenemos la respuesta del json
                        //Manejamos el json
                        manejarJsonUsuario(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }
    private void obtenerDatosComentarios(){
        String url = "https://jsonplaceholder.typicode.com/comments";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Obtenemos la respuesta del json
                        //Manejamos el json
                        manejarJsonComentarios(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }
    private void obtenerDatosCar(){
        String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos/2014-3";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Obtenemos la respuesta del json
                        //Manejamos el json
                        manejarJsonCar(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }
    private void obtenerDatosMarcadores(){
        String url = "https://christiancrespo8.000webhostapp.com/marcadores.json";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Obtenemos la respuesta del json
                        //Manejamos el json
                        manejarJsonMarcadores(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }
    private void manejarJsonMarcadores(JSONArray jsonArray){
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObject = null;
            Marcadores marcadores = new Marcadores();
            try {
                jsonObject = jsonArray.getJSONObject(i);
                marcadores.setLatitude(jsonObject.getDouble("latitude"));
                marcadores.setLongitude(jsonObject.getInt("longitude"));
                marcadores.setCity(jsonObject.getString("city"));
                marcadores.setDescription(jsonObject.getString("description"));
                arrayAdpater.add(marcadores.getDescription());
            }catch (JSONException ex){
                ex.printStackTrace();
            }
        }
        arrayAdpater.notifyDataSetChanged();
    }
    private void manejarJson(JSONArray jsonArray){
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObject = null;
            Publicacion publicacion = new Publicacion();
            try {
                jsonObject = jsonArray.getJSONObject(i);
                publicacion.setUserid(jsonObject.getInt("userId"));
                publicacion.setId(jsonObject.getInt("id"));
                publicacion.setTitulo(jsonObject.getString("title"));
                publicacion.setCuerpo(jsonObject.getString("body"));
                arrayAdpater.add(publicacion.getCuerpo());
            }catch (JSONException ex){
                ex.printStackTrace();
            }
        }
        arrayAdpater.notifyDataSetChanged();
    }
    private void manejarJsonUsuario(JSONArray jsonArray){
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObject = null;
            User usuario = new User();
            try {
                jsonObject = jsonArray.getJSONObject(i);
                usuario.setId(jsonObject.getInt("id"));
                usuario.setNickname(jsonObject.getString("nickname"));
                usuario.setGithub_profile(jsonObject.getString("github_profile"));
                usuario.setLink(jsonObject.getString("link"));
                arrayAdpater.add(usuario.getNickname());
            }catch (JSONException ex){
                ex.printStackTrace();
            }
        }
        arrayAdpater.notifyDataSetChanged();
    }

    private void manejarJsonComentarios(JSONArray jsonArray){
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObject = null;
            Comentarios comentarios = new Comentarios();
            try {
                jsonObject = jsonArray.getJSONObject(i);
                comentarios.setId(jsonObject.getInt("id"));
                comentarios.setName(jsonObject.getString("name"));
                comentarios.setEmail(jsonObject.getString("email"));
                comentarios.setBody(jsonObject.getString("body"));
                arrayAdpater.add(comentarios.getEmail());
            }catch (JSONException ex){
                ex.printStackTrace();
            }
        }
        arrayAdpater.notifyDataSetChanged();
    }
    private void manejarJsonCar(JSONArray jsonArray){
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObject = null;
            Car car = new Car();
            try {
                jsonObject = jsonArray.getJSONObject(i);
                car.setValor(jsonObject.getString("Valor"));
                car.setMarca(jsonObject.getString("Marca"));
                car.setModelo(jsonObject.getString("Modelo"));
                car.setAnoModelo(jsonObject.getString("AnoModelo"));
                arrayAdpater.add(car.getMarca());
            }catch (JSONException ex){
                ex.printStackTrace();
            }
        }
        arrayAdpater.notifyDataSetChanged();
    }
}
