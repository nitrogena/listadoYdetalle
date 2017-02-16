package mx.nitrogena.coursera.aplicacion.Fragments;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.nitrogena.coursera.aplicacion.BD.BaseDatos;
import mx.nitrogena.coursera.aplicacion.BD.ConstantesBD;
import mx.nitrogena.coursera.aplicacion.R;
import mx.nitrogena.coursera.aplicacion.VacanteActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarvacanteFragment extends Fragment {

    private Button btnAgregarVacante;
    private Button btnLimpiar;
    private EditText etVacante;
    private EditText etDescripcion;
    private EditText etCorreo;
    private EditText etTelefono;
    private Context contexto;

    public AgregarvacanteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregarvacante, container, false);

        etVacante = (EditText) view.findViewById(R.id.fav_etVacante);
        etDescripcion = (EditText) view.findViewById(R.id.fav_etDesc);
        etCorreo = (EditText) view.findViewById(R.id.fav_etCorreo);
        etTelefono = (EditText) view.findViewById(R.id.fav_etTel);

        //setHasOptionsMenu(true);

        //((VacanteActivity) getActivity()).getSupportActionBar().hide();

        String strVacante = etVacante.getText().toString();
        Log.i("vacante1: ", strVacante);



        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.atras_48);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });



        limparCampos(view);
        agregarVacante(view);



        return view;
    }

    public void limparCampos(View view){
        btnLimpiar = (Button) view.findViewById(R.id.btnLimpiar);
        btnLimpiar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                etVacante.setText("");
                etDescripcion.setText("");
                etCorreo.setText("");
                etTelefono.setText("");
            }
        });
    }

    public void agregarVacante(View view){
        btnAgregarVacante = (Button) view.findViewById(R.id.btnAgregarVacante);
        btnAgregarVacante.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                    String strVacante = etVacante.getText().toString();
                    String strDesc = etDescripcion.getText().toString();
                    String strCorreo = etCorreo.getText().toString();
                    String strTelefono = etTelefono.getText().toString();

                    BaseDatos bdBase = new BaseDatos(getActivity());

                    ContentValues cvValues = new ContentValues();
                    cvValues.put(ConstantesBD.TABLE_POS_NAME, strVacante);
                    cvValues.put(ConstantesBD.TABLE_POS_TEL, strTelefono);
                    cvValues.put(ConstantesBD.TABLE_POS_EMAIL, strCorreo);
                    cvValues.put(ConstantesBD.TABLE_POS_DESCRPTION, strDesc);

                    bdBase.insertarVacante(cvValues);

                Toast.makeText(getActivity(), R.string.avf_vacanteReg, Toast.LENGTH_LONG).show();
            }
        });

    }
    /*
        @Override
        public void onResume() {
            super.onResume();
            getActivity().invalidateOptionsMu();
        }
        @Override
        public void onPrepareOptionsMenu(Menu menu) {
            super.onPrepareOptionsMenu(menu);
            menu.clear();    //remove all items
            getActivity().getMenuInflater().inflate(R.menu.menu_opcion_detalle, menu);
        }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @Override
    public void onAttach(final Activity activity) {

        super.onAttach(activity);

        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(final Menu menu) {

        super.onPrepareOptionsMenu(menu);

        menu.clear();//This removes all menu items (no need to know the id of each of them)
    }*/

    @Override
    public void onResume() {
        super.onResume();
        ((VacanteActivity) getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((VacanteActivity) getActivity()).getSupportActionBar().show();
    }
}
