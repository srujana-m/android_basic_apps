package com.example.examplerecyclerview;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyInterface {
    @GET("top-headlines?sources=bbc-news&apiKey=efc28900bc1a4d82896991106b8e3cd3")
    Call<String> value();
}
