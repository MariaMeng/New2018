package Algorithm;

/**
 * Created by apple on 10/12/18.
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        // write your code here
        if (word == null || word.length() == 0 || board == null || board.length == 0) return false;
        int n = board.length;
        int m = board[0].length;

        boolean res = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                res = backTrack(board, word, i, j, 0);
                if (res)
                    return true;
            }
        }
        return false;
    }
    public static boolean backTrack(char[][] board, String word, int i, int j, int idx) {
        int n = board.length, m = board[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m) return false;
        if (idx == word.length()) return true;

        boolean res = false;
        if (word.charAt(idx) == board[i][j]) {
            board[i][j] ^= 256;
            res = backTrack(board, word, i + 1, j, idx + 1) ||
                    backTrack(board, word, i - 1, j, idx + 1) ||
                    backTrack(board, word, i, j + 1, idx + 1) ||
                    backTrack(board, word, i, j - 1, idx + 1);
            if (res) return true;
            board[i][j] ^= 256;
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
        StringBuilder sb = new StringBuilder();
        sb.delete(0, sb.length());
        sb.append(' ');
        System.out.println(sb.toString());
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb.toString());
    }
}
