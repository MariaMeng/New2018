package Date.Oct.Oct14th2019;

import java.util.Stack;

/**
 * Created by apple on 10/14/19.
 */
public class Leetcode1124 {
    public static int longestWPI(int[] hours) {
        if (hours == null || hours.length == 0) return 0;

        int[] pre = new int[hours.length + 1];
        for (int i = 1; i <= hours.length; i++) {
            pre[i] = pre[i - 1] + (hours[i - 1] > 8 ? 1: -1);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= hours.length; i++) {
            if (stack.isEmpty() || pre[i] < pre[stack.peek()]) {
                stack.push(i);
            }
        }

        int ans = 0, i = hours.length;
        while (i > ans) {
            while (!stack.isEmpty() && pre[stack.peek()] < pre[i]) {
                ans = Math.max(ans, i - stack.pop());
            }
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] hours = new int[]{6,6,9};
        int res = longestWPI(hours);

        System.out.println(res);
    }


}
