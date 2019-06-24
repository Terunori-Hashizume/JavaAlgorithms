package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    private static int INF = Integer.MAX_VALUE;

    private int[] dst;
    private boolean[] done;
    private List<List<int[]>> nodes;
    private PriorityQueue<int[]> vertexQ;

    public Dijkstra(int n) {
        this.dst = new int[n];
        this.done = new boolean[n];
        this.nodes = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            nodes.add(new ArrayList<>());
        }
        this.vertexQ = new PriorityQueue<>((u, v) -> u[1] - v[1]);
    }

    private void init() {
        Arrays.fill(dst, INF);
        Arrays.fill(done, false);
        vertexQ.clear();
    }

    public int getDistance(int node) {
        return dst[node] < INF ? dst[node] : -1;
    }

    public void setDistances(int sp) {
        init();

        dst[sp] = 0;
        vertexQ.add(new int[] { sp, dst[sp] });

        while (!vertexQ.isEmpty()) {
            int[] cur = vertexQ.poll();
            int u = cur[0];
            done[u] = true;

            if (dst[u] < cur[1])
                continue;

            for (int[] node : nodes.get(u)) {
                int v = node[0];
                if (done[v])
                    continue;
                if (dst[v] > dst[u] + node[1]) {
                    dst[v] = dst[u] + node[1];
                    vertexQ.add(new int[] { v, dst[v] });
                }
            }
        }
    }

    public void addEdge(int u, int v, int l) {
        nodes.get(u).add(new int[] { v, l });
    }
}