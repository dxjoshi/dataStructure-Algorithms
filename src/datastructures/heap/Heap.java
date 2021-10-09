package datastructures.heap;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(1);
        minHeap.remove();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    }
}
