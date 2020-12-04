package Date.Oct.Oct3rd2019;

import java.util.*;

/**
 * Created by apple on 10/3/19.
 * @author  mengxiang
 * @since 2019/10/03
 */
public class NearlySorted {

    private int[] sortElement(int[] a, int n, int k){
        // write code here
        if (a == null || a.length == 0 || n == 0){
                return a;
        }
        int[] heap = Arrays.copyOf(a, k);

        int start = k / 2;
        for (int i = start; i >= 0; i--){
            heapAdjust(heap, i, k);
        }

        for (int i = k; i < n; i++){
            a[i - k] = heap[0];
            heap[0] = a[i];
            heapAdjust(heap, 0, k);
        }

        for (int i = n - k; i < n; i++){
            a[i] = heap[0];
            heap[0] = heap[k - 1];
            heapAdjust(heap, 0, --k);
        }
        return a;
    }

    private void heapAdjust(int[] a, int index, int len){
        int tmp = a[index];
        int child = index * 2 + 1;
        while (child  < len){
            if (child + 1 < len && a[child] > a[child + 1]){
                child++;
            }

            if (tmp < a[child]){
                break;
            }

            a[index] = a[child];
            index = child;
            child = 2 * index + 1;
        }
        a[index] = tmp;
    }

    public static void main(String[] args){
        int[] data = new int[] {2,1,4,3,6,5,8,7,10,9};
        int n = 10, k = 2;
        NearlySorted nearlySorted = new NearlySorted();
        int[] res = nearlySorted.sortElement(data, n, k);

        for (int r: res){
            System.out.println(r);
        }
    }
}
