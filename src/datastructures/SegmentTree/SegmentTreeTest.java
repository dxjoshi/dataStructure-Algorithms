package datastructures.SegmentTree;

import org.junit.Test;

public class SegmentTreeTest {

    @Test
    public void testSegmentTree() {
        int[] A = new int[] { 18, 17, 13, 19, 15, 11, 20 }; // the original array
        SegmentTree st = new SegmentTree(A);

        System.out.printf("              idx    0, 1, 2, 3, 4,  5, 6\n");
        System.out.printf("              A is {18,17,13,19,15, 11,20}\n");
        System.out.printf("RMQ(1, 3) = %d\n", st.rmq(1, 3)); // answer = index 2
        System.out.printf("RMQ(4, 6) = %d\n", st.rmq(4, 6)); // answer = index 5
        System.out.printf("RMQ(3, 4) = %d\n", st.rmq(3, 4)); // answer = index 4
        System.out.printf("RMQ(0, 0) = %d\n", st.rmq(0, 0)); // answer = index 0
        System.out.printf("RMQ(0, 1) = %d\n", st.rmq(0, 1)); // answer = index 1
        System.out.printf("RMQ(0, 6) = %d\n", st.rmq(0, 6)); // answer = index 5

        System.out.printf("              idx    0, 1, 2, 3, 4,  5, 6\n");
        System.out.printf("Now, modify A into {18,17,13,19,15,100,20}\n");
        st.update_point(5, 100);                  // update A[5] from 11 to 100
        System.out.printf("These values do not change\n");
        System.out.printf("RMQ(1, 3) = %d\n", st.rmq(1, 3));               // 2
        System.out.printf("RMQ(3, 4) = %d\n", st.rmq(3, 4));               // 4
        System.out.printf("RMQ(0, 0) = %d\n", st.rmq(0, 0));               // 0
        System.out.printf("RMQ(0, 1) = %d\n", st.rmq(0, 1));               // 1
        System.out.printf("These values change\n");
        System.out.printf("RMQ(0, 6) = %d\n", st.rmq(0, 6));            // 5->2
        System.out.printf("RMQ(4, 6) = %d\n", st.rmq(4, 6));            // 5->4
        System.out.printf("RMQ(4, 5) = %d\n", st.rmq(4, 5));            // 5->4
    }
}
