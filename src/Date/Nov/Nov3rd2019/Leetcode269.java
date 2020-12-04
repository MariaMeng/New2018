package Date.Nov.Nov3rd2019;

import java.util.*;

/**
 * Created by apple on 11/3/19.
 */
public class Leetcode269 {

    public String alienOrderA(String[] words) {

        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                // P1: 解决下面循环里，两个字符串后面长出来没有对比到的那部分，这里面可能还有部分indegree == 0的字符没加进indegree。而且map不给的话，之后BFS拿这些入度为0而且从来没给依赖关系的点，会出现空指针情况。
                indegree.putIfAbsent(c, 0);
                map.putIfAbsent(c, new ArrayList<Character>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    // P1: indegree不能和graph一起做，因为graph只遍历两个字符串里短的那部分，
                    char c1 = words[i].charAt(j);
                    char c2 = words[i + 1].charAt(j);
                    // P2： 小心a->b出现多次的情况，如果map内部嵌套的是set,不能出现第二次a->b的时候也无脑加入度，一定要让只有第一次出现a->b的时候加一次有效入度。因为你set没能再加一次，入度多加了的话，之后BFS的时候你的入度就减不到0了。另一个解决方案是map内部嵌套list，不过有冗余，时间复杂度高一点。
                    if (map.get(c1).add(c2)) {
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    // map.get(c1).add(c2);
                    // indegree.put(c2, indegree.get(c2) + 1);

                    //P3: 注意对比完一个就结束了！后续不能接着比的！两个字符串只得一个有效信息。
                    break;
                }
            }

        }

        Queue<Character> q = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char crt = q.poll();
            sb.append(crt);
            for (char next : map.get(crt)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    q.offer(next);
                }
            }
        }

        // P4:要确认一下有没有出现循环依赖。
        if (sb.length() != indegree.size()) {
            return "";
        } else {
            return sb.toString();
        }

    }


    public static void main(String[] args) {

        String[] words = new String[] {"wrt","wrf","er","ett","rftt"};
        String res = alienOrder(words);
        System.out.println(res);
    }


    /**
     * Lintcode 外星人词典
     * https://www.lintcode.com/problem/alien-dictionary/description
     * @param words
     * @return
     */
    public static String alienOrder(String[] words) {
        // Write your code here
        boolean[] visited = new boolean[26];
        int[] indegree = new int[26];
        List<Integer>[] nei = new ArrayList[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int count = 0;

        for (String w: words) {

            for (char c: w.toCharArray()) {
                int idx = c - 'a';
                if (!visited[idx]) {
                    visited[idx] = true;
                    count++;
                    nei[idx] = new ArrayList<>();
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    int src = words[i].charAt(j) - 'a';
                    int tar = words[i + 1].charAt(j) - 'a';
                    nei[src].add(tar);
                    indegree[tar]++;

                    break;
                }
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (visited[i] && indegree[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int idx = pq.poll();
            char c = (char)(idx + 'a');
            sb.append(c);

            List<Integer> nodes = nei[idx];
            for (int n: nodes) {

                if (--indegree[n] == 0) {
                    pq.add(n);
                }
            }
        }

        if (sb.length() != count) return "";
        return sb.toString();
    }

}
