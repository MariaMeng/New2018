package Sort;

/**
 * Created by apple on 10/3/18.
 */
import java.util.*;

public class RadixSort {
    public static int[] radixSort(int[] A, int n) {
        // write code here
        if (A.length <= 1) return A;
        int[] bucket = new int[10];
        int[] res = new int[n];

        for (int i = 1; i <= 4; i++) {

            for (int j = 0; j < 10; j++) {
                bucket[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                int tmp = getValue(A[j], i);
                bucket[tmp]++;
            }

            for (int j = 1; j <= 9; j++) {
                bucket[j] = bucket[j] + bucket[j - 1];
            }

            for (int j = n - 1; j >= 0; j--) {
                int tmp = getValue(A[j], i);
                res[bucket[tmp]-- - 1] = A[j];
            }

            for (int j = 0; j < n; j++) {
                A[j] = res[j];
            }

        }
        return A;


    }

    /**
     * 返回为index位的余数
     * @param A
     * @param index
     * @return
     */
    public static int getValue(int A, int index) {
        int[] arr = {-1, 1, 10, 100, 1000};
        return (A / arr[index] % 10);
    }


    public static void main(String[] args) {
        int[] A = {21, 97, 2, 213, 456,3, 25, 3, 10, 1999};
        int[] res = radixSort(A, 10);
        System.out.println(res);
    }

}
