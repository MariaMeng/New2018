package Algorithm;

/**
 * Created by apple on 10/19/18.
 */
public class ReversePair {
    public static long reversePairs(int[] A) {
        // write your code here
        if (A == null || A.length <= 1) return 0;
        int n = A.length;
        return helper(A, 0, n - 1);
    }
    public static long helper(int[] A, int left, int right) {
        if (left == right) return 0;
        int mid = left + (right - left) / 2;

        long L = helper(A, left, mid);
        long R = helper(A, mid + 1, right);

        int res = 0;
        int[] cache = new int[right - left + 1];
        int k = 0;
        int start1 = left, start2 = mid + 1;
        while (start1 <= mid && start2 <= right) {
            if (A[start2] < A[start1]) {
                cache[k++] = A[start2++];
                res += mid - start1 + 1;
            }
            else
                cache[k++] = A[start1++];
        }
        while (start1 <= mid)
            cache[k++] = A[start1++];

        while (start2 <= right)
            cache[k++] = A[start2++];

        // reverse the array
        for (int i = left; i <= right; i++)
            A[i] = cache[i - left];

        return res + L + R;
    }
    public static void main(String[] args) {
        int[] a = new int[]{4,5,8,1,2,7};
        System.out.println(reversePairs(a));
    }
}
