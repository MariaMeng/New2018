package Kickstart;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 * Created by apple on 7/24/18.
 *
 *
 * Input



 5
 6
 0 1 0 0 0 0
 1 0 1 0 0 0
 0 1 0 1 0 0
 0 0 1 0 1 0
 0 0 0 1 0 1
 0 0 0 0 1 0
 6
 0 2 0 0 0 0
 2 0 0 0 0 0
 0 0 0 3 0 0
 0 0 3 0 0 0
 0 0 0 0 0 4
 0 0 0 0 4 0
 6
 0 1 0 0 0 0
 1 0 0 0 0 0
 0 0 0 2 0 0
 0 0 2 0 0 0
 0 0 0 0 0 4
 0 0 0 0 4 0
 6
 0 1 1 1 1 1
 1 0 0 0 0 0
 1 0 0 0 0 0
 1 0 0 0 0 0
 1 0 0 0 0 0
 1 0 0 0 0 0
 8
 0 5 0 0 0 0 0 0
 5 0 0 0 0 0 0 0
 0 0 0 5 0 0 0 0
 0 0 5 0 0 0 0 0
 0 0 0 0 0 5 0 0
 0 0 0 0 5 0 0 0
 0 0 0 0 0 0 0 5
 0 0 0 0 0 0 5 0



 Output:
 Case #1: 1
 Case #2: 1
 Case #3: 0
 Case #4: 0
 Case #5: 5
 */
public class FairiesAndWithes {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String path = "outputfw.txt";
        File file = new File(path);

        FileWriter fw = new FileWriter(file);

        for (int k = 0; k < n; k++) {
            int N = in.nextInt();

            int[][] matrix = new int[N][N];

            for (int j = 0 ;j < N; j++) {
                for (int i = 0 ; i < N; i++) {
                    int val = in.nextInt();
                    matrix[i][j] = in.nextInt();

                }
            }

            ArrayList<Integer> tmpList = new ArrayList<>();
            int[] res = new int[0];
            int sum = 0;
            boolean[] visited = new boolean[N];

            findWays(matrix, N, 0, tmpList, res, sum, visited);


            fw.write("Case #" + k + ": " + res[0] + '\n');
        }
        fw.close();
    }



    /**
     * find the ways to form convex polygon
     *
     * @param matrix
     * @param row
     * @return -1 failed; otherwise success
     */
    public static void findWays(int[][] matrix, int N, int row, ArrayList<Integer> tmpList, int[] res, int sum, boolean[] visited) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ;

        if (tmpList.size() >= 3) {
            tmpList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.intValue() - o2.intValue();
                }
            });

            if (sum > 2 * tmpList.get(tmpList.size() - 1)) {
                res[0]++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == true) continue;

            for (int j = row; j < N; j++) {
                if (matrix[i][j] == 0) continue;

                tmpList.add(matrix[i][j]);
                visited[i] = true;
                findWays(matrix, N, i, tmpList, res, sum + matrix[i][j], visited);

                tmpList.remove(tmpList.size() - 1);
                visited[i] = false;
            }
        }

    }
}
