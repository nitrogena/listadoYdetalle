package mx.nitrogena.coursera.aplicacion.vacantes;

import java.util.ArrayList;

import mx.nitrogena.coursera.aplicacion.Adaptadores.VacanteAdapter;
import mx.nitrogena.coursera.aplicacion.Datos.Vacantes;

/**
 * Created by USUARIO on 14/02/2017.
 */

public interface InterfaceVacante {
    public void generarLlv();

    public VacanteAdapter generarAdapter(ArrayList<Vacantes> arrLstVacantes);

    public void inicializarAdaptador(VacanteAdapter vaVacante);

}
