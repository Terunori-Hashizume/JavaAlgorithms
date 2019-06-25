package graph;

public class FloydWarshall {
    private static int INF = Integer.MAX_VALUE;
    private int size;
    private int[][] d;

    public FloydWarshall(int n) {
        this.size = n;
        this.d = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                d[i][j] = i == j ? 0 : INF;
    }

    public void addEdge(int src, int dest, int weight) {
        d[src][dest] = weight;
    }

    public int getDistance(int src, int dest) {
        return d[src][dest];
    }

    public void setDistances() {
        for (int k = 0; k < size; ++k) {
            for (int i = 0; i < size; ++i) {
                if (d[i][k] == INF) continue;
                for (int j = 0; j < size; ++j) {
                    if (d[k][j] == INF) continue;
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }

    public boolean hasNegativeCycle() {
        for (int i = 0; i < size; ++i) {
            if (d[i][i] < 0) return true;
        }
        return false;
    }
}