package com.v.healme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class list_book extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;

    ArrayList<HashMap<String , String >> listBuku;

    String url = "https://vikatantri.000webhostapp.com/API2/menu/data_buku/read_buku.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);

        recyclerView = findViewById(R.id.buku_recyclerview);

        manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);

        listBuku = new ArrayList<HashMap<String, String>>();

        getBuku();

    }

    private void getBuku(){
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response", response);

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject result = jsonArray.getJSONObject(i);
                                HashMap<String, String> map = new HashMap<String, String>();
                                map.put("id_buku", result.getString("id_buku"));
                                map.put("judul_buku", result.getString("judul_buku"));
                                map.put("author_buku", result.getString("author_buku"));
                                map.put("halaman_buku", result.getString("halaman_buku"));
                                map.put("deskripsi_buku", result.getString("deskripsi_buku"));
                                map.put("gambar_buku", result.getString("gambar_buku"));
                                listBuku.add(map);

                                recyclerAdapter adapter2 = new recyclerAdapter(list_book.this, listBuku);
                                recyclerView.setAdapter(adapter2);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Toast.makeText(list_book.this, error.toString(),Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(list_book.this).add(request);
    }


}