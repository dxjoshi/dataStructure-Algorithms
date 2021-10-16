package datastructures.UnionFind;

/*
 * From Leetcode Graph learning cards
 * */
public class UnionFindWithPathCompression implements UnionFind{

    int[] root;

    public UnionFindWithPathCompression(int size) {
        this.root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootX] = rootY;
        }
    }

    // this recursive call will lead to path compression
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);       //root[5] = find(4) ->  root[4] = find(3) ->  root[3] = find(2) ->  root[2] = find(1) ->  root[1] = find(0)       5->4->3->2->1->0
    }

    @Override
    public String name() {
        return "UnionFindWithPathCompression";
    }

}
