package practica3.ej6;

import java.util.List;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;
    private String legajo;
    private List<String> materiasAprobadas;

    public Estudiante(String apellido, String nombre, int edad, String legajo, List<String> materiasAprobadas) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.legajo = legajo;
        this.materiasAprobadas = materiasAprobadas;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", legajo='" + legajo + '\'' +
                ", cantidadAprobadas='"+ materiasAprobadas.size()+ '\''+
                '}';
    }

    public int cantidadMateriasAprobadas(){
        return this.materiasAprobadas.size();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
