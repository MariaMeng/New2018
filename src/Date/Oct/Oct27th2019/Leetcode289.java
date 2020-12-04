package Date.Oct.Oct27th2019;

/**
 * Created by apple on 10/27/19.
 */
public class Leetcode289 {
    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return ;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = checkAlive(board, i, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 0 || board[i][j] == -1 ? 0: 1;
            }
        }
    }

    public static int checkAlive(int[][] board, int i, int j) {
        int count = 0;
        int m = board.length, n = board[0].length;

        int left = Math.max(0, j - 1);
        int right = Math.min(n - 1, j + 1);
        int top = Math.max(0, i - 1);
        int bottom = Math.min(m - 1, i + 1);

        for (int x = top; x <= bottom; x++) {
            for (int y = left; y <= right; y++) {
                int tmp = board[x][y] == 1 || board[x][y] == -1 ? 1 : 0;
                count += tmp;
            }
        }
        return board[i][j] == 1? (count == 3 || count == 4? 1: -1): (count == 3 ? -2: 0);
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
