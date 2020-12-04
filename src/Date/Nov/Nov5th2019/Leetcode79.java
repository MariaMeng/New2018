package Date.Nov.Nov5th2019;

/**
 * Created by apple on 11/5/19.
 */
public class Leetcode79 {

    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                if(find(word, 0, board, visited, i, j))
                    return true;
            }
        }
        return false;
    }

    public static boolean find(String word, int pos, char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (visited[i][j] || word.charAt(pos) != board[i][j]) return false;

        if (pos == word.length() - 1) return true;

        visited[i][j] =  true;
        boolean res = find(word, pos + 1, board, visited, i - 1, j) ||
                find(word, pos + 1, board, visited, i + 1, j) ||
                find(word, pos + 1, board, visited, i, j + 1) ||
                find(word, pos + 1, board, visited, i, j - 1);

        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        String str = "ABCCED";
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean res = exist(board, str);
        System.out.println(res);

        str = "SEE";
        res = exist(board, str);
        System.out.println(res);

        str = "ABCB";
        res = exist(board, str);
        System.out.println(res);

    }
}
