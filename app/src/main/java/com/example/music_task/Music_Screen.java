package com.example.music_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Music_Screen extends AppCompatActivity {

    private static  final String URL_DATA="https://itunes.apple.com/search?term=Michael+jackson";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Listitem> listitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music__screen);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listitems= new ArrayList<>();

        loadRecyclerViewData();

    }

    private void loadRecyclerViewData(){
        final ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setMessage("Loading data.....");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject= new JSONObject(s);
                    JSONArray array= jsonObject.getJSONArray("results");

                    for(int i=0; i<array.length();i++){
                        JSONObject o = array.getJSONObject(i);
                        Listitem listitem= new Listitem(
                                o.getString("artworkUrl100"),
                                o.getString("artistName"),
                                o.getString("trackName"),
                                o.getString("primaryGenreName")
                        );

                        listitems.add(listitem);
                    }

                    adapter= new MyAdapter(listitems,getApplicationContext());
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),volleyError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
