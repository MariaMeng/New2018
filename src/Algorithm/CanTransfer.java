package Algorithm;

import java.util.*;

/**
 * Created by apple on 10/20/18.
 */
public class CanTransfer {
    public static boolean canTransfer(String startString, String endString) {
        // Write your code here
        if (startString.length() != endString.length()) return false;

        boolean[] visited = new boolean[26];
        boolean[] onStack = new boolean[26];
        int[] adj = new int[26];
        Arrays.fill(adj, -1);

        for (int i = 0; i < startString.length(); i++) {
            int src = startString.charAt(i) - 'a';
            if (adj[src] != -1) return false;
            int dst = endString.charAt(i) - 'a';
            adj[src] = dst;
        }

        for (int i = 0; i < 26; i++) {
            if (adj[i] != -1 && !visited[i] && !dfs(visited, onStack, i, adj))
                return false;
        }
        return true;
    }
    public static boolean dfs(boolean[] visited, boolean[] onStack, int i, int[] adj) {
        visited[i] = true;
        onStack[i] = true;
        int neib = adj[i];
        if (neib != -1 && (onStack[neib] || !visited[neib] && !dfs(visited, onStack, neib, adj)))
            return false;
        onStack[i] = false;
        return true;
    }
    public static void main(String[] args) {
        String startString = "abc";
        String endString = "bca";
        System.out.println(canTransfer(startString, endString));
    }

}
