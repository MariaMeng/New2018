package MIOJ;

import java.util.Scanner;

/**
 * Created by apple on 3/20/19.
 * 描述
 有 N?M 的一个矩阵，小米兔今天很开心，从矩阵左上角的第一个位置开始顺时针从外向里走，很快就走遍了所有的位置，
 可是小米兔想知道自己走过的轨迹，你能告诉小米兔它走过的轨迹吗？

 （输出一个字符串，由小米兔走过的位置的值组成，用空格分隔。）

 输入
 单组输入。

 第 1 行是 2 个整数，分别代表 NN 和 MM 的值；
 第 2 ~ NN + 1 行，表示 N \cdot MN?M 的矩阵中的每一行。
 输出
 输出为一个字符串，由小米兔走过的位置的值组成，用空格分隔。

 输入样例
 3 3
 1 2 3
 4 5 6
 7 8 9
 复制样例
 输出样例
 1 2 3 6 9 8 7 4 5
 */
public class RabbitTrack {

    static StringBuilder solution = new StringBuilder();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int start = 0;
        while (start * 2 < m && start * 2 < n) {
            print(matrix, m, n, start);
            start++;
        }

        System.out.println(solution);
    }

    public static void print(int[][] matrix, int m, int n, int start) {
        int endCol = n - 1 - start;
        int endRow = m - 1 - start;

        for (int i = start; i <= endCol; i++) {
            solution.append(matrix[start][i] + " ");
        }

        if (endRow > start) {
            for (int i = start + 1; i <= endRow; i++) {
                solution.append(matrix[i][endCol] + " ");
            }
        }

        if (endCol > start && endRow > start) {
            for (int i = endCol - 1; i >= start; i--) {
                solution.append(matrix[endRow][i] + " ");
            }
        }

        if (endCol > start && endRow - 1 > start) {
            for (int i = endRow - 1; i > start; i--) {
                solution.append(matrix[i][start] + " ");
            }
        }
    }



}
