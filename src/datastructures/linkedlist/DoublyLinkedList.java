package datastructures.linkedlist;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {


    private static class Node<T> {
        T element;
        Node<T> prev;
        Node<T> next;

        public Node(T element) {
            this(element, null, null);
        }

        public Node(T element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    int size;
    Node<T> head, tail;

    public DoublyLinkedList() {

    }

    public int size() {
        return size;
    }

    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.element = null;
            trav.prev = trav.next =null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //by default adds at the end of the list
    public void add(T node) {
        addLast(node);
    }

    public void addAt(int index, T node) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Invalid index");

        if (index == 0) {
            addFirst(node);
            return;
        }

        if (index == size) {
            addLast(node);
            return;
        }

        Node<T> trav = head;
        for (int i = 0; i < index-1; i++) {
            trav = trav.next;
        }

        trav.next.prev = trav.next = new Node<T>(node, trav, trav.next);
        size++;
    }

    public void addLast(T node) {
        if (isEmpty()) {
            head = tail = new Node<T>(node, null,null);
        } else {
            tail.next = new Node<T>(node, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T node) {
        if (isEmpty()) {
            head = tail = new Node<T>(node, null, null);
        } else {
            head.prev = new Node<T>(node, null, head);
            head = head.prev;
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty List!!");
        return head.element;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty List!!");
        return tail.element;
    }

    public int indexOf(T node) {
        int index = 0;
        Node<T> trav = head;
        while(trav != null) {
            if (node == null) {
                if (trav.element == null) {
                    return index;
                }
            } else if (node.equals(trav.element)) {
                return index;
            }
            trav = trav.next;
            index++;
        }
        return -1;
    }

    public boolean contains(T node) {
        int index = indexOf(node);
        return index != -1;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Linked List is empty!!");
        T element = head.element;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        } else {
            head.prev = null;
        }
        return element;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Linked List is empty!!");
        T element = tail.element;
        tail = tail.prev;
        size--;
        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }
        return element;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid Index!!");
        if (index == 0) return removeFirst();
        if (index == size-1) return removeLast();

        Node<T> trav = head;
        for (int i = 0; i < index; i++) {
            trav = trav.next;
        }

        trav.prev.next = trav.next;
        trav.next.prev = trav.prev;
        T element = (T) trav.element;
        trav.element = null;
        trav = trav.next = trav.prev = null;
        size--;
        return element;
    }

    public boolean remove(T node) {
        int index = indexOf(node);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = (T) trav.element;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[ ");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.element);
            if (trav.next != null) {
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
