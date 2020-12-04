package Date.Oct.Ock21th2019;

import java.util.Stack;

/**
 * Created by apple on 10/21/19.
 */
public class Leetcode42 {

    public static int trap1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;

        Stack<Integer> stack = new Stack<>();

        int i = 0, sum = 0;
        while (i < n) {
            if (stack.isEmpty() || height[stack.peek()] >= height[i]) {
                stack.push(i);
                i++;
            } else {
                int peek = stack.pop();
                if (stack.isEmpty()) {
                    continue;
                }

                int dis = i - stack.peek() - 1;
                int hei = Math.min(height[i], height[stack.peek()]) - height[peek];

                sum += dis * hei;
            }
        }
        return sum;
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int left = 1, right = height.length - 2;
        int max_left = 0, max_right =0;
        int sum = 0;

        while (left <= right) {
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);

                if (max_left > height[left]) {
                    sum += max_left - height[left];
                }
                left++;
            } else {
                max_right = Math.max(max_right, height[right + 1]);

                if (max_right > height[right]) {
                    sum += max_right - height[right];
                }
                right--;
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        Leetcode42 leetcode42 = new Leetcode42();
        int[] height = new int[]{8,6,4,2,4,10};
        int res = leetcode42.trap(height);
        System.out.println(res);
    }
}
