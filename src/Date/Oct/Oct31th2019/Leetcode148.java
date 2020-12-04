package Date.Oct.Oct31th2019;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by apple on 10/31/19.
 * microsoft phone interview 挂！
 */
class ListNode {
    int val;
    ListNode next;
    ListNode (int val) {
        this.val = val;
    }
    ListNode() {}
}
public class Leetcode148 {



    private ListNode sort(ListNode root) {
        if (root == null || root.next == null) return root;

        TreeMap<Integer, ListNode> map = new TreeMap<>();


        while (root != null) {
            int val = root.val;
            if (!map.containsKey(val)) {
                map.put(val, root);
                root = root.next;
                map.get(val).next = null;
            }

        }

        ListNode pre = new ListNode();
        ListNode cur = pre;
        for (Map.Entry<Integer,  ListNode> entry: map.entrySet()) {
            int key = entry.getKey();
            ListNode val = entry.getValue();

            if  (val != null) {
                cur.next = val;
                cur = cur.next;
            }
        }
        return pre.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        return helper(head);

    }

    public ListNode helper(ListNode head) {

        ListNode first = head;
        ListNode second = head;
        ListNode pre = new ListNode(0);
        pre.next = head;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            pre = pre.next;
        }
        pre.next = null;

        if (head != null && head.next != null) {
            head = helper(head);
        }

        if (first != null && first.next != null) {
            first = helper(first);
        }

        ListNode res = merge(first, head);


        return res;

    }
    public ListNode merge(ListNode f1, ListNode f2) {
        if (f1 == null) return f2;
        if (f2 == null) return f1;

        ListNode pre = new ListNode();
        ListNode cur = pre;

        while (f1 != null && f2 != null) {
            if (f1.val > f2.val) {
                cur.next = f2;
                f2 = f2.next;

            } else {
                cur.next = f1;
                f1 = f1.next;
            }
            cur = cur.next;
        }
        while (f1 != null) {
            cur.next = f1;
            f1 = f1.next;
            cur = cur.next;
        }

        while (f2 != null) {
            cur.next = f2;
            f2 = f2.next;
            cur = cur.next;
        }
        return pre.next;
    }

    public static void main(String[] args ) {
        Leetcode148 oct31 = new Leetcode148();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next  = new ListNode(2);

        ListNode res = oct31.sortList(head);
        System.out.println(res.val);
    }
}
