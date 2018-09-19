package Algorithm;

import java.util.*;

/**
 * Created by apple on 8/18/18.
 *
 * Input:
 n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 src = 0, dst = 2, k = 1
 Output: 200


 Input:
 n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 src = 0, dst = 2, k = 0
 Output: 500
 */
public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights == null || flights[0].length == 0) return -1;
        int[][] path = new int[n][n];

        for (int i = 0; i < flights.length; i++) {
            path[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        boolean[] visited = new boolean[n];
        int res = DFS(path, dst, src, 0, K, visited);

        return res != Integer.MAX_VALUE ? res : -1;
    }

    public static int DFS(int[][] path, int dst, int src, int start, int K, boolean[] visited) {
        if (dst == src && start <= K + 1)
            return 0;
        if (dst != src && start >= K + 1)
            return Integer.MAX_VALUE;

        if (visited[src]) return path[src][dst];

        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < path.length; i++) {
            if (i == src)
                continue;
            if (path[src][i] != 0) {

                sum = DFS(path, dst, i,  start + 1, K, visited);
                if (sum == Integer.MAX_VALUE)
                    continue;
                sum += path[src][i];
                result = Math.min(result, sum);
            }

        }
        if (result < path[src][dst])
            visited[src] = true;
        return result;
    }

    public int findCheapestPrice_B(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[] {0, src, k + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[] {price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }

    public int findCheapestPrice_C(int n, int[][] flights, int src, int dst, int K) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for(int i = 0; i <= K; i++){
            int[] tmp = Arrays.copyOf(prices, n);

            for(int[] flight: flights){
                int cur = flight[0], next = flight[1], price = flight[2];
                if(prices[cur] == Integer.MAX_VALUE)
                    continue;

                tmp[next] = Math.min(tmp[next], prices[cur] + price);
            }

            prices = tmp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }


    public int findCheapestPrice_D(int n, int[][] flights, int src, int dst, int K) {

        int INF = (K+1) * 10000;

        int [][] dp = new int [K+2][n];

        for(int[] row : dp)    Arrays.fill(row,INF);


        for(int i = 0;i < K+2;i++)      dp[i][src] = 0;

        //for(int i = 0;i < K+2;i++){
        //    for(int j = 0;j < n;j++)
        //        System.out.print(dp[i][j] + " ");
        //    System.out.print("\n");
        //}

        for(int count = 1;count <= K+1;count++){
            for(int [] flight : flights){
                int from = flight[0];
                int to   = flight[1];
                int cost = flight[2];
                dp[count][to] = Math.min(dp[count-1][from]+cost, Math.min(dp[count-1][to], dp[count][to]));
            }

            if (compare(dp[count-1], dp[count])) return dp[count][dst] >= INF? -1 : dp[count][dst];
        }

        return dp[K+1][dst] >= INF? -1 : dp[K+1][dst];
    }

    public boolean compare(int [] a, int [] b){
        for(int i = 0;i < a.length;i++){
            if(a[i] != b[i])    return false;
        }
        return true;
    }

    public static void main(String[] args) {

//        int[][] dp = new int[3][3];
//
//        for (int[] d : dp) {
//            Arrays.fill(d, Integer.MAX_VALUE);
//        }
//
//        System.out.println(dp);

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] flight = new int[m][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                flight[i][j] = in.nextInt();
            }
        }

        int src = in.nextInt();
        int dst = in.nextInt();

        int K = in.nextInt();

        int res = findCheapestPrice(n, flight, src, dst, K);

        System.out.println(res);
    }
}
