package Date.Mar;

import java.util.PriorityQueue;

/**
 * @author mengxiang
 * @date 20/4/5
 */
public class Leetcode5195 {

    class Node {
        char c;
        int val;
        Node(int val, char c) {
            this.val = val;
            this.c = c;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        Node aa = new Node(a, 'a');
        Node bb = new Node(b, 'b');
        Node cc = new Node(c, 'c');
        PriorityQueue<Node> pq = new PriorityQueue<>((A, B) -> B.val - A.val);
        pq.add(aa);
        pq.add(bb);
        pq.add(cc);

        StringBuilder sb = new StringBuilder();

        int count = 0;
        while (true) {
            Node high = pq.poll();
            if (high.val == 0) break;
            if (sb.length() == 0 || high.c != sb.charAt(sb.length() - 1)) {
                sb.append(high.c);
                high.val--;
                count = 1;
            } else {
                if (count < 2) {
                    sb.append(high.c);
                    high.val--;
                    count++;
                    pq.offer(high);
                } else {
                   Node next = pq.poll();
                   if (next.val != 0) {
                       sb.append(next.c);
                       next.val--;
                       count = 1;
                       pq.offer(next);
                       pq.offer(high);
                   } else {
                       break;
                   }
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode5195 leetcode5195 = new Leetcode5195();
        int a = 1, b = 1, c = 7;
        String s = leetcode5195.longestDiverseString(a, b, c);
        System.out.println(s);
    }
}
