package Algorithm;

import java.util.*;

/**
 * Created by apple on 9/1/18.
 */
public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[] {};
        ArrayList<Integer> result = new ArrayList<>();

        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            for (int i = 0; i < numCourses; ++i) {
                result.add(i);
            }
            int[] res = new int[result.size()];
            for (int i =0; i < res.length; i++) {
                res[i] = result.get(i);
            }
            return res;
        }


        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        int[] degree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int dst = pre[0];
            int src = pre[1];

            if (map.get(src) == null) {
                map.put(src, new ArrayList<>());
            }
            map.get(src).add(dst);
            degree[dst]++;
        }

        // 1. find the degree zero points
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0)
                queue.add(i);
        }


        while (!queue.isEmpty()) {
            int point = queue.poll();

            result.add(point);

            if (map.get(point) == null) continue;
            for (int neibour: map.get(point)) {
                if(--degree[neibour] == 0)
                    queue.offer(neibour);
            }

        }

        int[] res = new int[result.size()];
        for (int i =0; i < result.size(); ++i) {
            res[i] = result.get(i);
        }

        return res.length == numCourses ? res : new int[0];
    }

    public int[] findOrder_B(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }

        // How many courses don't need prerequisites.
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int m = in.nextInt();

        int[][] prerequisites = new int[m][2];

        for (int i = 0; i < m; i++) {
            prerequisites[i][0] = in.nextInt();
            prerequisites[i][1] = in.nextInt();
        }

        int[] res = findOrder(N, prerequisites);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
