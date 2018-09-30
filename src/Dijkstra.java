import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by apple on 8/18/18.
 */
public class Dijkstra {
    public static int dijkstra(int[][] path, int src, int dst) {
        int n = path.length;
        boolean[] visited = new boolean[n];

        for (int i  = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && path[i][j] == 0)
                    path[i][j] = Integer.MAX_VALUE;
            }
        }

        visited[src] = true;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);

        int tmp = 0;
        while (queue.isEmpty()) {
            int point = queue.poll();
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    tmp = path[src][point] + path[point][i];
                    path[src][i] = Math.min(path[src][i], tmp);
                }
            }
            visited[src] = true;
            queue.add(src);
        }

        return path[src][dst];
    }
}
