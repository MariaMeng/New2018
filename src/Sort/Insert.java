package Sort;

/**
 * Created by apple on 7/3/19.
 */
public class Insert {
    public int[] insertionSort(int[] A, int n) {
        // write code here
        if (A == null || A.length <= 1 || n <= 1) return A;
        for (int i = 1; i < n; i++) {
            int tmp = A[i];
            int j = i - 1;
            for (; j >= 0 && A[j] > tmp; j--) {
                A[j + 1] = A[j];
            }
            A[j + 1] = tmp;
        }
        return A;
    }
}
