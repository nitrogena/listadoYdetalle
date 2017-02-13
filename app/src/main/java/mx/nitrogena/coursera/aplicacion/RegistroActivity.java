package mx.nitrogena.coursera.aplicacion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmpresa;
    private EditText etSector;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        /*btnRegistrar = (Button) findViewById(R.id.ar_btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generarArchivo(view);
            }
        });*/

        findViewById(R.id.ar_btnRegistrar).setOnClickListener(this);
        findViewById(R.id.ar_btnLimpiar).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.ar_btnRegistrar:
                generarArchivo(view);
                break;
            case R.id.ar_btnLimpiar:
                limparCampos(view);
                break;
        }
    }

    public void limparCampos(View view){
        etEmpresa = (EditText) findViewById(R.id.ar_etEmpresa);
        etSector = (EditText) findViewById(R.id.ar_etSector);
        etEmpresa.setText("");
        etSector.setText("");
    }

    public void  generarArchivo(View view){
        try{
            etEmpresa = (EditText) findViewById(R.id.ar_etEmpresa);
            etSector = (EditText) findViewById(R.id.ar_etSector);
            String strEmpresa = etEmpresa.getText().toString();
            String strSector = etSector.getText().toString();
            String strEspacio = " ";

            String strToken = "tk1:" +strEmpresa+ "tk2:" + strSector;

            FileOutputStream fosFileOS = null;
            fosFileOS = openFileOutput("RegistroArchivo.txt", Context.MODE_APPEND);
            fosFileOS.write(strEmpresa.getBytes());
            fosFileOS.write(strEspacio.getBytes());
            fosFileOS.write(strSector.getBytes());
            fosFileOS.write(strEspacio.getBytes());
            fosFileOS.close();



            //SharedPreferences spVisto = getSharedPreferences("Visto", Context.MODE_PRIVATE);
            SharedPreferences spVisto = getSharedPreferences("Autenticacion", Context.MODE_APPEND);
            SharedPreferences.Editor editor = spVisto.edit();

            editor.putString("empresa", strEmpresa);
            editor.putString("sector", strSector);
            editor.putString("token", strToken);
            editor.commit();
            Toast.makeText(this, R.string.ra_mensaje1, Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, R.string.ra_mensaje2, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistroActivity.this, VacanteActivity.class);
            startActivity(intent);

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, R.string.ra_mensajeE, Toast.LENGTH_SHORT).show();
        }
    }



    public void mostrarPreferencia(){

        //LE HACE FALTA SU BOTON MOSTRAR PREFERENCIA
        SharedPreferences spVisto = getSharedPreferences("Visto", Context.MODE_PRIVATE);
        String strEmpresa = spVisto.getString("empresa", "No existe empresa");
        String strSector = spVisto.getString("sector", "No existe sector") ;

        TextView tvDesc = (TextView) findViewById(R.id.ar_tvDesc);

        String strValores = "\nEmpresa: " +strEmpresa+ "\nSector: " + strSector;

        tvDesc.setText(strValores);

    }
}
