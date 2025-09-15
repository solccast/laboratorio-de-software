package practica3.ej5;

import practica3.ej1.Stack;

import java.util.Iterator;

public class StackTest {
    public static void main(String[] args) {
        String s1 = "Prueba 1";
        String s2 = "Prueba 2";
        String s3 = "Prueba 3";

        practica3.ej1.Stack stack = new Stack();
        stack.push(s1);
        stack.push(s2);
        stack.push(s3);

        for (Object str: stack){
            System.out.println((String) str);
        }

        for (Object str: stack){
            System.out.println((String) str);
        }

        System.out.println("Obteniendo el iterador...");
        Iterator<String> itr = stack.iterator();
        while (itr.hasNext()){
            System.out.println((String)itr.next());
        }

        System.out.println("Segunda iteración...");
        Iterator<String> itr2 = stack.iterator();
        while (itr2.hasNext()){
            System.out.println((String)itr2.next());
        }

    }
}
