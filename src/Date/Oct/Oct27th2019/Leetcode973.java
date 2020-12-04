package Date.Oct.Oct27th2019;

import java.util.PriorityQueue;

/**
 * Created by apple on 10/27/19.
 */
public class Leetcode973 {

    public static int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || points[0].length == 0) return points;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int i = 0; i < points.length; i++) {
            if (i < K)
                pq.add(new int[] {points[i][0], points[i][1]});
            else {
                int[] peek = pq.peek();
                int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];
                if (dis < peek[0] * peek[0] + peek[1] * peek[1]) {
                    pq.poll();
                    pq.add(new int[] {points[i][0], points[i][1]});
                }
            }
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            int[] top = pq.poll();
            res[i][0] = top[0];
            res[i][1] = top[1];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int K = 1;
        int[][] res = kClosest(points, K);
        for (int i = 0 ; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }

        points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        K = 2;
        res = kClosest(points, K);
        for (int i = 0 ; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }

        points = new int[][]{{-5, 4}, {-6, -5}, {4, 6}};
        K = 2;
        res = kClosest(points, K);
        for (int i = 0 ; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }

}
