package datastructures.Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedQueue<T> implements Iterable<T>, Queue<T> {

    private List<T> list;

    public LinkedQueue() {
        this(null);
    }

    public LinkedQueue(T element) {
        this.list = new LinkedList<>();
        if (element != null) {
            list.add(element);
        }
    }

    @Override
    public void offer(T elem) {
        list.add(elem);
    }

    @Override
    public T poll() {
        T element = list.get(0);
        list.remove(0);
        return element;
    }

    @Override
    public T peek() {
        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
