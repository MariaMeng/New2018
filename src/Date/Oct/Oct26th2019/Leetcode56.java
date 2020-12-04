package Date.Oct.Oct26th2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 10/26/19.
 */
public class Leetcode56 {

    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if (intervals == null || intervals.length == 0|| intervals[0].length == 0) return list.toArray(new int[0][]);


        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;

        int left = intervals[0][0], right = intervals[0][1];
        int i = 1;
        while (i < n) {
            if (right > intervals[i][0]) {
                right = Math.max(right, intervals[i][1]);
            } else {
                list.add(new int[] {left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
            i++;
        }
        list.add(new int[]{left, right});

        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] data = new int[][] {{1,4},{2,3}};
        int[][] res = merge(data);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + "," + res[i][1]);
        }
    }
}
