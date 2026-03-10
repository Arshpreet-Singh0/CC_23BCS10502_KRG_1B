import java.util.*;

public class C_Tree_Infection {

    static boolean canFinish(List<Integer> list, int m, int extra) {
        int need = 0;
        for (int i = 0; i < list.size(); i++) {
            int remaining = list.get(i) - (m - i);
            if (remaining > 0) {
                if (remaining > extra) {
                    need += remaining - extra;
                }
            }
        }

        return need <= extra;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] cnt = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                int p = sc.nextInt();
                cnt[p]++;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (cnt[i] > 0) {
                    list.add(cnt[i]);
                }
            }

            list.add(1);
            Collections.sort(list, Collections.reverseOrder());

            int m = list.size();

            int lo = 0, hi = n;
            int ans = n;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;

                if (canFinish(list, m, mid)) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            System.out.println(m + ans);
        }

        sc.close();
    }
}