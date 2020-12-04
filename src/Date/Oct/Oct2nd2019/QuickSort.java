package Date.Oct.Oct2nd2019;

/**
 * Created by apple on 10/2/19.
 */
public class QuickSort {

    public static int[] quickSort(int[] A, int n) {
        // write code here
        if (A == null || A.length <= 1 || n <= 1) {
            return A;
        }

        int[] res = quick(A, 0, n - 1);
        return res;
    }

    public static int[] quick(int[] A, int s, int e) {
        if (s < 0 || e >= A.length || s >= e) {
            return A;
        }

        // find the index of pivot
        int p = findPivot(A, s, e);
        int pivot = A[p];

        // swap pivot index with last element index
        swap(A, p, e - 1);

        // make subarry ordered
        int l = s, r = e - 1;
        while (l < r) {
            while (l <= e && A[l] < pivot) {
                l++;
            }
            while (r >= s && A[r] >= pivot) {
                r--;
            }
            if (l < r) {
                swap(A, l, r);
            }
        }
        // swap the l with p
        if (l < e) {
            swap(A, l, e - 1);
        }

        quick(A, s, l - 1);
        quick(A, l + 1, e);
        return A;
    }

    public static int findPivot(int[] A, int s, int e) {
        int m = s + (e - s) / 2;

        if (A[s] > A[m]) {
            swap(A, s, m);
        }
        if (A[s] > A[e]) {
            swap(A, s, e);
        }
        if (A[m] > A[e]) {
            swap(A, m, e);
        }
        return m;
    }

    public static void swap(int[] A, int i, int j) {
        if (i == j)  {
            return;
        }
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] data = new int[] {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int n = 13;

        int[] res = quickSort(data, n);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
