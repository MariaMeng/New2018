package Date.Oct.Oct25th2019;

import java.util.Stack;

/**
 * Created by apple on 10/25/19.
 */
public class Leetcode20 {

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '['){
                stack.push(']');
            }
            else if (stack.isEmpty() || stack.pop() != s.charAt(i)) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = null;
        s = "{(){[]}}";
        boolean res = isValid(s);
        System.out.println(res);

        s = "";
        res = isValid(s);
        System.out.println(res);


    }
}
