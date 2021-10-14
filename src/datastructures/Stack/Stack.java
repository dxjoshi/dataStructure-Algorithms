package datastructures.Stack;

public interface Stack<T> {
    // return the number of elements in the Stack
    public int size();

    // return if the Stack is empty
    public boolean isEmpty();

    // push the element on the Stack
    public void push(T elem);

    // pop the element off the Stack
    public T pop();

    public T peek();
}