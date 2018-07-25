package Kickstart;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by apple on 7/18/18.
 * Input

 The first line contains an integer T, the number of test cases. T test cases follow. The first line of each test case contains an integer N, the number of planets and vacuum tubes. The planets are numbered from 1 to N.
 N lines follow, the i-th of these lines contains two integers xi and yi, indicating that the i-th vacuum tube connects planet xi and planet yi.

 Output

 For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is a list of N space-separated values in which the i-th value represents the minimum distance between the i-th planet and a planet in the cycle.

 Limits

 1 ¡Ü T ¡Ü 100.
 1 ¡Ü xi ¡Ü N, for all i.
 1 ¡Ü yi ¡Ü N, for all i.
 xi ¡Ù yi, for all i.
 (xi, yi) ¡Ù (xj, yj), for all i ¡Ù j.
 The graph in which planets are nodes and tubes are edges is connected and has exactly one cycle.
 Small dataset

 3 ¡Ü N ¡Ü 30.
 Large dataset

 3 ¡Ü N ¡Ü 1000.
 Sample


 Input

 2
 5
 1 2
 2 3
 3 4
 2 4
 5 3
 3
 1 2
 3 2
 1 3

 Output
 Case #1: 1 0 0 0 1
 Case #2: 0 0 0


 */
public class Solution {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner in  = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = in.nextInt();

        for (int z = 1; z <= n; z++) {
            int N = in.nextInt();
            int[][] matrix = new int[N + 1][N + 1];
            int[] degree = new int[N + 1];

            // 1. initialize the matrix
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }

            // 2. set the value
            for (int i = 1; i <= N; i++) {
                int first = in.nextInt();
                int second = in.nextInt();
                matrix[first][second] = 1;
                matrix[second][first] = 1;

                degree[first]++;
                degree[second]++;
            }

            int[] cycle = new int[N + 1];

            Stack<Integer> stack = new Stack<>();

            findCycle(matrix, cycle, N, stack, degree); //set element equals zero if on cycle

            System.out.print("Case #" + z + ": ");
            for (int k = 1; k <= N; k++) {

                System.out.print(cycle[k] + (k != N ? " " : ""));
            }
            if (z != n)
                System.out.println();

        }
    }

    public static void findCycle(int[][] matrix, int[] cycle, int N, Stack<Integer> stack, int[] degree) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ;

        boolean[] visited = new boolean[N + 1];

        // find the indegree zero points
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int top = queue.poll();
            degree[top]--;
            visited[top] = true;

            stack.push(top);
            cycle[top] = INF;

            count++;

            for (int i = 1; i <= N; i++) {
                if (matrix[top][i] == INF || top == i)  continue;
                degree[i]--;
                if (degree[i] <= 1 && !visited[i])
                    queue.add(i);

            }

        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            for (int i = 1; i <= N; i++) {
                if (i == top) continue;
                if (cycle[i] != INF && matrix[top][i] != INF)
                    cycle[top] = Math.min(cycle[top], matrix[top][i] + cycle[i]);
            }
        }

    }
}
