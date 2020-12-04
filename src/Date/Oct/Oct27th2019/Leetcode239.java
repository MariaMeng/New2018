package Date.Oct.Oct27th2019;

import java.util.*;

/**
 * Created by apple on 10/27/19.
 */
public class Leetcode239 {


    /**
     * 剑指offer 牛客网
     * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        // 双端队列维护了一个队头元素值最大，队尾元素值最小的双端队列
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0) return res;

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i >= size - 1) {
                while (deque.peek() < i - size + 1) {
                    deque.pollFirst();
                }
                res.add(num[deque.peek()]);
            }
        }
        return res;
    }

    /**
     * Leetcode 239
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i >= k - 1) {
                while (deque.peek() < i - k + 1) {
                    deque.pollFirst();
                }
                res[count++] = nums[deque.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[] {2,3,4,2,6,2,5,1};
        int size = 3;
        int[] res = maxSlidingWindow(num, size);
        for (int r: res) {
            System.out.print(r + " ");
        }
    }
}
