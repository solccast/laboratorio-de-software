package practica3.ej5;
import java.util.Iterator;

public class Stack implements Iterable<Object>{
    private java.util.ArrayList<Object> items;

    public Stack(){
        this.items = new java.util.ArrayList<>();
    }

    public void push (Object item){
        this.items.add(item);
    }

    public Object pop(){
        return this.items.removeLast();
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    public Iterator<Object> iterator(){
        return new Iterator<Object>(){
            private int indice = 0;
            @Override
            public boolean hasNext() {
                return indice < items.size();
            }

            @Override
            public Object next() {
                Object next = items.get(indice);
                indice++;
                return next;
            }
        };
    }
}
