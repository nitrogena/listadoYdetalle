package mx.nitrogena.coursera.aplicacion;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consultar();

        Toast.makeText(this, getResources().getString(R.string.am_onCreate), Toast.LENGTH_SHORT).show();
    }

    public void consultar(){
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnConsultar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, getResources().getString(R.string.am_onStart), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, getResources().getString(R.string.am_onResume), Toast.LENGTH_SHORT).show();
    }

    //los de arriba está corriendo

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, getResources().getString(R.string.am_onRestart), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, getResources().getString(R.string.am_onPause), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, getResources().getString(R.string.am_onStop), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, getResources().getString(R.string.am_onDestroy), Toast.LENGTH_SHORT).show();
    }
}
