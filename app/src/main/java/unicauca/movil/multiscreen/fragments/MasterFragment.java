package unicauca.movil.multiscreen.fragments;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import unicauca.movil.multiscreen.BR;
import unicauca.movil.multiscreen.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment {

    public static MasterFragment instance(){
        return new MasterFragment();
    }

    public interface ColorSelected{
        void onColorSelected(int pos);
    }

    ColorSelected selected;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        selected = (ColorSelected) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.f_master, container, false);
        ViewDataBinding binding = DataBindingUtil.bind(v);
        binding.setVariable(BR.handler, this);

        return binding.getRoot();
    }

    public void colorSelected(int pos){
        selected.onColorSelected(pos);
    }


}
