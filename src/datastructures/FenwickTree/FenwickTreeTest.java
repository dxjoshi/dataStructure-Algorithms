package datastructures.FenwickTree;

import org.junit.Assert;
import org.junit.Test;

public class FenwickTreeTest {


    @Test
    public void testFenwickTreeRangeQueryPointUpdate() {
        // The values array must be one based
        long[] values = {0,1,2,2,4};
        //               ^ first element does not get used

        FenwickTreeRangeQueryPointUpdate ft = new FenwickTreeRangeQueryPointUpdate(values);

        Assert.assertTrue(ft.sum(1, 4)==9); // 9, sum all numbers in interval [1, 4] in O(log(n))
        ft.add(3, 1); // Adds +1 to index 3.
        Assert.assertTrue(ft.sum(1, 4) == 10); // 10, sum all numbers in interval [1, 4]
        ft.set(4, 0); // Set index 4  to have value zero.
        Assert.assertTrue(ft.sum(1, 4) == 6); // 6, sum all numbers in interval [1, 4]
        Assert.assertTrue(ft.get(2) == 2);    // 2, Get the value at index 2, this is the same as .sum(2, 2)
    }

    @Test
    public void testFenwickTreeRangeUpdatePointQuery() {
        // The values array must be one based
        long[] values = {0,+1,-2,+3,-4,+5,-6};
        //               ^ first element does not get used

        FenwickTreeRangeUpdatePointQuery ft = new FenwickTreeRangeUpdatePointQuery(values);

        ft.updateRange(1, 4, 10); // Add +10 to interval [1, 4] in O(log(n))
        Assert.assertTrue(ft.get(1) == 11);  // 11
        Assert.assertTrue(ft.get(4) ==  6);  // 6
        Assert.assertTrue(ft.get(5) ==  5);  // 5
        ft.updateRange(3, 6, -20); // Add -20 to interval [1, 4] in O(log(n))
        Assert.assertTrue(ft.get(3) ==  -7);  // -7
        Assert.assertTrue(ft.get(4) ==  -14);  // -14
        Assert.assertTrue(ft.get(5) ==  -15);  // -15
    }

}
