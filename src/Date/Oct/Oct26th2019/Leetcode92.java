package Date.Oct.Oct26th2019;

import java.util.*;

/**
 * Created by apple on 10/26/19.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
public class Leetcode92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;

        ListNode pre = new ListNode(0);
        ListNode dummy = pre;

        pre.next = head;
        for (int i = 1; i < m; i++) {
            head = head.next;
            pre = pre.next;
        }

        for (int i = m; i < n; i++) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Leetcode92 l = new Leetcode92();
        ListNode node = new ListNode(1);
        ListNode n1 = (node.next = new ListNode(2));
        ListNode n2 = (n1.next = new ListNode(3));
        ListNode n3 = (n2.next = new ListNode(4));
        ListNode n4 = (n3.next = new ListNode(5));

        ListNode res = l.reverseBetween(node, 2, 4);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

        System.out.println();
        res = l.reverseBetween(node, 1, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

        List<Integer> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        int[][] arrays = new int[][] {{9, 3, 3}, {9, 1, 3}};
        Arrays.sort(arrays, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });

        Integer[] array = new Integer[] {1, 5, 2};
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

    }

}
