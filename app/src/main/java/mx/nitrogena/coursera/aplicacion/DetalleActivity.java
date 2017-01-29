package mx.nitrogena.coursera.aplicacion;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class DetalleActivity extends AppCompatActivity {

    TextView tvNombre;
    TextView tvTelefono;
    TextView tvCorreo;
    ImageView ivFoto;

    ImageButton ibContactar;
    ImageButton ibOcultar;
    ImageButton ibPreguntar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String telefono = parametros.getString("telefono");
        String correo = parametros.getString("correo");


        int foto = parametros.getInt("foto");


        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTel);
        tvCorreo = (TextView) findViewById(R.id.tvCorreo);

          ivFoto = (ImageView) findViewById(R.id.ivFoto);

               Log.i("telefono", telefono);

        tvNombre.setText(nombre);
        tvCorreo.setText(correo);
        tvTelefono.setText(telefono);

        ivFoto.setImageResource(foto);

        consultar();





    }

    public void llamarTel(View view) {
        String telefono = tvTelefono.getText().toString();
        //Intent implicito
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Log.i("telefonoLlamar", telefono);
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));

    }

    public void enviarCorreo(View view){
        String correo = tvCorreo.getText().toString();
        Intent itCorreo = new Intent((Intent.ACTION_SEND));
        itCorreo.setData(Uri.parse("mailto:"));
        itCorreo.putExtra(Intent.EXTRA_EMAIL, correo);
        itCorreo.setType("message/rfc822");
        startActivity(Intent.createChooser(itCorreo, "Correo-e"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent itKd = new Intent(this, ListaActivity.class);
            startActivity(itKd);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void consultar() {
        ibContactar = (ImageButton) findViewById(R.id.ibContactar);
        ibOcultar = (ImageButton) findViewById(R.id.ibOcultar);
        ibPreguntar = (ImageButton) findViewById(R.id.ibPreguntar);

        ibContactar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(DetalleActivity.this, getResources().getString(R.string.da_contactar), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DetalleActivity.this, ListaActivity.class);
                startActivity(intent);


            }
        });
    }

}

