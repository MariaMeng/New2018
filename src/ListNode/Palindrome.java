package ListNode;

import java.util.Scanner;

/**
 * Created by apple on 10/6/18.
 */
public class Palindrome {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode (int val) {
            this.val = val;
        }
    }
    public static boolean isPalindrome(ListNode pHead) {
        // write code here
        if (pHead == null || pHead.next == null)return true;
        ListNode first = pHead, second = pHead, left = pHead;
        while (second != null && second.next != null) {
            second = second.next.next;
            first = first.next;
        }
        ListNode right = reverse(first);
        while (left != right && left.val == right.val){
            left = left.next;
            right = right.next;
            if (right == null)
                return true;
        }
        return left == right;
    }
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static void main(String[] args) {
//        int[] res = {5,2,2,3,7,0,7,2,1,0,6,1,0,3,3,3,4,3,4,5,5,4,9,0,9,4,0,6,3,2,2,1,6,7,1,8,2,8,0,6,0,0,4,1,8,2,2,8,1,4,0,0,6,0,8,2,8,1,7,6,1,2,2,3,6,0,4,9,0,9,4,5,5,4,3,4,3,3,3,0,1,6,0,1,2,7,0,7,3,2,2,5};
        int[] res = {1, 2, 3, 2, 1};
        int n = res.length;
        System.out.println(res.length);
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        ListNode head = new ListNode(in.nextInt());
        ListNode head = new ListNode(res[0]);
        ListNode start = head;
        for (int i = 1; i < n; i++) {
//            head.next = new ListNode(in.nextInt());
            head.next = new ListNode(res[i]);
            head = head.next;
        }
        System.out.println(isPalindrome(start));
    }
}
