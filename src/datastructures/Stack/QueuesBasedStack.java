package datastructures.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class QueuesBasedStack {
    Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();

    public QueuesBasedStack() {

    }

    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty())    {
            q2.offer(q1.poll());
        }
        while(!q2.isEmpty())    {
            q1.offer(q2.poll());
        }
    }

    public int pop() {
        if (empty()) return -1;
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.size()==0;
    }

}
