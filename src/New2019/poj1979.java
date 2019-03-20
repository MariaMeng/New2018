package New2019;

import java.util.Scanner;

/**
 * Created by apple on 3/20/19.
 *
 * Description

 There is a rectangular room, covered with square tiles. Each tile is colored either red or black. A man is standing on a black tile. From a tile, he can move to one of four adjacent tiles. But he can't move on red tiles, he can move only on black tiles.

 Write a program to count the number of black tiles which he can reach by repeating the moves described above.
 Input

 The input consists of multiple data sets. A data set starts with a line containing two positive integers W and H; W and H are the numbers of tiles in the x- and y- directions, respectively. W and H are not more than 20.

 There are H more lines in the data set, each of which includes W characters. Each character represents the color of a tile as follows.

 '.' - a black tile
 '#' - a red tile
 '@' - a man on a black tile(appears exactly once in a data set)
 The end of the input is indicated by a line consisting of two zeros.
 Output

 For each data set, your program should output a line which contains the number of tiles he can reach from the initial tile (including itself).
 */
public class poj1979 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int W = in.nextInt();
        int H = in.nextInt();
        int[][] matrix = new int[H][W];
        boolean[][] visited = new boolean[H][W];
        int col = 0, row = 0;

        for (int i = 0 ; i < H; i++) {
            String input = in.next();
            for (int j = 0; j < W; j++) {
                if (input.charAt(j) == '.') {
                    matrix[i][j] = 1;
                }

                else if (input.charAt(j) == '#') {
                    matrix[i][j] = 0;
                }

                else {
                    matrix[i][j] = 1;
                    row = i;
                    col = j;
                }
            }
        }

        int res = dfs(matrix, visited, row, col);
        System.out.println(res);
    }

    public static int dfs(int[][] matrix, boolean[][] visited, int row, int col) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return -1;

        int m = matrix.length;
        int n = matrix[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n) return 0;
        if (visited[row][col] || matrix[row][col] == 0) return 0;

        int res = 1;
        visited[row][col] = true;

        res += dfs(matrix, visited, row + 1, col);
        res += dfs(matrix, visited, row - 1, col);
        res += dfs(matrix, visited, row, col + 1);
        res += dfs(matrix, visited, row, col - 1);

        return res;
    }

}
