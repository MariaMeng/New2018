package Sort;

/**
 * Created by apple on 7/3/19.
 */
public class Merge {
    public static int[] mergeSort(int[] A, int n) {
        // write code here
        if (A == null || A.length <= 1 || n <= 1) return A;
        merge(A, 0, n - 1);
        return A;
    }
    public static void merge(int[] A, int left, int right) {
        if (left >= right) {
            return ;
        }
        int mid = left + (right - left) / 2;
        merge(A, left, mid);
        merge(A, mid + 1, right);
        int[] res = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (A[i] > A[j]) {
                res[k++] = A[j++];
            } else {
                res[k++] = A[i++];
            }
        }
        while (i <= mid) {
            res[k++] = A[i++];
        }
        while (j <= right) {
            res[k++] = A[j++];
        }
        for (int m = 0; m < right - left + 1; m++) {
            A[left + m] = res[m];
        }
    }
    public static void main(String[] args) {
        int[] A = {8, 6, 5, 4, 2};
        int[] res = mergeSort(A, 5);
        for (int r: res) {
            System.out.print(r + " ");
        }
    }
}
