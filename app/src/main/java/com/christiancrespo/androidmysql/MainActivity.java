package com.christiancrespo.androidmysql;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre;
    EditText txtEmail;
    EditText txtTelefono;
    EditText txtPass;
    Button button;
    String url="https://christiancrespo8.000webhostapp.com/insertar.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre=findViewById(R.id.txtNombre);
        txtEmail=findViewById(R.id.txtEmail);
        txtTelefono=findViewById(R.id.txtTelefono);
        txtPass=findViewById(R.id.txtPass);
        button= findViewById(R.id.btnGuardar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre=txtNombre.getText().toString();
                String email=txtEmail.getText().toString();
                String telefono=txtTelefono.getText().toString();
                String pass=txtPass.getText().toString();

                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        txtNombre.setText("");
                        txtEmail.setText("");
                        txtTelefono.setText("");
                        txtPass.setText("");
                        Toast.makeText(MainActivity.this, response.toString(),Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String,String>param= new HashMap<String,String>();
                        param.put("nombre",nombre);
                        param.put("email",email);
                        param.put("telefono",telefono);
                        param.put("pass",pass);

                        return param;
                    }
                };
                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                queue.add(request);
            }
        });
        Volley.newRequestQueue(this);
    }

    /*public void guardarUsuario(View view){

        String url="http://localhost/android_mysql/insertar.php?nombre=christian";

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                        System.out.println("Enviado la peticion post");
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    error.getMessage();
                        System.out.println("Error en el envio de la peticion post");
                    }


                }
        );
    }*/
}