package datastructures.DynamicArray;

import java.util.Arrays;
import java.util.Iterator;

/*
*  Generic Implementation of dynamic array
*
* */
@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private static int INIT_CAPACITY = 16;
    private int capacity;             // contains current maximum capacity of the the array
    private int size;               // contains the number of elements present in the array currently
    private T[] arr;                // the data structure that holds the underlying elements


    public DynamicArray() {
        this(INIT_CAPACITY);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity should not be less than zero!!");
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        if (size+1 >= capacity) {
            resize();
        }
        arr[size++] = element;
    }

    private void resize() {
        if (capacity == 0) {
            capacity = 1;
        } else {
            capacity *= 2;
        }
        T[] newarr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newarr[i] = arr[i];
        }
        arr = newarr;
    }

    public boolean contains(T element) {
        boolean isPresent = false;
        for (int i = 0; i <size ; i++) {
            if (arr[i] == element) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

    public void clear() {
        for (int i = 0; i <size ; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index position!!");
        if (size+1 >= capacity) {
            resize();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index position!!");
        return arr[index];
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index position!!");
        T element = arr[index];
        T[] newarr = (T[]) new Object[size-1];
        for (int i = 0, j = 0; i < size-1; i++) {
            if (i == index) {
                j = 1;
            }
            newarr[i] = arr[i+j];
        }
        arr = newarr;
        capacity = --size;
        return element;
    }

    public boolean remove(Object element) {
        int index = indexOf(element);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element == null) {
                if (arr[i] == null) return i;
            } else if (element.equals(arr[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pos = 0;
            @Override
            public boolean hasNext() {
                return pos+1 < size;
            }

            @Override
            public T next() {
                return arr[pos++];
            }
        };
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DynamicArray{");
        sb.append("size=").append(size);
        sb.append(", arr=").append(Arrays.toString(arr));
        sb.append('}');
        return sb.toString();
    }
}
