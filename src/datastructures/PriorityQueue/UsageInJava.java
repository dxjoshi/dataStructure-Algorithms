package datastructures.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UsageInJava {
    public static void main(String[] args) {
        // by default a min heap is created by the below collection
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(1);
        minHeap.add(5);
        minHeap.add(11);
        System.out.println(minHeap.peek()); // 1
        System.out.println("Min Heap: "+minHeap);
        // passing a reverse order comparator gives a maxHeap impl
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(1);
        maxHeap.add(5);
        maxHeap.add(11);
        System.out.println(maxHeap.peek());// 11
        System.out.println("Max Heap: " + maxHeap);

    }
}
