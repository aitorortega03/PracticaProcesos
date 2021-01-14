package com.example.infocovid.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.infocovid.R;

import static androidx.navigation.Navigation.findNavController;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioSesionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioSesionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InicioSesionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioSesionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioSesionFragment newInstance(String param1, String param2) {
        InicioSesionFragment fragment = new InicioSesionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
        Button bInicioSesion = vista.findViewById(R.id.bIniciarSesion);
        EditText etUsuario = vista.findViewById(R.id.etUsuario);
        EditText etContrasena = vista.findViewById(R.id.etContrasena);

        bInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsuario.getText().toString().equals("AlbertoP") || etUsuario.getText().toString().equals("AitorO") ||
                        etUsuario.getText().toString().equals("IsraelP") || etUsuario.getText().toString().equals("AdrianM") ||
                        etUsuario.getText().toString().equals("AndreaN") || etUsuario.getText().toString().equals("AntontioP")) {
                    if(etContrasena.getText().toString().equals("1234")){
                        MainActivity.nombreUsuario = etUsuario.getText().toString();
                        findNavController(v).navigate(R.id.demainAMain);
                    }
                }
            }
        });


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
        return vista;
    }
}