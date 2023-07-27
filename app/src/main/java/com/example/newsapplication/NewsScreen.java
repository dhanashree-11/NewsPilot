package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NewsScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    newsadapter newsScreenAdapter;
    LinearLayoutManager linearLayoutManager;
    String category,country,date;
    String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_screen);


        country = getIntent().getStringExtra("country");
        category = getIntent().getStringExtra("category");
        date = getIntent().getStringExtra("date");

        Log.d("checking", "onCreate: "+country+category+date);

        URL = "https://newsapi.org/v2/top-headlines?apiKey=76e25b06acba4ed19f0e71d895171960&country="+country+"&category="+category+"&from="+date;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String[] imageArr = new String[response.length()];
                String[] titleArr = new String[response.length()];
                String[] descArr = new String[response.length()];
                String[] linkArr = new String[response.length()];

                try {
                    Log.d("Ress: ",response.toString());
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("articles");
                    if (jsonArray.length() > 0){
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            String image = jsonObject1.getString("urlToImage");
                            String title = jsonObject1.getString("title");
                            String desc = jsonObject1.getString("description");
                            String link = jsonObject1.getString("url");

                            imageArr[i] = image.toString();
                            titleArr[i] = title.toString();
                            descArr[i] = desc.toString();
                            linkArr[i] = link.toString();
                        }

                        recyclerView = (RecyclerView) findViewById(R.id.NewsRecyclerView);
                        newsScreenAdapter = new newsadapter(getApplicationContext(), imageArr, titleArr,descArr,linkArr);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                        recyclerView.setAdapter(newsScreenAdapter);

                    }
                }catch(Exception e){
                    Log.d("responseE", e.toString());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("responseError", error.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap header = new HashMap();
                header.put("User-Agent", "Mozilla/5.0");
                return header;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}