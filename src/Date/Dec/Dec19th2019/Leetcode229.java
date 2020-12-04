package Date.Dec.Dec19th2019;

import java.util.Stack;

/**
 * Created by apple on 12/19/19.
 */
public class Leetcode229 {

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();

        // store the previous sum of save level
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        // cur sum
        int sum = 0;
        // cur num
        int num = 0;
        for (int i =0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (s.charAt(i) == '(') {
                stack.push(sum);
                sum = 0;
                stack.push(sign == 1? 1: -1);
                sign = 1;
            }else if (s.charAt(i) == '-') {
                sign = -1;
                num = 0;
            } else if (s.charAt(i) == '+') {
                sign = 1;
                num = 0;
            } else if (s.charAt(i) == ')') {
                sum *= stack.pop();
                sum += stack.pop();
            } else {
                if (i > 0 && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') {
                    sum -= num;
                    num *= 10;
                }
                num += sign * (s.charAt(i) - '0');
                sum += num;
            }

        }
        return sum;
    }
}
