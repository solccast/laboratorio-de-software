package practica2.ej3;

import java.util.Collection;
import java.util.HashSet;

public class HashSetAgregadosB<E> {
    private int cantidadAgregados = 0;
    private HashSet<E> hashSet;

    public HashSetAgregadosB(){
        this.hashSet = new HashSet<E>();
    }

    public boolean add(E e){
        cantidadAgregados++;
        return this.hashSet.add(e);
    }

    public boolean addAll(Collection<? extends E> c){
        cantidadAgregados += c.size();
        return this.hashSet.addAll(c);
    }

    public int getCantidadAgregados(){
        return cantidadAgregados;
    }
}
