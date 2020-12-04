package Date.Oct.Oct25th2019;

import java.util.List;

/**
 * Created by apple on 10/25/19.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }

}
public class Leetcode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int k = lists.length;

        ListNode res = divide(lists, 0, k - 1);
        return res;
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;

        int k = lists.size();

        ListNode res = divide(lists, 0, k - 1);
        return res;
    }

    public ListNode divide(ListNode[] list, int start, int end) {
        if (start < 0 || end >= list.length) return null;
        if (start == end) {
            return list[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = divide(list, start, mid);
        ListNode right = divide(list, mid + 1, end);

        return merge(left, right);
    }

    public ListNode divide(List<ListNode> list, int start, int end) {
        if (start < 0 || end >= list.size()) return null;
        if (start == end) {
            return list.get(start);
        }
        int mid = start + (end - start) / 2;
        ListNode left = divide(list, start, mid);
        ListNode right = divide(list, mid + 1, end);

        return merge(left, right);
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        while (h1 != null && h2 != null) {
            if (h1.val > h2.val) {
                pre.next = h2;
                h2 = h2.next;

            } else {
                pre.next = h1;
                h1 = h1.next;
            }
            pre = pre.next;
        }

        while (h1 != null) {
            pre.next = h1;
            h1 = h1.next;
            pre = pre.next;
        }
        while (h2 != null) {
            pre.next = h2;
            h2 = h2.next;
            pre = pre.next;
        }
        return cur.next;
    }

    public static void main(String[] args) {

    }
}
