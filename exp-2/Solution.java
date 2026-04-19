package exp-2;

import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2) {
            return n;
        }

        int globalMax = 0;

        for (int i = 0; i < n - 1; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int hcf = gcd(dx, dy);

                dx /= hcf;
                dy /= hcf;

                String slope = dx + "," + dy;

                int count = map.getOrDefault(slope, 0) + 1;
                map.put(slope, count);

                localMax = Math.max(localMax, count);
            }

            globalMax = Math.max(globalMax, localMax + 1);
        }

        return globalMax;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a == 0 ? 1 : Math.abs(a);
        return gcd(b, a % b);
    }
}
