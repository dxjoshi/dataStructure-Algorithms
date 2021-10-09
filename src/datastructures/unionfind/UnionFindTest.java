package datastructures.unionfind;

import org.junit.Assert;

public class UnionFindTest {
    public static void main(String[] args) throws Exception {
        UnionFind uf = new UnionFindWithPathCompressionAndUnionByRank(10);
        test(uf);
    }

    public static void test (UnionFind uf) {
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        Assert.assertTrue("Should be true!!",uf.connected(1, 5)); // true
        Assert.assertTrue("Should be true!!",uf.connected(5, 7)); // true
        Assert.assertFalse("Should be false!!",uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        Assert.assertTrue("Should be true!!",uf.connected(4, 9)); // true
        System.out.printf(String.format("All TC passed for %s!!", uf.name()));

    }
}
