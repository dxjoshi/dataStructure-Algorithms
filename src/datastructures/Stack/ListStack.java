package datastructures.Stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListStack<T> implements Iterable<T>, Stack<T> {

    private List<T> list; java.util.Stack

    public ListStack() {
        this(null);
    }

    public ListStack(T element) {
        this.list = new LinkedList<>();
        if (element != null) {
            list.add(element);
        }
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
    public void push(T elem) {
        list.add(elem);
    }

    @Override
    public T pop() {
        return list.remove(list.size()-1);
    }

    @Override
    public T peek() {
        return list.get(list.size()-1);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
