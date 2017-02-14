package mx.nitrogena.coursera.aplicacion.BD;

import android.content.Context;

import java.util.ArrayList;

import mx.nitrogena.coursera.aplicacion.Datos.Vacantes;

/**
 * Created by USUARIO on 14/02/2017.
 */

public class InteractorVacante {
    private Context contexto;
    public InteractorVacante(Context contexto){
        this.contexto = contexto;

    }

    public ArrayList<Vacantes> obtenerDatos(){
        ArrayList<Vacantes>arrVacantes = new ArrayList<Vacantes>();
        arrVacantes.add(new Vacantes("Desarrollador web", "77777777", "sisma@inventado.com", "Experiencia en programación orientada a objetos"));
        arrVacantes.add(new Vacantes("Tester", "88888888", "tic@inventado.com", "Desarrollador junior para realizar pruebas en sistemas web"));
        arrVacantes.add(new Vacantes("Desarrollador de aplicaciones móviles", "99999999", "appmovil@inventado.com", "Desarrollo con iOS"));
        arrVacantes.add(new Vacantes("Adminstrador de servidores", "66666666", "desapp@inventado.com", "Experiencia de 8 años"));
        return arrVacantes;
    }
}
