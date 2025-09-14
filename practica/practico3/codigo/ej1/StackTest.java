package practica3;

import java.util.Iterator;

public class StackTest {
    public static void main(String[] args) {
        String s1 = "Prueba 1";
        String s2 = "Prueba 2";
        String s3 = "Prueba 3";

        Stack stack = new Stack();
        stack.push(s1);
        stack.push(s2);
        stack.push(s3);

        /* ---------Punto 1.a---------
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
         */

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

        /* ------ Punto 3d --------
        Iterator<String> itr3 = stack.new StackIterator();
        while(itr3.hasNext()){
            System.out.println(itr3.next());
        }
         */

    }
}
