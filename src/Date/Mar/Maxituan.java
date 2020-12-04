package Date.Mar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author mengxiang
 * @date 20/3/22
 */
public class Maxituan {

    public int bestSeqAtIndex(int[] height, int[] weight) {

        int n = height.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = height[i];
            data[i][1] = weight[i];
        }

        Arrays.sort(data, (a, b)-> a[0] == b[0]? b[1] - a[1]: a[0] - b[0]);
        int[] dp = new int[n + 1];
        dp[1] = data[0][1];
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (data[i][1] > dp[idx]) {
                dp[++idx] = data[i][1];
            } else if (data[i][1] < dp[idx]) {
                int tmpIdx = Arrays.binarySearch(dp, 1, idx + 1, data[i][1]);
                if (tmpIdx < 0) {
                    tmpIdx = -(tmpIdx + 1);
                }
                dp[tmpIdx] = data[i][1];
            }
        }
        return idx;
    }

    public int binarySearch(int[] dp, int end, int val) {
        int left = 1;
        int right = end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (val < dp[mid]) {
                right = mid;
            }

            else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Maxituan m = new Maxituan();
        int[] height = new int[]{1, 2, 2, 3, 4};
        int[] wieght = new int[]{1, 3, 4, 5, 7};
        int res = m.bestSeqAtIndex(height, wieght);
        System.out.println(res);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
