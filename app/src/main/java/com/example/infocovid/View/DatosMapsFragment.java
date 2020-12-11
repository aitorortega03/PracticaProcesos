package com.example.infocovid.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.infocovid.Controller.PoblacionService;
import com.example.infocovid.Controller.PostService;
import com.example.infocovid.Model.Atributes;
import com.example.infocovid.Model.Features;
import com.example.infocovid.Model.JsonPoblacion;
import com.example.infocovid.Model.PoblacionData;
import com.example.infocovid.Model.Posts;
import com.example.infocovid.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DatosMapsFragment extends Fragment {


    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> poblasionDensidad = new ArrayList<>();
    private ArrayAdapter arrayAdapter;
    private ArrayAdapter arrayAdapterPoblacion;
    private HashMap<String,Atributes> datosMunicipios = new HashMap<String, Atributes>();
    private HashMap<String,PoblacionData> datosPoblacion = new HashMap<String, PoblacionData>();
    private ProgressBar loading;
    private ConstraintLayout layout;


    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //Permite programar el evento onClick del boton bBuscar
        View vista = inflater.inflate(R.layout.fragment_datos_maps, container, false);
        Button bBuscar = vista.findViewById(R.id.bBuscar);
        Spinner spComunidad = vista.findViewById(R.id.spComunidad);
        Spinner spMunicipio = vista.findViewById(R.id.spMunicipio);
        EditText etnPoblacion = vista.findViewById(R.id.etnPoblacion);
        EditText etnContagios = vista.findViewById(R.id.etnContagios);
        EditText etnFallecidos = vista.findViewById(R.id.etnFallecidos);
        arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,titles);
        spMunicipio.setAdapter(arrayAdapter);
        loading = vista.findViewById(R.id.progressBar);
        layout = vista.findViewById(R.id.constrailLayoutMenu);
        layout.setVisibility(View.INVISIBLE);
        loading.setVisibility(View.VISIBLE);
        getPoblaciones();
        getPosts();
        bBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spComunidad.getSelectedItemPosition()==0 || spMunicipio.getSelectedItemPosition()==0 ) {
                    Toast.makeText(getContext(), "Seleccione una comunidad, municipio y zona sanitaria.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Buscando datos...", Toast.LENGTH_LONG).show();
                    etnPoblacion.setText(""+datosPoblacion.get(spMunicipio.getSelectedItem().toString()).getDensidad_por_km2());
                    etnContagios.setText(""+datosMunicipios.get(spMunicipio.getSelectedItem().toString()).getCasos_confirmados_ultimos_14dia());
                    etnFallecidos.setText("-");
                }
            }
        });

        return vista;
        //return inflater.inflate(R.layout.fragment_datos_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    private void getPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://services7.arcgis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService postService = retrofit.create(PostService.class);
        Call<Posts> call = postService.getPost();
        titles.add("--Elige un municipio--");
        call.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                for (Features feature: response.body().getFeatures()) {
                    Atributes atribute = feature.getAttributes();
                    if (titles.contains(atribute.getDSMUNI())){

                    }else {
                        datosMunicipios.put(atribute.getDSMUNI().toString(),atribute);
                        titles.add(atribute.getDSMUNI().toString());
                    }
                }
                Collections.sort(titles);
                arrayAdapter.notifyDataSetChanged();
                loading.setVisibility(View.INVISIBLE);
                layout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                titles.add(t.getCause().toString());
                Toast.makeText(getContext(),""+t.getCause(),Toast.LENGTH_LONG).show();
                System.out.println(t.getCause().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private void getPoblaciones() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://datos.comunidad.madrid")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PoblacionService poblacionservice = retrofit.create(PoblacionService.class);
        Call<JsonPoblacion> call2 = poblacionservice.getPost();
        call2.enqueue(new Callback<JsonPoblacion>() {
            @Override
            public void onResponse(Call<JsonPoblacion> call, Response<JsonPoblacion> response) {
                for (PoblacionData pd: response.body().getData()) {
                    if (poblasionDensidad.contains(pd.getMunicipio_nombre())){

                    }else {
                        datosPoblacion.put(pd.getMunicipio_nombre().toString(),pd);
                        poblasionDensidad.add(pd.getMunicipio_nombre().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonPoblacion> call, Throwable t) {
                titles.add(t.getCause().toString());
                Toast.makeText(getContext(),""+t.getCause(),Toast.LENGTH_LONG).show();
                System.out.println(t.getCause().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}