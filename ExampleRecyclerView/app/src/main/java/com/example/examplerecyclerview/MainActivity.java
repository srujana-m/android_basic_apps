package com.example.examplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     RecyclerView rv;
     ArrayList<MyModel>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        list =new ArrayList<>();
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(ScalarsConverterFactory.create()).build();
        Call<String> response = retrofit.create(MyInterface.class).value();
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                String res= response.body();
                try {
                    JSONObject root=new JSONObject(res);
                    JSONArray articles =root.getJSONArray("articles");
                    for(int i=0;i<articles.length();i++)
                    {
                        JSONObject obj=articles.getJSONObject(i);
                        String title =obj.getString("title");
                        String link=obj.getString("urlToImage");
                        MyModel myModel=new MyModel(title,link);
                        list.add(myModel);
                    }
                    MyAdapter adapter=new MyAdapter(MainActivity.this,list);
                    rv.setAdapter(adapter);
                    rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed to fetch", Toast.LENGTH_SHORT).show();
            }
        });


    }
}