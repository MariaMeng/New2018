package Date.Nov.Nov3rd2019;

/**
 * Created by apple on 11/3/19.
 */
public class Leetcode207 {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;

        int[] indegree  = new int[numCourses];
        boolean[] edge = new boolean[prerequisites.length];

        boolean find = true;

        for (int[] e: prerequisites) {
            int end = e[1];
            indegree[end]++;
        }

        while (find) {
            find = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (edge[i]) continue;

                int start = prerequisites[i][0];
                int end = prerequisites[i][1];
                if (indegree[start] != 0 ) continue;

                find = true;
                edge[i] = true;
                indegree[end]--;
            }
        }

        for (int d: indegree) {
            if (d != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] pre = new int[][] {{1, 3}, {1, 4}, {4, 5}, {3, 5}, {3, 4}, {2, 3}, {0, 1}};
        int n = 6;
        boolean res = canFinish(n, pre);
        System.out.println(res);
    }
}
