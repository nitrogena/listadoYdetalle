package mx.nitrogena.coursera.aplicacion.Fragments;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.nitrogena.coursera.aplicacion.AutenticaActivity;
import mx.nitrogena.coursera.aplicacion.BD.BaseDatos;
import mx.nitrogena.coursera.aplicacion.BD.ConstantesBD;
import mx.nitrogena.coursera.aplicacion.MainActivity;
import mx.nitrogena.coursera.aplicacion.R;

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


        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.atras_48);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });



        btnAgregarVacante = (Button) view.findViewById(R.id.btnAgregarVacante);
        btnAgregarVacante.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                agregarVacante(view);
                //Intent intent = new Intent(MainActivity.this, AutenticaActivity.class);
                //startActivity(intent);
            }
        });

        btnLimpiar = (Button) view.findViewById(R.id.btnLimpiar);
        btnLimpiar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                limparCampos(view);
                //Intent intent = new Intent(MainActivity.this, AutenticaActivity.class);
                //startActivity(intent);
            }
        });
        return view;
    }

    public void limparCampos(View view){
        etVacante = (EditText) view.findViewById(R.id.fav_etVacante);
        etDescripcion = (EditText) view.findViewById(R.id.fav_etDesc);
        etCorreo = (EditText) view.findViewById(R.id.fav_etCorreo);
        etTelefono = (EditText) view.findViewById(R.id.fav_etTel);
        etVacante.setText("");
        etDescripcion.setText("");
        etCorreo.setText("");
        etTelefono.setText("");
    }

    public void agregarVacante(View view){
        /*
        etVacante = (EditText) view.findViewById(R.id.fav_etVacante);
        etDescripcion = (EditText) view.findViewById(R.id.fav_etDesc);
        etCorreo = (EditText) view.findViewById(R.id.fav_etCorreo);
        etTelefono = (EditText) view.findViewById(R.id.fav_etTel);

        String strVacante = etVacante.getText().toString();
        String strDesc = etDescripcion.getText().toString();
        String strCorreo = etCorreo.getText().toString();
        String strTelefono = etTelefono.getText().toString();


        BaseDatos bdBase = new BaseDatos(contexto);
        //insertarVacantes(bdBase);
        ContentValues cvValues = new ContentValues();
        cvValues.put(ConstantesBD.TABLE_POS_NAME, strVacante);
        cvValues.put(ConstantesBD.TABLE_POS_TEL, strTelefono);
        cvValues.put(ConstantesBD.TABLE_POS_EMAIL, strCorreo);
        cvValues.put(ConstantesBD.TABLE_POS_DESCRPTION, strDesc);

        bdBase.insertarVacante(cvValues);
        */
        Toast.makeText(getActivity(), R.string.avf_vacanteReg, Toast.LENGTH_LONG).show();
    }
}
