import java.io.*;
import java.util.*;

public class 165C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        int n = s.length();

      
        long[] freq = new long[n + 1];

        long answer = 0;
        int onesSoFar = 0;

    
        freq[0] = 1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                onesSoFar++;
            }

            if (onesSoFar >= k) {
                answer += freq[onesSoFar - k];
            }

            freq[onesSoFar]++;
        }

        System.out.println(answer);
    }
}