package com.example.samim.recylerview_volly_glide_gson_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.samim.recylerview_volly_glide_gson_json.Adapter.GithubAdapter;
import com.example.samim.recylerview_volly_glide_gson_json.UserDetail.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    //JSON URL
    private static final String URL= "https://api.github.com/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //RecylerView
        final RecyclerView userList=(RecyclerView)findViewById(R.id.userList);
        userList.setLayoutManager(new LinearLayoutManager(this));

        //Responsed Block
        StringRequest request=new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("CODE",response);
                Toast.makeText(getApplicationContext(),"code is worked",Toast.LENGTH_SHORT).show();
                //use GSON data
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson=gsonBuilder.create();
              User[] users=  gson.fromJson(response, User[].class);
                //print responsed in recylerView
                userList.setAdapter(new GithubAdapter(MainActivity.this,users));
                //Toast.makeText(MainActivity.this,"user details"+users,Toast.LENGTH_LONG).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Somthing went wrong",Toast.LENGTH_SHORT).show();

            }
        });
        //Add request
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(request);
    }
}
