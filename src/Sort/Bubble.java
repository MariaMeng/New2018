package Sort;

import java.util.Arrays;

/**
 * Created by apple on 7/1/19.
 */
public class Bubble {

    public static int[] bubbleSort(int[] A, int n) {
        // write code here
        if (A == null || A.length <= 1 || n <= 1) return A;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                }
            }
        }
        return A;
    }
    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] A = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        bubbleSort(A, 13);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

}
