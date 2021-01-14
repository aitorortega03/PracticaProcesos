package com.example.infocovid.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infocovid.R;

public class profileFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public profileFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static profileFragment newInstance(String param1, String param2) {
        profileFragment fragment = new profileFragment();
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
        View vista = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView nick = vista.findViewById(R.id.tvNickname);
        Button b_oscuro = vista.findViewById(R.id.b_oscuro);
        ImageView iconoClaro = vista.findViewById(R.id.imageView);


        b_oscuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(b_oscuro.getText().toString().equals("MODO CLARO")) {
                    b_oscuro.setText("MODO OSCURO");
                    MainActivity.ModoOscuro = true;
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);


                }
                else {
                    b_oscuro.setText("MODO CLARO");
                    MainActivity.ModoOscuro = false;
                    
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });


        nick.setText(MainActivity.nombreUsuario);
        return vista;

    }
}