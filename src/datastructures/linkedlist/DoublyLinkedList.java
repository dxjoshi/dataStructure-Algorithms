package datastructures.linkedlist;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {


    /*
    *
    * Node object
    * constructors -- default
    * clear
    * size
    * isEmpty
    * add
    * addFirst
    * addLast
    * peekFirst
    * peekLast
    * removeFirst
    * removeLast
    * private remove(node)
    * removeAt(index)
    * remove(Object)
    * indexOf
    * contains
    * iterator
    * toString
    *
    * */

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}
