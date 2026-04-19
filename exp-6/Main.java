package exp-6;

import java.io.*;
import java.util.*;

public class Main {

    static FastScanner fs = new FastScanner(System.in);
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static void solve() {
        int n = fs.nextInt();

        boolean[][] e = new boolean[26][26];
        String last = null;

        for (int k = 0; k < n; k++) {
            String c = fs.next();

            if (last != null) {
                int ln = last.length();
                int cn = c.length();

                int li = 0, ci = 0;
                boolean found = false;

                while (li < ln && ci < cn) {
                    if (last.charAt(li) != c.charAt(ci)) {
                        int from = last.charAt(li) - 'a';
                        int to = c.charAt(ci) - 'a';
                        e[from][to] = true;
                        found = true;
                        break;
                    }
                    li++;
                    ci++;
                }

                if (!found && li < ln) {
                    out.println("Impossible");
                    return;
                }
            }

            last = c;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (e[i][j]) {
                    adj.get(i).add(j);
                }
            }
        }

        List<Integer> topo = topoSortBFS(26, adj);

        if (topo.size() != 26) {
            out.println("Impossible");
        } else {
            for (int x : topo) {
                out.print((char) (x + 'a'));
            }
            out.println();
        }
    }

    static List<Integer> topoSortBFS(int n, List<List<Integer>> adj) {
        int[] indegree = new int[n];

        for (int u = 0; u < n; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return topo;
    }

    public static void main(String[] args) {
        solve();
        out.flush();
    }

    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
