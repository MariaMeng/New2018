package Date.Oct.Oct24th2019;

import java.util.PriorityQueue;

/**
 * Created by apple on 10/24/19.
 */
public class Leetcode407 {

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        int m = heightMap.length, n = heightMap[0].length;

        if (m <= 2 || n <= 2) return 0;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int j = 0; j < n; j++) {
            visited[0][j] = true;
            pq.add(new int[] {heightMap[0][j], 0, j});
            visited[m - 1][j] = true;
            pq.add(new int[] {heightMap[m - 1][j], m - 1, j});
        }

        for (int i = 1; i <= m - 2; i++) {
            visited[i][0] = true;
            pq.add(new int[] {heightMap[i][0], i, 0});
            visited[i][n - 1] = true;
            pq.add(new int[] {heightMap[i][n - 1], i, n - 1});
        }


        int counter = (m - 2) * (n - 2);
        int sum = 0;

        int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (counter > 0) {

            int[] top = pq.poll();
            for (int i = 0; i < 4; i++) {

                int x = top[1] + dir[i][0];
                int y = top[2] + dir[i][1];

                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) continue;
                visited[x][y] = true;
                counter--;
                sum += Math.max(0, top[0] - heightMap[x][y]);

                pq.add(new int[]{Math.max(top[0], heightMap[x][y]), x, y});
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[][] heightMap = new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        Leetcode407 res = new Leetcode407();
//        int result = res.trapRainWater(heightMap);


//        int[][] heightMap = new int[][] {{3, 3, 1}, {4 ,1, 3}, {5, 2, 4}, {4, 4, 1}};
//        int result = res.trapRainWater(heightMap);
//        System.out.println(result);

        int[][] heightMap = new int[][]{{1}};
        int result = res.trapRainWater(heightMap);
        System.out.println(result);
    }
}
