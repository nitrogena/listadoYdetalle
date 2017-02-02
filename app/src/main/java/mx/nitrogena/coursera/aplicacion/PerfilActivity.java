package mx.nitrogena.coursera.aplicacion;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import mx.nitrogena.coursera.aplicacion.Adaptadores.PageAdapter;
import mx.nitrogena.coursera.aplicacion.Fragments.CurriculumFragment;
import mx.nitrogena.coursera.aplicacion.Fragments.PerfilFragment;

public class PerfilActivity extends AppCompatActivity {

    //private Toolbar tbToolbar;
    private TabLayout tlTab;
    private ViewPager vpPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Toolbar actionBar = (Toolbar) findViewById(R.id.abPerfil);
        setSupportActionBar(actionBar);

        //tbToolbar = (Toolbar) findViewById(R.id.tbToolbar);

        tlTab = (TabLayout) findViewById(R.id.tlTab);
        vpPerfil = (ViewPager) findViewById(R.id.vpPerfil);

        setUpViewPager();

    }

    //para usar el viewpager
    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> arrLstFragment = new ArrayList<>();
        arrLstFragment.add(new PerfilFragment());
        arrLstFragment.add(new CurriculumFragment());
        return arrLstFragment;
    }

    //para usar el viewpager
    private void setUpViewPager() {
        vpPerfil.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tlTab.setupWithViewPager(vpPerfil);
        tlTab.getTabAt(0).setIcon(R.drawable.ic_profile);
        tlTab.getTabAt(1).setIcon(R.drawable.ic_curriculum);

    }

    public void verMenuPopup(View view) {
        ImageView ivFoto = (ImageView) view.findViewById(R.id.ivFoto);
        PopupMenu pmPopupMenu = new PopupMenu(this, ivFoto);
        pmPopupMenu.getMenuInflater().inflate(R.menu.menu_popup, pmPopupMenu.getMenu());

        pmPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mpuEditarFoto:
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.mpu_Editar), Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });


        pmPopupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opcion_perfil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mopEditar:
                //refrescar();
                break;
            case R.id.mopEditarFoto:
                //refrescar();
                break;
            case R.id.mopVerCurriculum:
                //refrescar();
                break;

            case R.id.moAcerca:
                mostrarInformativo("acerca");
                break;
            case R.id.moCreditos:
                mostrarInformativo("creditos");
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
