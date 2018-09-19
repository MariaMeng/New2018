package Algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by apple on 8/23/18.
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0) return -1;

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int[] t : times) {
            int source = t[0];
            int next = t[1];
            int weight = t[2];

            if (!map.containsKey(source)) {
                map.put(source, new HashMap<>());
            }
            map.get(source).put(next, weight);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));

        pq.add( new int[]{0, K});

        HashMap<Integer, Integer> distance = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();

            int weight = tmp[0];
            int source = tmp[1];

            if (distance.containsKey(source)) continue;
            if (!distance.containsKey(source)) distance.put(source, weight);


            if (distance.keySet().size() == N) break;

            Map<Integer, Integer> adj = map.getOrDefault(source, new HashMap<>());
            for (int a : adj.keySet()) {
                pq.add(new int[] {weight + adj.get(a), a});
            }

        }

        if (distance.keySet().size() != N) return -1;

        int max = 0;
        for (int key : distance.keySet()) {
            max = Math.max(max, distance.get(key));
        }

        return max == 0 ? -1 : max;
    }


    public static int networkDelayTime_B(int[][] times, int N, int K) {
        if(times == null || times.length == 0)
            return 0;

        //create a directed weighted graph
        int graph[][] = new int[N+1][N+1];
        for(int i = 0; i <= N; i++)
            for(int j = 0; j <= N; j++)
                graph[i][j] = -1;

        for(int i = 0; i < times.length; i++)
            graph[times[i][0]][times[i][1]] = times[i][2]; //u , v = w

        //Nodes start from 1
        boolean spSet[] = new boolean[N+1];

        //to store the distance from K to every other node
        int dist[] = new int[N+1];

        for(int  i= 0; i <= N; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[K] = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= N; i++) {
            int u = getMinKey(spSet, dist);

            spSet[u] = true;

            for(int v = 1; v <= N; v++)
                if(!spSet[v] && graph[u][v] != -1 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        for(int i = 1; i <= N; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                return -1; // some vertex is not reachable at all
            else
                max = Math.max(max, dist[i]);
        }

        return max;
    }


    private static int getMinKey(boolean spSet[], int dist[]) {
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int i = 1; i < spSet.length; i++) {
            if(!spSet[i] && minVal >= dist[i]) {
                minVal = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] times = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                times[i][j] = in.nextInt();
            }
        }

        int N = in.nextInt();

        int K = in.nextInt();

        System.out.println(networkDelayTime_B(times, N, K));
    }
}
