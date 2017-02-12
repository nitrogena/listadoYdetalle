package mx.nitrogena.coursera.aplicacion;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

import mx.nitrogena.coursera.aplicacion.Adaptadores.VacanteAdapter;
import mx.nitrogena.coursera.aplicacion.Datos.Vacantes;

public class VacanteActivity extends AppCompatActivity {

    SwipeRefreshLayout srlRefresh;
    Adapter adaptador;

    ListView lvVacantes;

    ArrayList<Vacantes> arrVacantes;

    private RecyclerView rvListaVacantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacante);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        rvListaVacantes = (RecyclerView) findViewById(R.id.rvVacante);

        LinearLayoutManager llmLayout = new LinearLayoutManager(this);
        llmLayout.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glmLayout = new GridLayoutManager(this, 2);

        rvListaVacantes.setLayoutManager(llmLayout);
        InicializarListaVacantes();
        inicializarAdaptador();


        GridLayoutManager glm = new GridLayoutManager(this, 2);


        srlRefresh = (SwipeRefreshLayout) findViewById(R.id.srlRefresh);


        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescar();
            }
        });

        //finish();
    }

    private void refrescar() {

        Intent intent2 = new Intent(this, VacanteActivity.class);

        startActivity(intent2);
        srlRefresh.setRefreshing(false);
    }

    public void InicializarListaVacantes(){

        arrVacantes = new ArrayList<Vacantes>();

        arrVacantes.add(new Vacantes("Desarrollador web", "77777777", "sisma@inventado.com", "Experiencia en programación orientada a objetos"));
        arrVacantes.add(new Vacantes("Tester", "88888888", "tic@inventado.com", "Desarrollador junior para realizar pruebas en sistemas web"));
        arrVacantes.add(new Vacantes("Desarrollador de aplicaciones móviles", "99999999", "appmovil@inventado.com", "Desarrollo con iOS"));
        arrVacantes.add(new Vacantes("Adminstrador de servidores", "66666666", "desapp@inventado.com", "Experiencia de 8 años"));



    }

    public void inicializarAdaptador(){
        VacanteAdapter paAdaptador = new VacanteAdapter(arrVacantes, this);
        rvListaVacantes.setAdapter(paAdaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opcion_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.moContactado:
                refrescar();
                break;
            case R.id.moPendiente:
                refrescar();
                break;
            case R.id.moOculto:
                refrescar();
                break;
            case R.id.moNuevo:
                refrescar();
                break;

            case R.id.moAcerca:
                mostrarInformativo("acerca");
                break;
            case R.id.moCreditos:
                mostrarInformativo("creditos");
                break;
            case R.id.moAvRefresh:
                refrescar();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void mostrarInformativo(String strOpcion){

        Intent intent = new Intent(this, InformativoActivity.class);
        intent.putExtra("texto", strOpcion);
        startActivity(intent);
    }


}