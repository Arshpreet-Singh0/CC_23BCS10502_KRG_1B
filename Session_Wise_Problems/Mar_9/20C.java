import java.util.*;

public class 20C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(0, 0));
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (current.weight > dist[current.node]) continue;
            for (Edge neighbor : graph.get(current.node)) {
                long newDist = dist[current.node] + neighbor.weight;
                if (newDist < dist[neighbor.node]) {
                    dist[neighbor.node] = newDist;
                    pq.add(new Edge(neighbor.node, (int)newDist));
                }
            }
        }

        if (dist[n - 1] == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        int curr = n - 1;
        int i = 0;
        int[] arr = new int[n];
        while(curr != 0){
            for(Edge edge : graph.get(curr)){
                if(edge.weight + dist[edge.node] == dist[curr]){
                    arr[i++] = curr + 1;
                    curr = edge.node;
                    break;
                }
            }
        }
        System.out.print(1 + " ");
        for(int a = n - 1; a>=0; a--){
            if(arr[a] != 0) System.out.print(arr[a] + " ");
        }
    }

    static class Edge {
        int node, weight;
        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}