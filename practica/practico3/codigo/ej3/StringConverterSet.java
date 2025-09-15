package practica3.ej3;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringConverterSet<E> extends AbstractSet<E> implements Set<E>{

    private Set<E> set;

    public StringConverterSet(){
        this.set = new HashSet<>();
    }

    @Override
    public Iterator iterator() {
        return new IteratorStringAdapter();
    }

    @Override
    public int size() {
        return this.set.size();
    }

    @Override
    public boolean add(E e) {
        return this.set.add(e);
    }

    private class IteratorStringAdapter implements Iterator{

        private Iterator<E> itr = set.iterator();

        @Override
        public boolean hasNext() {
            return itr.hasNext();
        }

        @Override
        public String next() {
            return itr.next().toString();
        }

    }
}
