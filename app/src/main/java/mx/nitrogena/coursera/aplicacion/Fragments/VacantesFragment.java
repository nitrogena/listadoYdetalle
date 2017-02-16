package mx.nitrogena.coursera.aplicacion.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

import mx.nitrogena.coursera.aplicacion.Adaptadores.VacanteAdapter;
import mx.nitrogena.coursera.aplicacion.Datos.Vacantes;
import mx.nitrogena.coursera.aplicacion.R;
import mx.nitrogena.coursera.aplicacion.VacanteActivity;
import mx.nitrogena.coursera.aplicacion.vacantes.InterfaceVacante;
import mx.nitrogena.coursera.aplicacion.vacantes.InterfaceVacantePresenter;
import mx.nitrogena.coursera.aplicacion.vacantes.VacantePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class VacantesFragment extends Fragment implements InterfaceVacante {

    SwipeRefreshLayout srlRefresh;
    Adapter adaptador;

    ListView lvVacantes;

    ArrayList<Vacantes> arrVacantes;

    private RecyclerView rvListaVacantes;
    private InterfaceVacantePresenter ivpPresenter;

    public VacantesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_vacantes, container, false);




        rvListaVacantes = (RecyclerView) view.findViewById(R.id.rvVacante);
        ivpPresenter = new VacantePresenter(this, getContext());

        srlRefresh = (SwipeRefreshLayout) view.findViewById(R.id.srlRefresh);
        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescar();
            }
        });

        return view;
    }

    private void refrescar() {
        //Intent intent2 = new Intent(this, VacanteActivity.class);
        //startActivity(intent2);
        srlRefresh.setRefreshing(false);
    }
    @Override
    public void generarLlv() {
        LinearLayoutManager llmLayout = new LinearLayoutManager(getActivity());
        llmLayout.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glmLayout = new GridLayoutManager(this, 2);
        rvListaVacantes.setLayoutManager(llmLayout);
    }

    @Override
    public VacanteAdapter generarAdapter(ArrayList<Vacantes> arrLstVacantes) {
        VacanteAdapter vaAdaptador = new VacanteAdapter(arrLstVacantes, getActivity());
        return vaAdaptador;
    }



    @Override
    public void inicializarAdaptador(VacanteAdapter vaAdaptador) {
        rvListaVacantes.setAdapter(vaAdaptador);
    }
}
