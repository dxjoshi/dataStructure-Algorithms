package datastructures.unionfind;

public interface UnionFind {
    String name();
    void union(int x, int y);
    int find(int x);
    boolean connected(int x, int y);
}
