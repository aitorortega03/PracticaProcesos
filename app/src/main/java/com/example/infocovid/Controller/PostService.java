package com.example.infocovid.Controller;

import com.example.infocovid.Model.Posts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    String API_ROUTE = "/lTrEzFGSU2ayogtj/arcgis/rest/services/Catalogo_de_datos_abiertos_de_CCAA_Madrid/FeatureServer/1/query?where=1%3D1&outFields=DSMUNI,fecha_informe,casos_confirmados_ultimos_14dia,tasa_incidencia_acumulada_ultim&outSR=4326&f=json";
    @GET(API_ROUTE)
    Call<Posts> getPost();
}
