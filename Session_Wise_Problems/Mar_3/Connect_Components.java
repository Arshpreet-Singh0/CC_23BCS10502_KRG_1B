import java.util.*;

public class Connect_Components {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        findComponents(adj, n);
    }

    static void findComponents(ArrayList<ArrayList<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        List<Integer> representatives = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                representatives.add(i);
                dfs(adj, visited, i);
            }
        }

        System.out.println(representatives.size());

        if (representatives.size() > 1) {
            for (int i = 1; i < representatives.size(); i++) {
                System.out.println(representatives.get(0) + representatives.get(i));
            }
        } else {
            System.out.println("Graph is already connected.");
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}