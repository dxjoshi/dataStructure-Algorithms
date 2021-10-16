package datastructures.UnionFind;

/*
 * From Leetcode Graph learning cards
 * */
public class UnionFindWithPathCompressionAndUnionByRank implements UnionFind {

    int[] root, rank;

    public UnionFindWithPathCompressionAndUnionByRank(int size) {
        this.root = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    // union by rank optimization
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
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
        return "UnionFindWithPathCompressionAndUnionByRank";
    }

}
