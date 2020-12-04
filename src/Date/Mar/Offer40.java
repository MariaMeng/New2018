package Date.Mar;

import java.util.PriorityQueue;

/**
 * @author mengxiang
 * @date 20/3/20
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[0];
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else {
                if (pq.peek() > arr[i]) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
