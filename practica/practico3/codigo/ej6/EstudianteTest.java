package practica3.ej6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EstudianteTest {
    public static void main(String[] args) {
        // Creamos 5 listas de materias aprobadas para cada estudiante
        List<String> materias1 = Arrays.asList("Matemática I", "Algoritmos", "Inglés I");
        List<String> materias2 = Arrays.asList("Programación II", "Bases de Datos");
        List<String> materias3 = Arrays.asList("Física I", "Química", "Sociología");
        List<String> materias4 = Arrays.asList("Matemática Discreta", "Álgebra", "Análisis I", "Programación I");
        List<String> materias5 = Arrays.asList("Estadística", "Economía");

        // Creamos los estudiantes
        Estudiante e1 = new Estudiante("García", "Ana", 20, "A123", materias1);
        Estudiante e2 = new Estudiante("Pérez", "Luis", 22, "B456", materias2);
        Estudiante e3 = new Estudiante("Martínez", "Sofía", 19, "C789", materias3);
        Estudiante e4 = new Estudiante("López", "Carlos", 21, "D012", materias4);
        Estudiante e5 = new Estudiante("Fernández", "Ana", 23, "E345", materias5);

        // Guardarlos en una lista (opcional)
        Estudiante[] estudiantes = {e1, e2, e3, e4, e5};


        System.out.println("Listado de estudiantes sin orden-----------");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }

        System.out.println("Uso de ordenador: cantidad de materias aprobadas");
        Arrays.sort(estudiantes, new Comparator<Estudiante>(){
            @Override
            public int compare(Estudiante e1, Estudiante e2) {
                return Integer.compare(e1.cantidadMateriasAprobadas(), e2.cantidadMateriasAprobadas());
            }
        });

        for (Estudiante e: estudiantes){
            System.out.println(e.toString());
        }

        System.out.println("Uso de ordenador: edad en forma descendente");
        Arrays.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                return Integer.compare(o2.getEdad(), o1.getEdad());
            }
        });
        for (Estudiante e: estudiantes){
            System.out.println(e.toString());
        }

        System.out.println("Uso de ordenador: legajo en forma ascendente");
        Arrays.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                return o1.getLegajo().compareTo(o2.getLegajo());
            }
        });
        for (Estudiante e: estudiantes){
            System.out.println(e.toString());
        }

        System.out.println("Uso de ordenador: nombre y apellido en forma descendente");
        Arrays.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                int aux = compararNombre(o1, o2)*(-1);
                if (aux == 0){
                    return compararApellido(o1, o2)*(-1);
                } else return aux;
            }

            private int compararApellido(Estudiante e1, Estudiante e2){
                return e1.getApellido().compareTo(e2.getApellido());
            }
            private int compararNombre(Estudiante e1, Estudiante e2){
                return e1.getNombre().compareTo(e2.getNombre());
            }
        });

        for (Estudiante e: estudiantes){
            System.out.println(e.toString());
        }
    }
}
