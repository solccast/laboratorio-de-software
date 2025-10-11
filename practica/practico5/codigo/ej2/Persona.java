package practica5.ej2;

@Archivo(name="prueba_persona.txt")
public class Persona {
    @AlmacenarAtributo
    private String nombre;
    private String apellido;
    @AlmacenarAtributo
    private int edad;

    public Persona(String apellido, int edad, String nombre) {
        this.apellido = apellido;
        this.edad = edad;
        this.nombre = nombre;
    }

    public Persona(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
