package com.example.infocovid.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.infocovid.R;

import static androidx.navigation.Navigation.findNavController;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_main, container, false);

        Button data = vista.findViewById(R.id.btnData);
        Button help = vista.findViewById(R.id.btnHelp);
        Button profile = vista.findViewById(R.id.btnProfile);
        ImageView iconoClaro = vista.findViewById((R.id.imageView));

        if (MainActivity.ModoOscuro == true){
            iconoClaro.setImageResource(R.drawable.logo_white_large);

        }
        else{
            iconoClaro.setImageResource(R.drawable.logo_large);
            
        }

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { findNavController(v).navigate(R.id.demainADatos);  }

        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { findNavController(v).navigate(R.id.demainAHelp);  }
        });

        profile.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) { findNavController(v).navigate(R.id.demainAPerfil);  }
        });

        return vista;
    }
}
