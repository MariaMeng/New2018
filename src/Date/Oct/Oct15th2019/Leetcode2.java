package Date.Oct.Oct15th2019;

/**
 * Created by apple on 10/15/19.
 */



class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class Leetcode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int[] carr = new int[1];

        ListNode head = acc(l1, l2, carr);
        if (carr[0] == 1) {
            ListNode pre = new ListNode(1);
            pre.next = head;
        }
        return head;
    }

    public ListNode acc(ListNode l1, ListNode l2, int[] carr) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(0);
        head.next = acc(l1.next, l2.next, carr);

        int sum = l1.val + l2.val + (carr[0] == 1? 1: 0);

        head.val = sum % 10;
        carr[0] = sum / 10;

        return head;
    }
}
