package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by apple on 10/5/18.
 */
public class SlideWindow {
    public static int[] slide(int[] arr, int n, int w) {
        // write code here
        if (n <= 1)return arr;
        int[] slide = new int[n - w + 1];
        int start = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (dq.isEmpty() || arr[dq.peekLast()] > arr[i])
                dq.offer(i);
            else {
                while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
                    dq.pollLast();
                dq.offer(i);
            }
            if (i >= w - 1) {
                while (dq.peek() < i - w + 1)
                    dq.pollFirst();
                slide[start++] = arr[dq.peek()];
            }
        }
        return slide;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int n = 8;
        int w = 3;
        int[] res = slide(arr, n, w);
        for (int r : res)
            System.out.println(r);
    }

}
