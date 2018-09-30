package Algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by apple on 9/19/18.
 * 已知一个节点个数N， 边的二维数组，获取每个点至其他个点的距离和
 * 1 <= N <= 10000
 */
public class SumOfDistancesInTree {

    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N <= 0 || edges == null || edges.length == 0) return new int[]{0};
        int[] res = new int[N];
        int[][] dis = new int[N][N];

        // 1. INITIAL
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j )
                    continue;
                dis[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int[] e : edges) {
            int src = e[0];
            int dst = e[1];

            dis[src][dst] = 1;
            dis[dst][src] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || i == k || j == k) continue;
                    if (dis[i][k] != Integer.MAX_VALUE && dis[k][j] != Integer.MAX_VALUE)
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);

                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res[i] += (dis[i][j] == Integer.MAX_VALUE ? 0 : dis[i][j]);
            }
        }

        return res;
    }

    int[] res, count;
    ArrayList<HashSet<Integer>> tree;
    int n;
    public int[] sumOfDistancesInTree_B(int N, int[][] edges) {
        res = new int[N];
        count = new int[N];
        tree = new ArrayList<>();
        n = N;

        for (int i = 0; i < N; i++) {
            tree.add(new HashSet<>());
        }

        for (int[] e : edges) {
            int src = e[0];
            int dst = e[1];

            tree.get(src).add(dst);
            tree.get(dst).add(src);
        }

        dfs(0, new HashSet<Integer>());
        dfs2(0, new HashSet<Integer>());

        return res;
    }

    public void dfs(int root, HashSet<Integer> visited) {
        visited.add(root);
        for (int i : tree.get(root)) {
            if (!visited.contains(i)) {
                dfs(i, visited);
                count[root] += count[i];
                res[root] += res[i] + count[i];
            }

        }
        count[root]++;
    }

    public void dfs2(int root, HashSet<Integer> visited) {
        visited.add(root);
        for (int i : tree.get(root)) {
            if (!visited.contains(i)) {
                res[i] = res[root] - count[i] + n - count[i];
                dfs2(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int m = in.nextInt();

        int[][] edge = new int[m][2];
        for (int i = 0; i < m; i++) {
            edge[i][0] = in.nextInt();
            edge[i][1] = in.nextInt();
        }

        int[] res = sumOfDistancesInTree(N, edge);

        for (int r : res) {
            System.out.println(r);
        }
    }

}
