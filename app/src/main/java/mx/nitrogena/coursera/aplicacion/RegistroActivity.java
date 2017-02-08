package mx.nitrogena.coursera.aplicacion;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class RegistroActivity extends AppCompatActivity {

    private EditText etEmpresa;
    private EditText etSector;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);
        btnRegistrar = (Button) findViewById(R.id.ar_btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generarArchivo(view);
            }
        });
    }

    public void  generarArchivo(View view){

        try{

        etEmpresa = (EditText) findViewById(R.id.ar_etEmpresa);
        etSector = (EditText) findViewById(R.id.ar_etSector);


            String strEmpresa = etEmpresa.getText().toString();
            String strSector = etSector.getText().toString();
            String strEspacio = " ";

            FileOutputStream fosFileOS = null;
            fosFileOS = openFileOutput("RegistroArchivo.txt", Context.MODE_APPEND);
            fosFileOS.write(strEmpresa.getBytes());
            fosFileOS.write(strEspacio.getBytes());
            fosFileOS.write(strSector.getBytes());
            fosFileOS.write(strEspacio.getBytes());
            fosFileOS.close();

            Toast.makeText(this, R.string.ra_mensaje1, Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, R.string.ra_mensajeE, Toast.LENGTH_SHORT).show();
        }
    }
}
