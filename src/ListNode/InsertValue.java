package ListNode;

/**
 * Created by apple on 10/6/18.
 */
public class InsertValue {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode (int val) {
            this.val = val;
        }
    }
    public static ListNode insert(int[] A, int[] nxt, int val) {
        // write code here
        // 1. make linked list
        if (A.length == 0) return new ListNode(val);
        ListNode newNode = new ListNode(val);
        int n = A.length;
        ListNode head = new ListNode(A[0]);
        ListNode dummy = head;
        for (int i = 1; i < n; i++) {
            ListNode node = new ListNode(A[i]);
            head.next = node;
            head = head.next;
        }
        head.next = dummy;
        head = dummy;
        ListNode next = dummy.next;
        while (val > next.val && next != head) {
            dummy = dummy.next;
            next = next.next;
        }
        dummy.next = newNode;
        newNode.next = next;
        return head;
    }
    public static ListNode insert_B(int[] A, int[] nxt, int val) {
        // write code here
        if (A == null || A.length == 0) {
            return new ListNode(val);
        }
        // 建立环形链表
        ListNode root = new ListNode(A[0]);
        root.next = root;
        ListNode cur = root;
        for (int i = 0; i < A.length - 1; i++) {
            ListNode node = new ListNode(A[nxt[i]]);
            // 在这个题目这里并不需要设置next指针，否则出现“输出超限:您的程序打印了太多的内容” 的奇怪错误。
            //node.next = cur.next;
            cur.next = node;
            cur = cur.next;
        }
        ListNode current = new ListNode(val);
        ListNode pre = root;
        ListNode next = root.next;
        while (next != null && current.val > next.val ) {
            pre = next;
            next = next.next;
        }
        pre.next = current;
        current.next = next;
        return root;

    }

    public static void main(String[] args) {
        int[] A = {1,3,4,5,7};
        int[] next = {1,2,3,4,0};
        int val = 2;
        ListNode res = insert_B(A, next, val);
        System.out.println(res);
    }
}
