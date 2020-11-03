package com.example.infocovid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DatosMapsFragment extends Fragment {

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
        Spinner spZonaSan = vista.findViewById(R.id.spZonaSan);
        EditText etnPoblacion = vista.findViewById(R.id.etnPoblacion);
        EditText etnContagios = vista.findViewById(R.id.etnContagios);
        EditText etnFallecidos = vista.findViewById(R.id.etnFallecidos);

        bBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spComunidad.getSelectedItemPosition()==0 || spMunicipio.getSelectedItemPosition()==0 || spZonaSan.getSelectedItemPosition()==0) {
                    Toast.makeText(getContext(), "Seleccione una comunidad, municipio y zona sanitaria.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Buscando datos...", Toast.LENGTH_LONG).show();
                    etnPoblacion.setText("128.256");
                    etnContagios.setText("7.365");
                    etnFallecidos.setText("117");
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
}