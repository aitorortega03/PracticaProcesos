package com.example.infocovid.Controller;

import com.example.infocovid.Model.JsonPoblacion;
import com.example.infocovid.Model.PoblacionData;
import com.example.infocovid.Model.Posts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PoblacionService {
    String API_ROUTE = "/catalogo/dataset/032474a0-bf11-4465-bb92-392052962866/resource/301aed82-339b-4005-ab20-06db41ee7017/download/municipio_comunidad_madrid.json";
    @GET(API_ROUTE)
    Call<JsonPoblacion> getPost();
}
