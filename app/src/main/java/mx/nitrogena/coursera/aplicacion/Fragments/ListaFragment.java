package mx.nitrogena.coursera.aplicacion.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.nitrogena.coursera.aplicacion.R;

/**
 * Created by USUARIO on 31/01/2017.
 */

public class ListaFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}
