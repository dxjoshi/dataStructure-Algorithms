package datastructures.Queue;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
};

public class LinkedListBasedQueue {
    Node head;
    Node tail;
    int size;

    LinkedListBasedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // Function to check if the queue is empty.
    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int data) {

        // Increase the count of elements present in the List.
        size++;

        // Create a new node.
        Node newNode = new Node(data);

        // Check if the Queue is empty.
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // Push the element to the last of the queue.
        tail.next = newNode;
        tail = newNode;
        return;
    }

    int dequeue() {

        // Check if the queue is empty.
        if (isEmpty()) {
            return -1;
        }

        int ans = head.data;

        Node tmp = head;
        head = head.next;

        // If the queue is empty make the tail pointer null.
        if (head == null) {
            tail = null;
        }

        tmp = null;

        size--;

        return ans;
    }

    int front() {

        // Check if the queue is empty.
        if (isEmpty()) {
            return -1;
        }

        // Return the element at the front.
        return head.data;
    }

}

