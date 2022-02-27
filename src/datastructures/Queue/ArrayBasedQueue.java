package datastructures.Queue;

public class ArrayBasedQueue {
    int[] arr;
    int front, rear, size;
    ArrayBasedQueue() {
        arr = new int[10000];
        front = 0; rear = 0; size = 0;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int data) {
        arr[rear++] = data;
        size++;
    }

    int dequeue() {
        if (isEmpty())	return -1;
        int ele = arr[front++];
        size--;
        if (front == rear) {
            front = 0;
            rear = 0;
        }
        return ele;
    }

    int front() {
        return isEmpty() ? -1 : arr[front];
    }
}
