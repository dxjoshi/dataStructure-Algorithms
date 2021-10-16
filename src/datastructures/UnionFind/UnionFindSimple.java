package datastructures.UnionFind;

/*
* From Leetcode Graph learning cards
* */
public class UnionFindSimple implements UnionFind {

    int[] root;

    public UnionFindSimple(int size) {
        this.root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    @Override
    public String name() {
        return "UnionFind Naive implementation";
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootX] = rootY;
        }
    }

    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }
}
