package mx.nitrogena.coursera.aplicacion;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
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
import mx.nitrogena.coursera.aplicacion.Fragments.VacantesFragment;
import mx.nitrogena.coursera.aplicacion.vacantes.InterfaceVacante;
import mx.nitrogena.coursera.aplicacion.vacantes.InterfaceVacantePresenter;
import mx.nitrogena.coursera.aplicacion.vacantes.VacantePresenter;

public class VacanteActivity extends AppCompatActivity{

    SwipeRefreshLayout srlRefresh;
    Adapter adaptador;

    ListView lvVacantes;

    ArrayList<Vacantes> arrVacantes;

    private RecyclerView rvListaVacantes;
    //private InterfaceVacantePresenter ivpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacante);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        //rvListaVacantes = (RecyclerView) findViewById(R.id.rvVacante);
        //ivpPresenter = new VacantePresenter(this, getBaseContext());

        /*vista presentador
        LinearLayoutManager llmLayout = new LinearLayoutManager(this);
        llmLayout.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glmLayout = new GridLayoutManager(this, 2);
        rvListaVacantes.setLayoutManager(llmLayout);
*/
        /*inicializarListaVacantes();
        inicializarAdaptador();*/

        //srlRefresh = (SwipeRefreshLayout) findViewById(R.id.srlRefresh);
        /*srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescar();
            }
        });*/
        //finish();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// Replace the contents of the container with the new fragment
        ft.replace(R.id.av_flVacantes, new VacantesFragment());
// or ft.add(R.id.your_placeholder, new FooFragment());
// Complete the changes added above
        ft.commit();
    }

    private void refrescar() {
        Intent intent2 = new Intent(this, VacanteActivity.class);
        startActivity(intent2);
        srlRefresh.setRefreshing(false);
    }
    /*presenter
        public void inicializarListaVacantes(){
            arrVacantes = new ArrayList<Vacantes>();
            arrVacantes.add(new Vacantes("Desarrollador web", "77777777", "sisma@inventado.com", "Experiencia en programación orientada a objetos"));
            arrVacantes.add(new Vacantes("Tester", "88888888", "tic@inventado.com", "Desarrollador junior para realizar pruebas en sistemas web"));
            arrVacantes.add(new Vacantes("Desarrollador de aplicaciones móviles", "99999999", "appmovil@inventado.com", "Desarrollo con iOS"));
            arrVacantes.add(new Vacantes("Adminstrador de servidores", "66666666", "desapp@inventado.com", "Experiencia de 8 años"));
        }

        public void inicializarAdaptador(){
           VacanteAdapter vaAdaptador = new VacanteAdapter(arrVacantes, this);
            rvListaVacantes.setAdapter(vaAdaptador);
        }
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opcion_vacante, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.movAgregar:
                refrescar();
                break;
            case R.id.movTodasVacantes:
                refrescar();
                break;
            case R.id.movVacantesDisponibles:
                refrescar();
                break;
            case R.id.movVacantesOcupadas:
                refrescar();
                break;
            case R.id.movVacantesSinPostulantes:
                refrescar();
                break;
            case R.id.moAcerca:
                mostrarInformativo("acerca");
                break;
            case R.id.moCreditos:
                mostrarInformativo("creditos");
                break;
            case R.id.movAvRefresh:
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

    /*@Override
    public void generarLlv() {
        LinearLayoutManager llmLayout = new LinearLayoutManager(this);
        llmLayout.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glmLayout = new GridLayoutManager(this, 2);
        rvListaVacantes.setLayoutManager(llmLayout);
    }

    @Override
    public VacanteAdapter generarAdapter() {
        VacanteAdapter vaAdaptador = new VacanteAdapter(arrVacantes, this);
        return vaAdaptador;
    }

    @Override
    public void inicializarAdaptador(VacanteAdapter vaAdaptador) {
        rvListaVacantes.setAdapter(vaAdaptador);
    }*/
}