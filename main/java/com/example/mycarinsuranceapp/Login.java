package com.example.mycarinsuranceapp;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import  com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private EditText username,password;
    private Button login;
    private RequestQueue requestQueue;
    private String baseurL = "https://moblieappdevelopment.onrender.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.user);
        password = findViewById(R.id.pwd);
        login = findViewById(R.id.button2);

        requestQueue = Volley.newRequestQueue(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

               if(email.isEmpty() || pass.isEmpty()){
                   Toast.makeText(Login.this,"Empty",Toast.LENGTH_SHORT).show();
                   return;
               }



                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST,
                        baseurL + "/login",
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String msg = response.getString("message");
                                    Toast.makeText(Login.this, msg, Toast.LENGTH_SHORT).show();

                                    if (msg.equals("Login Successful")) {
                                        Toast.makeText(Login.this,"Done",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Login.this, HomeActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(Login.this, "Json Error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Log.e("Login","Error:"+volleyError.toString());
                            }
                        }

                ){
                   @Override
                   protected Map<String,String> getParams(){
                       Map<String, String> params = new HashMap<>();

                       params.put("email", email);
                       params.put("pass", pass);

                       return params;
                   }
                };
               requestQueue.add(jsonObjectRequest);

            }
        });


        };
    }
