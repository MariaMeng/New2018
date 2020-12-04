package Date.Mar;

import java.util.Stack;

/**
 * @author mengxiang
 * @date 20/3/23
 */
public class Leetcode71 {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        Stack<String> stack = new Stack<>();

        char[] data = path.toCharArray();
        int idx = 1;
        int start = 1;
        while (idx < data.length) {
            if (data[idx] == '/')  {
                String str = path.substring(start, idx);
                if (str.equals("..") && !stack.isEmpty()) {
                    stack.pop();
                } else if (str.equals("/") || str.equals(".")) {

                } else {
                    stack.push(str);
                }

                start = idx + 1;
            }
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str  = "abc";
        String s = str.substring(0, 0);
        System.out.println(s);
    }
}
