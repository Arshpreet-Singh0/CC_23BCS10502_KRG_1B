import java.lang.reflect.Array;
import java.util.*;

public class Bellman_Ford {

    static class Edge {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    int V, E;
    Edge edge[];

    Bellman_Ford(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
    }

    void bellmanFord(int src) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int w = edge[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        for (int j = 0; j < E; j++) {
            int u = edge[j].src;
            int v = edge[j].dest;
            int w = edge[j].weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5; 
        int E = 8;

        Bellman_Ford graph = new Bellman_Ford(V, E);

        graph.edge[0] = new Edge(0, 1, -1);
        graph.edge[1] = new Edge(0, 2, 4);
        graph.edge[2] = new Edge(1, 2, 3);
        graph.edge[3] = new Edge(1, 3, 2);
        graph.edge[4] = new Edge(1, 4, 2);
        graph.edge[5] = new Edge(3, 2, 5);
        graph.edge[6] = new Edge(3, 1, 1);
        graph.edge[7] = new Edge(4, 3, -3);

        graph.bellmanFord(0);
    }
}