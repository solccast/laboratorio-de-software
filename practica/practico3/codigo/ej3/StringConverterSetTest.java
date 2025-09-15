package practica3.ej3;

import java.util.Iterator;
import java.util.Set;

public class StringConverterSetTest {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan", "Perez");
        Persona p2 = new Persona("Tomas", "Rodriguez");
        Persona p3 = new Persona("Maria", "Mercedes");

        Set<Persona> set = new StringConverterSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        Iterator itr = set.iterator();

        while (itr.hasNext()) System.out.println(itr.next());
    }
}
