package Date.Feb.Feb2nd2020;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 20/2/2.
 */
public class Leetcode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;

        char[][] board = new char[n][n];
        init(board);
        helper(0, res, board);

        return res;
    }

    public void init(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void helper(int row, List<List<String>> res, char[][] board) {
        if (row == board.length) {
            res.add(generate(board));
            return ;
        }

        for (int j = 0; j < board.length; j++) {
            if (isValid(board, row, j)) {
                board[row][j] = 'Q';
                helper(row + 1, res, board);
                board[row][j] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col) {
        for (int i = row - 1; i >=0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    public List<String> generate(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode51 lc  = new Leetcode51();
        List<List<String>> res = lc.solveNQueens(5);
        for (List<String> r: res) {
            System.out.println(r);
        }
        System.out.println(res.size());
        System.out.println(Integer.MAX_VALUE + " Binary string: " + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.MIN_VALUE + " Binary string: " + Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(-8 + " Binary string: " + Integer.toBinaryString(-8));
        System.out.println(7 + " Binary string: " + Integer.toBinaryString(7));
        System.out.println(-128 + " Binary string: " + Integer.toBinaryString(-128));
        String str = "";
        str.trim();

        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(Integer.MIN_VALUE / 10);
    }
}
