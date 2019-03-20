package Algorithm;

import java.util.*;

/**
 * Created by apple on 10/22/18.
 */
public class BalancedGraph {
    public int balanceGraph(int[][] edges) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        // 1. store the balance
        for (int[] edge: edges) {
            int src = edge[0];
            int dst = edge[1];
            int w = edge[2];
            if (!map.containsKey(src)) {
                map.put(src, 0);
            }
            map.put(src, map.get(src) - w);
            if (!map.containsKey(dst)) {
                map.put(dst, 0);
            }
            map.put(dst, map.get(dst) + w);
        }
        // 2. get num of unbalanced account
        int[] account = new int[map.size()];
        int len = 0;
        for (int v : map.values()) {
            if (v != 0) {
                account[len++] = v;
            }
        }
        if (len == 0) return 0;

        // 3. Ã¶¾Ù
        int[] dp = new int[1 << len];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        for (int i = 1; i < dp.length; i++) {

            int sum = 0, count = 0;
            for (int j = 0; j < len; j++) {
                if ((1 << j & i) != 0) {
                    sum += account[j];
                    count++;
                }
            }

            if (sum == 0) {
                dp[i] = count - 1;
                for (int j = 1; j < i; j++) {
                    if ((i & j) == j && dp[j] + dp[i - j] < dp[i]) {
                        dp[i] = dp[j] + dp[i - j];
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
