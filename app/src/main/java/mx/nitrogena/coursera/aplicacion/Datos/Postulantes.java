package mx.nitrogena.coursera.aplicacion.Datos;

/**
 * Created by Nidia on 26/01/2017.
 */

public class Postulantes {
    String nombre;
    String telefono;
    String correo;

    public Postulantes(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
