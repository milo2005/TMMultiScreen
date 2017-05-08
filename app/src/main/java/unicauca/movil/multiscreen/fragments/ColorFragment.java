package unicauca.movil.multiscreen.fragments;


import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import unicauca.movil.multiscreen.R;
import unicauca.movil.multiscreen.databinding.FragmentColorBinding;

public class ColorFragment extends Fragment {

    public static final int AZUL = 0;
    public static final int ROJO = 1;
    public static final int AMARILLO = 2;
    public static final int VERDE = 3;
    public static final int NARANJA = 4;
    public static final int VIOLETA = 5;

    public static final ColorFragment instance(int color){
        ColorFragment fragment =  new ColorFragment();
        Bundle args =  new Bundle();
        args.putInt("color", color);
        fragment.setArguments(args);
        return fragment;
    }

    FragmentColorBinding binding;

    public ColorFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_color, container, false);

        int color =  getArguments().getInt("color");
        binding.setColor(color);

        return binding.getRoot();
    }

}
