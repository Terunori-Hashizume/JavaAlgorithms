package graph;

public class UnionFind {
    private int[] rank, parent, size;

    public UnionFind(int n) {
        this.rank = new int[n];
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    public int getSize(int x) {
        return size[root(x)];
    }

    public boolean same(int x, int y) {
        return root(x) == root(y);
    }

    public void unite(int x, int y) {
        int a = root(x);
        int b = root(y);

        if (rank[a] < rank[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        parent[b] = a;
        if (rank[a] == rank[b])
            rank[a]++;

        size[a] += size[b];
    }

    public int root(int x) {
        if (parent[x] != x) {
            parent[x] = root(parent[x]);
        }
        return parent[x];
    }
}