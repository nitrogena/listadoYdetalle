package mx.nitrogena.coursera.aplicacion;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    TextView tvNombre;
    TextView tvTelefono;
    TextView tvCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String telefono = parametros.getString("telefono");
        String correo = parametros.getString("correo");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTel);
        tvCorreo = (TextView) findViewById(R.id.tvCorreo);

        Log.i("telefono", telefono);

        tvNombre.setText(nombre);
        tvCorreo.setText(correo);
        tvTelefono.setText(telefono);


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
}
