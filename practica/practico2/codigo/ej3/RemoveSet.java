package practica2.ej3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveSet<E> implements Set<E> {
    private int cantidadRemovidos = 0;
    private Set<E> set;

    public RemoveSet(){
        this.set = new HashSet<>();
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return set.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return set.add(e);
    }

    @Override
    public boolean remove(Object o) {
        this.cantidadRemovidos++;
        return set.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return set.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int preCall = this.set.size();
        boolean ok = set.retainAll(c);
        int postCall = 0;
        if (ok){
            postCall = preCall - this.set.size();
        }
        this.cantidadRemovidos += postCall;
        return ok;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        //Funcionaría igual que el anterior xd me da paja
        return this.set.removeAll(c);
    }

    @Override
    public void clear() {
        this.set.clear();
    }
}
