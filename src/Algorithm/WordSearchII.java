package Algorithm;

import java.util.*;

/**
 * Created by apple on 10/12/18.
 */
public class WordSearchII {
    static class TrieNode{
        char c;
        boolean isLeaf;
        TrieNode[] next;
        public TrieNode(char c) {
            this.c = c;
            next = new TrieNode[26];
        }
    }
    public static List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        if (words == null || words.size() == 0) return words;
        TrieNode root = new TrieNode(' ');
        for (String w : words)
            build(root, w);

        List<String> list = new ArrayList<>();

        int n = board.length;
        int m = board[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < root.next.length; k++) {
                    char tmp = board[i][j];
                    if (root.next[tmp - 'a'] == null) continue;
                    search(list, board, i, j, root.next[tmp - 'a'], sb);
                }
            }
        }
        return list;
    }
    public static boolean search(List<String> list, char[][] board, int i, int j, TrieNode root, StringBuilder sb) {

        int n = board.length, m = board[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m) return false;

        boolean res = false;
        if (board[i][j] == root.c) {
            sb.append(root.c);
            if (root.isLeaf) {
                list.add(new String(sb.toString()));
                sb.delete(sb.length() - 1, sb.length());
                return true;
            }

            board[i][j] ^= 256;

            for (int k = 0; k < root.next.length; k++) {
                if (root.next[k] == null) continue;
                res = search(list, board, i + 1, j, root.next[k], sb) ||
                        search(list, board, i - 1, j, root.next[k], sb) ||
                        search(list, board, i, j - 1, root.next[k], sb) ||
                        search(list, board, i, j + 1, root.next[k], sb) ;
                if (!res) return false;
            }
            sb.delete(sb.length() - 1, sb.length());
            board[i][j] ^= 256;
        }
        return true;
    }

    public static void build(TrieNode root, String word) {
        if (word == null || word.length() == 0) return ;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char tmp = word.charAt(i);
            if(root.next[tmp - 'a'] == null) {
                root.next[tmp - 'a'] = new TrieNode(tmp);
            }
            root = root.next[tmp - 'a'];
        }
        root.isLeaf = true;
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{{'d', 'o', 'a', 'f'}, {'a', 'g', 'a', 'i'}, {'d', 'c', 'a', 'n'}};
        List<String> words = new ArrayList<>();
        words.add("dog");
        words.add("dad");
        words.add("dgdg");
        words.add("can");
        words.add("again");
        System.out.println(wordSearchII(board, words));
    }
}
