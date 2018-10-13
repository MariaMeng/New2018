package Algorithm;

import java.util.Stack;

/**
 * Created by apple on 10/5/18.
 */
public class StackReverse {
    public static int[] reverseStack(int[] A, int n) {
        // write code here
        if (n <= 1) return A;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--)
            stack.push(A[i]);
        reverse(stack);
        int start = 0;
        while (!stack.isEmpty())
            A[start++] = stack.pop();
        return A;
    }
    public static int get(Stack<Integer> stack) {
        int node = stack.pop();
        if (stack.isEmpty())
            return node;
        int res = get(stack);
        stack.push(node);
        return res;
    }
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return ;
        int node = get(stack);
        reverse(stack);
        stack.push(node);
    }
    public static void main(String[] args) {
        int[] A = {4,3,2,1};
        int n = 4;
        int[] res = reverseStack(A, n);
        for (int r : res)
            System.out.println(r);
    }
}
