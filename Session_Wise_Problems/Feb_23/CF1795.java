import java.io.*;
import java.util.*;

public class CF1795 {

    public static void solve(int n, long[] teas, long[] tasters) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long[] ans = new long[n];
        long sum = 0;
        for(int i=0; i<n; i++) {
            pq.add(sum+teas[i]);
            long curr = 0;
            while(!pq.isEmpty() && pq.peek() <= sum+tasters[i]) {
                curr += pq.poll()-sum;
            }

            curr += pq.size()*tasters[i];
            sum += tasters[i];
            ans[i] = curr;
        }

        for(long i: ans) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] teas = new long[n];
            long[] tasters = new long[n];
            for(int i=0; i<n; i++) {
                teas[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                tasters[i] = Long.parseLong(st.nextToken());
            }

            solve(n, teas, tasters);
        }
    }
}