package mx.nitrogena.coursera.aplicacion;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import mx.nitrogena.coursera.aplicacion.Datos.Postulantes;

public class ListaActivity extends AppCompatActivity {

    SwipeRefreshLayout srlRefresh;
    Adapter adaptador;

    ListView lvPostulantes;

    ArrayList<Postulantes> postulantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        postulantes = new ArrayList<Postulantes>();
        postulantes.add(new Postulantes("Nidia Orduña", "77777777", "nidia.iof@gmail.com"));
        postulantes.add(new Postulantes("David Chávez", "88888888", "david@inventado.com"));
        postulantes.add(new Postulantes("Luis Ezcurdia", "99999999", "luis@inventado.com"));
        postulantes.add(new Postulantes("Marduk Pérez", "66666666", "marduk@inventado.com"));

        ArrayList<String> nombresPostulantes = new ArrayList<>();
        for (Postulantes postulante: postulantes){
            nombresPostulantes.add(postulante.getNombre());
        }

        lvPostulantes = (ListView) findViewById(R.id.lv_postulantes);
        lvPostulantes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresPostulantes));

        lvPostulantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Explicitos: unir una pantalla a otra
                Intent intent = new Intent(ListaActivity.this, DetalleActivity.class);
                intent.putExtra("nombre", postulantes.get(i).getNombre());
                intent.putExtra("telefono", postulantes.get(i).getTelefono());
                intent.putExtra("correo", postulantes.get(i).getCorreo());

                startActivity(intent);
            }
        });

        srlRefresh = (SwipeRefreshLayout) findViewById(R.id.srlRefresh);


        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescar();
            }
        });
    }

    private void refrescar() {
        String[] arrPlanetas = getResources().getStringArray(R.array.arrPlanetas);
        lvPostulantes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrPlanetas));

        srlRefresh.setRefreshing(false);
    }
}
