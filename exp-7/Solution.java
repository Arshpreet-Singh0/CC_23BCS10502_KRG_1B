package exp-7;

import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k = k + 1;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] minPrice = new int[n];
        int[] minSteps = new int[n];
        Arrays.fill(minPrice, Integer.MAX_VALUE);
        Arrays.fill(minSteps, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, src}); // price, steps, node

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int price = cur[0];
            int steps = cur[1];
            int node = cur[2];

            if (price >= minPrice[node] && steps >= minSteps[node]) continue;
            if (node == dst) return price;
            if (steps == k) continue;

            minPrice[node] = Math.min(minPrice[node], price);
            minSteps[node] = Math.min(minSteps[node], steps);

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int flightPrice = next[1];
                pq.offer(new int[]{price + flightPrice, steps + 1, nextNode});
            }
        }

        return -1;
    }
}