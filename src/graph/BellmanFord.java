package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    private static int INF = Integer.MAX_VALUE;

    private int[] dst;
    private List<Edge> edges;

    private class Edge {
        int src;
        int dest;
        int weight;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public BellmanFord(int n) {
        this.dst = new int[n];
        this.edges = new ArrayList<>();
    }

    public boolean hasNegativeCycle() {
        for (Edge e : edges) {
            int u = e.src;
            int v = e.dest;
            int w = e.weight;

            if (dst[u] != INF && dst[u] + w < dst[v]) {
                return true;
            }
        }
        return false;
    }

    public int getDistance(int node) {
        return dst[node];
    }

    public void setDistances(int sp) {
        Arrays.fill(dst, INF);
        dst[sp] = 0;

        for (int i = 0; i < dst.length; ++i) {
            for (Edge e : edges) {
                int u = e.src;
                int v = e.dest;
                int w = e.weight;

                if (dst[u] != INF && dst[u] + w < dst[v]) {
                    dst[v] = dst[u] + w;
                }
            }
        }
    }

    public void addEdge(int u, int v, int w) {
        edges.add(new Edge(u, v, w));
    }
}
